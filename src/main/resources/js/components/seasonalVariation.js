define(['knockout'], function(ko) {
	return function SeasonalVariation(data) {
		var self = this;
		if (data != null) {
			self.id = data.id;
			self.variation = ko.observable(data.variation);
			self.min = ko.observable(data.min);
			self.max = ko.observable(data.max);
		} else {
			self.variation = ko.observable();
			self.min = ko.observable();
			self.max = ko.observable();
		}
	}
});