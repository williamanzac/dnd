<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit Category Modal -->
    <div data-bind="modal: {
	    visible: editCategoryModal.visible,
	    header: { data: { label: 'Edit Category' } },
	    body: { name: 'editCategoryModalTemplate' },
	    footer: { data: { action: $root.updateCategory, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New Category Modal -->
    <div data-bind="modal: {
	    visible: newCategoryModal.visible,
	    header: { data: { label: 'New Category' } },
	    body: { name: 'editCategoryModalTemplate' },
	    footer: { data: { action: $root.createCategory, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

    <!-- Edit WorldHook Modal -->
    <div data-bind="modal: {
        visible: editWorldHookModal.visible,
        header: { data: { label: 'Edit World Hook' } },
        body: { name: 'editWorldHookModalTemplate' },
        footer: { data: { action: $root.updateWorldHook, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New WorldHook Modal -->
    <div data-bind="modal: {
        visible: newWorldHookModal.visible,
        header: { data: { label: 'New World Hook' } },
        body: { name: 'editWorldHookModalTemplate' },
        footer: { data: { action: $root.createWorldHook, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

	<div class="container">
		<@layout.breadcrumbs breadcrumbs=breadcrumbs />
		<div class="row">
			<#assign l=breadcrumbs?size />
			<h1>${breadcrumbs[l - 1]}</h1>
		</div>
		<div class="row">
			<div class="col-md-4">
				<div class="form-inline row">
					<div class="form-group">
						<button class="btn btn-success" data-bind="click: newCategoryModal.show">
							<i class="fa fa-plus"></i>
						</button>
						<input class="form-control" type="number" data-bind="value: times" min="1" >
                        <button type="button" class="btn btn-default" data-bind="click: generate">
                            <i class="fa fa-list" aria-hidden="true"></i>
                        </button>
					</div>
				</div>
				<div class="row" data-bind="foreach: categories">
					<div class="category col-md-12">
                        <div class="col-md-2">
                            <div class="row" data-bind="text: $data.min() + '-' + $data.max()"></div>
                        </div>
						<div class="col-md-7">
							<div class="row" data-bind="text: $data.name"></div>
						</div>
						<div class="col-md-3">
							<div class="btn-group btn-group-xs pull-right row" role="group">
                                <button type="button" class="btn btn-success" data-bind="click: function(){$root.editWorldHook().categoryId($data.id); $root.newWorldHookModal.show($root.editWorldHook());}">
                                    <i class="fa fa-plus"></i>
                                </button>
								<button type="button" class="btn btn-default" data-bind="click: $root.editCategoryModal.show">
									<i class="fa fa-pencil" aria-hidden="true"></i>
								</button>
								<button type="button" class="btn btn-warning" data-bind="click: remove">
									<i class="fa fa-times" aria-hidden="true"></i>
								</button>
							</div>
						</div>
					</div>
                    <!-- ko foreach: $data.worldHooks -->
                    <div class="worldHook col-md-12">
                        <div class="col-md-offset-3 col-md-6">
                            <div class="row" data-bind="text: $data.name"></div>
                        </div>
                        <div class="col-md-3">
                            <div class="btn-group btn-group-xs pull-right row" role="group">
                                <button type="button" class="btn btn-default" data-bind="click: $root.editWorldHookModal.show">
                                    <i class="fa fa-pencil" aria-hidden="true"></i>
                                </button>
                                <button type="button" class="btn btn-warning" data-bind="click: remove">
                                    <i class="fa fa-times" aria-hidden="true"></i>
                                </button>
                            </div>
                        </div>
                    </div>
                    <!-- /ko -->
				</div>
			</div>
			<div class="col-md-4">
				<div class="col-md-12" data-bind="foreach: worldHooks">
					<div class="name row">
						<div class="col-md-12" data-bind="text: $data.name"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

    <template id="editCategoryModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input type="text" class="form-control" placeholder="Name" autofocus data-bind="value: $root.editCategoryModal.value().name" />
			</div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Min" data-bind="value: $root.editCategoryModal.value().min" />
            </div> <!-- /input-group -->
            <div class="input-group">
                <input type="number" class="form-control" placeholder="Max" data-bind="value: $root.editCategoryModal.value().max" />
            </div> <!-- /input-group -->
		</div>
    </template>

    <template id="editWorldHookModalTemplate">
        <div class="clearfix">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Name" autofocus data-bind="value: $root.editWorldHookModal.value().name" />
            </div> <!-- /input-group -->
        </div>
    </template>
</@layout.layout>