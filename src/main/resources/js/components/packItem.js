define([ 'jquery', 'knockout', '../components/gear' ], function($, ko, Gear) {

	function PackItem(data) {
		var self = this;
		self.id = data && data.id || null;
		self.quantity = ko.observable(data && data.qiantity || null);
		self.item = new Gear(data && data.item || null);
	}

	return PackItem;
});