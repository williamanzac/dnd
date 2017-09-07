define([ 'jquery', 'knockout' ], function($, ko) {
	var baseurl = "/admin/languages";
	
	function Language(data) {
		var self = this;
		self.id = data && data.id || null;
		self.name = ko.observable(data && data.name || null);
		self.commonSpeakers = ko.observableArray(data && data.commonSpeakers || []);
		self.script = ko.observable(data && data.script || null);

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

	Language.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new Language(item)
			});
			list(mapped);
		});
	}

	return Language;
});