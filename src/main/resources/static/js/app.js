document.addEventListener('DOMContentLoaded', function () {
    if (document.querySelectorAll('#map-canvas').length > 0)
    {
        if (document.querySelector('html').lang)
            lang = document.querySelector('html').lang;
        else
            lang = 'en';

        var js_file = document.createElement('script');
        js_file.type = 'text/javascript';
        js_file.src = 'https://maps.googleapis.com/maps/api/js?&signed_in=true&language=' + lang;
        document.getElementsByTagName('head')[0].appendChild(js_file);
    }
});
var api = apiclient;
var app = (function (){
	var city;
    var markers;
    var bounds;
    var map;
	var _map = function (list){
    	return list.map(function(data){
    			return {name:data.name, temp:data.main.temp, pressure: data.main.pressure}
    	})
    }
	var setCity = function(city_name){
		city = city_name;
	};
	function table(weather) {
	    console.log(weather)
	    console.log(weather.main.temp);
	    console.log(weather.main.temp_min);
	    console.log(weather.main.temp_max);
	    console.log(weather.main.humidity);
	    console.log(weather.main.pressure);
	    console.log(weather.main.feels_like);
	    $("#body").html("");
    		$('#body')
    			.append(
    			  `<tr>
    				<td>`+weather.main.temp+`</td>
    				<td>`+weather.main.temp_min+`</td>
    				<td>`+weather.main.temp_max+`</td>
    				<td>`+weather.main.humidity+`</td>
    				<td>`+weather.main.pressure+`</td>
    			  </tr>`
    			);
    	plotMarkers(weather);
    };
	var getWeatherByCity = function(city) {
        setCity(city);
        if (city != "") {
            api.getWeatherByCity(city,table);
        }
    };
	var getFunctionsByWeather =  function (b,c) {
        console.log(b);
        if (a != "" && b != "" ) {
            api.getFunctionsByWeather(a,b,c,getSeats);
        }
    };
})();