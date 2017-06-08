define(['knockout'], function(ko) {
	return function PlanetaryTemperature(data) {
		var self = this;
		if (data != null) {
			self.id = data.id;
			self.category = ko.observable(data.category);
			self.min = ko.observable(data.min);
			self.max = ko.observable(data.max);
		} else {
			self.category = ko.observable();
			self.min = ko.observable();
			self.max = ko.observable();
		}
	}
});