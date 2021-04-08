package edu.eci.arsw.weather.connection;
import java.io.IOException;
/**
 * Interfaz encargada de realizar la conexion directamente con la API para obtener el clima de la ciudad correspondiente.
 * @author  Alejandro Toro Daza
 * @version 1.0.  (8 de Abril del 2021) 
 */
public interface HttpConnection {
    /**
     * Metodo encargado de obtener usando el protocolo HTTP el clima de la ciudad.
     * @param city Ciudad la cual se desea consultar el clima.
     * @return Clima de la ciudad en cuestion.
     * @throws WeatherException Excepcion que se lanza si no se encuentra la temperatura de la ciudad ingresada.
     * @throws IOException Excepcion que se lanza si hay algun error de tipografia.
     */
    String getWeatherByCity(String city)  throws WeatherException, IOException ;
}