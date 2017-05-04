function AbilityScore(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.score = ko.observable(data.score);
		self.modifier = ko.observable(data.modifier);
	} else {
		self.score = ko.observable();
		self.modifier = ko.observable();
	}
}

function AbilityScoresViewModel() {
	var self = this;
	self.abilityScores = ko.observableArray();
	self.newScore = ko.observable(new AbilityScore());

	self.editAbilityScoreModalVisible = ko.observable(false);
	self.showEditAbilityScoreModal = function(data) {
		self.newScore(data);
		self.editAbilityScoreModalVisible(true);
	};
	self.hideEditAbilityScoreModal = function() {
		self.editAbilityScoreModalVisible(false);
	};

	self.newAbilityScoreModalVisible = ko.observable(false);
	self.showNewAbilityScoreModal = function() {
		self.newScore(new AbilityScore());
		self.newAbilityScoreModalVisible(true);
	};
	self.hideNewAbilityScoreModal = function() {
		self.newAbilityScoreModalVisible(false);
	};

	self.getAbilityScores = function() {
		$.getJSON("/admin/abilityScores", function (data) {
			var mapped = $.map(data, function(item) {
				return new AbilityScore(item)
			});
			self.abilityScores(mapped);
		});
	}

	self.createAbilityScore = function() {
		self.hideNewAbilityScoreModal();
		var data = {
			"score": parseInt(self.newScore().score()),
			"modifier": parseInt(self.newScore().modifier())
		};
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/admin/abilityScores",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getAbilityScores();
			self.newScore(new AbilityScore());
		});
	}

	self.updateAbilityScore = function() {
		self.hideEditAbilityScoreModal();
		var data = {
			"id": parseInt(self.newScore().id),
			"score": parseInt(self.newScore().score()),
			"modifier": parseInt(self.newScore().modifier())
		};
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/admin/abilityScores",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getAbilityScores();
			self.newScore(new AbilityScore());
		});
	}
	
	self.getAbilityScores();
}

var mainModel = new AbilityScoresViewModel();
ko.applyBindings(mainModel);