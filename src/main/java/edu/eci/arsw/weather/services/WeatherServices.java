package edu.eci.arsw.weather.services;
import edu.eci.arsw.weather.cache.WeatherCache;
import edu.eci.arsw.weather.connection.WeatherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
/**
 * Clase encargada de consultar las estadisticas del clima para una ciudad correspondiente.
 * @author  Alejandro Toro Daza
 * @version 1.0.  (8 de Abril del 2021) 
 */
@Service
public class WeatherServices {
	@Autowired
	WeatherCache cache;
        /**
	 * Metodo encargado de consultar las estadisticas del clima para una ciudad correspondiente.
	 * @param city Ciudad la cual se desea consultar las estadisticas.
	 * @return Estadisticas del clima de la ciudad en cuestion.
	 * @throws WeatherException Excepcion que se lanza si no se encuentra la temperatura de la ciudad ingresada.
	 * @throws IOException Excepcion que se lanza si hay algun error de tipografia.
	 */
	public String getWeatherByCity(String city) throws WeatherException, IOException {
		String data = cache.getCity(city);
		return  data;
	}
}