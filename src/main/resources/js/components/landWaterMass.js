define([ 'jquery', 'knockout' ], function($, ko) {
	var baseurl = "/tools/worldBuilder/planetology/landWaterMasses";

	function LandWaterMass(data) {
		var self = this;
		self.id = data && data.id || null;
		self.numRegions = ko.observable(data && data.numRegions || null);
		self.numMasses = ko.observable(data && data.numMasses || null);
		self.minSize = ko.observable(data && data.minSize || null);
		self.maxSize = ko.observable(data && data.maxSize || null);

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

	LandWaterMass.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new LandWaterMass(item)
			});
			list(mapped);
		});
	}

	LandWaterMass.generate = function(list, hydrographyId, displayTypeId) {
		$.ajax({
		    method : "POST",
		    url : baseurl + "/generate?hId=" + hydrographyId + "&dId=" + displayTypeId,
		    contentType : "application/json",
		    dataType : "json"
		}).done(function(data) {
			list.push(data);
		});
	}

	return LandWaterMass;
});