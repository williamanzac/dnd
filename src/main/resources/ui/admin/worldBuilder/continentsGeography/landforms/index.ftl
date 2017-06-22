<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit MountainProperty Modal -->
    <div data-bind="modal: {
        visible: editMountainPropertyModalVisible,
        header: { data: { label: 'Edit Mountain Property' } },
        body: { name: 'editMountainPropertyModalTemplate' },
        footer: { data: { action: updateMountainProperty, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New MountainProperty Modal -->
    <div data-bind="modal: {
        visible: newMountainPropertyModalVisible,
        header: { data: { label: 'New Mountain Property' } },
        body: { name: 'editMountainPropertyModalTemplate' },
        footer: { data: { action: createMountainProperty, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

    <!-- Edit MountainPlacement Modal -->
    <div data-bind="modal: {
        visible: editMountainPlacementModalVisible,
        header: { data: { label: 'Edit Mountain Placement' } },
        body: { name: 'editMountainPlacementModalTemplate' },
        footer: { data: { action: updateMountainPlacement, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New MountainPlacement Modal -->
    <div data-bind="modal: {
        visible: newMountainPlacementModalVisible,
        header: { data: { label: 'New Mountain Placement' } },
        body: { name: 'editMountainPlacementModalTemplate' },
        footer: { data: { action: createMountainPlacement, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

	<div class="container">
		<@layout.breadcrumbs breadcrumbs=breadcrumbs />
		<div class="row">
			<#assign l=breadcrumbs?size />
			<h1>${breadcrumbs[l - 1]}</h1>
		</div>
		<div class="row">
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
                                        <button class="btn btn-success" data-bind="click: showNewMountainPlacementModal">
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
                                        <button type="button" class="btn btn-default" data-bind="click: $root.showEditMountainPlacementModal.bind($data)">
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-warning" data-bind="click: $root.removeMountainPlacement.bind($data)">
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
                                        <button class="btn btn-success" data-bind="click: showNewMountainPropertyModal">
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
                                        <button type="button" class="btn btn-default" data-bind="click: $root.showEditMountainPropertyModal.bind($data)">
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-warning" data-bind="click: $root.removeMountainProperty.bind($data)">
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

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/knockout/3.4.0/knockout-min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/knockout.mapping/2.4.1/knockout.mapping.min.js"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.11/js/dataTables.bootstrap.min.js"></script>
	<script
		src="https://cdn.datatables.net/select/1.1.2/js/dataTables.select.min.js"></script>
	<script src="/js/knockstrap.js"></script>
	<script src="/js/landforms.js"></script>
</@layout.layout>