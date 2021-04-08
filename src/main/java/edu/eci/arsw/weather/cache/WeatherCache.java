package edu.eci.arsw.weather.cache;
import edu.eci.arsw.weather.connection.HttpConnection;
import edu.eci.arsw.weather.connection.WeatherException;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class WeatherCache {
    @Autowired
    HttpConnection http;
    public String getCity(String name) throws IOException, WeatherException {
        return temp;
    }
}