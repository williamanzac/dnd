define(['jquery', 'knockout', 'Modal', '../components/heightWeight', 'knockstrap'], function($, ko,
		Modal, HeightWeight) {
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
/*			var myArray = /(\d+)'(\d+)"/g.exec(self.newScore().baseHeight());
			var baseHeight = parseInt(myArray[1]) * 12 + parseInt(myArray[2]);
			console.log(baseHeight);
			var data = {
				"type" : self.newScore().type(),
				"baseHeightInch" : baseHeight,
				"heightModifier" : self.newScore().heightModifier(),
				"baseWeightLB" : parseInt(self.newScore().baseWeightLB()),
				"weightModifier" : self.newScore().weightModifier()
			};
			$.ajax({
				method : "POST",
				data : JSON.stringify(data),
				url : "/tools/heightWeights",
				contentType : "application/json",
				dataType : "json"
			}).done(function() {
				self.getHeightWeights();
				self.newScore(new HeightWeight());
			});
			*/
		}

		self.updateHeightWeight = function() {
			self.hideEditHeightWeightModal();
			self.newScore().update();
/*			var myArray = /(\d+)'(\d+)"/g.exec(self.newScore().baseHeight());
			var baseHeight = parseInt(myArray[1]) * 12 + parseInt(myArray[2]);
			console.log(baseHeight);
			var data = {
				"id" : parseInt(self.newScore().id),
				"type" : self.newScore().type(),
				"baseHeightInch" : baseHeight,
				"heightModifier" : self.newScore().heightModifier(),
				"baseWeightLB" : parseInt(self.newScore().baseWeightLB()),
				"weightModifier" : self.newScore().weightModifier()
			};
			$.ajax({
				method : "PUT",
				data : JSON.stringify(data),
				url : "/tools/heightWeights",
				contentType : "application/json",
				dataType : "json"
			}).done(function() {
				self.getHeightWeights();
				self.newScore(new HeightWeight());
			});
			*/
		}

		self.getHeightWeights();
	}
});