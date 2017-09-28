define([ 'jquery', 'knockout', '../models/ability' ], function($, ko, Ability) {

	var abilities = ko.observableArray([]);
	function AbilityScoreAdjustment(data) {
		var self = this;
		self.ability = ko.observable(new Ability(data && data.ability || null));
		self.editable = !(data && data.ability);
		self.modifier = ko.observable(data && data.modifier || null);
		self.abilityId = ko.pureComputed({
	        read: function () {
	            return (this.ability() !== null && this.ability() !== undefined) ? this.ability.id : null;
	        },
	        write: function (value) {
	        	if (value === null || value === undefined) {
	        		this.ability(null);
	        	} else {
	        		var selected = abilities().filter(function(item) {
	        			return item.id === value;
	        		})[0];
	        		var temp = ko.toJS(selected);
	        		this.ability(selected);
	        	}
	        },
	        owner: this
	    });
	}
	Ability.list(abilities);

	return AbilityScoreAdjustment;
});