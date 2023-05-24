package com.somosDual.hotel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.somosDual.hotel.service.IHotelService;

@Controller
public class WebController {
	
	@Autowired
	private IHotelService hotelService;


    @GetMapping("/buscar")
    public List<Hotel> buscarHotelesPorLocalidadYCategoría(@RequestParam String localidad, @RequestParam String categoría) {
        return hotelService.buscarHotelesPorLocalidadYCategoría(localidad, categoría);
    }

    @GetMapping("/habitaciones/buscar")
    public List<Habitacion> buscarHabitacionesPorTamañoYPrecio(@RequestParam int tamaño, @RequestParam double precioMin, @RequestParam double precioMax) {
        return hotelService.buscarHabitacionesPorTamañoYPrecio(tamaño, precioMin, precioMax);
    }

    @PostMapping("/registrar")
    public void registrarNuevoHotel(@RequestBody Hotel hotel) {
        hotelService.registrarNuevoHotel(hotel);
    }

    @PostMapping("/habitaciones/registrar")
    public void registrarNuevaHabitación(@RequestBody Habitacion habitación) {
        hotelService.registrarNuevaHabitación(habitación);
    }

    @DeleteMapping("/habitaciones/{id}")
    public void eliminarHabitación(@PathVariable long id) {
        Habitacion habitación = new Habitacion();
        habitación.setId(id);
        hotelService.eliminarHabitación(habitación);
    }

    @PutMapping("/habitaciones/{id}/ocupada")
    public void marcarHabitaciónComoOcupada(@PathVariable long id) {
        Habitacion habitación = new Habitacion();
        habitación.setId(id);
        hotelService.marcarHabitaciónComoOcupada(habitación);
    }
    
    @PutMapping("/habitaciones/{id}/desocupada")
    public void marcarHabitaciónComoNOOcupada(@PathVariable long id) {
        Habitacion habitación = new Habitacion();
        habitación.setId(id);
        hotelService.marcarHabitaciónComoNoOcupada(habitación);
    }
}
