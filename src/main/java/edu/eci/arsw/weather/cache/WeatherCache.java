package edu.eci.arsw.weather.cache;
import edu.eci.arsw.weather.connection.HttpConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WeatherCache {
    @Autowired
    HttpConnection http;
}