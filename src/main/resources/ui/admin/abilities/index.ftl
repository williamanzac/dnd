<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit Ability Modal -->
    <div data-bind="modal: {
	    visible: editAbilityModalVisible,
	    header: { data: { label: 'Edit Ability' } },
	    body: { name: 'editAbilityModalTemplate' },
	    footer: { data: { action: updateAbility, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New Ability Modal -->
    <div data-bind="modal: {
	    visible: newAbilityModalVisible,
	    header: { data: { label: 'New Ability' } },
	    body: { name: 'editAbilityModalTemplate' },
	    footer: { data: { action: createAbility, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

	<div class="container">
		<@layout.breadcrumbs breadcrumbs=breadcrumbs />
		<div class="row">
			<#assign l=breadcrumbs?size />
			<h1>${breadcrumbs[l - 1]}</h1>
		</div>
		<div class="row">
			<div class="col-md-6">
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>Name</th>
							<th>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-success" data-bind="click: showNewAbilityModal">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</th>
						</tr>
					</thead>
					<tbody data-bind="foreach: abilities">
						<tr>
							<td data-bind="text: name"></td>
							<td>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-default" data-bind="click: $root.showEditAbilityModal.bind($data)">
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
	</div>

    <template id="editAbilityModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input class="form-control" placeholder="Name" autofocus type="text" data-bind="value: $root.newScore().name" />
			</div> <!-- /input-group -->
		</div>
    </template>

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
	<script src="/js/abilities.js"></script>
</@layout.layout>