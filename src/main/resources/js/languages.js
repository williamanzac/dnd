function Language(data) {
	var self = this;
	if (data != null) {
		self.id = data.id;
		self.name = ko.observable(data.name);
		self.commonSpeakers = ko.observableArray(data.commonSpeakers);
		self.script = ko.observable(data.script);
	} else {
		self.name = ko.observable();
		self.commonSpeakers = ko.observableArray();
		self.script = ko.observable();
	}
}

function LanguagesViewModel() {
	var self = this;
	self.languages = ko.observableArray();
	self.newScore = ko.observable(new Language());
	self.newSpoken = ko.observable();

	self.editLanguageModalVisible = ko.observable(false);
	self.showEditLanguageModal = function(data) {
		self.newScore(data);
		self.editLanguageModalVisible(true);
	};
	self.hideEditLanguageModal = function() {
		self.editLanguageModalVisible(false);
	};

	self.newLanguageModalVisible = ko.observable(false);
	self.showNewLanguageModal = function() {
		self.newScore(new Language());
		self.newLanguageModalVisible(true);
	};
	self.hideNewLanguageModal = function() {
		self.newLanguageModalVisible(false);
	};

	self.addSpoken = function() {
		var a = self.newScore().commonSpeakers();
		a.push(self.newSpoken());
		self.newScore().commonSpeakers(a);
		self.newSpoken('');
	}

	self.getLanguages = function() {
		$.getJSON("/admin/languages", function (data) {
			var mapped = $.map(data, function(item) {
				return new Language(item)
			});
			self.languages(mapped);
		});
	}

	self.createLanguage = function() {
		self.hideNewLanguageModal();
		var data = {
			"name": self.newScore().name(),
			"commonSpeakers" : self.newScore().commonSpeakers(),
			"script": self.newScore().script()
		};
		$.ajax({
			method: "POST",
			data: JSON.stringify(data),
			url: "/admin/languages",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getLanguages();
			self.newScore(new Language());
		});
	}

	self.updateLanguage = function() {
		self.hideEditLanguageModal();
		var data = {
			"id": parseInt(self.newScore().id),
			"name": self.newScore().name(),
			"commonSpeakers" : self.newScore().commonSpeakers(),
			"script": self.newScore().script()
		};
		$.ajax({
			method: "PUT",
			data: JSON.stringify(data),
			url: "/admin/languages",
			contentType: "application/json",
			dataType: "json"
		}).done(function() {
			self.getLanguages();
			self.newScore(new Language());
		});
	}
	
	self.getLanguages();
}

var mainModel = new LanguagesViewModel();
ko.applyBindings(mainModel);