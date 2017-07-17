<#-- @ftlvariable name="" type="nz.co.manager.views.GenericView" -->
<#import "../../../../layout.ftl" as layout>
<@layout.layout breadcrumbs=breadcrumbs path=path>
	<div class="row">
	    <div class="col-sm-4 sidenav">
	          <div class="panel panel-default">
	              <div class="panel-heading">Display Types</div>
	              <table class="table table-striped table-hover table-bordered">
	                  <tbody data-bind="foreach: displayTypes">
	                      <tr data-bind="css: {active: $root.selectedDisplayType() != null && $root.selectedDisplayType().id == id}, click: $root.setSelectedDisplayType.bind($data)">
	                          <td data-bind="text: name"></td>
	                      </tr>
	                  </tbody>
	              </table>
	          </div>
	          <div class="panel panel-default">
	              <div class="panel-heading">Hydrography</div>
	              <div class="panel-body">
	                  <div class="input-group">
	                      <input class="form-control" type="number" data-bind="value: times" min="1">
	                      <span class="input-group-btn">
	                          <button type="button" class="btn btn-default" data-bind="click: generateHydrography, enable: selectedDisplayType">
	                              <i class="fa fa-list" aria-hidden="true"></i>
	                          </button>
	                      </span>
	                  </div>
	              </div>
	              <table class="table table-striped table-hover table-bordered">
	                  <tbody data-bind="foreach: hydrographies">
	                      <tr>
	                          <td data-bind="text: percent"></td>
	                      </tr>
	                  </tbody>
	              </table>
	          </div>
	</div>
	<div class="col-sm-8">
	    <div class="row">
	           <div class="panel panel-default">
	               <div class="panel-heading">Land/Water Distribution</div>
	               <table class="table table-striped table-hover table-bordered">
	                   <thead>
	                       <tr>
	                           <th>Hydrography</th>
	                           <!-- ko foreach: $root.regionTypes -->
	                         <th data-bind="text: name"></th>
	                         <!-- /ko -->
	                     </tr>
	                 </thead>
	                 <tbody data-bind="foreach: results">
	                     <tr>
	                         <td data-bind="text: percent"></td>
	                         <!-- ko foreach: $root.regionTypes -->
	                         <td>
	                         	<span data-bind="text: $root.findNumRegions(name(), $root.selectedDisplayType().name(), $parent.percent()).numRegions()"></span>
	     					</td>
	                         <!-- /ko -->
	                     </tr>
	                 </tbody>
	             </table>
	         </div>
	         <div class="panel panel-default">
	             <div class="panel-heading">Positions and Sizes</div>
	             <table class="table table-striped table-hover table-bordered">
	                 <thead>
	                     <tr>
	                         <th># Regions</th>
	                         <th>Positions</th>
	                         <th>Sizes</th>
	                     </tr>
	                 </thead>
	                 <tbody data-bind="foreach: massResults">
	                     <tr>
	                         <td data-bind="text: mass != null ? mass.numRegions : 0"></td>
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