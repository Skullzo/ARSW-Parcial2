apiclient= (function () {
            //var url = "http://localhost:8080/weather"
            var url = "https://toro-arsw-t2.herokuapp.com/weather"
            var  getWeatherByCity = function(city,callback){
                $.getJSON(url+"/"+city,(data)=>{
                    callback(data);
                },null)
 })();