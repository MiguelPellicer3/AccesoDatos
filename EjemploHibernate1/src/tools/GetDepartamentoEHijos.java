package tools;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Departamentos;
import modelo.Empleados;

public class GetDepartamentoEHijos {

	public static void main(String[] args) {
		//Obtenemos la session factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		
		//Obtenemos la session
		Session sesion = sessionFactory.openSession();
		
		int n = 2;
		System.out.println("Get departamento"+ n);
		
		Departamentos dep = null;
		
		dep = (Departamentos) sesion.get(Departamentos.class, n);
		if(dep==null) {
			System.out.println("No encontrado");
			System.exit(0);
		}
		
		Set<Empleados> empleadoses = dep.getEmpleadoses();
		
		for (Empleados empleados : empleadoses) {
			System.out.println(empleados.getApellido()+"  "+empleados.getFechaAlta());
		}
		
		
		sesion.close();
		System.exit(0);

	}

}
