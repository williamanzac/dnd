define([ 'knockout', '../components/worldHook' ], function(ko, WorldHook) {
	var baseurl = "/tools/worldHookCategories";

	function Category(data) {
		var self = this;
		self.id = data && data.id || null;
		self.name = ko.observable(data && data.name || null);
		self.min = ko.observable(data && data.min || null);
		self.max = ko.observable(data && data.max || null);
		self.worldHooks = ko.observableArray([]);
		var mapped = $.map(data && data.worldHooks || [], function(item) {
			return new WorldHook(item)
		});
		self.worldHooks(mapped);

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

	Category.list = function(list) {
		$.getJSON(baseurl, function(data) {
			var mapped = $.map(data, function(item) {
				return new Category(item)
			});
			list(mapped);
		});
	}

	return Category;
});