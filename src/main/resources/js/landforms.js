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

function LandformViewModel() {
	var self = this;
	self.mountainPlacements = ko.observableArray([]);
	self.mountainProperties = ko.observableArray([]);
	
	self.times = ko.observable(3);
	self.results = ko.observableArray([]);

	self.editMountainPlacement = ko.observable(new MountainPlacement());
	self.editMountainProperty = ko.observable(new MountainProperty());

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

	self.generateHydrography = function () {
		$.ajax({
			method: "POST",
			url: "/tools/worldBuilder/continentsgeography/hydrographies/generate?times=" + self.times(),
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

	self.getMountainPlacements();
	self.getMountainProperties();
}

var mainModel = new LandformViewModel();
ko.applyBindings(mainModel);