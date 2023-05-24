package com.somosDual.hotel.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somosDual.hotel.domain.Habitacion;
import com.somosDual.hotel.domain.Hotel;
import com.somosDual.hotel.reposotiry.IHabitacionRepository;
import com.somosDual.hotel.reposotiry.IHotelRepository;

import java.util.List;

@Service
public class HotelService implements IHotelService {

	private final IHotelRepository hotelRepository;
    private final IHabitacionRepository habitacionRepository;

    @Autowired
    public HotelService(IHotelRepository hotelRepository, IHabitacionRepository habitacionRepository) {
        this.hotelRepository = hotelRepository;
        this.habitacionRepository = habitacionRepository;
    }


    @Override
    public List<Hotel> buscarHotelesPorLocalidadYCategoría(String localidad, String categoría) {
        return hotelRepository.findByLocalidadAndCategoria(localidad, categoría);
    }

    @Override
    public List<Habitacion> buscarHabitacionesPorTamañoYPrecio(int tamaño, double precioMin, double precioMax) {
        return habitacionRepository.findByTamanyoAndPrecioBetweenAndLibreIsTrue(tamaño, precioMin, precioMax);
    }

    @Override
    public void registrarNuevoHotel(Hotel hotel) {
        hotelRepository.save(hotel);
    }

    @Override
    public void registrarNuevaHabitación(Habitacion habitación) {
        habitacionRepository.save(habitación);
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
