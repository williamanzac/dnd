define([ 'jquery', 'knockout', 'Modal', '../models/earthquakeActivity', '../models/mountainPlacement',
        '../models/mountainProperty', '../models/plateMovement', '../models/volcanicActivity',
        '../models/worldSize', 'knockstrap' ], function($, ko, Modal, EarthquakeActivity, MountainPlacement,
        MountainProperty, PlateMovement, VolcanicActivity, WorldSize) {
	return function SeismologyViewModel() {
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

		self.editPlateMovementModal = new Modal(self.editPlateMovement);
		self.editWorldSizeModal = new Modal(self.editWorldSize);
		self.editVolcanicActivityModal = new Modal(self.editVolcanicActivity);
		self.editEarthquakeActivityModal = new Modal(self.editEarthquakeActivity);
		self.editMountainPlacementModal = new Modal(self.editMountainPlacement);
		self.editMountainPropertyModal = new Modal(self.editMountainProperty);

		self.newPlateMovementModal = new Modal(self.editPlateMovement);
		self.newWorldSizeModal = new Modal(self.editWorldSize);
		self.newVolcanicActivityModal = new Modal(self.editVolcanicActivity);
		self.newEarthquakeActivityModal = new Modal(self.editEarthquakeActivity);
		self.newMountainPlacementModal = new Modal(self.editMountainPlacementModal);
		self.newMountainPropertyModal = new Modal(self.editMountainProperty);

		self.updatePlateMovement = function() {
			self.editPlateMovement().update();
		}
		self.createPlateMovement = function() {
			self.editPlateMovement().create();
		}

		self.updateWorldSize = function() {
			self.editWorldSize().update();
		}
		self.createWorldSize = function() {
			self.editWorldSize().create();
		}

		self.updateVolcanicActivity = function() {
			self.editVolcanicActivity().update();
		}
		self.createVolcanicActivity = function() {
			self.editVolcanicActivity().create();
		}

		self.updateEarthquakeActivity = function() {
			self.editEarthquakeActivity().update();
		}
		self.createEarthquakeActivity = function() {
			self.editEarthquakeActivity().create();
		}

		self.updateMountainPlacement = function() {
			self.editMountainPlacement().update();
		}
		self.createMountainPlacement = function() {
			self.editMountainPlacement().create();
		}

		self.updateMountainProperty = function() {
			self.editMountainProperty().update();
		}
		self.createMountainProperty = function() {
			self.editMountainProperty().create();
		}

		self.generatePlates = function() {
			$.ajax({
			    method : "POST",
			    url : "/tools/worldBuilder/planetology/tectonicPlates/generate?times=" + self.times(),
			    contentType : "application/json",
			    dataType : "json"
			}).done(function(data) {
				self.plateResults(data);
			});
		}

		self.getPlateMovements = function() {
			PlateMovement.list(self.plateMovements);
		}
		self.getWorldSizes = function() {
			WorldSize.list(self.worldSizes);
		}
		self.getVolcanicActivities = function() {
			VolcanicActivity.list(self.volcanicActivities);
		}
		self.getEarthquakeActivities = function() {
			EarthquakeActivity.list(self.earthquakeActivities);
		}
		self.getMountainPlacements = function() {
			MountainPlacement.list(self.mountainPlacements);
		}
		self.getMountainProperties = function() {
			MountainProperty.list(self.mountainProperties);
		}

		self.getEarthquakeStrengths = function() {
			EarthquakeActivity.listEarthquakeStrengths(self.earthquakeStrengths);
		}
		self.getEarthquakeFrequencies = function() {
			EarthquakeActivity.listEarthquakeFrequencies(self.earthquakeFrequencies);
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
});