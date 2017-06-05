function PlateMovement(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.description = ko.observable(data.description);
		self.min = ko.observable(data.min);
		self.max = ko.observable(data.max);
	} else {
		self.description = ko.observable();
		self.min = ko.observable();
		self.max = ko.observable();
	}
}

function WorldSize(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.diameter = ko.observable(data.diameter);
		self.min = ko.observable(data.min);
		self.max = ko.observable(data.max);
		self.worldMapSize = ko.observable(data.worldMapSize);
		self.regionMapSize = ko.observable(data.regionMapSize);
		self.mountainSizeAdjustment = ko.observable(data.mountainSizeAdjustment);
		self.mountainSizeComment = ko.observable(data.mountainSizeComment);
	} else {
		self.diameter = ko.observable();
		self.min = ko.observable();
		self.max = ko.observable();
		self.worldMapSize = ko.observable();
		self.regionMapSize = ko.observable();
		self.mountainSizeAdjustment = ko.observable();
		self.mountainSizeComment = ko.observable();
	}
}

function VolcanicActivity(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.activity = ko.observable(data.activity);
		self.min = ko.observable(data.min);
		self.max = ko.observable(data.max);
	} else {
		self.activity = ko.observable();
		self.min = ko.observable();
		self.max = ko.observable();
	}
}

function EarthquakeActivity(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.strength = ko.observable(data.strength);
		self.frequency = ko.observable(data.frequency);
		self.min = ko.observable(data.min);
		self.max = ko.observable(data.max);
	} else {
		self.strength = ko.observable();
		self.frequency = ko.observable();
		self.min = ko.observable();
		self.max = ko.observable();
	}
}

function MountainPlacement(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.type = ko.observable(data.type);
		self.min = ko.observable(data.min);
		self.max = ko.observable(data.max);
	} else {
		self.type = ko.observable();
		self.min = ko.observable();
		self.max = ko.observable();
	}
}

function MountainProperty(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.characteristic = ko.observable(data.characteristic);
		self.min = ko.observable(data.min);
		self.max = ko.observable(data.max);
	} else {
		self.characteristic = ko.observable();
		self.min = ko.observable();
		self.max = ko.observable();
	}
}

