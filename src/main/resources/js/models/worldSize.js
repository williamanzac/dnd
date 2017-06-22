define([ 'jquery', 'knockout' ], function($, ko) {
	var baseurl = "/tools/worldBuilder/planetology/worldSizes";

	function WorldSize(data) {
		var self = this;
		self.id = data && data.id || null;
		self.diameter = ko.observable(data && data.diameter || null);
		self.min = ko.observable(data && data.min || null);
		self.max = ko.observable(data && data.max || null);
		self.worldMapSize = ko.observable(data && data.worldMapSize || null);
		self.regionMapSize = ko.observable(data && data.regionMapSize || null);
		self.mountainSizeAdjustment = ko.observable(data && data.mountainSizeAdjustment || null);
		self.mountainSizeComment = ko.observable(data && data.mountainSizeComment || null);

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

	WorldSize.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new WorldSize(item)
			});
			list(mapped);
		});
	}

	WorldSize.generate = function(list, times) {
		$.ajax({
		    method : "POST",
		    url : baseurl + "/generate?times=" + times,
		    contentType : "application/json",
		    dataType : "json"
		}).done(function(data) {
			list(data);
		});
	}

	return WorldSize;
});