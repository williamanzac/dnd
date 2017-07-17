define([ 'jquery', 'knockout' ], function($, ko) {
	ko.bindingHandlers.inline = {
		init : function(element, valueAccessor) {
			var rollbackValues = [];

			// a flag to indicate if the field is being edited
			valueAccessor.isEditing = ko.observable(false);

			// start an edit
			beginEdit = function() {
				if (valueAccessor.isEditing()) {
					return;
				}

				rollbackValues.push(valueAccessor());

				valueAccessor.isEditing(true);
			};

			// end (commit) an edit
			endEdit = function() {
				if (!valueAccessor.isEditing()) {
					return;
				}

				valueAccessor.isEditing(false);
			};

			// cancel and roll-back an edit
			cancelEdit = function() {
				if (!valueAccessor.isEditing() || !rollbackValues.length) {
					valueAccessor.isEditing(false);
					return;
				}

				valueAccessor(rollbackValues.pop());

				valueAccessor.isEditing(false);
			};

			var span = $(element);
			var input = $('<input />', {
			    'type' : 'text',
			    'style' : 'display:none',
			    'class' : 'form-control input-sm'
			});
			span.after(input);

			ko.applyBindingsToNode(input.get(0), {
			    value: valueAccessor(),
			    visible: valueAccessor.isEditing
			});
			ko.applyBindingsToNode(span.get(0), {
			    text: valueAccessor(),
			    visible: !valueAccessor.isEditing()
			});

			span.dblclick(beginEdit);

			input.blur(cancelEdit);

			input.keypress(function(e) {
				if (e.which == 13 || e.keyCode == 13) {
					endEdit();
				} else if (e.which == 27 || e.keyCode == 27) {
					cancelEdit();
				}
			});
		}
	}
});