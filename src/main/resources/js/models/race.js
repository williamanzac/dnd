define([ 'jquery', 'knockout', '../models/abilityScoreAdjustment' ], function($, ko, AbilityScoreAdjustment) {
	var baseurl = "/admin/races";

	function Race(data) {
		var self = this;
		self.id = data && data.id || null;
		self.name = ko.observable(data && data.name || null);
		self.abilityScoreAdjustments = ko.observableArray([]);
		if (data && data.abilityScoreAdjustments) {
			var mapped = $.map(data.abilityScoreAdjustments, function(item) {
				return new AbilityScoreAdjustment(item)
			});
			self.abilityScoreAdjustments(mapped);
		}
		if (data && data.parent && data.parent.abilityScoreAdjustments) {
			var mapped = $.map(data.parent.abilityScoreAdjustments, function(item) {
				return new AbilityScoreAdjustment(item)
			});
			mapped.forEach(function(item) {
				self.abilityScoreAdjustments.push(item);
			});
		}
		self.parent = ko.observable(data && data.parent || null);
		self.subRaces = ko.observableArray([]);
 
		self.getSubRaces = function() {
			var parent = self.parent();
			if (self.id && parent === null) {
				$.getJSON(baseurl + "/" + self.id + "/subRaces", function(data) {
					var mapped = $.map(data, function(item) {
						return new Race(item)
					});
					self.subRaces(mapped);
				});
			}
		}
		self.getSubRaces();
		
		self.update = function() {
			var data = ko.toJS(self);
			delete data.subRaces;
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
			delete data.subRaces;
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

		self.createSubRace = function(subRace) {
			var data = ko.toJS(subRace);
			delete data.subRaces;
			$.ajax({
			    method : "POST",
			    data : JSON.stringify(data),
			    url : baseurl + "/" + self.id + "/subRaces",
			    contentType : "application/json",
			    dataType : "json"
			});
		}
	}

	Race.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new Race(item)
			});
			list(mapped);
		});
	}

	return Race;
});