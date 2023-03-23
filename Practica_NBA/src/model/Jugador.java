package model;
// Generated 8 feb 2023 20:01:42 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Jugador generated by hbm2java
 */
public class Jugador implements java.io.Serializable {

	private Integer codigo;
	private Equipo equipo;
	private String nombre;
	private String procedencia;
	private String altura;
	private Integer peso;
	private String posicion;
	private Set<Estadistica> estadisticas = new HashSet<Estadistica>(0);

	public Jugador() {
	}

	public Jugador(String nombre, String procedencia) {
		this.nombre = nombre;
		this.procedencia = procedencia;
	}

	public Jugador(Equipo equipo, String nombre, String procedencia, String altura, Integer peso, String posicion,
			Set<Estadistica> estadisticas) {
		this.equipo = equipo;
		this.nombre = nombre;
		this.procedencia = procedencia;
		this.altura = altura;
		this.peso = peso;
		this.posicion = posicion;
		this.estadisticas = estadisticas;
	}

	public Integer getCodigo() {
		return this.codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Equipo getEquipo() {
		return this.equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getProcedencia() {
		return this.procedencia;
	}

	public void setProcedencia(String procedencia) {
		this.procedencia = procedencia;
	}

	public String getAltura() {
		return this.altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}

	public Integer getPeso() {
		return this.peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	public String getPosicion() {
		return this.posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Set<Estadistica> getEstadisticas() {
		return this.estadisticas;
	}

	public void setEstadisticas(Set<Estadistica> estadisticas) {
		this.estadisticas = estadisticas;
	}

	@Override
	public String toString() {
		return "Jugador [codigo=" + codigo + ", nombre=" + nombre + "]";
	}

	
}