define(['jquery', 'knockout', 'Modal', '../components/worldHydrography', '../components/displayType', '../components/landWaterDistribution', '../components/landWaterMass', '../components/regionType', 'knockstrap'], function($, ko, Modal, WorldHydrography, DisplayType, LandWaterDistribution, LandWaterMass, RegionType) {
	return function HydrographyViewModel() {
		var self = this;
		self.displayTypes = ko.observableArray([]);
		self.regionTypes = ko.observableArray([]);
		self.hydrographies = ko.observableArray([]);
		self.distributions = ko.observableArray([]);
		self.masses = ko.observableArray([]);
		
		self.times = ko.observable(3);
		self.results = ko.observableArray([]);
		self.selectedDisplayType = ko.observable();
		self.massResults = ko.observableArray([]);

		self.editHydrography = ko.observable(new WorldHydrography());
		self.editRegionType = ko.observable(new RegionType());
		self.editDisplayType = ko.observable(new DisplayType());
		self.editLandWaterDistribution = ko.observable(new LandWaterDistribution({displayType: null, regionType: null, hydrography: null}));
		self.editLandWaterMass = ko.observable(new LandWaterMass());

		self.setSelectedDisplayType = function(data) {
			self.selectedDisplayType(data);
		}

		self.editHydrographyModal = new Modal(self.editHydrography);
		self.editRegionTypeModal = new Modal(self.editRegionType);
		self.editDisplayTypeModal = new Modal(self.editDisplayType);
		self.editLandWaterDistributionModal = new Modal(self.editLandWaterDistribution);
		self.editLandWaterMassModal = new Modal(self.editLandWaterMass);

		self.newHydrographyModal = new Modal(self.editHydrography);
		self.newRegionTypeModal = new Modal(self.editRegionType);
		self.newDisplayTypeModal = new Modal(self.editDisplayType);
		self.newLandWaterDistributionModal = new Modal(self.editLandWaterDistribution);
		self.newLandWaterMassModal = new Modal(self.editLandWaterMass);

		self.updateHydrography = function() {
			self.editHydrography().update();
		}
		self.createHydrography = function() {
			self.editHydrography().create();
		}

		self.updateRegionType = function() {
			self.editRegionType().update();
		}
		self.createRegionType = function() {
			self.editRegionType().create();
		}

		self.updateDisplayType = function() {
			self.editDisplayType().update();
		}
		self.createDisplayType = function() {
			self.editDisplayType().create();
		}

		self.updateLandWaterDistribution = function() {
			self.editLandWaterDistribution().update();
		}
		self.createLandWaterDistribution = function() {
			self.editLandWaterDistribution().create();
		}

		self.updateLandWaterMass = function() {
			self.editLandWaterMass().update();
		}
		self.createLandWaterMass = function() {
			self.editLandWaterMass().create();
		}

		self.generateHydrography = function () {
			$.ajax({
				method: "POST",
				url: "/tools/worldBuilder/planetology/hydrographies/generate?times=" + self.times(),
				contentType: "application/json",
				dataType: "json"
			}).done(function (data) {
				self.results(data);
				self.massResults([]);
				data.forEach(function (d) {
					self.generateLandWaterMasses(d);
				});
			});
		}

		self.generateLandWaterMasses = function(hydrography) {
			$.ajax({
				method: "POST",
				url: "/tools/worldBuilder/planetology/landWaterMasses/generate?hId=" + hydrography.id + "&dId=" + self.selectedDisplayType().id,
				contentType: "application/json",
				dataType: "json"
			}).done(function (data) {
				var temp = self.massResults();
				temp.push(data);
				self.massResults(temp);
			});
		}
		
		self.findNumRegions = function(regionType, displayType, hydrography) {
			var distribution = self.distributions().find(function (element) {
				return element.displayType().name() == displayType && element.regionType().name() == regionType && element.hydrography().percent() == hydrography;
			});
			return distribution;
		}

		self.getHydrographies = function () {
			WorldHydrography.list(self.hydrographies);
		}
		self.getRegionTypes = function () {
			RegionType.list(self.regionTypes);
		}
		self.getDisplayTypes = function () {
			DisplayType.list(self.displayTypes);
		}
		self.getDistributions = function () {
			LandWaterDistribution.list(self.distributions);
		}
		self.getMasses = function () {
			LandWaterMass.list(self.masses);
		}

		self.getHydrographies();
		self.getRegionTypes();
		self.getDisplayTypes();
		self.getDistributions();
		self.getMasses();
	}
});