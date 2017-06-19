define([ 'jquery', 'knockout' ], function($, ko) {
	return function Modal(value) {
		var self = this;
		self.value = value;
		self.visible = ko.observable(false);

		self.show = function(data) {
			self.value(data);
			self.visible(true);
		};

		self.hide = function() {
			self.visible(false);
		};
	}
});