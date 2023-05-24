package com.somosDual.hotel.reposotiry;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.somosDual.hotel.domain.Habitacion;

@Repository
public interface IHabitacionRepository extends CrudRepository<Habitacion, Long> {
    List<Habitacion> findByTamanyoAndPrecioBetweenAndLibreIsTrue(int tamaño, double precioMin, double precioMax);
    void deleteById(long id);
    @Modifying
    @Query("UPDATE Habitacion h SET h.ocupada = true WHERE h.id = :id")
    void updateHabitacionOcupada(@Param("id") long id);
}