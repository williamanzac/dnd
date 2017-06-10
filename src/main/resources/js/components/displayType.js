define(['jquery', 'knockout'], function($, ko) {
	var baseurl = "/tools/worldBuilder/planetology/displayTypes";

	function DisplayType(data) {
		var self = this;
		if (data != null) {
			self.id = data.id;
			self.name = ko.observable(data.name);
			self.selected = ko.observable(false);
		} else {
			self.name = ko.observable();
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

	DisplayType.list = function(list) {
		$.getJSON(baseurl, function (data) {
			var mapped = $.map(data, function(item) {
				return new DisplayType(item)
			});
			list(mapped);
		});
	}

	return DisplayType;
});