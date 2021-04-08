package edu.eci.arsw.weather.connection.impl;
import edu.eci.arsw.weather.connection.HttpConnection;
import edu.eci.arsw.weather.connection.WeatherException;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
/**
 * Clase encargada de llevar a cabo el manejo de la conexion HTTP directamente con la API de OpenWeather.
 * @author  Alejandro Toro Daza
 * @version 1.0.  (8 de Abril del 2021) 
 */
@Service
public class HttpConnectionImpl implements HttpConnection {
    /**
     * Metodo encargado de realizar la conexion y peticion de datos a traves del protocolo HTTP.
     * @param city Ciudad en la cual se va a consultar directamente con la API de Open Weather sus estadisticas.
     * @return URL con la ciudad y sus respectivas estadisticas y localizacion en el mapa.
     * @throws WeatherException Excepcion que se lanza si no se encuentra la temperatura de la ciudad ingresada.
     * @throws IOException Excepcion que se lanza si hay algun error de tipografia.
     */
    @Override
	public String getWeatherByCity(String city)  throws WeatherException, IOException {
		String USER_AGENT = "Mozilla/5.0";
    	String GET_URL = "http://api.openweathermap.org/data/2.5/weather?q="+city+"&appid=e628214cfe83ce10a80c350ba9ef00f0";
        URL obj = new URL(GET_URL);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", USER_AGENT);
        int responseCode = con.getResponseCode();
        System.out.println("GET Response Code :: " + responseCode);
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());
            return response.toString();
        } else {
        	return null;
        }
	}
}