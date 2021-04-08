package edu.eci.arsw.weather.controllers;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
/**
 * Clase encargada de llevar a cabo el manejo de la excepcion en caso de que no se encuentre el recurso ingresado por el usuario.
 * @author  Alejandro Toro Daza
 * @version 1.0.  (8 de Abril del 2021) 
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{ 
    
}