define([ 'jquery', 'knockout' ], function($, ko) {
	var baseurl = "/tools/worldBuilder/planetology/mountainProperties";

	function MountainProperty(data) {
		var self = this;
		self.id = data && data.id || null;
		self.characteristic = ko.observable(data && data.characteristic || null);
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

	MountainProperty.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new MountainProperty(item)
			});
			list(mapped);
		});
	}

	return MountainProperty;
});