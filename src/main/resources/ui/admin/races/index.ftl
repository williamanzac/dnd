<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit Race Modal -->
    <div data-bind="modal: {
	    visible: editRaceModal.visible,
	    header: { data: { label: 'Edit Race' } },
	    body: { name: 'editRaceModalTemplate' },
	    footer: { data: { action: updateRace, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"></div>

    <!-- New Race Modal -->
    <div data-bind="modal: {
	    visible: newRaceModal.visible,
	    header: { data: { label: 'New Race' } },
	    body: { name: 'editRaceModalTemplate' },
	    footer: { data: { action: createRace, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

    <!-- New SubRace Modal -->
    <div data-bind="modal: {
	    visible: newSubRaceModal.visible,
	    header: { data: { label: 'New Sub Race' } },
	    body: { name: 'editSubRaceModalTemplate' },
	    footer: { data: { action: createSubRace, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"></div>

		<div class="row">
			<div class="col-md-6">
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<th>Name</th>
							<th>Adjustments</th>
							<th>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-success" data-bind="click: showNewRaceModal">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</th>
						</tr>
					</thead>
					<tbody data-bind="foreach: races">
						<tr>
							<td data-bind="text: name"></td>
							<td>
								<!-- ko if: $data.abilityScoreAdjustments -->
								<!-- ko foreach: $data.abilityScoreAdjustments -->
								<div class="col-sm-6" data-bind="text: $data.ability().name"></div>
								<div class="col-sm-6" data-bind="text: $data.modifier"></div>
								<!-- /ko -->
								<!-- /ko -->
							</td>
							<td style="min-width: 82px;">
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-default" data-bind="click: $root.editRaceModal.show">
										<i class="fa fa-pencil"></i>
									</button>
									<button class="btn btn-success" data-bind="click: $root.showNewSubRaceModal">
										<i class="fa fa-plus"></i>
									</button>
									<button class="btn btn-warning" data-bind="click: remove">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</td>
						</tr>
						<!-- ko foreach: subRaces -->
						<tr>
							<td data-bind="text: name"></td>
							<td>
								<!-- ko if: $data.abilityScoreAdjustments -->
								<!-- ko foreach: $data.abilityScoreAdjustments -->
								<div class="col-sm-6" data-bind="text: $data.ability().name"></div>
								<div class="col-sm-6" data-bind="text: $data.modifier"></div>
								<!-- /ko -->
								<!-- /ko -->
							</td>
							<td>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-default" data-bind="click: $root.editRaceModal.show">
										<i class="fa fa-pencil"></i>
									</button>
									<button class="btn btn-warning" data-bind="click: remove">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</td>
						</tr>
						<!-- /ko -->
					</tbody>
				</table>
			</div>
		</div>

    <script type="text/html" id="editRaceModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input class="form-control" placeholder="Name" autofocus type="text" data-bind="value: $root.editRace().name" />
			</div> <!-- /input-group -->
			<div>
				<table class="table table-striped table-hover table-bordered">
					<thead>
						<tr>
							<td>
								<select class="form-control" data-bind="value: $root.newAbilityScoreAdjustment().abilityId, options: $root.abilities, optionsText: 'name', optionsValue: 'id', optionsCaption: 'Ability'"></select>
							</td>
							<td>
								<input class="form-control" placeholder="Modifier" type="number" data-bind="textInput: $root.newAbilityScoreAdjustment().modifier" />
							</td>
							<td>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-success" data-bind="click: $root.addAbilityScoreAdjustment">
										<i class="fa fa-plus"></i>
									</button>
								</div>
							</td>
						</tr>
					</thead>
					<tbody data-bind="foreach: $root.editRace().abilityScoreAdjustments">
						<tr>
							<td data-bind="text: $data.ability() && $data.ability().name"></th>
							<td data-bind="text: $data.modifier"></td>
							<td>
								<div class="btn-group btn-group-xs" role="group">
									<button class="btn btn-default" data-bind="">
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
    </script>
    <script type="text/html" id="editSubRaceModalTemplate">
		<div class="clearfix">
			<div class="input-group">
				<input class="form-control" placeholder="Name" autofocus type="text" data-bind="value: $root.editSubRace().name" />
			</div> <!-- /input-group -->
		</div>
    </script>

</@layout.layout>