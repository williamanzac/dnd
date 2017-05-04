function Condition(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
	} else {
		self.name = ko.observable();
	}
}

function ConditionsViewModel() {
	var self = this;
	self.conditions = ko.observableArray();
	self.newScore = ko.observable(new Condition());

	self.editConditionModalVisible = ko.observable(false);
	self.showEditConditionModal = function(data) {
		self.newScore(data);
		self.editConditionModalVisible(true);
	};
	self.hideEditConditionModal = function() {
		self.editConditionModalVisible(false);
	};

	self.newConditionModalVisible = ko.observable(false);
	self.showNewConditionModal = function() {
		self.newScore(new Condition());
		self.newConditionModalVisible(true);
	};
	self.hideNewConditionModal = function() {
		self.newConditionModalVisible(false);
	};

	self.getConditions = function() {
		$.getJSON("/admin/conditions", function (data) {
			var mapped = $.map(data, function(item) {
				return new Condition(item)
			});
			self.conditions(mapped);
		});
	}

	self.createCondition = function() {
		self.hideNewConditionModal();
		var data = {
			"name": self.newScore().name(),
		};
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/admin/conditions",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getConditions();
			self.newScore(new Condition());
		});
	}

	self.updateCondition = function() {
		self.hideEditConditionModal();
		var data = {
			"id": parseInt(self.newScore().id),
			"name": self.newScore().name(),
		};
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/admin/conditions",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getConditions();
			self.newScore(new Condition());
		});
	}
	
	self.getConditions();
}

var mainModel = new ConditionsViewModel();
ko.applyBindings(mainModel);