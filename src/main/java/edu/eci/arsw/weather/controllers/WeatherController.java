package edu.eci.arsw.weather.controllers;
import edu.eci.arsw.weather.services.WeatherServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * Clase encargada de llevar a cabo el manejo del controlador del clima de las ciudades, utilizando el recurso /weather para mostrar las estadisticas de la ciudad correspondiente.
 * @author  Alejandro Toro Daza
 * @version 1.0.  (8 de Abril del 2021) 
 */
@RestController
@RequestMapping(value = "/weather")
public class WeatherController {
    @Autowired
    private WeatherServices weater;
    @RequestMapping(method = RequestMethod.GET,path = "{city}")
    /**
     * Metodo encargado de retornar las estadisticas utilizando el protocolo HTTP de la ciudad correspondiente.
     * @param city Ciudad con su respectiva temperatura y localizacion en el mapa.
     * @return Retorna utilizando el protocolo HTTP la temperatura de la ciudad junto con su localizacion en el mapa, y retorna Error 404 si la ciudad que se ingreso no existe.
     */
    public ResponseEntity<?> getWeatherOfACity(@PathVariable String city ){
	    try {
	    	return new ResponseEntity<> (weater.getWeatherByCity(city),HttpStatus.ACCEPTED);
	    } catch (Exception ex) {
	        return new ResponseEntity<>("Error 404",HttpStatus.NOT_FOUND);
	    }
	}
    
}