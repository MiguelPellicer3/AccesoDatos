package tools;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import modelo.Departamentos;

public class JFrameMetodos {
	
	//DEPARTAMENTOS
	public static Departamentos getById(Session sesion,int id) {
		Query q = sesion.createQuery("from Departamentos d where d.dptoNo = :dpto_No");
		q.setInteger("dpto_No", id);
		Departamentos dep = (Departamentos) q.uniqueResult();
		return dep;
	}
	
	public static Boolean insertarDepartamento(Session sesion, Departamentos dep) {
		Transaction tx = sesion.beginTransaction();
		try {
			sesion.save(dep);
			tx.commit();
			System.out.println("Departamento insertado");
			return true;
		}catch (ConstraintViolationException cve) {
			System.out.println("Registro duplicado");
			return false;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problemas al guardar:" + e.getMessage());
			return false;
		}
	}
	
	public static Boolean eliminarDepartamento(Session sesion, int id) {
		int filas = 0;
		Transaction tx = sesion.beginTransaction();
		Departamentos dep = getById(sesion, id);
		if(dep.getEmpleadoses().isEmpty()) {return false;}
		Query q = sesion.createQuery("delete Departamentos d where d.dptoNo= :dptoNo");
		q.setInteger("dptoNo", id);
		filas = q.executeUpdate();
		tx.commit();
		if(filas>0) {return true;} else {return false;}
	}
	
	public static Boolean modificarDepartamento(Session sesion, Departamentos dep) {
		int filas = 0;
		Transaction tx = sesion.beginTransaction();
		Query q = sesion.createQuery("Update Departamentos set dnombre = :dnombre, loc = :loc where dptoNo = :dptoNo ");
		q.setString("dnombre", dep.getDnombre());
		q.setString("loc", dep.getLoc());
		q.setInteger("dptoNo", dep.getDptoNo());
		filas = q.executeUpdate();
		tx.commit();
		if(filas>0) {return true;} else {return false;}
	}
	
}
