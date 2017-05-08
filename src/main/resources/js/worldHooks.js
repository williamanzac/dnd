function WorldHook(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
		self.categoryId = ko.observable();
	} else {
		self.name = ko.observable();
		self.categoryId = ko.observable();
	}
}

function Category(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
		self.min = ko.observable(data.min);
		self.max = ko.observable(data.max);
		self.worldHooks = ko.observableArray([]);
		var mapped = $.map(data.worldHooks, function(item) {
			return new WorldHook(item)
		});
		self.worldHooks(mapped);
	} else {
		self.name = ko.observable();
		self.min = ko.observable();
		self.max = ko.observable();
		self.worldHooks = ko.observableArray([]);
	}
}

function WorldHookViewModel() {
	var self = this;
	self.categories = ko.observableArray([]);
	self.worldHooks = ko.observableArray([]);
	self.times = ko.observable(3);

	self.editCategory = ko.observable(new Category());
	self.editWorldHook = ko.observable(new WorldHook());

	self.editCategoryModalVisible = ko.observable(false);
	self.showEditCategoryModal = function(data) {
		self.editCategory(data);
		self.editCategoryModalVisible(true);
	};
	self.hideEditCategoryModal = function() {
		self.editCategoryModalVisible(false);
	};

	self.editWorldHookModalVisible = ko.observable(false);
	self.showEditWorldHookModal = function(data) {
		self.editWorldHook(data);
		self.editWorldHookModalVisible(true);
	};
	self.hideEditWorldHookModal = function() {
		self.editWorldHookModalVisible(false);
	};

	self.newCategoryModalVisible = ko.observable(false);
	self.showNewCategoryModal = function() {
		self.editCategory(new Category());
		self.newCategoryModalVisible(true);
	};
	self.hideNewCategoryModal = function() {
		self.newCategoryModalVisible(false);
	};

	self.newWorldHookModalVisible = ko.observable(false);
	self.showNewWorldHookModal = function(data) {
		self.editWorldHook(new WorldHook());
		self.editWorldHook().categoryId(data.id);
		self.newWorldHookModalVisible(true);
	};
	self.hideNewWorldHookModal = function() {
		self.newWorldHookModalVisible(false);
	};

	self.updateCategory = function () {
		self.hideEditCategoryModal();
		var data = {
			"id": parseInt(self.editCategory().id),
			"name": self.editCategory().name(),
			"min": parseInt(self.editCategory().min()),
			"max": parseInt(self.editCategory().max())
		};
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
		self.hideNewCategoryModal();
		var data = {
			"name": self.editCategory().name(),
			"min": parseInt(self.editCategory().min()),
			"max": parseInt(self.editCategory().max())
		};
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
		self.hideEditWorldHookModal();
		var data = {
			"id": parseInt(self.editWorldHook().id),
			"name": self.editWorldHook().name(),
			"category": {
				"id": parseInt(self.editWorldHook().categoryId())
			}
		};
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
		self.hideNewWorldHookModal();
		console.log(self.editWorldHook().categoryId());
		var data = {
			"name": self.editWorldHook().name(),
			"category": {
				"id": parseInt(self.editWorldHook().categoryId())
			}
		};
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

var mainModel = new WorldHookViewModel();
ko.applyBindings(mainModel);