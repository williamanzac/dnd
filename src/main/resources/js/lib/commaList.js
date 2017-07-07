define([ 'jquery', 'knockout' ], function($, ko) {
	ko.extenders.commaList = function(target) {
		target.formatted = ko.pureComputed({
		    read : function() {
			    return target().join(', ');
		    },
		    write : function(newValue) {
			    if (Array.isArray(newValue)) {
				    target(newValue);
			    } else {
				    var a = newValue.split(', ');
				    target(a);
			    }
		    }
		});

		return target;
	}
})