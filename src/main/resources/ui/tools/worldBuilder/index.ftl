<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <div class="row">
        <div class="col-sm-4 sidenav">
            <form class="form-horizontal">
                <div class="form-group">
                    <div class="col-sm-offset-5 col-sm-7">
                        <button type="button" class="btn btn-default" data-bind="click: generateMap">
                            Generate <i class="fa fa-globe" aria-hidden="true"></i>
                        </button>
                    </div>
                </div>
                <div class="form-group">
                    <label for="Seed" class="col-sm-5 control-label">Seed</label>
                    <div class="col-sm-7">
                        <input type="text" class="form-control" id="Seed" data-bind="value: seed" />
                    </div>
                </div>
                <div class="form-group">
                    <label for="DisplayType" class="col-sm-5 control-label">Display Type</label>
                    <div class="col-sm-7">
                        <select class="form-control" id="DisplayType" data-bind="options: displayTypes, value: selectedDisplayTypeId, optionsText: 'name', optionsValue: 'id'"></select>
                    </div>
                </div>
                <div class="form-group">
                    <label for="WorldHydrography" class="col-sm-5 control-label">World Hydrography</label>
                    <div class="col-sm-7">
                        <select class="form-control" id="WorldHydrography" data-bind="options: hydrographies, value: selectedHydrographyId, optionsText: 'percent', optionsValue: 'id'"></select>
                    </div>
                </div>
            </form>
        </div>
        <div class="col-sm-8">
            <div class="row">
                <div class="panel panel-default">
                    <div class="panel-heading">Map</div>
                    <div class="panel-body" data-bind="html: map"></div>
                </div>
            </div>
        </div>
    </div>
</@layout.layout>