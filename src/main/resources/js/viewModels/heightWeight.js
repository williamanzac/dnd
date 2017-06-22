define([ 'jquery', 'knockout', 'Modal', '../models/heightWeight', 'knockstrap' ], function($, ko, Modal,
        HeightWeight) {
	return function HeightWeightViewModel() {
		var self = this;
		self.result = ko.observableArray();
		self.times = ko.observable(1);
		self.heightWeights = ko.observableArray();
		self.newScore = ko.observable(new HeightWeight());

		self.editHeightWeightModal = new Modal(self.newScore);
		self.newHeightWeightModal = new Modal(self.newScore);

		self.getHeightWeights = function() {
			HeightWeight.list(self.heightWeights);
		}

		self.createHeightWeight = function() {
			self.hideNewHeightWeightModal();
			self.newScore().create();
		}

		self.updateHeightWeight = function() {
			self.hideEditHeightWeightModal();
			self.newScore().update();
		}

		self.getHeightWeights();
	}
});