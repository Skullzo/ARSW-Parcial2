package edu.eci.arsw.weather.cache;
import edu.eci.arsw.weather.connection.HttpConnection;
import edu.eci.arsw.weather.connection.WeatherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
@Service
public class WeatherCache {
    @Autowired
    HttpConnection http;
    private ConcurrentHashMap<String, String> cities = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, LocalDateTime> time = new ConcurrentHashMap<>();
    public void addCities(String name ,String weather){
            cities.put(name,weather);
            time.put(name, LocalDateTime.now());
    }
    public String getCity(String name) throws IOException, WeatherException {
        if(cities.containsKey(name)) {
            LocalDateTime weatherTime = time.get(name);
            if(LocalDateTime.now().isAfter(weatherTime.plusMinutes(5))) {
                String weather = http.getWeatherByCity(name);
                cities.replace(name, weather);
                time.replace(name, LocalDateTime.now());
                return weather;
            }
            return cities.get(name);
        }else{
            String weather = http.getWeatherByCity(name);
            cities.put(name,weather);
            time.put(name, LocalDateTime.now());
            return weather;
        }
    }
}