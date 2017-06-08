define(['jquery', 'knockout', 'Modal', '../components/planetaryTemperature', '../components/seasonalVariation', 'knockstrap'], function($, ko, Modal, PlanetaryTemperature, SeasonalVariation) {
	return function ClimatologyViewModel() {
		var self = this;
		self.planetaryTemperatures = ko.observableArray([]);
		self.seasonalVariations = ko.observableArray([]);
		
		self.times = ko.observable(3);

		self.editPlanetaryTemperature = ko.observable(new PlanetaryTemperature());
		self.editSeasonalVariation = ko.observable(new SeasonalVariation());

		self.editPlanetaryTemperatureModal = new Modal(self.editPlanetaryTemperature);
		self.editSeasonalVariationModal = new Modal(self.editSeasonalVariation);
		self.newPlanetaryTemperatureModal = new Modal(self.editPlanetaryTemperature);
		self.newSeasonalVariationModal = new Modal(self.editSeasonalVariation);

		self.updatePlanetaryTemperature = function () {
			self.editPlanetaryTemperatureModal.hide();
			var data = ko.toJS(self.editPlanetaryTemperature());
			$.ajax({
				method: "PUT",
				data: JSON.stringify(data),
				url: "/tools/worldBuilder/planetology/planetaryTemperatures",
				contentType: "application/json",
				dataType: "json"
			}).done(function() {
				self.getPlanetaryTemperatures();
			});
		}
		self.createPlanetaryTemperature = function () {
			self.newPlanetaryTemperatureModal.hide();
			var data = ko.toJS(self.editPlanetaryTemperature());
			$.ajax({
				method: "POST",
				data: JSON.stringify(data),
				url: "/tools/worldBuilder/planetology/planetaryTemperatures",
				contentType: "application/json",
				dataType: "json"
			}).done(function() {
				self.getPlanetaryTemperatures();
			});
		}
		self.removePlanetaryTemperature = function (data) {
			$.ajax({
				method: "DELETE",
				url: "/tools/worldBuilder/planetology/planetaryTemperatures/" + data.id,
				contentType: "application/json",
				dataType: "json"
			}).done(function (data) {
				self.getPlanetaryTemperatures();
			});
		}

		self.updateSeasonalVariation = function () {
			self.editSeasonalVariationModal.hide();
			var data = ko.toJS(self.editSeasonalVariation());
			$.ajax({
				method: "PUT",
				data: JSON.stringify(data),
				url: "/tools/worldBuilder/planetology/seasonalVariations",
				contentType: "application/json",
				dataType: "json"
			}).done(function() {
				self.getSeasonalVariations();
			});
		}
		self.createSeasonalVariation = function () {
			self.newSeasonalVariationModal.hide();
			var data = ko.toJS(self.editSeasonalVariation());
			$.ajax({
				method: "POST",
				data: JSON.stringify(data),
				url: "/tools/worldBuilder/planetology/seasonalVariations",
				contentType: "application/json",
				dataType: "json"
			}).done(function() {
				self.getSeasonalVariations();
			});
		}
		self.removeSeasonalVariation = function (data) {
			$.ajax({
				method: "DELETE",
				url: "/tools/worldBuilder/planetology/seasonalVariations/" + data.id,
				contentType: "application/json",
				dataType: "json"
			}).done(function (data) {
				self.getSeasonalVariations();
			});
		}

		self.getPlanetaryTemperatures = function () {
			$.getJSON("/tools/worldBuilder/planetology/planetaryTemperatures", function (data) {
				var mapped = $.map(data, function(item) {
					return new PlanetaryTemperature(item)
				});
				self.planetaryTemperatures(mapped);
			});
		}
		self.getSeasonalVariations = function () {
			$.getJSON("/tools/worldBuilder/planetology/seasonalVariations", function (data) {
				var mapped = $.map(data, function(item) {
					return new SeasonalVariation(item)
				});
				self.seasonalVariations(mapped);
			});
		}

		self.getPlanetaryTemperatures();
		self.getSeasonalVariations();
	}
});