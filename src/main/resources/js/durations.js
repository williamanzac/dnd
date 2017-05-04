function Duration(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
	} else {
		self.name = ko.observable();
	}
}

function DurationsViewModel() {
	var self = this;
	self.durations = ko.observableArray();
	self.newScore = ko.observable(new Duration());

	self.editDurationModalVisible = ko.observable(false);
	self.showEditDurationModal = function(data) {
		self.newScore(data);
		self.editDurationModalVisible(true);
	};
	self.hideEditDurationModal = function() {
		self.editDurationModalVisible(false);
	};

	self.newDurationModalVisible = ko.observable(false);
	self.showNewDurationModal = function() {
		self.newScore(new Duration());
		self.newDurationModalVisible(true);
	};
	self.hideNewDurationModal = function() {
		self.newDurationModalVisible(false);
	};

	self.getDurations = function() {
		$.getJSON("/admin/durations", function (data) {
			var mapped = $.map(data, function(item) {
				return new Duration(item)
			});
			self.durations(mapped);
		});
	}

	self.createDuration = function() {
		self.hideNewDurationModal();
		var data = {
			"name": self.newScore().name(),
		};
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/admin/durations",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getDurations();
			self.newScore(new Duration());
		});
	}

	self.updateDuration = function() {
		self.hideEditDurationModal();
		var data = {
			"id": parseInt(self.newScore().id),
			"name": self.newScore().name(),
		};
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/admin/durations",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getDurations();
			self.newScore(new Duration());
		});
	}
	
	self.getDurations();
}

var mainModel = new DurationsViewModel();
ko.applyBindings(mainModel);