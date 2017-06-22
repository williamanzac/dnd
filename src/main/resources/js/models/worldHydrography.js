define([ 'jquery', 'knockout' ], function($, ko) {
	var baseurl = "/tools/worldBuilder/planetology/hydrographies";

	function WorldHydrography(data) {
		var self = this;
		self.id = data && data.id || null;
		self.percent = ko.observable(data && data.percent || null);
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

	WorldHydrography.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new WorldHydrography(item)
			});
			list(mapped);
		});
	}

	WorldHydrography.generate = function(list, times) {
		$.ajax({
		    method : "POST",
		    url : baseurl + "/generate?times=" + times,
		    contentType : "application/json",
		    dataType : "json"
		}).done(function(data) {
			var mapped = $.map(data, function(item) {
				return new WorldHydrography(item)
			});
			list(mapped);
		});
	}

	return WorldHydrography;
});