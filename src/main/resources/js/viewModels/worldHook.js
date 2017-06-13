define([ 'jquery', 'knockout', 'Modal', '../components/worldHook',
		'../components/worldHookCategory', 'knockstrap' ], function($, ko,
		Modal, WorldHook, Category) {
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

		self.updateCategory = function() {
			self.editCategory().update();
		}
		self.createCategory = function() {
			self.editCategory().create();
		}

		self.updateWorldHook = function() {
			self.editWorldHook().update();
		}
		self.createWorldHook = function() {
			self.editWorldHook().create();
		}

		self.generate = function() {
			WorldHook.generate(self.worldHooks, self.times());
		}

		self.getCategories = function() {
			Category.list(self.categories);
		}

		self.getCategories();
	}
});