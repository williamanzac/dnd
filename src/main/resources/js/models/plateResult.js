define([ 'jquery', 'knockout' ], function($, ko) {
	return function PlateResult(data) {
		var self = this;
		self.positions = data && data.positions || [];
		self.sizes = data && data.sizes || [];
	}
});