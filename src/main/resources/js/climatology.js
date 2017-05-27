function PlanetaryTemperature(data) {
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

function SeasonalVariation(data) {
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

function ClimatologyViewModel() {
	var self = this;
	self.planetaryTemperatures = ko.observableArray([]);
	self.seasonalVariations = ko.observableArray([]);
	
	self.times = ko.observable(3);

	self.editPlanetaryTemperature = ko.observable(new PlanetaryTemperature());
	self.editSeasonalVariation = ko.observable(new SeasonalVariation());

	self.editPlanetaryTemperatureModalVisible = ko.observable(false);
	self.showEditPlanetaryTemperatureModal = function(data) {
		self.editPlanetaryTemperature(data);
		self.editPlanetaryTemperatureModalVisible(true);
	};
	self.hideEditPlanetaryTemperatureModal = function() {
		self.editPlanetaryTemperatureModalVisible(false);
	};

	self.editSeasonalVariationModalVisible = ko.observable(false);
	self.showEditSeasonalVariationModal = function(data) {
		self.editSeasonalVariation(data);
		self.editSeasonalVariationModalVisible(true);
	};
	self.hideEditSeasonalVariationModal = function() {
		self.editSeasonalVariationModalVisible(false);
	};

	self.newPlanetaryTemperatureModalVisible = ko.observable(false);
	self.showNewPlanetaryTemperatureModal = function() {
		self.editPlanetaryTemperature(new PlanetaryTemperature());
		self.newPlanetaryTemperatureModalVisible(true);
	};
	self.hideNewPlanetaryTemperatureModal = function() {
		self.newPlanetaryTemperatureModalVisible(false);
	};

	self.newSeasonalVariationModalVisible = ko.observable(false);
	self.showNewSeasonalVariationModal = function() {
		self.editSeasonalVariation(new SeasonalVariation());
		self.newSeasonalVariationModalVisible(true);
	};
	self.hideNewSeasonalVariationModal = function() {
		self.newSeasonalVariationModalVisible(false);
	};

	self.updatePlanetaryTemperature = function () {
		self.hideEditPlanetaryTemperatureModal();
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
		self.hideNewPlanetaryTemperatureModal();
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
		self.hideEditSeasonalVariationModal();
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
		self.hideNewSeasonalVariationModal();
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

var mainModel = new ClimatologyViewModel();
ko.applyBindings(mainModel);