define(['jquery', 'knockout'], function($, ko) {
    var baseurl = "/tools/worldBuilder/planetology/landWaterMasses";

    function LandWaterMass(data) {
        var self = this;
        if (data != null) {
            self.id = data.id;
            self.numRegions = ko.observable(data.numRegions);
            self.numMasses = ko.observable(data.numMasses);
            self.minSize = ko.observable(data.minSize);
            self.maxSize = ko.observable(data.maxSize);
        } else {
            self.name = ko.observable();
            self.numRegions = ko.observable();
            self.numMasses = ko.observable();
            self.minSize = ko.observable();
            self.maxSize = ko.observable();
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

    LandWaterMass.list = function(list) {
        $.getJSON(baseurl, function (data) {
            var mapped = $.map(data, function(item) {
                return new LandWaterMass(item)
            });
            list(mapped);
        });
    }

    return LandWaterMass;
});