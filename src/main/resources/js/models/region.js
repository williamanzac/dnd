define([ 'jquery', 'knockout', '../lib/commaList' ], function($, ko, commaList) {

	function Region(data) {
		var self = this;
		self.id = data && data.id || null;
		self.number = ko.observable(data && data.number || null);
		self.adjacentRegions = ko.observableArray(data && data.adjacentRegions || []).extend({commaList});
	}

	return Region;
});