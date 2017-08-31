define([ 'jquery', 'knockout' ], function($, ko) {
	
	function Step(id, name, template, model, isValid) {
		var self = this;
		self.id = id;
		self.name = ko.observable(name);
		self.template = template;
		self.model = ko.observable(model);
		
		self.isValid = isValid;
	}

	return Step;
});