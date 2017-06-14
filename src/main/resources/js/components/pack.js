define([ 'jquery', 'knockout', '../components/packItem' ], function($, ko, PackItem) {
	var baseurl = "/admin/packs";

	function Pack(data) {
		var self = this;
		self.id = data && data.id || null;
		self.name = ko.observable(data && data.name || null);
		self.costGP = ko.observable(data && data.costGP || null);
		self.items = ko.observableArray([]);
		var mapped = $.map(data && data.items || [], function(item) {
			return new PackItem(item)
		});
		self.items(mapped);

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

	Pack.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new Pack(item)
			});
			list(mapped);
		});
	}

	return Pack;
});