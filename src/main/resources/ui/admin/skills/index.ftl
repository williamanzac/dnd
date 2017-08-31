<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit Skill Modal -->
    <div data-bind="modal: {
	    visible: editSkillModal.visible,
	    header: { data: { label: 'Edit Skill' } },
	    body: { name: 'editSkillModalTemplate' },
	    footer: { data: { action: updateSkill, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New Skill Modal -->
    <div data-bind="modal: {
	    visible: newSkillModal.visible,
	    header: { data: { label: 'New Skill' } },
	    body: { name: 'editSkillModalTemplate' },
	    footer: { data: { action: createSkill, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

		<div class="row">
			<div class="col-md-6">
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>Name</th>
							<th>Ability</th>
							<th>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-success" data-bind="click: showNewSkillModal">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</th>
						</tr>
					</thead>
					<tbody data-bind="foreach: skills">
						<tr>
							<td data-bind="text: name"></td>
							<td data-bind="text: $data.ability() && $data.ability().name"></td>
							<td>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-default" data-bind="click: $root.editSkillModal.show">
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

    <script type="text/html" id="editSkillModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input class="form-control" placeholder="Name" autofocus type="text" data-bind="value: $root.editSkill().name" />
			</div> <!-- /input-group -->
			<div class="input-group">
				<select class="form-control" data-bind="value: $root.editSkill().ability, options: $parent.abilities, optionsText: 'name', optionsCaption: 'Please Select...'"></select>
			</div> <!-- /input-group -->
		</div>
    </script>

</@layout.layout>