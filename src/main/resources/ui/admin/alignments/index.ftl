<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit Alignment Modal -->
    <div data-bind="modal: {
	    visible: editAlignmentModalVisible,
	    header: { data: { label: 'Edit Alignment' } },
	    body: { name: 'editAlignmentModalTemplate' },
	    footer: { data: { action: updateAlignment, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New Alignment Modal -->
    <div data-bind="modal: {
	    visible: newAlignmentModalVisible,
	    header: { data: { label: 'New Alignment' } },
	    body: { name: 'editAlignmentModalTemplate' },
	    footer: { data: { action: createAlignment, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

		<div class="row">
			<div class="col-md-6">
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>Name</th>
							<th>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-success" data-bind="click: showNewAlignmentModal">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</th>
						</tr>
					</thead>
					<tbody data-bind="foreach: alignments">
						<tr>
							<td data-bind="text: name"></td>
							<td>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-default" data-bind="click: $root.showEditAlignmentModal.bind($data)">
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

    <script type="text/html" id="editAlignmentModalTemplate">
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
	<script src="/js/lib/knockstrap.js"></script>
	<script src="/js/alignments.js"></script>
</@layout.layout>