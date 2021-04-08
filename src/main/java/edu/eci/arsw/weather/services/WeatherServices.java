package edu.eci.arsw.weather.services;
import edu.eci.arsw.weather.cache.WeatherCache;
import edu.eci.arsw.weather.connection.WeatherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
@Service
public class WeatherServices {
	@Autowired
	WeatherCache cache;
	public String getWeatherByCity(String city) throws WeatherException, IOException {
		String data = cache.getCity(city);
		return  data;
	}
}