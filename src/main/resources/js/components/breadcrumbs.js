define([ 'knockout', 'text!../components/breadcrumbs.html' ], function(ko, html) {
	function ViewModel(params) {
		var self = this;
		self.crumbs = ko.observableArray(params.crumbs);
	}

	return {
	    viewModel : ViewModel,
	    template : html
	};
});