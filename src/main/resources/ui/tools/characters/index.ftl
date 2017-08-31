<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
	<div class="row">
		<div class="panel panel-default">
			<div class="panel-heading" data-bind="text: step().name"></div>
			<div class="panel-body" data-bind="template: {name: getTemplate, data: step().model}">
			</div>
			<div class="panel-footer">
				<div class="btn-group">
					<button type="button" class="btn btn-default" data-bind="click: back, enable: canGoBack">
						<i class="fa fa-chevron-left"></i>
						Back
					</button>
					<button type="button" class="btn btn-default" data-bind="click: next, enable: canGoNext">
						Next
						<i class="fa fa-chevron-right"></i>
					</button>
				</div>
				<div class="btn-group">
					<button type="button" class="btn btn-primary" data-bind="click: finish, enable: canFinish">
						Finish
					</button>
				</div>
				<div class="btn-group">
					<button type="button" class="btn btn-warning" data-bind="click: cancel, enable: canCancel">
						Cancel
					</button>
				</div>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">Character Sheet</div>
			<div class="panel-body">
				<div class="row">
					<div class="col-md-5">
						<div class="col-md-10 character-info">&nbsp;</div>
						<div class="col-md-offset-2 col-md-8">Character Name</div>
					</div>
					<div class="col-md-7 panel panel-default">
						<table class="table">
							<tr>
								<td class="character-info">&nbsp;</td>
								<td class="character-info">&nbsp;</td>
								<td class="character-info">&nbsp;</td>
							</tr>
							<tr>
								<td>Class &amp; Level</td>
								<td>Background</td>
								<td>Player Name</td>
							</tr>
							<tr>
								<td class="character-info" data-bind="text: characterSheet.race() && characterSheet.race().name">&nbsp;</td>
								<td class="character-info">&nbsp;</td>
								<td class="character-info">&nbsp;</td>
							</tr>
							<tr>
								<td>Race</td>
								<td>Alignment</td>
								<td>Experience Points</td>
							</tr>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<div class="row" data-bind="foreach: abilities">
									<div class="col-md-12">
										<div class="panel panel-default">
											<div class="panel-heading" data-bind="text: name"></div>
											<div class="panel-body">
												<div class="character-info">&nbsp;</div>
												<div>&nbsp;</div>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-8">
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="col-md-3 character-info">&nbsp;</div>
												<div class="col-md-9">Inspiration</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-default">
											<div class="panel-body">
												<div class="col-md-3 character-info">&nbsp;</div>
												<div class="col-md-9">Proficiency Bonus</div>
											</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-default">
											<div class="panel-body" data-bind="foreach: abilities">
												<div class="col-md-3" style="background-color: #353a41;">&nbsp;</div>
												<div class="col-md-9" data-bind="text: name"></div>
											</div>
											<div class="panel-footer">Saving Throws</div>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="panel panel-default">
											<div class="panel-body" data-bind="foreach: skills">
												<div class="col-md-3" style="background-color: #353a41;">&nbsp;</div>
												<div class="col-md-9">
													<span data-bind="text: name"></span>
													<span class="text-muted">(<span data-bind="text: ability().name().substr(3)"></span>)</span>
												</div>
											</div>
											<div class="panel-footer">Skills</div>
										</div>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="col-md-3 character-info">&nbsp;</div>
										<div class="col-md-9">Passive Wisdom (Perception)</div>
									</div>
								</div>
							</div>
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="col-md-12" style="background-color: #353a41; min-height: 10em;">&nbsp;</div>
									</div>
									<div class="panel-footer">Other Proficiencies & Languages</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
						<div class="row">
							<div class="col-md-4">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="col-md-12 character-info">&nbsp;</div>
									</div>
									<div class="panel-footer">Armour Class</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="col-md-12 character-info">&nbsp;</div>
									</div>
									<div class="panel-footer">Initiative</div>
								</div>
							</div>
							<div class="col-md-4">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="col-md-12 character-info">&nbsp;</div>
									</div>
									<div class="panel-footer">Speed</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="col-md-6">Hit Point Maximum</div>
										<div class="col-md-6" style="background-color: #353a41;">&nbsp;</div>
										<div class="col-md-12 character-info" style="margin-top: 15px;">&nbsp;</div>
									</div>
									<div class="panel-footer">Current Hit Points</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="col-md-12 character-info">&nbsp;</div>
									</div>
									<div class="panel-footer">Temporary Hit Points</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="col-md-6">Total</div>
										<div class="col-md-6" style="background-color: #353a41;">&nbsp;</div>
										<div class="col-md-12 character-info" style="margin-top: 15px;">&nbsp;</div>
									</div>
									<div class="panel-footer">Hit Dice</div>
								</div>
							</div>
							<div class="col-md-6">
								<div class="panel panel-default">
									<div class="panel-body">
										<div class="row">
											<div class="col-md-6">Successes</div>
											<div class="col-md-6">
												<input type="radio" />
												<input type="radio" />
												<input type="radio" />
											</div>
											<div class="col-md-6">Failures</div>
											<div class="col-md-6">
												<input type="radio" />
												<input type="radio" />
												<input type="radio" />
											</div>
										</div>
									</div>
									<div class="panel-footer">Death Saves</div>
								</div>
							</div>
						</div>
					</div>
					<div class="col-md-4">
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<template id="chooseRace">
		<div class="row">
			<div class="col-md-6">
				<ul class="list-group" data-bind="foreach: $parent.races">
					<!-- ko if: $data.subRaces().length > 0 -->
					<!-- ko foreach: $data.subRaces -->
					<li class="list-group-item name" data-bind="click: $root.selectRace, css: {selected: $root.characterSheet.race() && $data.id == $root.characterSheet.race().id}">
						<div data-bind="text: name"></div>
					</li>
					<!-- /ko -->
					<!-- /ko -->
					<!-- ko if: $data.subRaces().length == 0 -->
					<li class="list-group-item name" data-bind="click: $root.selectRace, css: {selected: $root.characterSheet.race() && $data.id == $root.characterSheet.race().id}">
						<div data-bind="text: name"></div>
					</li>
					<!-- /ko -->
				</ul>
			</div>
			<div class="col-md-6">
				<div class="panel panel-default">
					<div class="panel-heading">Traits</div>
					<div class="panel-body">
						<div class="row" data-bind="if: $data.race()">
							<div class="col-md-12">
								<div class="panel panel-default">
									<div class="panel-heading">Ability Score Adjustments</div>
									<div class="panel-body">
										<table class="table table-bordered">
											<tbody data-bind="foreach: $root.characterSheet.abilityScoreAdjustments">
												<tr>
													<!-- ko if: $data.ability() && $data.ability().id -->
													<td data-bind="text: $data.ability() && $data.ability().name"></td>
													<!-- /ko -->
													<!-- ko ifnot: $data.ability() && $data.ability().id -->
													<td>
														<select class="form-control" data-bind="value: $data.abilityId, options: $root.selectableAbilities, optionsText: 'name', optionsValue: 'id', optionsCaption: 'Ability'"></select>
													</td>
													<!-- /ko -->
													<td data-bind="text: $data.modifier"></td>
												</tr>
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</template>
	
	<template id="chooseClass">
		<div class="row">
			<div class="col-md-6">
				<form class="form-horizontal">
					<div class="form-group">
						<div class="col-md-4">
							<select class="form-control" data-bind="value: class1, options: $parent.classes, optionsText: 'name', optionsValue: 'id', optionsCaption: 'Please Select...'"></select>
						</div>
						<div class="col-md-4">
							<select class="form-control" data-bind="value: class2, options: $parent.classes, optionsText: 'name', optionsValue: 'id', optionsCaption: 'Please Select...'"></select>
						</div>
						<div class="col-md-4">
							<select class="form-control" data-bind="value: class3, options: $parent.classes, optionsText: 'name', optionsValue: 'id', optionsCaption: 'Please Select...'"></select>
						</div>
					</div>
					<div class="form-group">
						<div class="col-md-4">
							<input type="number" class="form-control" data-bind="value: level1"></input>
						</div>
						<div class="col-md-4">
							<input type="number" class="form-control" data-bind="value: level2"></input>
						</div>
						<div class="col-md-4">
							<input type="number" class="form-control" data-bind="value: level3"></input>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-6">
			</div>
		</div>
	</template>
</@layout.layout>