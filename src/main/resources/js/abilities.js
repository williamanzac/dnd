function Ability(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
	} else {
		self.name = ko.observable();
	}
}

function AbilitiesViewModel() {
	var self = this;
	self.abilities = ko.observableArray();
	self.newScore = ko.observable(new Ability());

	self.editAbilityModalVisible = ko.observable(false);
	self.showEditAbilityModal = function(data) {
		self.newScore(data);
		self.editAbilityModalVisible(true);
	};
	self.hideEditAbilityModal = function() {
		self.editAbilityModalVisible(false);
	};

	self.newAbilityModalVisible = ko.observable(false);
	self.showNewAbilityModal = function() {
		self.newScore(new Ability());
		self.newAbilityModalVisible(true);
	};
	self.hideNewAbilityModal = function() {
		self.newAbilityModalVisible(false);
	};

	self.getAbilities = function() {
		$.getJSON("/admin/abilities", function (data) {
			var mapped = $.map(data, function(item) {
				return new Ability(item)
			});
			self.abilities(mapped);
		});
	}

	self.createAbility = function() {
		self.hideNewAbilityModal();
		var data = {
			"name": self.newScore().name(),
		};
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/admin/abilities",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getAbilities();
			self.newScore(new Ability());
		});
	}

	self.updateAbility = function() {
		self.hideEditAbilityModal();
		var data = {
			"id": parseInt(self.newScore().id),
			"name": self.newScore().name(),
		};
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/admin/abilities",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getAbilities();
			self.newScore(new Ability());
		});
	}
	
	self.getAbilities();
}

var mainModel = new AbilitiesViewModel();
ko.applyBindings(mainModel);