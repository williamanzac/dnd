define([ 'jquery', 'knockout', '../models/region' ], function($, ko, Region) {
	var baseurl = "/tools/worldBuilder/planetology/displayTypes";
	
	function DisplayType(data) {
		var self = this;
		self.id = data && data.id || null;
		self.name = ko.observable(data && data.name || null);
		self.numRegions = ko.observable(data && data.numRegions || null);
		self.selected = ko.observable(false);
		self.regions = ko.observableArray([]);
		var mapped = $.map(data && data.regions || [], function(item) {
			return new Region(item)
		});
		self.regions(mapped);

		self.update = function() {
			var data = ko.toJS(self);
			delete data.selected;
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
			delete data.selected;
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

	DisplayType.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new DisplayType(item)
			});
			list(mapped);
		});
	}

	return DisplayType;
});