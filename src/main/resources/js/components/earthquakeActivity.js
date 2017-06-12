define([ 'jquery', 'knockout' ], function($, ko) {
	var baseurl = "/tools/worldBuilder/planetology/earthquakeActivities";

	function EarthquakeActivity(data) {
		var self = this;
		self.id = data && data.id || null;
		self.strength = ko.observable(data && data.strength || null);
		self.frequency = ko.observable(data && data.frequency || null);
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

	EarthquakeActivity.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new EarthquakeActivity(item)
			});
			list(mapped);
		});
	}

	EarthquakeActivity.listEarthquakeStrengths = function(list) {
		$.getJSON(baseurl + "/earthquakeStrengths", function(data) {
			list(data);
		});
	}

	EarthquakeActivity.listEarthquakeFrequencies = function(list) {
		$.getJSON(baseurl + "/earthquakeFrequencies", function(data) {
			list(data);
		});
	}

	return EarthquakeActivity;
});