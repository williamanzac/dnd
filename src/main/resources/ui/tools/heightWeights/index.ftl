<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit HeightWeight Modal -->
    <div data-bind="modal: {
	    visible: editHeightWeightModal.visible,
	    header: { data: { label: 'Edit Height Weight' } },
	    body: { name: 'editHeightWeightModalTemplate' },
	    footer: { data: { action: updateHeightWeight, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New HeightWeight Modal -->
    <div data-bind="modal: {
	    visible: newHeightWeightModal.visible,
	    header: { data: { label: 'New Height Weight' } },
	    body: { name: 'editHeightWeightModalTemplate' },
	    footer: { data: { action: createHeightWeight, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

		<div class="row">
			<div class="col-md-3">
				<div class="form-inline row">
					<div class="form-group">
						<button class="btn btn-success" data-bind="click: newHeightWeightModal.show">
							<i class="fa fa-plus"></i>
						</button>
						<input class="form-control" type="number" data-bind="value: times" min="1" >
					</div>
				</div>
				<div class="row" data-bind="foreach: heightWeights">
					<div class="nameSet col-md-12">
						<div class="col-md-6">
							<div class="row" data-bind="text: $data.type"></div>
						</div>
						<div class="col-md-6">
							<div class="btn-group btn-group-xs pull-right row" role="group">
								<button type="button" class="btn btn-default" data-bind="click: generate.bind($root.result, $root.times())">
									<i class="fa fa-list" aria-hidden="true"></i>
								</button>
								<button type="button" class="btn btn-default" data-bind="click: $root.editHeightWeightModal.show">
									<i class="fa fa-pencil" aria-hidden="true"></i>
								</button>
								<button type="button" class="btn btn-warning" data-bind="click: remove">
									<i class="fa fa-times" aria-hidden="true"></i>
								</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="row">
					<div class="col-md-6">Height</div>
					<div class="col-md-6">Weight</div>
				</div>
				<div class="row" data-bind="foreach: result">
					<div class="col-md-6" data-bind="text: $index() % 2 == 0 ? Math.floor($data / 12) + '\'' + ($data - (Math.floor($data / 12) * 12)) + '\'\'' : $data + 'lb'"></div>
				</div>
			</div>
		</div>

    <script type="text/html" id="editHeightWeightModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Type" autofocus data-bind="value: $root.newScore().type" />
			</div> <!-- /input-group -->
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Base Height" data-bind="value: $root.newScore().baseHeight" />
				<input type="text" class="form-control" placeholder="Height Modifier" data-bind="value: $root.newScore().heightModifier" />
			</div> <!-- /input-group -->
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Base Weight" data-bind="value: $root.newScore().baseWeightLB" />
				<input type="text" class="form-control" placeholder="Weight Modifier" data-bind="value: $root.newScore().weightModifier" />
			</div> <!-- /input-group -->
		</div>
    </script>
</@layout.layout>