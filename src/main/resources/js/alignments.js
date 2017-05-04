function Alignment(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
	} else {
		self.name = ko.observable();
	}
}

function AlignmentsViewModel() {
	var self = this;
	self.alignments = ko.observableArray();
	self.newScore = ko.observable(new Alignment());

	self.editAlignmentModalVisible = ko.observable(false);
	self.showEditAlignmentModal = function(data) {
		self.newScore(data);
		self.editAlignmentModalVisible(true);
	};
	self.hideEditAlignmentModal = function() {
		self.editAlignmentModalVisible(false);
	};

	self.newAlignmentModalVisible = ko.observable(false);
	self.showNewAlignmentModal = function() {
		self.newScore(new Alignment());
		self.newAlignmentModalVisible(true);
	};
	self.hideNewAlignmentModal = function() {
		self.newAlignmentModalVisible(false);
	};

	self.getAlignments = function() {
		$.getJSON("/admin/alignments", function (data) {
			var mapped = $.map(data, function(item) {
				return new Alignment(item)
			});
			self.alignments(mapped);
		});
	}

	self.createAlignment = function() {
		self.hideNewAlignmentModal();
		var data = {
			"name": self.newScore().name(),
		};
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/admin/alignments",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getAlignments();
			self.newScore(new Alignment());
		});
	}

	self.updateAlignment = function() {
		self.hideEditAlignmentModal();
		var data = {
			"id": parseInt(self.newScore().id),
			"name": self.newScore().name(),
		};
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/admin/alignments",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getAlignments();
			self.newScore(new Alignment());
		});
	}
	
	self.getAlignments();
}

var mainModel = new AlignmentsViewModel();
ko.applyBindings(mainModel);