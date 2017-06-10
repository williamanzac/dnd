define(['jquery', 'knockout', '../components/worldHydrography', '../components/displayType', '../components/regionType'], function($, ko, WorldHydrography, DisplayType, RegionType) {
    var baseurl = "/tools/worldBuilder/planetology/landWaterDistributions";

    function LandWaterDistribution(data) {
        var self = this;
        if (data != null) {
            self.id = data.id;
            self.numRegions = ko.observable(data.numRegions);
            self.displayType = ko.observable(new DisplayType(data.displayType));
            self.regionType = ko.observable(new RegionType(data.regionType));
            self.hydrography = ko.observable(new WorldHydrography(data.hydrography));
        } else {
            self.name = ko.observable();
            self.numRegions = ko.observable();
            self.displayType = ko.observable();
            self.regionType = ko.observable();
            self.hydrography = ko.observable();
        }

        self.update = function() {
            var data = ko.toJS(self);
            $.ajax({
                method: "PUT",
                data: JSON.stringify(data),
                url: baseurl,
                contentType: "application/json",
                dataType: "json"
            });
        }
        self.create = function() {
            var data = ko.toJS(self);
            $.ajax({
                method: "POST",
                data: JSON.stringify(data),
                url: baseurl,
                contentType: "application/json",
                dataType: "json"
            });
        }
        self.remove = function() {
            $.ajax({
                method: "DELETE",
                url: baseurl + "/" + self.id,
                contentType: "application/json",
                dataType: "json"
            });
        }
    }

    LandWaterDistribution.list = function(list) {
        $.getJSON(baseurl, function (data) {
            var mapped = $.map(data, function(item) {
                return new LandWaterDistribution(item)
            });
            list(mapped);
        });
    }

    return LandWaterDistribution;
});