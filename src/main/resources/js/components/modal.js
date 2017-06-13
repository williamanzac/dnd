define([ 'knockout', 'text!../components/modal.html', '../lib/modal',
		'../lib/knockstrap' ], function(ko, html, Modal) {
	function ViewModel(params) {
		var self = this;
		self.label = params.label;
		self.action = params.action;
		self.primaryLabel = params.primaryLabel;
		self.modal = new Modal(params.value);
	}

	return {
		viewModel : ViewModel,
		template : html
	};
})