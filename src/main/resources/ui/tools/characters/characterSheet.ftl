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