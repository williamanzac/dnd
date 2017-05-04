function HeightWeight(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.type = ko.observable(data.type);
		self.baseHeight = ko.observable(Math.floor(data.baseHeightInch / 12) + "'" + (data.baseHeightInch - (Math.floor(data.baseHeightInch / 12) * 12)) + '"');
		self.heightModifier = ko.observable(data.heightModifier);
		self.baseWeightLB = ko.observable(data.baseWeightLB);
		self.weightModifier = ko.observable(data.weightModifier);
	} else {
		self.type = ko.observable();
		self.baseHeight = ko.observable();
		self.heightModifier = ko.observable();
		self.baseWeightLB = ko.observable();
		self.weightModifier = ko.observable();
	}
}

function HeightWeightViewModel() {
	var self = this;
	self.result = ko.observableArray();
	self.times = ko.observable(1);
	self.heightWeights = ko.observableArray();
	self.newScore = ko.observable(new HeightWeight());

	self.editHeightWeightModalVisible = ko.observable(false);
	self.showEditHeightWeightModal = function(data) {
		self.newScore(data);
		self.editHeightWeightModalVisible(true);
	};
	self.hideEditHeightWeightModal = function() {
		self.editHeightWeightModalVisible(false);
	};

	self.newHeightWeightModalVisible = ko.observable(false);
	self.showNewHeightWeightModal = function() {
		self.newScore(new HeightWeight());
		self.newHeightWeightModalVisible(true);
	};
	self.hideNewHeightWeightModal = function() {
		self.newHeightWeightModalVisible(false);
	};

	self.getHeightWeights = function() {
		$.getJSON("/tools/heightWeights", function (data) {
			var mapped = $.map(data, function(item) {
				return new HeightWeight(item)
			});
			self.heightWeights(mapped);
		});
	}

	self.createHeightWeight = function() {
		self.hideNewHeightWeightModal();
		var myArray = /(\d+)'(\d+)"/g.exec(self.newScore().baseHeight());
		var baseHeight = parseInt(myArray[1]) * 12 + parseInt(myArray[2]);
		console.log(baseHeight);
		var data = {
			"type": self.newScore().type(),
			"baseHeightInch": baseHeight,
			"heightModifier": self.newScore().heightModifier(),
			"baseWeightLB": parseInt(self.newScore().baseWeightLB()),
			"weightModifier": self.newScore().weightModifier()
		};
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/tools/heightWeights",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getHeightWeights();
			self.newScore(new HeightWeight());
		});
	}

	self.updateHeightWeight = function() {
		self.hideEditHeightWeightModal();
		var myArray = /(\d+)'(\d+)"/g.exec(self.newScore().baseHeight());
		var baseHeight = parseInt(myArray[1]) * 12 + parseInt(myArray[2]);
		console.log(baseHeight);
		var data = {
			"id": parseInt(self.newScore().id),
			"type": self.newScore().type(),
			"baseHeightInch": baseHeight,
			"heightModifier": self.newScore().heightModifier(),
			"baseWeightLB": parseInt(self.newScore().baseWeightLB()),
			"weightModifier": self.newScore().weightModifier()
		};
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/tools/heightWeights",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getHeightWeights();
			self.newScore(new HeightWeight());
		});
	}

	self.generate = function(heightWeight) {
		$.ajax({
			method: "POST",
			url: "/tools/heightWeights/" + heightWeight.type() + "/generate?times=" + self.times(),
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.result(data);
		});
	}

	self.remove = function (heightWeight) {
		$.ajax({
			method: "DELETE",
			url: "/tools/heightWeights/" + heightWeight.type(),
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.getNameSets();
		});
	}

	self.getHeightWeights();
}

var mainModel = new HeightWeightViewModel();
ko.applyBindings(mainModel);