<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit Hydrography Modal -->
    <div data-bind="modal: {
	    visible: editHydrographyModalVisible,
	    header: { data: { label: 'Edit Regional Hydrography' } },
	    body: { name: 'editHydrographyModalTemplate' },
	    footer: { data: { action: updateHydrography, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New Hydrography Modal -->
    <div data-bind="modal: {
	    visible: newHydrographyModalVisible,
	    header: { data: { label: 'New Regional Hydrography' } },
	    body: { name: 'editHydrographyModalTemplate' },
	    footer: { data: { action: createHydrography, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

	<div class="container">
		<@layout.breadcrumbs breadcrumbs=breadcrumbs />
		<div class="row">
			<#assign l=breadcrumbs?size />
			<h1>${breadcrumbs[l - 1]}</h1>
		</div>
		<div class="row">
			<div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Regional Hydrography</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Continental Form</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success" data-bind="click: showNewHydrographyModal">
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: hydrographies">
                            <tr>
                                <td data-bind="text: min() + '-' + max()"></td>
                                <td data-bind="text: continentalForm"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default" data-bind="click: $root.showEditHydrographyModal.bind($data)">
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-warning" data-bind="click: $root.removeHydrography.bind($data)">
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

    <script type="text/html" id="editHydrographyModalTemplate">
		<div class="clearfix">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Continental Form" autofocus data-bind="value: $root.editHydrography().continentalForm" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Min" data-bind="value: $root.editHydrography().min" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Max" data-bind="value: $root.editHydrography().max" />
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
	<script src="/js/continentsGeography.js"></script>
</@layout.layout>