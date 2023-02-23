package repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import model.Equipo;

public class EquipoRepository {

	public Equipo getEquipoByNombre(String nombre) {
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		Query q = sesion.createQuery("from Equipo e where e.nombre = :nombre ");
		q.setString("nombre", nombre);
		Equipo e = (Equipo) q.uniqueResult();
		sesion.close();
		return e;
	}
	
	public boolean createEquipo(Equipo e) {
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.save(e);
			tx.commit();
			System.out.println("Equipo insertado");
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
	
	public boolean eliminarEquipo(String nombre) {
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		
		Query q = sesion.createQuery("delete Equipo e where e.nombre = :nombre");
		q.setString("nombre", nombre);
		int filas = q.executeUpdate();
		
		sesion.close();
		if(filas>0) {return true;} else {return false;}
	}
	
	public boolean modificarEquipo(Equipo equipo) {
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		
		Query q = sesion.createQuery("update Equipo e set ciudad = :ciudad, conferencia = :conferencia, division = :division where e.nombre = :nombre");
		q.setString("nombre", equipo.getNombre());
		q.setString("ciudad", equipo.getCiudad());
		q.setString("conferencia", equipo.getConferencia());
		q.setString("division", equipo.getDivision());
		
		int filas = q.executeUpdate();
		sesion.close();
		if(filas>0) {return true;} else {return false;}
	}
	
	public List<String> getNombres(){
		SessionFactory sesionFactory =HibernateSession.getSessionFactory();
		Session sesion= sesionFactory.openSession();
		Query q = sesion.createQuery("select nombre from Equipo");
		@SuppressWarnings("unchecked")
		List<String> nombres =  q.list();
		sesion.close();
		return nombres;
	}
	
}
