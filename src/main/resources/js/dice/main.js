requirejs
		.config({
			baseUrl : '../../../../js/lib',
			paths : {
				'jquery' : '//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min',
				'knockout' : '//cdnjs.cloudflare.com/ajax/libs/knockout/3.4.0/knockout-min',
				'ko-mapping' : '//cdnjs.cloudflare.com/ajax/libs/knockout.mapping/2.4.1/knockout.mapping.min',
				'bootstrap' : '//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min'
			},
			shim : {
				'bootstrap' : [ 'jquery' ],
			}
		});

require([ 'jquery', 'bootstrap', 'knockout', '../viewModels/dice',
		'domReady!' ], function($, bootstrap, ko, ViewModel) {
	ko.components.register('breadcrumbs', {
		require : '../components/breadcrumbs'
	});
	ko.applyBindings(new ViewModel());
});