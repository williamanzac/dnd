<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
    <!-- Edit PlanetaryTemperature Modal -->
    <div
        data-bind="modal: {
	    visible: editPlanetaryTemperatureModal.visible,
	    header: { data: { label: 'Edit Planetary Temperature' } },
	    body: { name: 'editPlanetaryTemperatureModalTemplate' },
	    footer: { data: { action: updatePlanetaryTemperature, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New PlanetaryTemperature Modal -->
    <div
        data-bind="modal: {
	    visible: newPlanetaryTemperatureModal.visible,
	    header: { data: { label: 'New Planetary Temperature' } },
	    body: { name: 'editPlanetaryTemperatureModalTemplate' },
	    footer: { data: { action: createPlanetaryTemperature, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

    <!-- Edit SeasonalVariation Modal -->
    <div
        data-bind="modal: {
        visible: editSeasonalVariationModal.visible,
        header: { data: { label: 'Edit Seasonal Variation' } },
        body: { name: 'editSeasonalVariationModalTemplate' },
        footer: { data: { action: updateSeasonalVariation, closeLabel: 'Cancel', primaryLabel: 'Update' } }
    }"
    ></div>

    <!-- New SeasonalVariation Modal -->
    <div
        data-bind="modal: {
        visible: newSeasonalVariationModal.visible,
        header: { data: { label: 'New Seasonal Variation' } },
        body: { name: 'editSeasonalVariationModalTemplate' },
        footer: { data: { action: createSeasonalVariation, closeLabel: 'Cancel', primaryLabel: 'Create' } }
    }"
    ></div>

        <div class="row">
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Planetary Temperature</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Category</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success"
                                            data-bind="click: newPlanetaryTemperatureModal.show"
                                        >
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: planetaryTemperatures">
                            <tr>
                                <td data-bind="text: min() + '-' + max()"></td>
                                <td data-bind="text: category"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default"
                                            data-bind="click: $root.editPlanetaryTemperatureModal.show"
                                        >
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-warning" data-bind="click: remove">
                                            <i class="fa fa-times" aria-hidden="true"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="col-md-4">
                <div class="panel panel-default">
                    <div class="panel-heading">Seasonal Variation</div>
                    <table class="table table-striped table-hover table-bordered">
                        <thead>
                            <tr>
                                <th></th>
                                <th>Variation</th>
                                <th>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button class="btn btn-success"
                                            data-bind="click: newSeasonalVariationModal.show"
                                        >
                                            <i class="fa fa-plus"></i>
                                        </button>
                                    </div>
                                </th>
                            </tr>
                        </thead>
                        <tbody data-bind="foreach: seasonalVariations">
                            <tr>
                                <td data-bind="text: min() + '-' + max()"></td>
                                <td data-bind="text: variation"></td>
                                <td>
                                    <div class="btn-group btn-group-xs" role="group">
                                        <button type="button" class="btn btn-default"
                                            data-bind="click: $root.editSeasonalVariationModal.show"
                                        >
                                            <i class="fa fa-pencil" aria-hidden="true"></i>
                                        </button>
                                        <button type="button" class="btn btn-warning" data-bind="click: remove">
                                            <i class="fa fa-times" aria-hidden="true"></i>
                                        </button>
                                    </div>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>

    <template id="editPlanetaryTemperatureModalTemplate">
    <div class="clearfix">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Category" autofocus
                data-bind="value: $root.editPlanetaryTemperatureModal.value().category"
            />
        </div>
        <!-- /input-group -->
        <div class="input-group">
            <input type="number" class="form-control" placeholder="Min"
                data-bind="value: $root.editPlanetaryTemperatureModal.value().min"
            />
        </div>
        <!-- /input-group -->
        <div class="input-group">
            <input type="number" class="form-control" placeholder="Max"
                data-bind="value: $root.editPlanetaryTemperatureModal.value().max"
            />
        </div>
        <!-- /input-group -->
    </div>
    </template>

    <template id="editSeasonalVariationModalTemplate">
    <div class="clearfix">
        <div class="input-group">
            <input type="text" class="form-control" placeholder="Variation" autofocus
                data-bind="value: $root.editSeasonalVariationModal.value().variation"
            />
        </div>
        <!-- /input-group -->
        <div class="input-group">
            <input type="number" class="form-control" placeholder="Min"
                data-bind="value: $root.editSeasonalVariationModal.value().min"
            />
        </div>
        <!-- /input-group -->
        <div class="input-group">
            <input type="number" class="form-control" placeholder="Max"
                data-bind="value: $root.editSeasonalVariationModal.value().max"
            />
        </div>
        <!-- /input-group -->
    </div>
    </template>
</@layout.layout>