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
		<#include "characterSheet.ftl">
	</div>
</@layout.layout>