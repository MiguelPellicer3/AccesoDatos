package tools;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import modelo.Departamentos;

public class LoadDepartamentos {

	public static void main(String[] args) {
		//Obtenemos la session factory
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				
				//Obtenemos la session
				Session sesion = sessionFactory.openSession();
				
				int n = 35;
				System.out.println("Get departamento"+ n);
				
				Departamentos dep = null;
				
				dep = (Departamentos) sesion.get(Departamentos.class, n);
				if(dep==null) {
					System.out.println("No encontrado");
				}else {
					System.out.println("Nombre del departamento "+ dep.getDnombre());
					System.out.println("Localicazion "+ dep.getLoc());
				}
				sesion.close();
				System.exit(0);
	}

}
