define([ 'jquery', 'knockout', '../models/abilityScoreAdjustment', '../models/language' ], function($, ko,
        AbilityScoreAdjustment, Language) {
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
		self.allAbilityScoreAdjustments = ko.pureComputed(function() {
			var list = self.abilityScoreAdjustments();
			if (self.parent()) {
				var mapped = $.map(self.parent().abilityScoreAdjustments, function(item) {
					return new AbilityScoreAdjustment(item)
				});
				mapped.forEach(function(item) {
					list.push(item);
				});
			}
			return list;
		});
		self.parent = ko.observable(data && data.parent || null);
		self.subRaces = ko.observableArray([]);
		self.languages = ko.observableArray([]);
		self.speed = ko.observable(data && data.speed || null);

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
		self.getLanguages = function() {
			$.getJSON(baseurl + "/" + self.id + "/languages", function(data) {
				var mapped = $.map(data, function(item) {
					return new Language(item)
				});
				self.languages(mapped);
			});
		}
		self.getSubRaces();
		self.getLanguages();

		self.update = function() {
			var data = ko.toJS(self);
			delete data.subRaces;
			delete data.allAbilityScoreAdjustments;
			delete data.allLanguages;
			data.abilityScoreAdjustments.forEach(function(item) {
				delete item.editable;
			});
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
			delete data.allAbilityScoreAdjustments;
			delete data.allLanguages;
			data.abilityScoreAdjustments.forEach(function(item) {
				delete item.editable;
			});
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