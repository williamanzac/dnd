<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
		<div class="row">
			<div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Generate</div>
                    <div class="panel-body">
                        <div class="input-group">
                            <input class="form-control" type="number" data-bind="value: times" min="1" >
                            <span class="input-group-btn">
                                <button type="button" class="btn btn-default" data-bind="click: function() { generateShape(); generateSize(); }">
                                    <i class="fa fa-list" aria-hidden="true"></i>
                                </button>
                            </span>
                        </div>
                    </div>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">World Shapes</div>
                    <table class="table table-striped table-hover table-bordered">
                        <tbody data-bind="foreach: worldShapes">
                            <tr>
                                <td data-bind="text: name"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                <div class="panel panel-default">
                    <div class="panel-heading">World Sizes</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Diameter</th>
                                <th>World Map Size</th>
                                <th>Region Map Size</th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: worldSizes">
                            <tr>
                                <td data-bind="text: diameter"></td>
                                <td data-bind="text: worldMapSize"></td>
                                <td data-bind="text: regionMapSize"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
			</div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Shapes</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Name</th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: shapes">
                            <tr>
                                <td data-bind="text: name"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Sizes</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th>Diameter</th>
                                <th>World Map Size</th>
                                <th>Region Map Size</th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: sizes">
                            <tr>
                                <td data-bind="text: diameter"></td>
                                <td data-bind="text: worldMapSize"></td>
                                <td data-bind="text: regionMapSize"></td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
		</div>
</@layout.layout>