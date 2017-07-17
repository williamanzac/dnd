<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit WorldShape Modal -->
    <div
        data-bind="modal: {
	    visible: editWorldShapeModal.visible,
	    header: { data: { label: 'Edit World Shape' } },
	    body: { name: 'editWorldShapeModalTemplate' },
	    footer: { data: { action: updateWorldShape, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New WorldShape Modal -->
    <div
        data-bind="modal: {
	    visible: newWorldShapeModal.visible,
	    header: { data: { label: 'New World Shape' } },
	    body: { name: 'editWorldShapeModalTemplate' },
	    footer: { data: { action: createWorldShape, closeLabel: 'Cancel', primaryLabel: 'Create' } }
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

        <div class="row">
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">World Shapes</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Name</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success" data-bind="click: newWorldShapeModal.show">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: worldShapes">
                            <tr>
                                <td data-bind="text: min() + '-' + max()"></td>
                                <td data-bind="text: name"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default" data-bind="click: $root.editWorldShapeModal.show">
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
                                <th></th>
                                <th>Diameter</th>
                                <th>World Map Size</th>
                                <th>Region Map Size</th>
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
                                <td data-bind="text: min() + '-' + max()"></td>
                                <td data-bind="text: diameter"></td>
                                <td data-bind="text: worldMapSize"></td>
                                <td data-bind="text: regionMapSize"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default" data-bind="click: $root.editWorldSizeModal.show">
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

    <script type="text/html" id="editWorldShapeModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Name" autofocus data-bind="value: $root.editWorldShape().name" />
			</div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Min" data-bind="value: $root.editWorldShape().min" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Max" data-bind="value: $root.editWorldShape().max" />
            </div> <!-- /input-group -->
		</div>
    </script>

    <script type="text/html" id="editWorldSizeModalTemplate">
        <div class="clearfix">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Planetary Diameter" autofocus data-bind="value: $root.editWorldSize().diameter" />
                <span class="input-group-addon">miles</span>
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Hex Size, World Map" data-bind="value: $root.editWorldSize().worldMapSize" />
                <span class="input-group-addon">miles</span>
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Hex Size, Region Map" data-bind="value: $root.editWorldSize().regionMapSize" />
                <span class="input-group-addon">miles</span>
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Min" data-bind="value: $root.editWorldSize().min" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Max" data-bind="value: $root.editWorldSize().max" />
            </div> <!-- /input-group -->
        </div>
    </script>
</@layout.layout>