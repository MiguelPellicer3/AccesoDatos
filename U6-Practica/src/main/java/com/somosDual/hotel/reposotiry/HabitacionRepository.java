package com.somosDual.hotel.reposotiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somosDual.hotel.domain.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Long> {
    List<Habitacion> findByTamanyoAndPrecioBetweenAndOcupadaIsFalse(int tamaño,double precioMin, double precioMax);
}