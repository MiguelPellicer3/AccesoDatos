package tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Empleados;

public class GetEmpleados {

	public static void main(String[] args) {
		//Obtenemos la session factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//Obtenemos la session
		Session sesion = sessionFactory.openSession();
		
		int n = 5;
		System.out.println("Get empleado "+ n);
		
		Empleados emp = null;
		
		emp = (Empleados) sesion.get(Empleados.class, n);
		if(emp==null) {
			System.out.println("No encontrado");
		}else {
			System.out.println("Apellido del empleado: "+ emp.getApellido());
			System.out.println("Departamento: "+ emp.getDepartamentos().getDnombre());
			System.out.println("Fecha alta: "+ emp.getFechaAlta());
		}
		sesion.close();
		System.exit(0);

	}

}
