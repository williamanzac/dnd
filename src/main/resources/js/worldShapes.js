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

function WorldShapeViewModel() {
	var self = this;
	self.worldShapes = ko.observableArray([]);
	self.shapes = ko.observableArray([]);
	self.times = ko.observable(3);

	self.editWorldShape = ko.observable(new WorldShape());

	self.editWorldShapeModalVisible = ko.observable(false);
	self.showEditWorldShapeModal = function(data) {
		self.editWorldShape(data);
		self.editWorldShapeModalVisible(true);
	};
	self.hideEditWorldShapeModal = function() {
		self.editWorldShapeModalVisible(false);
	};

	self.newWorldShapeModalVisible = ko.observable(false);
	self.showNewWorldShapeModal = function() {
		self.editWorldShape(new WorldShape());
		self.newWorldShapeModalVisible(true);
	};
	self.hideNewWorldShapeModal = function() {
		self.newWorldShapeModalVisible(false);
	};

	self.updateWorldShape = function () {
		self.hideEditWorldShapeModal();
		var data = {
			"id": parseInt(self.editWorldShape().id),
			"name": self.editWorldShape().name(),
			"min": parseInt(self.editWorldShape().min()),
			"max": parseInt(self.editWorldShape().max())
		};
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
		var data = {
			"name": self.editWorldShape().name(),
			"min": parseInt(self.editWorldShape().min()),
			"max": parseInt(self.editWorldShape().max())
		};
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

	self.generate = function () {
		$.ajax({
			method: "POST",
			url: "/tools/worldBuilder/planetology/worldShapes/generate?times=" + self.times(),
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.shapes(data);
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

	self.getWorldShapes = function () {
		$.getJSON("/tools/worldBuilder/planetology/worldShapes", function (data) {
			var mapped = $.map(data, function(item) {
				return new WorldShape(item)
			});
			self.worldShapes(mapped);
		});
	}

	self.getWorldShapes();
}

var mainModel = new WorldShapeViewModel();
ko.applyBindings(mainModel);