function Gear(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
		self.category = ko.observable(data.category);
		self.costGP = ko.observable(data.costGP);
		self.weightLB = ko.observable(data.weightLB);
	} else {
		self.name = ko.observable();
		self.category = ko.observable();
		self.costGP = ko.observable();
		self.weightLB = ko.observable();
	}
}

function GearViewModel() {
	var self = this;
	self.gear = ko.observableArray();
	self.newScore = ko.observable(new Gear());

	self.editGearModalVisible = ko.observable(false);
	self.showEditGearModal = function(data) {
		self.newScore(data);
		self.editGearModalVisible(true);
	};
	self.hideEditGearModal = function() {
		self.editGearModalVisible(false);
	};

	self.newGearModalVisible = ko.observable(false);
	self.showNewGearModal = function() {
		self.newScore(new Gear());
		self.newGearModalVisible(true);
	};
	self.hideNewGearModal = function() {
		self.newGearModalVisible(false);
	};

	self.getGear = function() {
		$.getJSON("/admin/gear", function (data) {
			var mapped = $.map(data, function(item) {
				return new Gear(item)
			});
			self.gear(mapped);
		});
	}

	self.createGear = function() {
		self.hideNewGearModal();
		var data = {
			"name": self.newScore().name(),
			"category": self.newScore().category(),
			"costGP": self.newScore().costGP(),
			"weightLB": self.newScore().weightLB(),
		};
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/admin/gear",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getGear();
			self.newScore(new Gear());
		});
	}

	self.updateGear = function() {
		self.hideEditGearModal();
		var data = {
			"id": parseInt(self.newScore().id),
			"name": self.newScore().name(),
			"category": self.newScore().category(),
			"costGP": self.newScore().costGP(),
			"weightLB": self.newScore().weightLB(),
		};
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/admin/gear",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getGear();
			self.newScore(new Gear());
		});
	}
	
	self.getGear();
}

var mainModel = new GearViewModel();
ko.applyBindings(mainModel);