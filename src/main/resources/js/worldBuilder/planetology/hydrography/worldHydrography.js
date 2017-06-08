function Hydrography(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.percent = ko.observable(data.percent);
		self.min = ko.observable(data.min);
		self.max = ko.observable(data.max);
	} else {
		self.percent = ko.observable();
		self.min = ko.observable();
		self.max = ko.observable();
	}
}

function RegionType(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
	} else {
		self.name = ko.observable();
	}
}

function DisplayType(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
		self.selected = ko.observable(false);
	} else {
		self.name = ko.observable();
	}
}

function LandWaterDistribution(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.numRegions = ko.observable(data.numRegions);
		self.displayType = ko.observable(new DisplayType(data.displayType));
		self.regionType = ko.observable(new RegionType(data.regionType));
		self.hydrography = ko.observable(new Hydrography(data.hydrography));
	} else {
		self.name = ko.observable();
		self.numRegions = ko.observable();
		self.displayType = ko.observable();
		self.regionType = ko.observable();
		self.hydrography = ko.observable();
	}
}

function LandWaterMass(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.numRegions = ko.observable(data.numRegions);
		self.numMasses = ko.observable(data.numMasses);
		self.minSize = ko.observable(data.minSize);
		self.maxSize = ko.observable(data.maxSize);
	} else {
		self.name = ko.observable();
		self.numRegions = ko.observable();
		self.numMasses = ko.observable();
		self.minSize = ko.observable();
		self.maxSize = ko.observable();
	}
}

