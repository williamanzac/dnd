define([ 'jquery', 'knockout', '../models/step' ], function($, ko, Step, html) {
	function ChooseClassStep(model) {
		Step.call(this, 1, "Choose Class", 'chooseClass', model,  function() {
			return true;
		});
	}
	
	ChooseClassStep.prototype = Object.create(Step.prototype);
	ChooseClassStep.prototype.constructor = ChooseClassStep;
	
	return ChooseClassStep;
});