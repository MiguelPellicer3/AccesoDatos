package com.somosDual.hotel.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "habitaciones")
public class Habitacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column
	private double precio;
	@Column
	private double tamanyo;
	@Column
	private int nPersonas;
	@Column
	private boolean desyuno;
	@Column
	private boolean ocupada;
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	@JsonIgnoreProperties("habitaciones")
	private Hotel hotel;

}
