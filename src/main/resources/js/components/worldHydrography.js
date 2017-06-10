define(['jquery', 'knockout'], function($, ko) {
	var baseurl = "/tools/worldBuilder/planetology/hydrographies";

	function WorldHydrography(data) {
		var self = this;
		if (data != null) {
			self.id = data.id;
			self.percent = ko.observable(data.percent);
			self.min = ko.observable(data.min);
			self.max = ko.observable(data.max);
		} else {
			self.percent = ko.observable();
			self.min = ko.observable();
			self.max = ko.observable();
		}

		self.update = function() {
			var data = ko.toJS(self);
			$.ajax({
				method: "PUT",
				data: JSON.stringify(data),
				url: baseurl,
				contentType: "application/json",
				dataType: "json"
			});
		}
		self.create = function() {
			var data = ko.toJS(self);
			$.ajax({
				method: "POST",
				data: JSON.stringify(data),
				url: baseurl,
				contentType: "application/json",
				dataType: "json"
			});
		}
		self.remove = function() {
			$.ajax({
				method: "DELETE",
				url: baseurl + "/" + self.id,
				contentType: "application/json",
				dataType: "json"
			});
		}
	}

	WorldHydrography.list = function(list) {
		$.getJSON(baseurl, function (data) {
			var mapped = $.map(data, function(item) {
				return new WorldHydrography(item)
			});
			list(mapped);
		});
	}

	return WorldHydrography;
});