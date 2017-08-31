define([ 'jquery', 'knockout', '../models/step', '../models/characterSheet', '../models/race', '../models/ability', '../models/skill' ],
        function($, ko, Step, CharacterSheet, Race, Ability, Skill) {
	        return function DiceViewModel() {
		        var self = this;
		        self.characterSheet = new CharacterSheet();
		        self.races = ko.observableArray([]);
		        self.abilities = ko.observableArray([]);
		        self.skills = ko.observableArray([]);
		        self.selectableAbilities = ko.pureComputed(function() {
		        	if (self.abilities().length == 0) {
		        		return [];
		        	}
		        	var ids = $.map(self.characterSheet.abilityScoreAdjustments(), function(item) {
						return item.ability().id;
					});
		        	return self.abilities().filter(function(item) {
		        		return ids.indexOf(item.id) < 0;
		        	});
		        });

		        self.steps = ko.observableArray([
		                new Step(1, "Choose Race", "chooseRace", self.characterSheet, function() {
			                var value = this.model().race();
			                return typeof (value) !== 'undefined';
		                }), new Step(2, "Choose Class", "chooseClass", self.characterSheet, function() {
			                return true;
		                }), ]);
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

		        self.selectRace = function(data) {
		        	self.characterSheet.race(data);
		        	// copy ability score adjustments
		        	var adjustments = data.abilityScoreAdjustments();
		        	self.characterSheet.abilityScoreAdjustments(adjustments);
		        }
		        
		        self.getRaces = function() {
			        Race.list(self.races);
		        }
		        self.getAbilities = function() {
			        Ability.list(self.abilities);
		        }
		        self.getSkills = function() {
			        Skill.list(self.skills);
		        }

		        self.getRaces();
		        self.getAbilities();
		        self.getSkills();
	        }
        });