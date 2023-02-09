package model;
// Generated 8 feb 2023 20:01:42 by Hibernate Tools 4.3.6.Final

/**
 * EstadisticaId generated by hbm2java
 */
public class EstadisticaId implements java.io.Serializable {

	private String temporada;
	private int jugador;

	public EstadisticaId() {
	}

	public EstadisticaId(String temporada, int jugador) {
		this.temporada = temporada;
		this.jugador = jugador;
	}

	public String getTemporada() {
		return this.temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public int getJugador() {
		return this.jugador;
	}

	public void setJugador(int jugador) {
		this.jugador = jugador;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof EstadisticaId))
			return false;
		EstadisticaId castOther = (EstadisticaId) other;

		return ((this.getTemporada() == castOther.getTemporada()) || (this.getTemporada() != null
				&& castOther.getTemporada() != null && this.getTemporada().equals(castOther.getTemporada())))
				&& (this.getJugador() == castOther.getJugador());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTemporada() == null ? 0 : this.getTemporada().hashCode());
		result = 37 * result + this.getJugador();
		return result;
	}

}
