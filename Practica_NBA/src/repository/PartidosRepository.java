package repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import model.Partidos;
import model.Equipo;

public class PartidosRepository {

	
	public boolean insertarPartido(Partidos partido) {
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.save(partido);
			tx.commit();
			System.out.println("Partido insertado");
			return true;
		}catch (ConstraintViolationException cve) {
			System.out.println("Registro duplicado");
			return false;
		}catch(Exception ex) {
			ex.printStackTrace();
			System.out.println("Problemas al guardar:" + ex.getMessage());
			return false;
		}
	}
	
	public void equiposOrdenadosPuntos() {
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		Query q = sesion.createQuery("from Equipo");
		@SuppressWarnings("unchecked")
		List<Equipo> listaEquipos = q.list();
		for (Equipo equipo : listaEquipos) {
			int puntos=0;
			Collection<Partidos> partidosLocal = equipo.getPartidosesForEquipoLocal();
			for (Partidos partidos : partidosLocal) {
				puntos += partidos.getPuntosLocal();
			}
			Collection<Partidos> partidosVisitante = equipo.getPartidosesForEquipoVisitante();
			for (Partidos partidos : partidosVisitante) {
				puntos += partidos.getPuntosVisitante();
			}
			//equiposWPoints.add(new EquipoYPuntos(equipo, puntos));
	}
}
}

class EquipoYPuntos{
	private Equipo Equipo;
	private int PuntosTotales;
	public EquipoYPuntos(model.Equipo equipo, int puntosTotales) {
		super();
		Equipo = equipo;
		PuntosTotales = puntosTotales;
	}
	public Equipo getEquipo() {
		return Equipo;
	}
	public void setEquipo(Equipo equipo) {
		Equipo = equipo;
	}
	public int getPuntosTotales() {
		return PuntosTotales;
	}
	public void setPuntosTotales(int puntosTotales) {
		PuntosTotales = puntosTotales;
	}
}
