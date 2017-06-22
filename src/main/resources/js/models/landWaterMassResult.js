define([ 'jquery', 'knockout', '../models/landWaterMass' ], function($, ko, LandWaterMass) {
	return function LandWaterMassResult(data) {
		var self = this;
		self.mass = new LandWaterMass(data && data.mass || null);
		self.positions = data && data.positions || [];
		self.sizes = data && data.sizes || [];
	}
});