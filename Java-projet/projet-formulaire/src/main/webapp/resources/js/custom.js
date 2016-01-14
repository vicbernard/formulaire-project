//Flot Line Chart
$(document).ready(function() {

    function callAjax() {
        return $.ajax({
            url:  "http://localhost:8080/projet-1.0.0-SNAPSHOT/rs/reponse/moyenne",
            dataType: 'jsonp'

    });
    }

    var result = callAjax();

   console.log(result);
    //var text = '{"libelleQuestion":"test","nbNon":5 ,"nbOui":15}';
    var obj = JSON.parse(result);
    var data = [];
    console.log(obj);

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
});
