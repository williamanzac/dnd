<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit Pack Modal -->
    <div
        data-bind="modal: {
	    visible: editPackModal.visible,
	    header: { data: { label: 'Edit Pack' } },
	    body: { name: 'editPackModalTemplate' },
	    footer: { data: { action: $root.updatePack, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

		        <div class="row">
		            <div class="col-md-4">
		                <div class="panel panel-default">
		                    <div class="panel-heading">
		                        Packs
		                    </div>
		                    <table class="table table-striped table-hover table-bordered">
		                        <thead>
		                            <tr>
		                                <td>
		                                    <input type="text" class="form-control input-sm" placeholder="Name" data-bind="value: newPack().name" />
		                                </td>
		                                <td>
		                                    <input type="number" class="form-control input-sm" placeholder="Cost (gp)" data-bind="value: newPack().costGP" />
		                                </td>
		                                <td style="min-width: 75px;">
		                                    <div class="btn-group btn-group-xs" role="group">
		                                        <button class="btn btn-success" data-bind="click: createPack">
		                                            <i class="fa fa-plus"></i>
		                                        </button>
		                                    </div>
		                                </td>
		                            </tr>
		                        </thead>
		                        <tbody data-bind="foreach: packs">
		                            <tr data-bind="click: $root.editPack, css: {active: $data.id() == $root.editPack().id()}">
		                                <td>
		                                    <span data-bind="inline: name"></span>
		                                </td>
		                                <td>
		                                	<span data-bind="inline: costGP"></span>
		                                </td>
		                                <td>
		                                    <div class="btn-group btn-group-xs" role="group">
		                                        <button type="button" class="btn btn-default" data-bind="click: update">
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
		            <div class="col-md-4">
		                <div class="panel panel-default">
		                    <div class="panel-heading">
		                        Pack Contents
		                    </div>
		                    <table class="table table-striped table-hover table-bordered">
		                        <thead>
		                            <tr>
		                                <td>
		                                    <input type="number" class="form-control input-sm" placeholder="Quantity" data-bind="newPackItem().quantity" />
		                                </td>
		                                <td>
		                                    <select class="form-control input-sm" required data-bind="options: $root.gear, value: newPackItem().item.id, optionsText: 'name', optionsValue: 'id', optionsCaption: 'Item'">
		                                    </select>
		                                </td>
		                                <td style="min-width: 75px;">
		                                    <div class="btn-group btn-group-xs" role="group">
		                                        <button class="btn btn-success" data-bind="click: function() {$root.editPack().items.push($root.newPackItem());}">
		                                            <i class="fa fa-plus"></i>
		                                        </button>
		                                    </div>
		                                </td>
		                            </tr>
		                        </thead>
		                        <tbody data-bind="foreach: $root.editPack().items">
		                            <tr>
		                                <td>
		                                    <span data-bind="inline: quantity"></span>
		                                </td>
		                                <td>
		                                	<span data-bind="inline: item.name"></span>
		                                </td>
		                                <td>
		                                    <div class="btn-group btn-group-xs" role="group">
		                                        <button type="button" class="btn btn-warning" data-bind="click: $root.editPack().items.remove">
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

    <template id="editPackModalTemplate">
        <div class="clearfix">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Name" autofocus data-bind="value: $root.editPack().name" />
            </div>
            <!-- /input-group -->
            <div class="input-group">
                <input class="form-control" placeholder="Cost (gp)" type="text" data-bind="value: $root.editPack().costGP" />
            </div>
            <!-- /input-group -->
        </div>
    </template>
</@layout.layout>