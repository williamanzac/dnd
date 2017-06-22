<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit PlateMovement Modal -->
    <div
        data-bind="modal: {
	    visible: editPlateMovementModal.visible,
	    header: { data: { label: 'Edit Plate Movement' } },
	    body: { name: 'editPlateMovementModalTemplate' },
	    footer: { data: { action: updatePlateMovement, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New PlateMovement Modal -->
    <div
        data-bind="modal: {
	    visible: newPlateMovementModal.visible,
	    header: { data: { label: 'New Plate Movement' } },
	    body: { name: 'editPlateMovementModalTemplate' },
	    footer: { data: { action: createPlateMovement, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

    <!-- Edit WorldSize Modal -->
    <div
        data-bind="modal: {
        visible: editWorldSizeModal.visible,
        header: { data: { label: 'Edit World Size' } },
        body: { name: 'editWorldSizeModalTemplate' },
        footer: { data: { action: updateWorldSize, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New WorldSize Modal -->
    <div
        data-bind="modal: {
        visible: newWorldSizeModal.visible,
        header: { data: { label: 'New World Size' } },
        body: { name: 'editWorldSizeModalTemplate' },
        footer: { data: { action: createWorldSize, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

    <!-- Edit VolcanicActivity Modal -->
    <div
        data-bind="modal: {
        visible: editVolcanicActivityModal.visible,
        header: { data: { label: 'Edit Volcanic Activity' } },
        body: { name: 'editVolcanicActivityModalTemplate' },
        footer: { data: { action: updateVolcanicActivity, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New VolcanicActivity Modal -->
    <div
        data-bind="modal: {
        visible: newVolcanicActivityModal.visible,
        header: { data: { label: 'New Volcanic Activity' } },
        body: { name: 'editVolcanicActivityModalTemplate' },
        footer: { data: { action: createVolcanicActivity, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

    <!-- Edit EarthquakeActivity Modal -->
    <div
        data-bind="modal: {
        visible: editEarthquakeActivityModal.visible,
        header: { data: { label: 'Edit Earthquake Activity' } },
        body: { name: 'editEarthquakeActivityModalTemplate' },
        footer: { data: { action: updateEarthquakeActivity, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New EarthquakeActivity Modal -->
    <div
        data-bind="modal: {
        visible: newEarthquakeActivityModal.visible,
        header: { data: { label: 'New Earthquake Activity' } },
        body: { name: 'editEarthquakeActivityModalTemplate' },
        footer: { data: { action: createEarthquakeActivity, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

    <!-- Edit MountainProperty Modal -->
    <div
        data-bind="modal: {
        visible: editMountainPropertyModal.visible,
        header: { data: { label: 'Edit Mountain Property' } },
        body: { name: 'editMountainPropertyModalTemplate' },
        footer: { data: { action: updateMountainProperty, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New MountainProperty Modal -->
    <div
        data-bind="modal: {
        visible: newMountainPropertyModal.visible,
        header: { data: { label: 'New Mountain Property' } },
        body: { name: 'editMountainPropertyModalTemplate' },
        footer: { data: { action: createMountainProperty, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

    <!-- Edit MountainPlacement Modal -->
    <div
        data-bind="modal: {
        visible: editMountainPlacementModal.visible,
        header: { data: { label: 'Edit Mountain Placement' } },
        body: { name: 'editMountainPlacementModalTemplate' },
        footer: { data: { action: updateMountainPlacement, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New MountainPlacement Modal -->
    <div
        data-bind="modal: {
        visible: newMountainPlacementModal.visible,
        header: { data: { label: 'New Mountain Placement' } },
        body: { name: 'editMountainPlacementModalTemplate' },
        footer: { data: { action: createMountainPlacement, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

    <div class="container">
		<@layout.breadcrumbs breadcrumbs=breadcrumbs />
		<div class="row">
			<#assign l=breadcrumbs?size />
			<h1>${breadcrumbs[l - 1]}</h1>
		</div>
        <div class="row">
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-heading">Plate Movement</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Description</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success" data-bind="click: newPlateMovementModal.show">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: plateMovements">
                            <tr>
                                <td data-bind="text: min() + '-' + max()"></td>
                                <td data-bind="text: description"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default"
                                            data-bind="click: $root.editPlateMovementModal.show"
                                        >
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-warning" data-bind="click: remove">
                                            <i class="fa fa-times" aria-hidden="true"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-heading">World Sizes</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Diameter</th>
                                <th>Adjustment</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success" data-bind="click: newWorldSizeModal.show">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: worldSizes">
                            <tr>
                                <td data-bind="text: diameter"></td>
                                <td data-bind="text: mountainSizeAdjustment() + ' (' + mountainSizeComment() + ')'"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default"
                                            data-bind="click: $root.editWorldSizeModal.show"
                                        >
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-warning" data-bind="click: remove">
                                            <i class="fa fa-times" aria-hidden="true"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-heading">Volcanic Activity</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Activity</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success" data-bind="click: newVolcanicActivityModal.show">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: volcanicActivities">
                            <tr>
                                <td data-bind="text: min() + '-' + max()"></td>
                                <td data-bind="text: activity"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default"
                                            data-bind="click: $root.editVolcanicActivityModal.show"
                                        >
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-warning" data-bind="click: remove">
                                            <i class="fa fa-times" aria-hidden="true"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-heading">Earthquake Activity</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Strength</th>
                                <th>Frequency</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success"
                                            data-bind="click: newEarthquakeActivityModal.show"
                                        >
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: earthquakeActivities">
                            <tr>
                                <td data-bind="text: min() + '-' + max()"></td>
                                <td data-bind="text: strength"></td>
                                <td data-bind="text: frequency"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default"
                                            data-bind="click: $root.editEarthquakeActivityModal.show"
                                        >
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-warning" data-bind="click: remove">
                                            <i class="fa fa-times" aria-hidden="true"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-heading">Mountain Placement</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Type</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success"
                                            data-bind="click: newMountainPlacementModal.show"
                                        >
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: mountainPlacements">
                            <tr>
                                <td data-bind="text: min() + '-' + max()"></td>
                                <td data-bind="text: type"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default"
                                            data-bind="click: $root.editMountainPlacementModal.show"
                                        >
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-warning" data-bind="click: remove">
                                            <i class="fa fa-times" aria-hidden="true"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-5">
                <div class="panel panel-default">
                    <div class="panel-heading">Mountain Property</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Characteristic</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success" data-bind="click: newMountainPropertyModal.show">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: mountainProperties">
                            <tr>
                                <td data-bind="text: min() + '-' + max()"></td>
                                <td data-bind="text: characteristic"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default"
                                            data-bind="click: $root.editMountainPropertyModal.show"
                                        >
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-warning" data-bind="click: remove">
                                            <i class="fa fa-times" aria-hidden="true"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>

    <script type="text/html" id="editPlateMovementModalTemplate">
		<div class="clearfix">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Desctiption" autofocus data-bind="value: $root.editPlateMovement().description" />
                <span class="input-group-addon">%</span>
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Min" data-bind="value: $root.editPlateMovement().min" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Max" data-bind="value: $root.editPlateMovement().max" />
            </div> <!-- /input-group -->
		</div>
    </script>

    <script type="text/html" id="editWorldSizeModalTemplate">
        <div class="clearfix">
            <div class="input-group">
                <p class="form-control-static" data-bind="text: $root.editWorldSize().diameter" />
                <span class="input-group-addon">miles</span>
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Adjustment" data-bind="value: $root.editWorldSize().mountainSizeAdjustment" />
                <span class="input-group-addon">grades</span>
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Comment" data-bind="value: $root.editWorldSize().mountainSizeComment" />
            </div> <!-- /input-group -->
        </div>
    </script>

    <script type="text/html" id="editVolcanicActivityModalTemplate">
        <div class="clearfix">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Activity" autofocus data-bind="value: $root.editVolcanicActivity().activity" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Min" data-bind="value: $root.editVolcanicActivity().min" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Max" data-bind="value: $root.editVolcanicActivity().max" />
            </div> <!-- /input-group -->
        </div>
    </script>

    <script type="text/html" id="editEarthquakeActivityModalTemplate">
        <div class="clearfix">
            <div class="input-group">
                <select class="form-control" placeholder="Strength" autofocus data-bind="options: $root.earthquakeStrengths, value: $root.editEarthquakeActivity().strength" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <select class="form-control" placeholder="Frequency" data-bind="options: $root.earthquakeFrequencies, value: $root.editEarthquakeActivity().frequency" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Min" data-bind="value: $root.editEarthquakeActivity().min" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Max" data-bind="value: $root.editEarthquakeActivity().max" />
            </div> <!-- /input-group -->
        </div>
    </script>

    <script type="text/html" id="editMountainPlacementModalTemplate">
        <div class="clearfix">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Type" autofocus data-bind="value: $root.editMountainPlacement().type" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Min" data-bind="value: $root.editMountainPlacement().min" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Max" data-bind="value: $root.editMountainPlacement().max" />
            </div> <!-- /input-group -->
        </div>
    </script>

    <script type="text/html" id="editMountainPropertyModalTemplate">
        <div class="clearfix">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Characteristic" autofocus data-bind="value: $root.editMountainProperty().characteristic" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Min" data-bind="value: $root.editMountainProperty().min" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Max" data-bind="value: $root.editMountainProperty().max" />
            </div> <!-- /input-group -->
        </div>
    </script>
</@layout.layout>