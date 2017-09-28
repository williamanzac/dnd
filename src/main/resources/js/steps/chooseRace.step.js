define([ 'jquery', 'knockout', '../models/step', '../models/race', '../models/ability', '../models/Language' ], function($, ko, Step, Race, Ability, Language) {
	function ChooseRaceStep(model) {
		var self = this;
		Step.call(this, 1, "Choose Race", 'chooseRace', model,  function() {
			var value = this.model().race();
			return typeof (value) !== 'undefined';
		});
		
		self.races = ko.observableArray([]);
		self.abilities = ko.observableArray([]);
		self.languages = ko.observableArray([]);

		self.selectRace = function(data) {
			self.model().race(data);
			// copy ability score adjustments
			self.model().abilityScoreAdjustments(data.allAbilityScoreAdjustments());
			self.model().speed(data.speed());
			var mapped = self.languages().filter(function(item) {
				return data.allLanguages().indexOf(item.name()) >= 0;
			});
			self.model().languages(mapped);
		}

		self.selectableAbilities = ko.pureComputed(function() {
			if (self.abilities().length == 0) {
				return [];
			}
			var adjustments = self.model().abilityScoreAdjustments().filter(function(item) {
				return item && item.ability();
			});
			var ids = $.map(adjustments, function(item) {
				return item.ability().id;
			});
			return self.abilities().filter(function(item) {
				return ids.indexOf(item.id) < 0;
			});
		});

		self.selectableLanguages = ko.pureComputed(function() {
			if (self.languages().length == 0) {
				return [];
			}
			var languages = self.model().languages().filter(function(item) {
				return item && item.name();
			});
			var ids = $.map(languages, function(item) {
				return item.id;
			});
			return self.languages().filter(function(item) {
				return ids.indexOf(item.id) < 0;
			});
		});

		Race.list(self.races);
		Ability.list(self.abilities);
		Language.list(self.languages);
	}
	
	ChooseRaceStep.prototype = Object.create(Step.prototype);
	ChooseRaceStep.prototype.constructor = ChooseRaceStep;
	

	return ChooseRaceStep;
});