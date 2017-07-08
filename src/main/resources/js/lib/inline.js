define([ 'jquery', 'knockout' ], function($, ko) {
	ko.bindingHandlers.inline = {
		init : function(element, valueAccessor) {
			var span = $(element);
			var input = $('<input />', {
			    'type' : 'text',
			    'style' : 'display:none',
			    'class' : 'form-control input-sm'
			});
			span.after(input);

			ko.applyBindingsToNode(input.get(0), {
				value : valueAccessor()
			});
			ko.applyBindingsToNode(span.get(0), {
				text : valueAccessor()
			});

			span.dblclick(function() {
				span.hide();
				input.show();
				input.focus();
			});

			input.blur(function() {
				span.show();
				input.hide();
			});

			input.keypress(function(e) {
				if (e.keyCode == 13) {
					span.show();
					input.hide();
				}
			});
		}
	}
});