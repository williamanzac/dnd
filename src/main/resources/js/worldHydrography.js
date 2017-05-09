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

function HydrographyViewModel() {
	var self = this;
	self.worldHydrographies = ko.observableArray([]);
	self.hydrographies = ko.observableArray([]);
	self.times = ko.observable(3);

	self.editHydrography = ko.observable(new Hydrography());

	self.editHydrographyModalVisible = ko.observable(false);
	self.showEditHydrographyModal = function(data) {
		self.editHydrography(data);
		self.editHydrographyModalVisible(true);
	};
	self.hideEditHydrographyModal = function() {
		self.editHydrographyModalVisible(false);
	};

	self.newHydrographyModalVisible = ko.observable(false);
	self.showNewHydrographyModal = function() {
		self.editHydrography(new Hydrography());
		self.newHydrographyModalVisible(true);
	};
	self.hideNewHydrographyModal = function() {
		self.newHydrographyModalVisible(false);
	};

	self.updateHydrography = function () {
		self.hideEditHydrographyModal();
		var data = {
			"id": parseInt(self.editHydrography().id),
			"percent": parseInt(self.editHydrography().percent()),
			"min": parseInt(self.editHydrography().min()),
			"max": parseInt(self.editHydrography().max())
		};
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
		var data = {
			"percent": parseInt(self.editHydrography().percent()),
			"min": parseInt(self.editHydrography().min()),
			"max": parseInt(self.editHydrography().max())
		};
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

	self.generate = function () {
		$.ajax({
			method: "POST",
			url: "/tools/worldBuilder/planetology/hydrographies/generate?times=" + self.times(),
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.hydrographies(data);
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

	self.getHydrographies = function () {
		$.getJSON("/tools/worldBuilder/planetology/hydrographies", function (data) {
			var mapped = $.map(data, function(item) {
				return new Hydrography(item)
			});
			self.worldHydrographies(mapped);
		});
	}

	self.getHydrographies();
}

var mainModel = new HydrographyViewModel();
ko.applyBindings(mainModel);