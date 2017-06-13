function Hydrography(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.continentalForm = ko.observable(data.continentalForm);
		self.min = ko.observable(data.min);
		self.max = ko.observable(data.max);
	} else {
		self.continentalForm = ko.observable();
		self.min = ko.observable();
		self.max = ko.observable();
	}
}

function HydrographyViewModel() {
	var self = this;
	self.hydrographies = ko.observableArray([]);
	
	self.times = ko.observable(3);
	self.results = ko.observableArray([]);

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
		var data = ko.toJS(self.editHydrography());
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/worldBuilder/continentsgeography/hydrographies",
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
			url: "/tools/worldBuilder/continentsgeography/hydrographies",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getHydrographies();
		});
	}
	self.removeHydrography = function (data) {
		$.ajax({
			method: "DELETE",
			url: "/tools/worldBuilder/continentsgeography/hydrographies/" + data.id,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getHydrographies();
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

	self.getHydrographies = function () {
		$.getJSON("/tools/worldBuilder/continentsgeography/hydrographies", function (data) {
			var mapped = $.map(data, function(item) {
				return new Hydrography(item)
			});
			self.hydrographies(mapped);
		});
	}

	self.getHydrographies();
}

var mainModel = new HydrographyViewModel();
ko.applyBindings(mainModel);