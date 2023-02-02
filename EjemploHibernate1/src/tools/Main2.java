package tools;

import java.sql.Date;
import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.TransientPropertyValueException;
import org.hibernate.exception.ConstraintViolationException;

import modelo.Departamentos;
import modelo.Empleados;

public class Main2 {

	public static void main(String[] args) {
		//Obtenemos la session factory
				SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
				
				//Obtenemos la session
				Session sesion = sessionFactory.openSession();
				Transaction tx = sesion.beginTransaction();
				System.out.println("Insertamos un empleado");
				
				Departamentos dep = new Departamentos();
				dep.setDptoNo(2);
				
				Empleados emp = new Empleados();
				emp.setDepartamentos(dep);
				emp.setEmpNo(9);
				emp.setApellido("Arilla");
				emp.setDir((short)0);
				emp.setFechaAlta(Date.valueOf(LocalDate.now()));
				
				try {
					sesion.save(emp);
					tx.commit();
					System.out.println("Empleado insertado");
				}catch (ConstraintViolationException cve) {
					System.out.println("Registro duplicado");
				}catch(TransientPropertyValueException tvpe) {
					System.out.println("Problemas al guardar: El departamento indicado no es correcto");
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("Problemas al guardar:" + e.getMessage());
				}
				sesion.close();
				System.exit(0);
	}

}