function HydrographyViewModel() {
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

	self.editHydrography = ko.observable(new Hydrography());
	self.editRegionType = ko.observable(new RegionType());
	self.editDisplayType = ko.observable(new DisplayType());
	self.editLandWaterDistribution = ko.observable(new LandWaterDistribution({displayType: null, regionType: null, hydrography: null}));
	self.editLandWaterMass = ko.observable(new LandWaterMass());

	self.setSelectedDisplayType = function(data) {
		self.selectedDisplayType(data);
	}

	self.editHydrographyModalVisible = ko.observable(false);
	self.showEditHydrographyModal = function(data) {
		self.editHydrography(data);
		self.editHydrographyModalVisible(true);
	};
	self.hideEditHydrographyModal = function() {
		self.editHydrographyModalVisible(false);
	};

	self.editRegionTypeModalVisible = ko.observable(false);
	self.showEditRegionTypeModal = function(data) {
		self.editRegionType(data);
		self.editRegionTypeModalVisible(true);
	};
	self.hideEditRegionTypeModal = function() {
		self.editRegionTypeModalVisible(false);
	};

	self.editDisplayTypeModalVisible = ko.observable(false);
	self.showEditDisplayTypeModal = function(data) {
		self.editDisplayType(data);
		self.editDisplayTypeModalVisible(true);
	};
	self.hideEditDisplayTypeModal = function() {
		self.editDisplayTypeModalVisible(false);
	};

	self.editLandWaterDistributionModalVisible = ko.observable(false);
	self.showEditLandWaterDistributionModal = function(data) {
		self.editLandWaterDistribution(data);
		self.editLandWaterDistributionModalVisible(true);
	};
	self.hideEditLandWaterDistributionModal = function() {
		self.editLandWaterDistributionModalVisible(false);
	};

	self.editLandWaterMassModalVisible = ko.observable(false);
	self.showEditLandWaterMassModal = function(data) {
		self.editLandWaterMass(data);
		self.editLandWaterMassModalVisible(true);
	};
	self.hideEditLandWaterMassModal = function() {
		self.editLandWaterMassModalVisible(false);
	};

	self.newHydrographyModalVisible = ko.observable(false);
	self.showNewHydrographyModal = function() {
		self.editHydrography(new Hydrography());
		self.newHydrographyModalVisible(true);
	};
	self.hideNewHydrographyModal = function() {
		self.newHydrographyModalVisible(false);
	};

	self.newRegionTypeModalVisible = ko.observable(false);
	self.showNewRegionTypeModal = function() {
		self.editRegionType(new RegionType());
		self.newRegionTypeModalVisible(true);
	};
	self.hideNewRegionTypeModal = function() {
		self.newRegionTypeModalVisible(false);
	};

	self.newDisplayTypeModalVisible = ko.observable(false);
	self.showNewDisplayTypeModal = function() {
		self.editDisplayType(new DisplayType());
		self.newDisplayTypeModalVisible(true);
	};
	self.hideNewDisplayTypeModal = function() {
		self.newDisplayTypeModalVisible(false);
	};

	self.newLandWaterDistributionModalVisible = ko.observable(false);
	self.showNewLandWaterDistributionModal = function(regionType, displayType, hydrography) {
		var type = new LandWaterDistribution();
		type.regionType(regionType);
		type.displayType(displayType);
		type.hydrography(hydrography);
		self.editLandWaterDistribution(type);
		self.newLandWaterModalDistributionVisible(true);
	};
	self.hideNewLandWaterDistributionModal = function() {
		self.newLandWaterModalDistributionVisible(false);
	};

	self.newLandWaterMassModalVisible = ko.observable(false);
	self.showNewLandWaterMassModal = function() {
		self.editLandWaterMass(new LandWaterMass());
		self.newLandWaterMassModalVisible(true);
	};
	self.hideNewLandWaterMassModal = function() {
		self.newLandWaterMassModalVisible(false);
	};

	self.updateHydrography = function () {
		self.hideEditHydrographyModal();
		var data = ko.toJS(self.editHydrography());
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/hydrographies",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getHydrographies();
		});
	}
	self.createHydrography = function () {
		self.hideNewHydrographyModal();
		var data = ko.toJS(self.editHydrography());
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/hydrographies",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getHydrographies();
		});
	}
	self.removeHydrography = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/hydrographies/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getHydrographies();
		});
	}

	self.updateRegionType = function () {
		self.hideEditRegionTypeModal();
		var data = ko.toJSt(self.editRegionType);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/regionTypes",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getRegionTypes();
		});
	}
	self.createRegionType = function () {
		self.hideNewRegionTypeModal();
		var data = ko.toJS(self.editRegionType());
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/regionTypes",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getRegionTypes();
		});
	}
	self.removeRegionType = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/regionType/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getRegionTypes();
		});
	}

	self.updateDisplayType = function () {
		self.hideEditDisplayTypeModal();
		var data = ko.toJS(self.editDisplayType());
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/displayTypes",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getDisplayTypes();
		});
	}
	self.createDisplayType = function () {
		self.hideNewDisplayTypeModal();
		var data = ko.toJS(self.editDisplayType());
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/displayTypes",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getDisplayTypes();
		});
	}
	self.removeDisplayType = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/displayTypes/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getDisplayTypes();
		});
	}

	self.updateLandWaterDistribution = function () {
		self.hideEditLandWaterDistributionModal();
		var data = ko.toJS(self.editLandWater);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/landWaterDistributions",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getDistributions();
		});
	}
	self.createLandWaterDistribution = function () {
		self.hideNewLandWaterDistributionModal();
		var data = ko.toJS(self.editLandWaterDistribution);
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/landWaterDistributions",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getDistributions();
		});
	}
	self.removeLandWaterDistribution = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/landWaterDistributions/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getDistributions();
		});
	}

	self.updateLandWaterMass = function () {
		self.hideEditLandMassWaterModal();
		var data = ko.toJS(self.editLandWaterMasss);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/landWaterMasses",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getMasses();
		});
	}
	self.createLandWaterMass = function () {
		self.hideNewLandWaterMassModal();
		var data = ko.toJS(self.editLandWaterMass);
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/landWaterMasses",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getMasses();
		});
	}
	self.removeLandWaterMass = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/landWaterMasses/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getMasses();
		});
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
		$.getJSON("/tools/worldBuilder/planetology/hydrographies", function (data) {
			var mapped = $.map(data, function(item) {
				return new Hydrography(item)
			});
			self.hydrographies(mapped);
		});
	}
	self.getRegionTypes = function () {
		$.getJSON("/tools/worldBuilder/planetology/regionTypes", function (data) {
			var mapped = $.map(data, function(item) {
				return new RegionType(item)
			});
			self.regionTypes(mapped);
		});
	}
	self.getDisplayTypes = function () {
		$.getJSON("/tools/worldBuilder/planetology/displayTypes", function (data) {
			var mapped = $.map(data, function(item) {
				return new DisplayType(item)
			});
			self.displayTypes(mapped);
		});
	}
	self.getDistributions = function () {
		$.getJSON("/tools/worldBuilder/planetology/landWaterDistributions", function (data) {
			var mapped = $.map(data, function(item) {
				return new LandWaterDistribution(item)
			});
			self.distributions(mapped);
		});
	}
	self.getMasses = function () {
		$.getJSON("/tools/worldBuilder/planetology/landWaterMasses", function (data) {
			var mapped = $.map(data, function(item) {
				return new LandWaterMass(item)
			});
			self.masses(mapped);
		});
	}

	self.getHydrographies();
	self.getRegionTypes();
	self.getDisplayTypes();
	self.getDistributions();
	self.getMasses();
}

var mainModel = new HydrographyViewModel();
ko.applyBindings(mainModel);