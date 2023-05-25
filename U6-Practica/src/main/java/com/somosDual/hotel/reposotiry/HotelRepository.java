package com.somosDual.hotel.reposotiry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.somosDual.hotel.domain.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
	List<Hotel> findByLocalidadAndCategoria(String localidad, String categoria);
}
