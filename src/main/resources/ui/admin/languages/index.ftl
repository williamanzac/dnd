<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit Language Modal -->
    <div data-bind="modal: {
	    visible: editLanguageModalVisible,
	    header: { data: { label: 'Edit Language' } },
	    body: { name: 'editLanguageModalTemplate' },
	    footer: { data: { action: updateLanguage, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New Language Modal -->
    <div data-bind="modal: {
	    visible: newLanguageModalVisible,
	    header: { data: { label: 'New Language' } },
	    body: { name: 'editLanguageModalTemplate' },
	    footer: { data: { action: createLanguage, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

		<div class="row">
			<div class="col-md-6">
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>Name</th>
							<th>Commonly Spoken</th>
							<th>Script</th>
							<th>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-success" data-bind="click: showNewLanguageModal">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</th>
						</tr>
					</thead>
					<tbody data-bind="foreach: languages">
						<tr>
							<td data-bind="text: name"></td>
							<td data-bind="text: commonSpeakers"></td>
							<td data-bind="text: script"></td>
							<td>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-default" data-bind="click: $root.showEditLanguageModal.bind($data)">
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

    <script type="text/html" id="editLanguageModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input class="form-control" placeholder="Name" autofocus type="text" data-bind="value: $root.newScore().name" />
				<input class="form-control" placeholder="Script" type="text" data-bind="value: $root.newScore().script" />
			</div> <!-- /input-group -->
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Commonly Spoken..." autofocus data-bind="value: $root.newSpoken, valueUpdate: 'afterkeydown'" />
				<span class="input-group-btn">
					<button class="btn btn-default" data-bind="enable: $root.newSpoken, click: $root.addSpoken">
						<i class="fa fa-plus"></i>
					</button>
				</span>
			</div> <!-- /input-group -->
			<div class="input-group">
				<label class="control-label">Commonly Spoken</label>
			</div>
			<div class="col-md-12 nameList">
				<div class="row" data-bind="foreach: $root.newScore().commonSpeakers">
					<div class="name col-md-4">
						<div data-bind="text: $data"></div>
					</div>
				</div>
			</div>
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
	<script src="/js/languages.js"></script>
</@layout.layout>