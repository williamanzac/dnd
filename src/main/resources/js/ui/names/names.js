function NameSet(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.type = ko.observable(data.type);
		self.names = ko.observableArray(data.names);
	} else {
		self.type = ko.observable();
		self.names = ko.observableArray([]);
	}
}

function NamesViewModel() {
	var self = this;
	self.nameSets = ko.observableArray([]);
	self.names = ko.observableArray([]);
	self.numOf = ko.observable(10);

	self.newName = ko.observable();
	self.editSet = ko.observable(new NameSet());
	self.editNameSetModalVisible = ko.observable(false);
	self.showEditNameSetModal = function(data) {
		self.editSet(data);
		self.editNameSetModalVisible(true);
	};
	self.hideEditNameSetModal = function() {
		self.editNameSetModalVisible(false);
	};

	self.newNameSetModalVisible = ko.observable(false);
	self.showNewNameSetModal = function() {
		self.editSet(new NameSet());
		self.newNameSetModalVisible(true);
	};
	self.hideNewNameSetModal = function() {
		self.newNameSetModalVisible(false);
	};

	self.addName = function() {
		var a = self.editSet().names();
		a.push(self.newName());
		self.editSet().names(a);
		self.newName('');
	}
	self.updateSet = function() {
		self.hideEditNameSetModal();
		var data = {
		    "id" : parseInt(self.editSet().id),
		    "type" : self.editSet().type(),
		    "names" : self.editSet().names()
		};
		$.ajax({
		    method : "PUT",
		    data : JSON.stringify(data),
		    url : "/tools/names",
		    contentType : "application/json",
		    dataType : "json"
		}).done(function() {
			self.getNameSets();
		});
	}
	self.createSet = function() {
		self.hideNewNameSetModal();
		var data = {
		    "type" : self.editSet().type(),
		    "names" : self.editSet().names()
		};
		$.ajax({
		    method : "POST",
		    data : JSON.stringify(data),
		    url : "/tools/names",
		    contentType : "application/json",
		    dataType : "json"
		}).done(function() {
			self.getNameSets();
		});
	}

	self.generate = function(nameSet) {
		$.ajax({
		    method : "POST",
		    url : "/tools/names/" + nameSet.id + "/generate?numOf=" + self.numOf(),
		    contentType : "application/json",
		    dataType : "json"
		}).done(function(data) {
			self.names(data);
		});
	}

	self.remove = function(nameSet) {
		$.ajax({
		    method : "DELETE",
		    url : "/tools/names/" + nameSet.id,
		    contentType : "application/json",
		    dataType : "json"
		}).done(function(data) {
			self.getNameSets();
		});
	}

	self.getNameSets = function() {
		$.getJSON("/tools/names", function(data) {
			var mapped = $.map(data, function(item) {
				return new NameSet(item)
			});
			self.nameSets(mapped);
		});
	}

	self.getNameSets();
}

var mainModel = new NamesViewModel();
ko.applyBindings(mainModel);