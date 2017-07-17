<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
	<!-- Edit Spell Modal -->
	<div
		data-bind="modal: {
	    visible: editSpellModalVisible,
	    header: { data: { label: 'Edit Spell' } },
	    body: { name: 'editSpellModalTemplate' },
	    footer: { data: { action: updateSpell, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

	<!-- New Spell Modal -->
	<div
		data-bind="modal: {
	    visible: newSpellModalVisible,
	    header: { data: { label: 'New Spell' } },
	    body: { name: 'editSpellModalTemplate' },
	    footer: { data: { action: createSpell, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

		<div class="row">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>School</th>
						<th>Level</th>
						<th>Name</th>
						<th>Casting Time</th>
						<th>Duration</th>
						<th>Range/Area</th>
						<th>Attack/Save</th>
						<th>Damage/Effect</th>
						<th>
							<div class="btn-group btn-group-xs" role="group">
								<button class="btn btn-success"
									data-bind="click: showNewSpellModal">
									<i class="fa fa-plus"></i>
								</button>
							</div>
						</th>
					</tr>
				</thead>
				<tbody data-bind="foreach: spells">
					<tr>
						<td data-bind="text: school"></td>
						<td data-bind="text: level"></td>
						<td data-bind="text: name"></td>
						<td data-bind="text: castingTime"></td>
						<td data-bind="text: duration"></td>
						<td data-bind="text: range"></td>
						<td data-bind="text: attack"></td>
						<td data-bind="text: damage"></td>
						<td>
							<div class="btn-group btn-group-xs" role="group">
								<button class="btn btn-default"
									data-bind="click: $root.showEditSpellModal.bind($data)">
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

	<script type="text/html" id="editSpellModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input class="form-control" placeholder="Name" autofocus type="text" data-bind="value: $root.newScore().name" />
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
	<script src="/js/spells.js"></script>
</@layout.layout>