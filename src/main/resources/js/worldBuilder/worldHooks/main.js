requirejs
		.config({
			baseUrl : '../../../js/lib',
			paths : {
				'jquery' : '//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min',
				'knockout' : '//cdnjs.cloudflare.com/ajax/libs/knockout/3.4.0/knockout-min',
				'ko-mapping' : '//cdnjs.cloudflare.com/ajax/libs/knockout.mapping/2.4.1/knockout.mapping.min',
				'bootstrap' : '//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min',
				'datatables' : '//cdn.datatables.net/1.10.11/js/jquery.dataTables.min',
				'datatables-bootstrap' : '//cdn.datatables.net/1.10.11/js/dataTables.bootstrap.min',
				'datatables-select' : '//cdn.datatables.net/select/1.1.2/js/dataTables.select.min'
			},
			shim : {
				'bootstrap' : [ 'jquery' ],
				'datatables' : [ 'jquery', 'bootstrap' ]
			}
		});

require([ 'jquery', 'bootstrap', 'knockout', '../viewModels/worldHook',
		'domReady!' ], function($, bootstrap, ko, ViewModel) {
	ko.components.register('breadcrumbs', {
		require : '../components/breadcrumbs'
	});
	ko.applyBindings(new ViewModel());
});