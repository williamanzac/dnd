function DiceViewModel() {
	var self = this;
	self.rollData = ko.observable();
	self.result = ko.observableArray();
	self.times = ko.observable(1);

	self.roll = function() {
		$.ajax({
			method: "POST",
			url: "/tools/dice/roll/" + self.rollData() + "?times=" + self.times(),
			contentType: "application/json",
			dataType: "json"
		}).done(function (data) {
			self.result(data);
		});
	}
}

var mainModel = new DiceViewModel();
ko.applyBindings(mainModel);