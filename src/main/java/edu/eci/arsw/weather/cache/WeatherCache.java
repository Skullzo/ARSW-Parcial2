package edu.eci.arsw.weather.cache;
import edu.eci.arsw.weather.connection.HttpConnection;
import edu.eci.arsw.weather.connection.WeatherException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.concurrent.ConcurrentHashMap;
/**
 * Clase encargada de llevar a cabo todas las operaciones correspondientes para manejar el cache de la aplicacion.
 * @author  Alejandro Toro Daza
 * @version 1.0.  (8 de Abril del 2021) 
 */
@Service
public class WeatherCache {
    @Autowired
    HttpConnection http;
    private ConcurrentHashMap<String, String> cities = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, LocalDateTime> time = new ConcurrentHashMap<>();
    /**
     * Metodo encargado de agregar una ciudad y sus datos a una estructura de datos concurrente, junto con el tiempo en el que fue agregado.
     * @param name Nombre de la ciudad la cual se desea consultar el clima y su localizacion en el mapa.
     * @param weather Temperatura de la ciudad en cuestion.
     */
    public void addCities(String name ,String weather){
            cities.put(name,weather);
            time.put(name, LocalDateTime.now());
    }
    /**
     * Metodo encargado de obtener las estadisticas de la ciudad, y establecer un cache con un intervalo de 5 minutos.
     * @param name Nombre de la ciudad consultada por el usuario.
     * @return Estadisticas del clima de la ciudad correspondiente, si es dentro un intervalo de 5 minutos, se conserva en el cache de la app.
     * @throws IOException Excepcion que se lanza si hay algun error de tipografia.
     * @throws WeatherException Excepcion que se lanza si no se encuentra la temperatura de la ciudad ingresada.
     */
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