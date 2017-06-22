<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit NameSet Modal -->
    <div data-bind="modal: {
	    visible: editNameSetModalVisible,
	    header: { data: { label: 'Edit Name Set' } },
	    body: { name: 'editNameSetModalTemplate' },
	    footer: { data: { action: updateSet, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New NameSet Modal -->
    <div data-bind="modal: {
	    visible: newNameSetModalVisible,
	    header: { data: { label: 'New Name Set' } },
	    body: { name: 'editNameSetModalTemplate' },
	    footer: { data: { action: createSet, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

	<div class="container">
		<@layout.breadcrumbs breadcrumbs=breadcrumbs />
		<div class="row">
			<#assign l=breadcrumbs?size />
			<h1>${breadcrumbs[l - 1]}</h1>
		</div>
		<div class="row">
			<div class="col-md-3">
				<div class="form-inline row">
					<div class="form-group">
						<button class="btn btn-success" data-bind="click: showNewNameSetModal">
							<i class="fa fa-plus"></i>
						</button>
						<input class="form-control" type="number" data-bind="value: numOf" min="1" >
					</div>
				</div>
				<div class="row" data-bind="foreach: nameSets">
					<div class="nameSet col-md-12">
						<div class="col-md-6">
							<div class="row" data-bind="text: $data.type"></div>
						</div>
						<div class="col-md-6">
							<div class="btn-group btn-group-xs pull-right row" role="group">
								<button type="button" class="btn btn-default" data-bind="click: $root.generate.bind($data)">
									<i class="fa fa-list" aria-hidden="true"></i>
								</button>
								<button type="button" class="btn btn-default" data-bind="click: $root.showEditNameSetModal.bind($data)">
									<i class="fa fa-pencil" aria-hidden="true"></i>
								</button>
								<button type="button" class="btn btn-warning" data-bind="click: $root.remove.bind($data)">
									<i class="fa fa-times" aria-hidden="true"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="col-md-12" data-bind="foreach: names">
					<div class="name row">
						<div class="col-md-12" data-bind="text: $data"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

    <script type="text/html" id="editNameSetModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Type" autofocus data-bind="value: $root.editSet().type" />
			</div> <!-- /input-group -->
			<div class="input-group">
				<input type="text" class="form-control" placeholder="New Name..." autofocus data-bind="value: $root.newName, valueUpdate: 'afterkeydown'" />
				<span class="input-group-btn">
					<button class="btn btn-default" data-bind="enable: $root.newName, click: $root.addName.bind()">
						<i class="fa fa-plus"></i>
					</button>
				</span>
			</div> <!-- /input-group -->
			<div class="input-group">
				<label class="control-label">Names</label>
			</div>
			<div class="col-md-12 nameList">
				<div class="row" data-bind="foreach: $root.editSet().names">
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
	<script src="/js/lib/knockstrap.js"></script>
	<script src="/js/names.js"></script>
</@layout.layout>