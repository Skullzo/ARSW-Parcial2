package edu.eci.arsw.weather.connection;
/**
 * Clase encargada de llevar a cabo el manejo de la excepcion en caso de que no se encuentre la temperatura de la ciudad ingresada.
 * @author  Alejandro Toro Daza
 * @version 1.0.  (8 de Abril del 2021) 
 */
public class WeatherException extends Exception{
    /**
     * Metodo encargado de retornar el mensaje en tal caso de que se arroje la excepcion correspondiente.
     * @param message Mensaje que retorna al ususario en caso de que se arroja tal excepcion.
     */
    public WeatherException(String message) {
        super(message);
    }
    /**
     * Metodo encargado de retornar la excepcion como tal con el mensaje y la causa con la cual fue arrojada esta excepcion.
     * @param message Mensaje que retorna al ususario en caso de que se arroja tal excepcion.
     * @param cause Causa por la cual ha sido arrojada la excepcion.
     */
    public WeatherException(String message, Throwable cause) {
        super(message, cause);
    }
}