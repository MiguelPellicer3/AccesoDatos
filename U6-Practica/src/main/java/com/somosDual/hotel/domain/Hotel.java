package com.somosDual.hotel.domain;


import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "hoteles")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private String categoria;
	@Column
	private boolean piscina;
	@Column
	private String localidad;
	@JsonIgnoreProperties("hotel")
	@OneToMany(mappedBy = "hotel")
	private List<Habitacion> habitaciones;

}
