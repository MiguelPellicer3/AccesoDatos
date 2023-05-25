package com.somosDual.hotel.service;

import java.util.List;

import com.somosDual.hotel.domain.Habitacion;
import com.somosDual.hotel.domain.Hotel;

public interface HotelService {

	List<Hotel> buscarHotelesPorLocalidadYCategoria(String localidad, String categoria);

	List<Habitacion> buscarHabitacionesPorTamañoYPrecio(int tamaño, double precioMin, double precioMax);

	Hotel registrarNuevoHotel(Hotel hotel);

	Habitacion registrarNuevaHabitación(Habitacion habitación);

	void eliminarHabitación(Habitacion habitación);

	void marcarHabitaciónComoOcupada(Habitacion habitación);

	void marcarHabitaciónComoNoOcupada(Habitacion habitación);

	Habitacion habitacionByid(long id);

	Hotel hotelByid(long id);

}
