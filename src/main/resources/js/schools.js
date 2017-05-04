function School(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
	} else {
		self.name = ko.observable();
	}
}

function SchoolsViewModel() {
	var self = this;
	self.schools = ko.observableArray();
	self.newScore = ko.observable(new School());

	self.editSchoolModalVisible = ko.observable(false);
	self.showEditSchoolModal = function(data) {
		self.newScore(data);
		self.editSchoolModalVisible(true);
	};
	self.hideEditSchoolModal = function() {
		self.editSchoolModalVisible(false);
	};

	self.newSchoolModalVisible = ko.observable(false);
	self.showNewSchoolModal = function() {
		self.newScore(new School());
		self.newSchoolModalVisible(true);
	};
	self.hideNewSchoolModal = function() {
		self.newSchoolModalVisible(false);
	};

	self.getSchools = function() {
		$.getJSON("/admin/schools", function (data) {
			var mapped = $.map(data, function(item) {
				return new School(item)
			});
			self.schools(mapped);
		});
	}

	self.createSchool = function() {
		self.hideNewSchoolModal();
		var data = {
			"name": self.newScore().name(),
		};
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/admin/schools",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getSchools();
			self.newScore(new School());
		});
	}

	self.updateSchool = function() {
		self.hideEditSchoolModal();
		var data = {
			"id": parseInt(self.newScore().id),
			"name": self.newScore().name(),
		};
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/admin/schools",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getSchools();
			self.newScore(new School());
		});
	}
	
	self.getSchools();
}

var mainModel = new SchoolsViewModel();
ko.applyBindings(mainModel);