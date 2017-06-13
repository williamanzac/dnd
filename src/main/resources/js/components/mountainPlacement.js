define([ 'jquery', 'knockout' ], function($, ko) {
	var baseurl = "/tools/worldBuilder/planetology/mountainPlacements";

	function MountainPlacement(data) {
		var self = this;
		self.id = data && data.id || null;
		self.type = ko.observable(data && data.type || null);
		self.min = ko.observable(data && data.min || null);
		self.max = ko.observable(data && data.max || null);

		self.update = function() {
			var data = ko.toJS(self);
			$.ajax({
				method : "PUT",
				data : JSON.stringify(data),
				url : baseurl,
				contentType : "application/json",
				dataType : "json"
			});
		}
		self.create = function() {
			var data = ko.toJS(self);
			$.ajax({
				method : "POST",
				data : JSON.stringify(data),
				url : baseurl,
				contentType : "application/json",
				dataType : "json"
			});
		}
		self.remove = function() {
			$.ajax({
				method : "DELETE",
				url : baseurl + "/" + self.id,
				contentType : "application/json",
				dataType : "json"
			});
		}
	}

	MountainPlacement.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new MountainPlacement(item)
			});
			list(mapped);
		});
	}

	return MountainPlacement;
});