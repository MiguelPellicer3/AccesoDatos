package repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import model.Jugador;

public class JugadorRepository {
	
	public List<Jugador> getJugadores(){
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		Query q = sesion.createQuery("from Jugador");
		@SuppressWarnings("unchecked")
		List<Jugador> lista =q.list();
		return lista;
	}

	public Jugador getByNombre(String nombre) {
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		Query q = sesion.createQuery("from Jugador j where j.nombre = :nombre ");
		q.setString("nombre", nombre);
		Jugador jugador = (Jugador) q.uniqueResult();
		return jugador;		
	}
	
	public boolean createJugador(Jugador j) {
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.save(j);
			tx.commit();
			System.out.println("Jugador insertado");
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
	
	public boolean eliminarJugador(Jugador jugador) {
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		
		Query q = sesion.createQuery("delete Jugador j where j.codigo = :codigo");
		q.setInteger("codigo", jugador.getCodigo());
		int filas = q.executeUpdate();
		
		sesion.close();
		if(filas>0) {return true;} else {return false;}
	}
	
	public boolean modificarJugador(Jugador jugador) {
		//Los jugadores no pueden cambiar de nombre ni de equipo
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		
		Query q = sesion.createQuery("update Jugador j set procedencia = :procedencia,"
				+ " altura = :altura, peso = :peso, posicion = :posicion  where e.codigo = :codigo");
		q.setInteger("codigo", jugador.getCodigo());
		q.setString("procedencia", jugador.getProcedencia());
		q.setString("altura", jugador.getAltura());
		q.setInteger("peso", jugador.getPeso());
		q.setString("posicion", jugador.getPosicion());
		
		int filas = q.executeUpdate();
		sesion.close();
		if(filas>0) {return true;} else {return false;}
	}
}
