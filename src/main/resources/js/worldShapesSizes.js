function WorldShape(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
		self.min = ko.observable(data.min);
		self.max = ko.observable(data.max);
	} else {
		self.name = ko.observable();
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
	} else {
		self.diameter = ko.observable();
		self.min = ko.observable();
		self.max = ko.observable();
		self.worldMapSize = ko.observable();
		self.regionMapSize = ko.observable();
	}
}

function WorldShapeViewModel() {
	var self = this;
	self.worldShapes = ko.observableArray([]);
	self.worldSizes = ko.observableArray([]);

	self.shapes = ko.observableArray([]);
	self.sizes = ko.observableArray([]);
	self.times = ko.observable(3);

	self.editWorldShape = ko.observable(new WorldShape());
	self.editWorldSize = ko.observable(new WorldSize());

	self.editWorldShapeModalVisible = ko.observable(false);
	self.showEditWorldShapeModal = function(data) {
		self.editWorldShape(data);
		self.editWorldShapeModalVisible(true);
	};
	self.hideEditWorldShapeModal = function() {
		self.editWorldShapeModalVisible(false);
	};

	self.editWorldSizeModalVisible = ko.observable(false);
	self.showEditWorldSizeModal = function(data) {
		self.editWorldSize(data);
		self.editWorldSizeModalVisible(true);
	};
	self.hideEditWorldSizeModal = function() {
		self.editWorldSizeModalVisible(false);
	};

	self.newWorldShapeModalVisible = ko.observable(false);
	self.showNewWorldShapeModal = function() {
		self.editWorldShape(new WorldShape());
		self.newWorldShapeModalVisible(true);
	};
	self.hideNewWorldShapeModal = function() {
		self.newWorldShapeModalVisible(false);
	};

	self.newWorldSizeModalVisible = ko.observable(false);
	self.showNewWorldSizeModal = function() {
		self.editWorldSize(new WorldSize());
		self.newWorldSizeModalVisible(true);
	};
	self.hideNewWorldSizeModal = function() {
		self.newWorldSizeModalVisible(false);
	};

	self.updateWorldShape = function () {
		self.hideEditWorldShapeModal();
		var data = ko.toJS(self.editWorldShape());
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/worldShapes",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getWorldShapes();
		});
	}
	self.createWorldShape = function () {
		self.hideNewWorldShapeModal();
		var data = ko.toJS(self.editWorldShape());
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/planetology/worldShapes",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getWorldShapes();
		});
	}
	self.removeWorldShape = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/planetology/worldShapes/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getWorldShapes();
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

	self.generateShape = function () {
		$.ajax({
			method: "POST",
			url: "/tools/worldBuilder/planetology/worldShapes/generate?times=" + self.times(),
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.shapes(data);
		});
	}
	self.generateSize = function () {
		$.ajax({
			method: "POST",
			url: "/tools/worldBuilder/planetology/worldSizes/generate?times=" + self.times(),
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.sizes(data);
		});
	}

	self.getWorldShapes = function () {
		$.getJSON("/tools/worldBuilder/planetology/worldShapes", function (data) {
			var mapped = $.map(data, function(item) {
				return new WorldShape(item)
			});
			self.worldShapes(mapped);
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

	self.getWorldShapes();
	self.getWorldSizes();
}

var mainModel = new WorldShapeViewModel();
ko.applyBindings(mainModel);