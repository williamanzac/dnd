define([ 'jquery', 'knockout', '../models/step' ], function($, ko, Step, html) {
	function ChooseRaceStep(model) {
		Step.call(this, 1, "Choose Race", 'chooseRace', model,  function() {
			var value = this.model().race();
			return typeof (value) !== 'undefined';
		});
	}
	
	ChooseRaceStep.prototype = Object.create(Step.prototype);
	ChooseRaceStep.prototype.constructor = ChooseRaceStep;
	
	return ChooseRaceStep;
});