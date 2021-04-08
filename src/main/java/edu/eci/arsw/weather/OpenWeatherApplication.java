package edu.eci.arsw.weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
/**
 * Clase principal encargada de llevar a cabo la ejecucion de todo el programa.
 * @author  Alejandro Toro Daza
 * @version 1.0.  (8 de Abril del 2021) 
 */
@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.weather"})
public class OpenWeatherApplication {
    /**
     * Metodo principal main encargado de correr la aplicacion utilizando el Framework de Spring.
     * @param args Argumentos que entran a la clase principal.
     */
    public static void main(String[] args) {
        SpringApplication.run(OpenWeatherApplication.class, args);
    }
}