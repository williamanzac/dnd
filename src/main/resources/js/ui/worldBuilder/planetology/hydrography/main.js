requirejs.config({
    baseUrl : '../../../../js/lib',
    paths : {
        'jquery' : '//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min',
        'knockout' : '//cdnjs.cloudflare.com/ajax/libs/knockout/3.4.0/knockout-min',
        'ko-mapping' : '//cdnjs.cloudflare.com/ajax/libs/knockout.mapping/2.4.1/knockout.mapping.min',
        'bootstrap' : '//maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min'
    },
    shim : {
        'bootstrap' : [ 'jquery' ]
    }
});

require([ 'jquery', 'bootstrap', 'knockout', '../viewModels/worldHydrography', 'domReady!' ], function($, bootstrap,
        ko, ViewModel) {
	ko.components.register('breadcrumbs', {
		require : '../components/breadcrumbs'
	});
	ko.applyBindings(new ViewModel());

	$(document).ready(function() {
	    $('.navbar a.dropdown-toggle').on('click', function(e) {
	        var $el = $(this);
	        var $parent = $(this).offsetParent(".dropdown-menu");
	        $(this).parent("li").toggleClass('open');

	        if(!$parent.parent().hasClass('nav')) {
	            $el.next().css({"top": $el[0].offsetTop, "left": $parent.outerWidth() - 4});
	        }

	        $('.nav li.open').not($(this).parents("li")).removeClass("open");

	        return false;
	    });
	});
});