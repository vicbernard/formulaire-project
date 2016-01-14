//Flot Line Chart
$(document).ready(function() {
    console.log("document ready");

    //var data = [],
    //    series = Math.floor(Math.random() * 6) + 3;
    //
    //for (var i = 0; i < series; i++) {
    //    data[i] = {
    //        label: "Series" + (i + 1),
    //        data: Math.floor(Math.random() * 100) + 1
    //    }
    //}

    var text = '{"libelleQuestion":"test","nbNon":5 ,"nbOui":15}';
    var obj = JSON.parse(text);
    var data = [];

    data[0] = {
        label: "non",
        data: obj.nbNon
    };
    data[1] = {
        label: "oui",
        data: obj.nbOui
    };
    console.log(data);

    var placeholder = $("#graph");

    placeholder.unbind();
    $.plot(placeholder, data, {
        series: {
            pie: {
                show: true
            }
        },
        legend: {
            show: false
        }
    });

    //http://desktop-ipgg17v:8080/projet-1.0.0-SNAPSHOT/
});
