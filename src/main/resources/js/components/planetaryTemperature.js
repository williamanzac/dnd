define([ 'jquery', 'knockout' ], function($, ko) {
	var baseurl = "/tools/worldBuilder/planetology/planetaryTemperatures";

	function PlanetaryTemperature(data) {
		var self = this;
		self.id = data && data.id || null;
		self.category = ko.observable(data && data.category || null);
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

	PlanetaryTemperature.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new PlanetaryTemperature(item)
			});
			list(mapped);
		});
	}

	return PlanetaryTemperature;
});