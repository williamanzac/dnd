define([ 'jquery', 'knockout' ], function($, ko) {
	var baseurl = "/tools/heightWeights";

	function HeightWeight(data) {
		var self = this;
		self.id = data && data.id || null;
		self.type = ko.observable(data && data.type || null);
		self.baseHeightInch = ko.observable(data && data.baseHeightInch || null);
		self.baseHeight = ko.pureComputed({
	        read: function() {
				if (this && this.baseHeightInch) {
					return Math.floor(this.baseHeightInch() / 12) + "'" + (this.baseHeightInch() - (Math.floor(this.baseHeightInch() / 12) * 12)) + '"';
				}
				return null;
			},
	        write: function (value) {
	        	var myArray = /(\d+)'(\d+)"/g.exec(value);
				var baseHeight = parseInt(myArray[1]) * 12 + parseInt(myArray[2]);
				this.baseHeightInch(baseHeight);
	        },
	        owner: this
	    });
		self.heightModifier = ko.observable(data && data.heightModifier || null); 
		self.baseWeightLB = ko.observable(data && data.baseWeightLB || null);
		self.weightModifier = ko.observable(data && data.weightModifier || null);
	
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

		self.generate = function(list, times) {
			$.ajax({
				method : "POST",
				url : baseurl + "/" + self.id + "/generate?times=" + times,
				contentType : "application/json",
				dataType : "json"
			}).done(function(data) {
				list(data);
			});
		}
	}
	
	HeightWeight.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new HeightWeight(item)
			});
			list(mapped);
		});
	}
	
	return HeightWeight;
});