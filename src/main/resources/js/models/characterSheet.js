define([ 'jquery', 'knockout' ], function($, ko) {
	function CharacterSheet() {
		var self = this;
		self.race = ko.observable();
		self.abilityScoreAdjustments = ko.observableArray([]);

		self.class1 = ko.observable();
		self.class2 = ko.observable();
		self.class3 = ko.observable();
		self.level1 = ko.observable(1);
		self.level2 = ko.observable();
		self.level3 = ko.observable();
	}

	return CharacterSheet;
});