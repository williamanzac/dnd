define(['jquery', 'knockout', 'Modal', '../components/worldHook', '../components/worldHookCategory', 'knockstrap'], function($, ko, Modal, WorldHook, Category) {
	return function WorldHookViewModel() {
		var self = this;
		self.categories = ko.observableArray([]);
		self.worldHooks = ko.observableArray([]);
		self.times = ko.observable(3);

		self.editCategory = ko.observable(new Category());
		self.editWorldHook = ko.observable(new WorldHook());

		self.editCategoryModal = new Modal(self.editCategory);
		self.newCategoryModal = new Modal(self.editCategory);
		self.editWorldHookModal = new Modal(self.editWorldHook);
		self.newWorldHookModal = new Modal(self.editWorldHook);

		self.updateCategory = function () {
			self.editCategoryModal.hide();
			var data = ko.toJS(self.editCategory());
			$.ajax({
				method: "PUT",
				data: JSON.stringify(data),
				url: "/tools/worldHookCategories",
				contentType: "application/json",
				dataType: "json"
			}).done(function() {
				self.getCategories();
			});
		}
		self.createCategory = function () {
			self.newCategoryModal.hide();
			var data = ko.toJS(self.editCategory());
			$.ajax({
				method: "POST",
				data: JSON.stringify(data),
				url: "/tools/worldHookCategories",
				contentType: "application/json",
				dataType: "json"
			}).done(function() {
				self.getCategories();
			});
		}

		self.updateWorldHook = function () {
			self.editWorldHookModal.hide();
			var data = ko.toJS(self.editWorldHook());
			$.ajax({
				method: "PUT",
				data: JSON.stringify(data),
				url: "/tools/worldHooks",
				contentType: "application/json",
				dataType: "json"
			}).done(function() {
				self.getCategories();
			});
		}
		self.createWorldHook = function () {
			self.newWorldHookModal.hide();
			var data = ko.toJS(self.editWorldHook());
			$.ajax({
				method: "POST",
				data: JSON.stringify(data),
				url: "/tools/worldHooks",
				contentType: "application/json",
				dataType: "json"
			}).done(function() {
				self.getCategories();
			});
		}

		self.generate = function () {
			$.ajax({
				method: "POST",
				url: "/tools/worldHooks/generate?times=" + self.times(),
				contentType: "application/json",
				dataType: "json"
			}).done(function (data) {
				self.worldHooks(data);
			});
		}

		self.removeCategory = function (data) {
			$.ajax({
				method: "DELETE",
				url: "/tools/worldHookCategories/" + data.id,
				contentType: "application/json",
				dataType: "json"
			}).done(function (data) {
				self.getCategories();
			});
		}

		self.removeWorldHook = function (data) {
			$.ajax({
				method: "DELETE",
				url: "/tools/worldHooks/" + data.id,
				contentType: "application/json",
				dataType: "json"
			}).done(function (data) {
				self.getCategories();
			});
		}

		self.getCategories = function () {
			$.getJSON("/tools/worldHookCategories", function (data) {
				var mapped = $.map(data, function(item) {
					return new Category(item)
				});
				self.categories(mapped);
			});
		}

		self.getCategories();
	}
});