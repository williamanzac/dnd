<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
	<!-- Edit Gear Modal -->
	<div
		data-bind="modal: {
	    visible: editGearModalVisible,
	    header: { data: { label: 'Edit Gear' } },
	    body: { name: 'editGearModalTemplate' },
	    footer: { data: { action: updateGear, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

	<!-- New Gear Modal -->
	<div
		data-bind="modal: {
	    visible: newGearModalVisible,
	    header: { data: { label: 'New Gear' } },
	    body: { name: 'editGearModalTemplate' },
	    footer: { data: { action: createGear, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

	<div class="container">
		<@layout.breadcrumbs breadcrumbs=breadcrumbs />
		<div class="row">
			<#assign l=breadcrumbs?size />
			<h1>${breadcrumbs[l - 1]}</h1>
		</div>
		<div class="row">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Name</th>
						<th>Category</th>
						<th>Cost (gp)</th>
						<th>Weight (lb)</th>
						<th>
							<div class="btn-group btn-group-xs" role="group">
								<button class="btn btn-success"
									data-bind="click: showNewGearModal">
									<i class="fa fa-plus"></i>
								</button>
							</div>
						</th>
					</tr>
				</thead>
				<tbody data-bind="foreach: gear">
					<tr>
						<td data-bind="text: name"></td>
						<td data-bind="text: category"></td>
						<td data-bind="text: costGP"></td>
						<td data-bind="text: weightLB"></td>
						<td>
							<div class="btn-group btn-group-xs" role="group">
								<button class="btn btn-default"
									data-bind="click: $root.showEditGearModal.bind($data)">
									<i class="fa fa-pencil"></i>
								</button>
								<button class="btn btn-warning">
									<i class="fa fa-times"></i>
								</button>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>

	<script type="text/html" id="editGearModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input class="form-control" placeholder="Name" autofocus type="text" data-bind="value: $root.newScore().name" />
			</div> <!-- /input-group -->
			<div class="input-group">
				<input class="form-control" placeholder="Category" type="text" data-bind="value: $root.newScore().category" />
			</div> <!-- /input-group -->
			<div class="input-group">
				<input class="form-control" placeholder="Cost (gp)" type="text" data-bind="value: $root.newScore().costGP" />
			</div> <!-- /input-group -->
			<div class="input-group">
				<input class="form-control" placeholder="Weight (lb)" type="text" data-bind="value: $root.newScore().weightLB" />
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
	<script src="/js/lib/knockstrap.js"></script>
	<script src="/js/gear.js"></script>
</@layout.layout>