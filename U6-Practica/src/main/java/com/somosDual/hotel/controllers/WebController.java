package com.somosDual.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.somosDual.hotel.domain.Habitacion;
import com.somosDual.hotel.domain.Hotel;
import com.somosDual.hotel.service.HotelService;


@Controller
public class WebController {
	
	@Autowired
	private HotelService hotelService;

    public WebController(HotelService hotelService) {
		super();
		this.hotelService = hotelService;
	}

	@GetMapping("/hoteles")
    public ResponseEntity<List<Hotel>> buscarHotelesPorLocalidadYCategoría(@RequestParam("localidad") String localidad, @RequestParam("categoria") String categoria) {
        List<Hotel> hoteles = hotelService.buscarHotelesPorLocalidadYCategoria(localidad, categoria);
		return new ResponseEntity<List<Hotel>>(hoteles, HttpStatus.OK);
    }

    @GetMapping("/habitaciones")
    public ResponseEntity<List<Habitacion>> buscarHabitacionesPorTamañoYPrecio(@RequestParam("tamanyo") int tamaño, @RequestParam("precioMin") double precioMin, @RequestParam("precioMax") double precioMax) {
        List<Habitacion> habitaciones = hotelService.buscarHabitacionesPorTamañoYPrecio(tamaño, precioMin, precioMax);
    	return new ResponseEntity<List<Habitacion>>(habitaciones, HttpStatus.OK);
    }

    @PostMapping("/hoteles")
    public ResponseEntity<Hotel> registrarNuevoHotel(@RequestBody Hotel hotel) {
    	return new ResponseEntity<Hotel>( hotelService.registrarNuevoHotel(hotel),HttpStatus.CREATED);
    }

    @PostMapping("/habitaciones")
    public ResponseEntity<Habitacion> registrarNuevaHabitación(@RequestBody Habitacion habitación) {
    	return new ResponseEntity<Habitacion>( hotelService.registrarNuevaHabitación(habitación),HttpStatus.CREATED);
        
    }

    @DeleteMapping("/habitaciones/{id}")
    public ResponseEntity<Habitacion> eliminarHabitación(@PathVariable long id) {
        Habitacion habitación = hotelService.habitacionByid(id);
        if(habitación == null) {
        	return new ResponseEntity<Habitacion>(HttpStatus.NOT_FOUND);
        }
        hotelService.eliminarHabitación(habitación);
        return new ResponseEntity<Habitacion>(HttpStatus.OK);
    }

    @PutMapping("/habitaciones/marcarOcupada/{id}")
    public ResponseEntity<Habitacion> marcarHabitaciónComoOcupada(@PathVariable long id) {
        Habitacion habitación = hotelService.habitacionByid(id);
        if(habitación == null) {
        	return new ResponseEntity<Habitacion>(HttpStatus.NOT_FOUND);
        }
        hotelService.marcarHabitaciónComoOcupada(habitación);
        return new ResponseEntity<Habitacion>(HttpStatus.OK);
    }
    
    @PutMapping("/habitaciones/marcarDesocupada/{id}")
    public ResponseEntity<Habitacion> marcarHabitaciónComoNoOcupada(@PathVariable long id) {
    	Habitacion habitación = hotelService.habitacionByid(id);
        if(habitación == null) {
        	return new ResponseEntity<Habitacion>(HttpStatus.NOT_FOUND);
        }
        hotelService.marcarHabitaciónComoNoOcupada(habitación);
        return new ResponseEntity<Habitacion>(HttpStatus.OK);
    }
}
