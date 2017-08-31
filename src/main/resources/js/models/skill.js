define([ 'jquery', 'knockout', '../models/ability' ], function($, ko, Ability) {
	var baseurl = "/admin/skills";
	
	function Skill(data) {
		var self = this;
		self.id = data && data.id || null;
		self.name = ko.observable(data && data.name || null);
		self.ability = ko.observable(new Ability(data && data.ability || null));

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

	Skill.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new Skill(item)
			});
			list(mapped);
		});
	}

	return Skill;
});