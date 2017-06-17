define([ 'jquery', 'knockout', 'Modal', '../components/pack', '../components/packItem', '../components/gear',
        'knockstrap' ], function($, ko, Modal, Pack, PackItem, Gear) {
	return function PackViewModel() {
		var self = this;
		self.packs = ko.observableArray([]);

		self.editPack = ko.observable(new Pack());
		self.newPack = ko.observable(new Pack());

		self.editPackModal = new Modal(self.editPack);
		self.newPackModal = new Modal(self.editPack);

		self.showNewPackModal = function() {
			self.newPackModal.show(new Pack());
		}
		
		self.updatePack = function() {
			self.editPack().update();
			self.editPackModal.hide();
			self.getPacks();
		}
		self.createPack = function() {
			//self.editPack().create();
			//self.newPackModal.hide();
			self.newPack().create();
			self.getPacks();
			self.newPack(new Pack());
		}

		self.getPacks = function() {
			Pack.list(self.packs);
		}

		self.getPacks();
	}
});