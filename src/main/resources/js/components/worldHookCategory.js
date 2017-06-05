define(['knockout', '../components/worldHook'], function(ko, WorldHook) {
	return function Category(data) {
		var self = this;
		if (data != null) {
			self.id = data.id;
			self.name = ko.observable(data.name);
			self.min = ko.observable(data.min);
			self.max = ko.observable(data.max);
			self.worldHooks = ko.observableArray([]);
			var mapped = $.map(data.worldHooks, function(item) {
				return new WorldHook(item)
			});
			self.worldHooks(mapped);
		} else {
			self.name = ko.observable();
			self.min = ko.observable();
			self.max = ko.observable();
			self.worldHooks = ko.observableArray([]);
		}
	}
});