define([ 'jquery', 'knockout', 'Modal', '../models/race', '../models/abilityScoreAdjustment', '../models/ability',
        '../models/Language', 'knockstrap' ], function($, ko, Modal, Race, AbilityScoreAdjustment, Ability, Language) {
	return function RaceViewModel() {
		var self = this;
		self.races = ko.observableArray([]);
		self.newAbilityScoreAdjustment = ko.observable(new AbilityScoreAdjustment());
		self.abilities = ko.observableArray([]);
		self.languages = ko.observableArray([]);
		self.newLanguage = ko.observable();

		self.editRace = ko.observable(new Race());
		self.editSubRace = ko.observable(new Race());

		self.editRaceModal = new Modal(self.editRace);
		self.newRaceModal = new Modal(self.editRace);
		self.newSubRaceModal = new Modal(self.editSubRace);

		self.addAbilityScoreAdjustment = function() {
			var score = self.newAbilityScoreAdjustment();
			self.editRace().abilityScoreAdjustments.push(score);
			self.newAbilityScoreAdjustment(new AbilityScoreAdjustment());
		}
		self.addLanguage = function() {
			self.editRace().languages.push(self.newLanguage());
		}

		self.showNewRaceModal = function() {
			self.newRaceModal.show(new Race());
		}

		self.showNewSubRaceModal = function(parent) {
			self.editRace(parent);
			self.editSubRace(new Race());
			self.newSubRaceModal.show(self.editSubRace());
		}

		self.updateRace = function() {
			self.editRace().update();
			self.editRaceModal.hide();
			self.getRaces();
		}
		self.createRace = function() {
			self.editRace().create();
			self.newRaceModal.hide();
			self.getRaces();
			self.editRace(new Race());
		}
		self.createSubRace = function() {
			self.editRace().createSubRace(self.editSubRace());
			self.newSubRaceModal.hide();
			self.getRaces();
			self.editRace(new Race());
		}

		self.getRaces = function() {
			Race.list(self.races);
		}
		self.getAbilities = function() {
			Ability.list(self.abilities);
		}
		self.getLanguages = function() {
			Language.list(self.languages);
		}

		self.getRaces();
		self.getAbilities();
		self.getLanguages();
	}
});