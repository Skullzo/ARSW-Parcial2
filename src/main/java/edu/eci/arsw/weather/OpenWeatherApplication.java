package edu.eci.arsw.weather;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@SpringBootApplication
@ComponentScan(basePackages = {"edu.eci.arsw.weather"})
public class OpenWeatherApplication {
    public static void main(String[] args) {
        SpringApplication.run(OpenWeatherApplication.class, args);
    }
}