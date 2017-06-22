<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <div class="container">
		<@layout.breadcrumbs breadcrumbs=breadcrumbs />
		<div class="row">
			<#assign l=breadcrumbs?size />
			<h1>${breadcrumbs[l - 1]}</h1>
		</div>
        <div class="row">
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Generate Plates</div>
                    <div class="panel-body">
                        <div class="input-group">
                            <input class="form-control" type="number" data-bind="value: times" min="1"> <span
                                class="input-group-btn"
                            >
                                <button type="button" class="btn btn-default" data-bind="click: generatePlates">
                                    <i class="fa fa-list" aria-hidden="true"></i>
                                </button>
                            </span>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-md-8">
                <div class="panel panel-default">
                    <div class="panel-heading">Positions and Sizes</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Positions</th>
                                <th>Sizes</th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: plateResults">
                            <tr>
                                <td data-bind="text: positions"></td>
                                <td data-bind="text: sizes"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">Map</div>
                    <div class="panel-body">
                        <svg>
                            
                        </svg>
                    </div>
                </div>
            </div>
        </div>
    </div>
</@layout.layout>