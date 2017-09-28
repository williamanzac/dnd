define([ 'jquery', 'knockout', '../models/step', '../models/characterSheet', '../models/race', '../models/ability',
        '../models/skill', '../steps/chooseRace.step', '../steps/chooseClass.step' ], function($, ko, Step,
        CharacterSheet, Race, Ability, Skill, ChooseRaceStep, ChooseClassStep) {
	return function CharactersViewModel() {
		var self = this;
		self.characterSheet = new CharacterSheet();
		self.abilities = ko.observableArray([]);
		self.skills = ko.observableArray([]);

		self.steps = ko.observableArray([ new ChooseRaceStep(self.characterSheet),
		        new ChooseClassStep(self.characterSheet) ]);
		self.step = ko.observable(self.steps()[0]);
		self.stepIndex = ko.computed(function() {
			return self.steps.indexOf(self.step());
		});

		self.getTemplate = function(data) {
			return self.step().template;
		};

		self.canGoNext = ko.computed(function() {
			return self.stepIndex() < self.steps().length - 1;
		});
		self.canGoBack = ko.computed(function() {
			return self.stepIndex() > 0;
		});
		self.canFinish = ko.computed(function() {
			return self.stepIndex() == (self.steps().length - 1);
		});
		self.canCancel = ko.computed(function() {
			return true;
		});

		self.next = function() {
			if (!self.step().isValid()) {
				alert("not valid");
				return;
			}
			if (self.canGoNext()) {
				self.step(self.steps()[self.stepIndex() + 1]);
			}
		}
		self.back = function() {
			if (self.canGoBack()) {
				self.step(self.steps()[self.stepIndex() - 1]);
			}
		}
		self.cancel = function() {

		}
		self.finish = function() {
			if (!self.step().isValid()) {
				alert("not valid");
				return;
			}
		}

		self.getAbilities = function() {
			Ability.list(self.abilities);
		}
		self.getSkills = function() {
			Skill.list(self.skills);
		}

		self.getAbilities();
		self.getSkills();
	}
});