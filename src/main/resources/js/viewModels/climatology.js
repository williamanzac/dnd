define([ 'jquery', 'knockout', 'Modal', '../components/planetaryTemperature', '../components/seasonalVariation',
        'knockstrap' ], function($, ko, Modal, PlanetaryTemperature, SeasonalVariation) {
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

		self.updatePlanetaryTemperature = function() {
			self.editPlanetaryTemperature().update();
		}
		self.createPlanetaryTemperature = function() {
			self.editPlanetaryTemperature().create();
		}

		self.updateSeasonalVariation = function() {
			self.editSeasonalVariation().update();
		}
		self.createSeasonalVariation = function() {
			self.editSeasonalVariation().create();
		}

		self.getPlanetaryTemperatures = function() {
			PlanetaryTemperature.list(self.planetaryTemperatures);
		}
		self.getSeasonalVariations = function() {
			SeasonalVariation.list(self.seasonalVariations);
		}

		self.getPlanetaryTemperatures();
		self.getSeasonalVariations();
	}
});