function SeismologyViewModel() {
	var self = this;
	self.plateMovements = ko.observableArray([]);
	self.worldSizes = ko.observableArray([]);
	self.volcanicActivities = ko.observableArray([]);
	self.earthquakeActivities = ko.observableArray([]);
	self.mountainPlacements = ko.observableArray([]);
	self.mountainProperties = ko.observableArray([]);

	self.times = ko.observable(3);
	self.plateResults = ko.observableArray([]);
	self.earthquakeStrengths = ko.observableArray();
	self.earthquakeFrequencies = ko.observableArray();

	self.editPlateMovement = ko.observable(new PlateMovement());
	self.editWorldSize = ko.observable(new WorldSize());
	self.editVolcanicActivity = ko.observable(new VolcanicActivity());
	self.editEarthquakeActivity = ko.observable(new EarthquakeActivity());
	self.editMountainPlacement = ko.observable(new MountainPlacement());
	self.editMountainProperty = ko.observable(new MountainProperty());

	self.editPlateMovementModalVisible = ko.observable(false);
	self.showEditPlateMovementModal = function(data) {
		self.editPlateMovement(data);
		self.editPlateMovementModalVisible(true);
	};
	self.hideEditPlateMovementModal = function() {
		self.editPlateMovementModalVisible(false);
	};

	self.editWorldSizeModalVisible = ko.observable(false);
	self.showEditWorldSizeModal = function(data) {
		self.editWorldSize(data);
		self.editWorldSizeModalVisible(true);
	};
	self.hideEditWorldSizeModal = function() {
		self.editWorldSizeModalVisible(false);
	};

	self.editVolcanicActivityModalVisible = ko.observable(false);
	self.showEditVolcanicActivityModal = function(data) {
		self.editVolcanicActivity(data);
		self.editVolcanicActivityModalVisible(true);
	};
	self.hideEditVolcanicActivityModal = function() {
		self.editVolcanicActivityModalVisible(false);
	};

	self.editEarthquakeActivityModalVisible = ko.observable(false);
	self.showEditEarthquakeActivityModal = function(data) {
		self.editEarthquakeActivity(data);
		self.editEarthquakeActivityModalVisible(true);
	};
	self.hideEditEarthquakeActivityModal = function() {
		self.editEarthquakeActivityModalVisible(false);
	};

	self.editMountainPlacementModalVisible = ko.observable(false);
	self.showEditMountainPlacementModal = function(data) {
		self.editMountainPlacement(data);
		self.editMountainPlacementModalVisible(true);
	};
	self.hideEditMountainPlacementModal = function() {
		self.editMountainPlacementModalVisible(false);
	};

	self.editMountainPropertyModalVisible = ko.observable(false);
	self.showEditMountainPropertyModal = function(data) {
		self.editMountainProperty(data);
		self.editMountainPropertyModalVisible(true);
	};
	self.hideEditMountainPropertyModal = function() {
		self.editMountainPropertyModalVisible(false);
	};

	self.newPlateMovementModalVisible = ko.observable(false);
	self.showNewPlateMovementModal = function() {
		self.editPlateMovement(new PlateMovement());
		self.newPlateMovementModalVisible(true);
	};
	self.hideNewPlateMovementModal = function() {
		self.newPlateMovementModalVisible(false);
	};

	self.newWorldSizeModalVisible = ko.observable(false);
	self.showNewWorldSizeModal = function() {
		self.editWorldSize(new WorldSize());
		self.newWorldSizeModalVisible(true);
	};
	self.hideNewWorldSizeModal = function() {
		self.newWorldSizeModalVisible(false);
	};

	self.newVolcanicActivityModalVisible = ko.observable(false);
	self.showNewVolcanicActivityModal = function() {
		self.editVolcanicActivity(new VolcanicActivity());
		self.newVolcanicActivityModalVisible(true);
	};
	self.hideNewVolcanicActivityModal = function() {
		self.newVolcanicActivityModalVisible(false);
	};

	self.newEarthquakeActivityModalVisible = ko.observable(false);
	self.showNewEarthquakeActivityModal = function() {
		self.editEarthquakeActivity(new EarthquakeActivity());
		self.newEarthquakeActivityModalVisible(true);
	};
	self.hideNewEarthquakeActivityModal = function() {
		self.newEarthquakeActivityModalVisible(false);
	};

	self.newMountainPlacementModalVisible = ko.observable(false);
	self.showNewMountainPlacementModal = function() {
		self.editMountainPlacement(new MountainPlacement());
		self.newMountainPlacementModalVisible(true);
	};
	self.hideNewMountainPlacementModal = function() {
		self.newMountainPlacementModalVisible(false);
	};

	self.newMountainPropertyModalVisible = ko.observable(false);
	self.showNewMountainPropertyModal = function() {
		self.editMountainProperty(new MountainProperty());
		self.newMountainPropertyModalVisible(true);
	};
	self.hideNewMountainPropertyModal = function() {
		self.newMountainPropertyModalVisible(false);
	};

	self.updatePlateMovement = function () {
		self.hideEditPlateMovementModal();
		var data = ko.toJS(self.editPlateMovement);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/plateMovements",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getPlateMovements();
		});
	}
	self.createPlateMovement = function () {
		self.hideNewPlateMovementModal();
		var data = ko.toJS(self.editPlateMovement);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/plateMovements",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getPlateMovements();
		});
	}
	self.removePlateMovement = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/plateMovements/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getPlateMovements();
		});
	}

	self.updateWorldSize = function () {
		self.hideEditWorldSizeModal();
		var data = ko.toJS(self.editWorldSize());
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/worldSizes",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getWorldSizes();
		});
	}
	self.createWorldSize = function () {
		self.hideNewWorldSizeModal();
		var data = ko.toJS(self.editWorldSize());
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/worldSizes",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getWorldSizes();
		});
	}
	self.removeWorldSize = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/worldSizes/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getWorldSizes();
		});
	}

	self.updateVolcanicActivity = function () {
		self.hideEditVolcanicActivityModal();
		var data = ko.toJS(self.editVolcanicActivity);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/volcanicActivities",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getVolcanicActivities();
		});
	}
	self.createVolcanicActivity = function () {
		self.hideNewVolcanicActivityModal();
		var data = ko.toJS(self.editVolcanicActivity);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/volcanicActivities",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getVolcanicActivities();
		});
	}
	self.removeVolcanicActivity = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/volcanicActivies/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getVolcanicActivities();
		});
	}

	self.updateEarthquakeActivity = function () {
		self.hideEditEarthquakeActivityModal();
		var data = ko.toJS(self.editEarthquakeActivity);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/earthquakeActivities",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getEarthquakeActivities();
		});
	}
	self.createEarthquakeActivity = function () {
		self.hideNewEarthquakeActivityModal();
		var data = ko.toJS(self.editEarthquakeActivity);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/earthquakeActivities",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getEarthquakeActivities();
		});
	}
	self.removeEarthquakeActivity = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/earthquakeActivies/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getEarthquakeActivities();
		});
	}

	self.updateMountainPlacement = function () {
		self.hideEditMountainPlacementModal();
		var data = ko.toJS(self.editMountainPlacement);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/mountainPlacements",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getMountainPlacements();
		});
	}
	self.createMountainPlacement = function () {
		self.hideNewMountainPlacementModal();
		var data = ko.toJS(self.editMountainPlacement);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/mountainPlacements",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getMountainPlacements();
		});
	}
	self.removeMountainPlacement = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/mountainPlacements/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getMountainPlacements();
		});
	}

	self.updateMountainProperty = function () {
		self.hideEditMountainPropertyModal();
		var data = ko.toJS(self.editMountainProperty);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/mountainProperties",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getMountainProperties();
		});
	}
	self.createMountainProperty = function () {
		self.hideNewMountainPropertyModal();
		var data = ko.toJS(self.editMountainProperty);
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/mountainProperties",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getMountainProperties();
		});
	}
	self.removeMountainProperty = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/mountainPlacements/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getMountainProperties();
		});
	}

	self.generatePlates = function () {
		$.ajax({
			method: "POST",
			url: "/tools/worldBuilder/planetology/tectonicPlates/generate?times=" + self.times(),
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.plateResults(data);
		});
	}

	self.getPlateMovements = function () {
		$.getJSON("/tools/worldBuilder/planetology/plateMovements", function (data) {
			var mapped = $.map(data, function(item) {
				return new PlateMovement(item)
			});
			self.plateMovements(mapped);
		});
	}
	self.getWorldSizes = function () {
		$.getJSON("/tools/worldBuilder/planetology/worldSizes", function (data) {
			var mapped = $.map(data, function(item) {
				return new WorldSize(item)
			});
			self.worldSizes(mapped);
		});
	}
	self.getVolcanicActivities = function () {
		$.getJSON("/tools/worldBuilder/planetology/volcanicActivities", function (data) {
			var mapped = $.map(data, function(item) {
				return new VolcanicActivity(item)
			});
			self.volcanicActivities(mapped);
		});
	}
	self.getEarthquakeActivities = function () {
		$.getJSON("/tools/worldBuilder/planetology/earthquakeActivities", function (data) {
			var mapped = $.map(data, function(item) {
				return new EarthquakeActivity(item)
			});
			self.earthquakeActivities(mapped);
		});
	}
	self.getMountainPlacements = function () {
		$.getJSON("/tools/worldBuilder/planetology/mountainPlacements", function (data) {
			var mapped = $.map(data, function(item) {
				return new MountainPlacement(item)
			});
			self.mountainPlacements(mapped);
		});
	}
	self.getMountainProperties = function () {
		$.getJSON("/tools/worldBuilder/planetology/mountainProperties", function (data) {
			var mapped = $.map(data, function(item) {
				return new MountainProperty(item)
			});
			self.mountainProperties(mapped);
		});
	}

	self.getEarthquakeStrengths = function () {
		$.getJSON("/tools/worldBuilder/planetology/earthquakeActivities/earthquakeStrengths", function (data) {
			self.earthquakeStrengths(data);
		});
	}
	self.getEarthquakeFrequencies = function () {
		$.getJSON("/tools/worldBuilder/planetology/earthquakeActivities/earthquakeFrequencies", function (data) {
			self.earthquakeFrequencies(data);
		});
	}

	self.getPlateMovements();
	self.getWorldSizes();
	self.getVolcanicActivities();
	self.getEarthquakeActivities();
	self.getEarthquakeStrengths();
	self.getEarthquakeFrequencies();
	self.getMountainPlacements();
	self.getMountainProperties();
}

var mainModel = new SeismologyViewModel();
ko.applyBindings(mainModel);