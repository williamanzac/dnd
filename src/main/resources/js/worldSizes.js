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

function WorldSizeViewModel() {
	var self = this;
	self.worldSizes = ko.observableArray([]);
	self.sizes = ko.observableArray([]);
	self.times = ko.observable(3);

	self.editWorldSize = ko.observable(new WorldSize());

	self.editWorldSizeModalVisible = ko.observable(false);
	self.showEditWorldSizeModal = function(data) {
		self.editWorldSize(data);
		self.editWorldSizeModalVisible(true);
	};
	self.hideEditWorldSizeModal = function() {
		self.editWorldSizeModalVisible(false);
	};

	self.newWorldSizeModalVisible = ko.observable(false);
	self.showNewWorldSizeModal = function() {
		self.editWorldSize(new WorldSize());
		self.newWorldSizeModalVisible(true);
	};
	self.hideNewWorldSizeModal = function() {
		self.newWorldSizeModalVisible(false);
	};

	self.updateWorldSize = function () {
		self.hideEditWorldSizeModal();
		var data = {
			"id": parseInt(self.editWorldSize().id),
			"diameter": parseInt(self.editWorldSize().diameter()),
			"min": parseInt(self.editWorldSize().min()),
			"max": parseInt(self.editWorldSize().max()),
			"worldMapSize": parseInt(self.editWorldSize().worldMapSize()),
			"regionMapSize": parseInt(self.editWorldSize().regionMapSize())
		};
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
		var data = {
			"diameter": parseInt(self.editWorldSize().diameter()),
			"min": parseInt(self.editWorldSize().min()),
			"max": parseInt(self.editWorldSize().max()),
			"worldMapSize": parseInt(self.editWorldSize().worldMapSize()),
			"regionMapSize": parseInt(self.editWorldSize().regionMapSize())
		};
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

	self.generate = function () {
		$.ajax({
			method: "POST",
			url: "/tools/worldBuilder/planetology/worldSizes/generate?times=" + self.times(),
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.sizes(data);
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

	self.getWorldSizes = function () {
		$.getJSON("/tools/worldBuilder/planetology/worldSizes", function (data) {
			var mapped = $.map(data, function(item) {
				return new WorldSize(item)
			});
			self.worldSizes(mapped);
		});
	}

	self.getWorldSizes();
}

var mainModel = new WorldSizeViewModel();
ko.applyBindings(mainModel);