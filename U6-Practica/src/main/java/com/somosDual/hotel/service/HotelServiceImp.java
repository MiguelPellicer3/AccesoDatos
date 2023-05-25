package com.somosDual.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somosDual.hotel.domain.Habitacion;
import com.somosDual.hotel.domain.Hotel;
import com.somosDual.hotel.reposotiry.HabitacionRepository;
import com.somosDual.hotel.reposotiry.HotelRepository;

import java.util.List;

@Service
public class HotelServiceImp implements HotelService {

	private final HotelRepository hotelRepository;
    private final HabitacionRepository habitacionRepository;

    @Autowired
    public HotelServiceImp(HotelRepository hotelRepository, HabitacionRepository habitacionRepository) {
        this.hotelRepository = hotelRepository;
        this.habitacionRepository = habitacionRepository;
    }

    @Override
    public Hotel hotelByid(long id) {
    	return hotelRepository.findById(id).orElse(null);
    }
    @Override
    public Habitacion habitacionByid(long id) {
    	return habitacionRepository.findById(id).orElse(null);
    }
    
    @Override
    public List<Hotel> buscarHotelesPorLocalidadYCategoria(String localidad, String categoria) {
        return hotelRepository.findByLocalidadAndCategoria(localidad, categoria);
    }

    @Override
    public List<Habitacion> buscarHabitacionesPorTamañoYPrecio(int tamaño, double precioMin, double precioMax) {
        return habitacionRepository.findByTamanyoAndPrecioBetweenAndOcupadaIsFalse(tamaño, precioMin, precioMax);
    }

    @Override
    public Hotel registrarNuevoHotel(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public Habitacion registrarNuevaHabitación(Habitacion habitación) {
       return habitacionRepository.save(habitación);
    }

    @Override
    public void eliminarHabitación(Habitacion habitación) {
        habitacionRepository.delete(habitación);
    }

    @Override
    public void marcarHabitaciónComoOcupada(Habitacion habitación) {
        habitación.setOcupada(true);
        habitacionRepository.save(habitación);
    }
    
    @Override
    public void marcarHabitaciónComoNoOcupada(Habitacion habitación) {
        habitación.setOcupada(false);
        habitacionRepository.save(habitación);
    }
}
