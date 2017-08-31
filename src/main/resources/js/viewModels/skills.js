define([ 'jquery', 'knockout', 'Modal', '../models/skill', '../models/ability', 'knockstrap' ], function($, ko, Modal, Skill, Ability) {
	return function SkillViewModel() {
		var self = this;
		self.skills = ko.observableArray([]);
		self.abilities = ko.observableArray([]);

		self.editSkill = ko.observable(new Skill());

		self.editSkillModal = new Modal(self.editSkill);
		self.newSkillModal = new Modal(self.editSkill);

		self.showNewSkillModal = function() {
			self.newSkillModal.show(new Skill());
		}

		self.updateSkill = function() {
			self.editSkill().update();
			self.editSkillModal.hide();
			self.getSkills();
		}
		self.createSkill = function() {
			self.editSkill().create();
			self.newSkillModal.hide();
			self.getSkills();
			self.editSkill(new Skill());
		}

		self.getSkills = function() {
			Skill.list(self.skills);
		}
		self.getAbilities = function() {
			Ability.list(self.abilities);
		}

		self.getSkills();
		self.getAbilities();
	}
});