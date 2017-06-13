define(['knockout'], function(ko) {
	var baseurl = "/tools/worldHooks";

	function WorldHook(data) {
		var self = this;
		self.id = data && data.id || null;
		self.name = ko.observable(data && data.name || null);
		self.categoryId = ko.observable();

		self.update = function() {
			var data = ko.toJS(self);
			$.ajax({
				method: "PUT",
				data: JSON.stringify(data),
				url: baseurl,
				contentType: "application/json",
				dataType: "json"
			});
		}
		self.create = function() {
			var data = ko.toJS(self);
			$.ajax({
				method: "POST",
				data: JSON.stringify(data),
				url: baseurl,
				contentType: "application/json",
				dataType: "json"
			});
		}
		self.remove = function() {
			$.ajax({
				method: "DELETE",
				url: baseurl + "/" + self.id,
				contentType: "application/json",
				dataType: "json"
			});
		}
	}

	WorldHook.list = function(list) {
		$.getJSON(baseurl, function (data) {
			var mapped = $.map(data, function(item) {
				return new WorldHook(item)
			});
			list(mapped);
		});
	}

	WorldHook.generate = function (list times) {
		$.ajax({
			method: "POST",
			url: baseurl + "/generate?times=" + times,
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			list(data);
		});
	}

	return WorldHook;
});