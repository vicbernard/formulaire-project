//Flot Line Chart
$(document).ready(function() {

    function callAjax() {
        return $.ajax({
            url:  "http://localhost:8080/projet-1.0.0-SNAPSHOT/rs/reponse/moyenne/0",
            dataType: 'json',
            success: function(resp) {
                //console.log(resp);
                var data = [];
                data[0] = {
                    label: "non",
                    data: resp.nbNon
                };
                data[1] = {
                    label: "oui",
                    data: resp.nbOui
                };
                graph(data,resp.libelleQuestion);
                var data2 = [["Oui",resp.nbOui],["Non",resp.nbNon]];
                graph2(data2,resp.libelleQuestion);
            }
        });
    }

    var result = callAjax();

    function graph2(data,libelle){
        //var data = [ ["January", 10], ["February", 8], ["March", 4], ["April", 13], ["May", 17], ["June", 9] ];
        var placeholder = $("#graph2");
        $.plot(placeholder, [ data ], {
            series: {
                bars: {
                    show: true,
                    barWidth: 0.6,
                    align: "center"
                }
            },
            xaxis: {
                mode: "categories",
                tickLength: 0
            }
        });
    }

//
    function graph(data,libelle){
        var placeholder = $("#graph");
        $("#labelQuestion").text(libelle);
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
    }


});
