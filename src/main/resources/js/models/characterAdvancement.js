define([ 'jquery', 'knockout' ], function($, ko) {
	var baseurl = "/admin/characterAdvancements";

	function CharacterAdvancement(data) {
		var self = this;
		self.id = data && data.id || null;
		self.experience = ko.observable(data && data.experience || null);
		self.level = ko.observable(data && data.level || null);
		self.proficiencyBonus = ko.observable(data && data.proficiencyBonus || null);

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

	CharacterAdvancement.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new CharacterAdvancement(item)
			});
			list(mapped);
		});
	}

	return CharacterAdvancement;
});