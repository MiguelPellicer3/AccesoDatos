package com.somosDual.hotel.reposotiry;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.somosDual.hotel.domain.Hotel;

@Repository
public interface IHotelRepository extends CrudRepository<Hotel, Long> {

	List<Hotel> findByLocalidadAndCategoria(String localidad, String categoria);
}
