<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit CharacterAdvancement Modal -->
    <div data-bind="modal: {
	    visible: editCharacterAdvancementModal.visible,
	    header: { data: { label: 'Edit Character Advancement' } },
	    body: { name: 'editCharacterAdvancementModalTemplate' },
	    footer: { data: { action: updateCharacterAdvancement, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New CharacterAdvancement Modal -->
    <div data-bind="modal: {
	    visible: newCharacterAdvancementModal.visible,
	    header: { data: { label: 'New Character Advancement' } },
	    body: { name: 'editCharacterAdvancementModalTemplate' },
	    footer: { data: { action: createCharacterAdvancement, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

	<div class="row">
		<div class="col-md-6">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Experience</th>
						<th>Level</th>
						<th>Proficiency Bonus</th>
						<th>
							<div class="btn-group btn-group-xs" role="group">
								<button class="btn btn-success" data-bind="click: showNewCharacterAdvancementModal">
									<i class="fa fa-plus"></i>
								</button>
							</div>
						</th>
					</tr>
				</thead>
				<tbody data-bind="foreach: characterAdvancements">
					<tr>
						<td data-bind="text: experience"></td>
						<td data-bind="text: level"></td>
						<td data-bind="text: proficiencyBonus"></td>
						<td>
							<div class="btn-group btn-group-xs" role="group">
								<button class="btn btn-default" data-bind="click: $root.editCharacterAdvancementModal.show">
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

    <script type="text/html" id="editCharacterAdvancementModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input class="form-control" placeholder="Experience" autofocus type="number" data-bind="textInput: $root.editCharacterAdvancement().experience" />
			</div> <!-- /input-group -->
			<div class="input-group">
				<input class="form-control" placeholder="Level" type="number" data-bind="textInput: $root.editCharacterAdvancement().level" />
			</div> <!-- /input-group -->
			<div class="input-group">
				<input class="form-control" placeholder="Proficiency Bonus" type="number" data-bind="textInput: $root.editCharacterAdvancement().proficiencyBonus" />
			</div> <!-- /input-group -->
		</div>
    </script>

</@layout.layout>