package tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import modelo.Departamentos;

public class Main {

	public static void main(String[] args) {
		//Obtenemos la session factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//Obtenemos la session
		Session sesion = sessionFactory.openSession();
		Transaction tx = sesion.beginTransaction();
		System.out.println("Insertamos un departamento");
		
		Departamentos dep = new Departamentos();
		dep.setDptoNo(4);
		dep.setDnombre("Secretaria");
		dep.setLoc("Huesca");
		
		try {
			sesion.save(dep);
			tx.commit();
			System.out.println("Departamento insertado");
		}catch (ConstraintViolationException cve) {
			System.out.println("Registro duplicado");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problemas al guardar:" + e.getMessage());
		}
		sesion.close();
		System.exit(0);
	}

}
