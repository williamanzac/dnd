define([ 'jquery', 'knockout', 'Modal', '../models/worldShape', '../models/worldSize', 'knockstrap' ],
        function($, ko, Modal, WorldShape, WorldSize) {
	        return function WorldShapeViewModel() {
		        var self = this;
		        self.worldShapes = ko.observableArray([]);
		        self.worldSizes = ko.observableArray([]);

		        self.shapes = ko.observableArray([]);
		        self.sizes = ko.observableArray([]);
		        self.times = ko.observable(3);

		        self.editWorldShape = ko.observable(new WorldShape());
		        self.editWorldSize = ko.observable(new WorldSize());

		        self.editWorldShapeModal = new Modal(self.editWorldShape);
		        self.editWorldSizeModal = new Modal(self.editWorldSize);

		        self.newWorldShapeModal = new Modal(self.editWorldShape);
		        self.newWorldSizeModal = new Modal(self.editWorldSize);

		        self.updateWorldShape = function() {
			        self.editWorldShape().update();
		        }
		        self.createWorldShape = function() {
			        self.editWorldShape().create();
		        }

		        self.updateWorldSize = function() {
			        self.editWorldSize().update();
		        }
		        self.createWorldSize = function() {
			        self.editWorldSize().create();
		        }

		        self.generateShape = function() {
			        WorldShape.generate(self.shapes, self.times());
		        }
		        self.generateSize = function() {
			        WorldSize.generate(self.sizes, self.times());
		        }

		        self.getWorldShapes = function() {
			        WorldShape.list(self.worldShapes);
		        }
		        self.getWorldSizes = function() {
			        WorldSize.list(self.worldSizes);
		        }

		        self.getWorldShapes();
		        self.getWorldSizes();
	        }
        });