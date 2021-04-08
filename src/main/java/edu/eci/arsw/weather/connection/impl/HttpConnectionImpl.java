package edu.eci.arsw.weather.connection.impl;
import edu.eci.arsw.weather.connection.HttpConnection;
import edu.eci.arsw.weather.connection.WeatherException;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
@Service
public class HttpConnectionImpl implements HttpConnection {
    @Override
	public String getWeatherByCity(String city)  throws WeatherException, IOException {
		String USER_AGENT = "Mozilla/5.0";
    	String GET_URL = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=e628214cfe83ce10a80c350ba9ef00f0";
        URL obj = new URL(GET_URL);
}