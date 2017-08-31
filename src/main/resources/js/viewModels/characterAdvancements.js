define([ 'jquery', 'knockout', 'Modal', '../models/characterAdvancement', 'knockstrap' ], function($, ko, Modal, CharacterAdvancement) {
	return function CharacterAdvancementViewModel() {
		var self = this;
		self.characterAdvancements = ko.observableArray([]);

		self.editCharacterAdvancement = ko.observable(new CharacterAdvancement());

		self.editCharacterAdvancementModal = new Modal(self.editCharacterAdvancement);
		self.newCharacterAdvancementModal = new Modal(self.editCharacterAdvancement);

		self.showNewCharacterAdvancementModal = function() {
			self.newCharacterAdvancementModal.show(new CharacterAdvancement());
		}

		self.updateCharacterAdvancement = function() {
			self.editCharacterAdvancement().update();
			self.editCharacterAdvancementModal.hide();
			self.getCharacterAdvancements();
		}
		self.createCharacterAdvancement = function() {
			self.editCharacterAdvancement().create();
			self.newCharacterAdvancementModal.hide();
			self.getCharacterAdvancements();
			self.editCharacterAdvancement(new CharacterAdvancement());
		}

		self.getCharacterAdvancements = function() {
			CharacterAdvancement.list(self.characterAdvancements);
		}

		self.getCharacterAdvancements();
	}
});