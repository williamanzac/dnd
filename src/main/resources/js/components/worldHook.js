define(['knockout'], function(ko) {
	return function WorldHook(data) {
		var self = this;
		if (data != null) {
			self.id = data.id;
			self.name = ko.observable(data.name);
			self.categoryId = ko.observable();
		} else {
			self.name = ko.observable();
			self.categoryId = ko.observable();
		}
	}
});