<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit Hydrography Modal -->
    <div
        data-bind="modal: {
	    visible: editHydrographyModal.visible,
	    header: { data: { label: 'Edit World Hydrography' } },
	    body: { name: 'editHydrographyModalTemplate' },
	    footer: { data: { action: updateHydrography, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New Hydrography Modal -->
    <div
        data-bind="modal: {
	    visible: newHydrographyModal.visible,
	    header: { data: { label: 'New World Hydrography' } },
	    body: { name: 'editHydrographyModalTemplate' },
	    footer: { data: { action: createHydrography, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

    <!-- Edit RegionType Modal -->
    <div
        data-bind="modal: {
        visible: editRegionTypeModal.visible,
        header: { data: { label: 'Edit Region Type' } },
        body: { name: 'editRegionTypeModalTemplate' },
        footer: { data: { action: updateRegionType, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New RegionType Modal -->
    <div
        data-bind="modal: {
        visible: newRegionTypeModal.visible,
        header: { data: { label: 'New Region Type' } },
        body: { name: 'editRegionTypeModalTemplate' },
        footer: { data: { action: createRegionType, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

    <!-- Edit DisplayType Modal -->
    <div
        data-bind="modal: {
        visible: editDisplayTypeModal.visible,
        header: { data: { label: 'Edit Display Type' } },
        body: { name: 'editDisplayTypeModalTemplate' },
        footer: { data: { action: updateDisplayType, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New DisplayType Modal -->
    <div
        data-bind="modal: {
        visible: newDisplayTypeModal.visible,
        header: { data: { label: 'New Display Type' } },
        body: { name: 'editDisplayTypeModalTemplate' },
        footer: { data: { action: createDisplayType, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

    <!-- Edit LandWaterDistribution Modal -->
    <div
        data-bind="modal: {
        visible: editLandWaterDistributionModal.visible,
        header: { data: { label: 'Edit Land Water Distribution' } },
        body: { name: 'editLandWaterDistributionModalTemplate' },
        footer: { data: { action: updateLandWaterDistribution, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New LandWaterDistribution Modal -->
    <div
        data-bind="modal: {
        visible: newLandWaterDistributionModal.visible,
        header: { data: { label: 'New Land Water Distribution' } },
        body: { name: 'editLandWaterDistributionModalTemplate' },
        footer: { data: { action: createLandWaterDistribution, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

    <!-- Edit LandWaterMass Modal -->
    <div
        data-bind="modal: {
        visible: editLandWaterMassModal.visible,
        header: { data: { label: 'Edit Land Water Mass' } },
        body: { name: 'editLandWaterMassModalTemplate' },
        footer: { data: { action: updateLandWaterMass, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New LandWaterMass Modal -->
    <div
        data-bind="modal: {
        visible: newLandWaterMassModal.visible,
        header: { data: { label: 'New Land Water Mass' } },
        body: { name: 'editLandWaterMassModalTemplate' },
        footer: { data: { action: createLandWaterMass, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

        <div class="row">
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Hydrography</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Percent</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success" data-bind="click: newHydrographyModal.show">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: hydrographies">
                            <tr>
                                <td data-bind="text: min() + '-' + max()"></td>
                                <td data-bind="text: percent"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default" data-bind="click: $root.editHydrographyModal.show">
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
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Region Types</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success" data-bind="click: newRegionTypeModal.show">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: regionTypes">
                            <tr>
                                <td data-bind="text: name"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default" data-bind="click: $root.editRegionTypeModal.show">
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
                    <div class="panel-heading">Display Types</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
                                <th>Num Regions</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success" data-bind="click: newDisplayTypeModal.show">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: displayTypes">
                            <tr>
                                <td data-bind="text: name"></td>
                                <td data-bind="text: numRegions"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default" data-bind="click: $root.editDisplayTypeModal.show">
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
                    <div class="panel-heading">Land/Water Masses</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th># Regions</th>
                                <th>Number of masses</th>
                                <th>Size of Masses</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success" data-bind="click: newLandWaterMassModal.show">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: masses">
                            <tr>
                                <td data-bind="text: numRegions"></td>
                                <td data-bind="text: numMasses"></td>
                                <td data-bind="text: minSize() + '-' + maxSize()"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default" data-bind="click: $root.editLandWaterMassModal.show">
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
            <div class="col-md-7">
                <div class="panel panel-default">
                    <div class="panel-heading">Land and Water Distributions</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th rowspan="2">Region Type</th>
                                <!-- ko foreach: displayTypes -->
                                <th data-bind="attr: {colspan: $root.hydrographies().length}, text: name"></th>
                                <!-- /ko -->
                            </tr>
                            <tr>
                                <!-- ko foreach: displayTypes -->
                                <!-- ko foreach: $root.hydrographies -->
                                <th data-bind="text: percent"></th>
                                <!-- /ko -->
                                <!-- /ko -->
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: regionTypes">
                            <tr>
                                <td data-bind="text: name"></td>
                                <!-- ko foreach: $root.displayTypes -->
                                <!-- ko foreach: $root.hydrographies -->
                                <td>
                                    <!-- ko if: $root.findNumRegions($parents[1].name(), $parents[0].name(), percent()) -->
                                    <!-- ko with: $root.findNumRegions($parents[1].name(), $parents[0].name(), percent()) -->
                                    <span data-bind="text: numRegions"></span>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-default" data-bind="click: $root.editLandWaterDistributionModal.show">
                                            <i class="fa fa-pencil"></i>
                                        </button>
                                    </div>
                                    <!-- /ko -->
                                    <!-- /ko -->
                                    <!-- ko ifnot: $root.findNumRegions($parents[1].name(), $parents[0].name(), percent()) -->
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success" data-bind="click: $root.showNewLandWaterDistributionModal.bind($parents[2], $parents[1], $parents[0])">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                    <!-- /ko -->
                                </td>
                                <!-- /ko -->
                                <!-- /ko -->
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    <script type="text/html" id="editHydrographyModalTemplate">
		<div class="clearfix">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Hydrography" autofocus data-bind="value: $root.editHydrography().percent" />
                <span class="input-group-addon">%</span>
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Min" data-bind="value: $root.editHydrography().min" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Max" data-bind="value: $root.editHydrography().max" />
            </div> <!-- /input-group -->
		</div>
    </script>

    <script type="text/html" id="editRegionTypeModalTemplate">
        <div class="clearfix">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Name" autofocus data-bind="value: $root.editRegionType().name" />
            </div> <!-- /input-group -->
        </div>
    </script>

    <script type="text/html" id="editDisplayTypeModalTemplate">
        <input type="text" class="form-control" placeholder="Name" autofocus data-bind="value: $root.editDisplayType().name" />
        <input type="text" class="form-control" placeholder="Num Regions" data-bind="value: $root.editDisplayType().numRegions" />
        <table class="table table-striped table-hover table-bordered">
            <thead>
                <tr>
                    <th>Number</th>
                    <th>Adjacent Regions</th>
                </tr>
            </thead>
            <tbody data-bind="foreach: $root.editDisplayType().regions">
                <tr>
                    <td data-bind="text: number"></td>
                    <td>
                        <input type="text" class="form-control input-sm" data-bind="value: adjacentRegions.formatted" />
                    </td>
                </tr>
            </tbody>
        </table>
    </script>

    <script type="text/html" id="editLandWaterDistributionModalTemplate">
        <div class="clearfix">
            <div class="input-group">
                <p class="form-control-static" data-bind="text: $root.editLandWaterDistribution().regionType().name" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <p class="form-control-static" data-bind="text: $root.editLandWaterDistribution().displayType().name" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <p class="form-control-static" data-bind="text: $root.editLandWaterDistribution().hydrography().percent" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Num Regions" autofocus data-bind="value: $root.editLandWaterDistribution().numRegions" />
            </div> <!-- /input-group -->
        </div>
    </script>

    <script type="text/html" id="editLandWaterMassModalTemplate">
        <div class="clearfix">
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Num Regions" autofocus data-bind="value: $root.editLandWaterMass().numRegions" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="text" class="form-control" data-bind="value: $root.editLandWaterMass().numMasses" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" data-bind="value: $root.editLandWaterMass().minSize" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" data-bind="value: $root.editLandWaterMass().maxSize" />
            </div> <!-- /input-group -->
        </div>
    </script>
</@layout.layout>