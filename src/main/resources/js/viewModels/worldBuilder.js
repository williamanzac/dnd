define([ 'jquery', 'knockout', 'Modal', '../models/worldHydrography', '../models/displayType',
        '../models/landWaterDistribution', '../models/landWaterMass', '../models/regionType', '../models/region',
        'knockstrap' ], function($, ko, Modal, WorldHydrography, DisplayType, LandWaterDistribution, LandWaterMass,
        RegionType, Region) {
	return function HydrographyViewModel() {
		var self = this;
		self.displayTypes = ko.observableArray([]);
		self.regionTypes = ko.observableArray([]);
		self.hydrographies = ko.observableArray([]);
		self.distributions = ko.observableArray([]);
		self.masses = ko.observableArray([]);
		self.map = ko.observable();

		self.selectedDisplayTypeId = ko.observable();
		self.selectedHydrographyId = ko.observable();
		self.seed = ko.observable();
		
		self.generateMap = function() {
			$.ajax({
			    method : "POST",
			    url : "/tools/worldBuilder/generate/" + self.seed() + "/" + self.selectedDisplayTypeId() + "/" + self.selectedHydrographyId(),
			    accepts : "application/svg+xml"
			}).done(function(data) {
				var oSerializer = new XMLSerializer();
				var sXML = oSerializer.serializeToString(data);
				self.map(sXML);
			});
		}

		self.getHydrographies = function() {
			WorldHydrography.list(self.hydrographies);
		}
		self.getRegionTypes = function() {
			RegionType.list(self.regionTypes);
		}
		self.getDisplayTypes = function() {
			DisplayType.list(self.displayTypes);
		}
		self.getDistributions = function() {
			LandWaterDistribution.list(self.distributions);
		}
		self.getMasses = function() {
			LandWaterMass.list(self.masses);
		}

		self.getHydrographies();
		self.getRegionTypes();
		self.getDisplayTypes();
		self.getDistributions();
		self.getMasses();
	}
});