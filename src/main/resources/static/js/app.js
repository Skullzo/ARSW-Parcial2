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
})();