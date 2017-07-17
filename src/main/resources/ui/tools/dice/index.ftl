<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
		<div class="row form-inline">
			<div class="col-md-5">
				<div class="form-group">
					<input type="text" class="form-control" placeholder="(\d+)d(\d+)+(\d+)" size="5" autofocus data-bind="value: rollData, valueUpdate: 'afterkeydown'" />
					<input type="number" class="form-control" placeholder="times" min="1" size="2" data-bind="value: times" />
					<button class="btn btn-default" title="roll" data-bind="enable: rollData, click: roll">
						<i class="fa fa-random"></i>
					</button>
				</div>
				<div class="col-md-12" data-bind="foreach: result">
					<div class="name row">
						<div class="col-md-12" data-bind="text: $data"></div>
					</div>
				</div>
			</div>
		</div>
</@layout.layout>