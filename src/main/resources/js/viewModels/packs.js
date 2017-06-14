define([ 'jquery', 'knockout', 'Modal', '../components/pack', '../components/packItem', '../components/gear',
        'knockstrap' ], function($, ko, Modal, Pack, PackItem, Gear) {
	return function PackViewModel() {
		var self = this;
		self.packs = ko.observableArray([]);

		self.editPack = ko.observable(new Pack());

		self.editPackModal = new Modal(self.editPack);
		self.newPackModal = new Modal(self.editPack);

		self.updatePack = function() {
			var pack = self.editPack();
			pack.update();
		}
		self.createPack = function() {
			var pack = self.editPack();
			pack.create();
		}

		self.getPacks = function() {
			Pack.list(self.packs);
		}

		self.getPacks();
	}
});