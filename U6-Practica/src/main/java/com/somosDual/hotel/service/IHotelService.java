package com.somosDual.hotel.service;

import java.util.List;

import com.somosDual.hotel.domain.Habitacion;
import com.somosDual.hotel.domain.Hotel;

public interface IHotelService {

	List<Hotel> buscarHotelesPorLocalidadYCategoría(String localidad, String categoría);

	List<Habitacion> buscarHabitacionesPorTamañoYPrecio(int tamaño, double precioMin, double precioMax);

	void registrarNuevoHotel(Hotel hotel);

	void registrarNuevaHabitación(Habitacion habitación);

	void eliminarHabitación(Habitacion habitación);

	void marcarHabitaciónComoOcupada(Habitacion habitación);

	void marcarHabitaciónComoNoOcupada(Habitacion habitación);

}
