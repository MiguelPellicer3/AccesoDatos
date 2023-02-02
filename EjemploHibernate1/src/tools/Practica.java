package tools;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import modelo.Departamentos;

public class Practica {
	public static void main(String[] args) {
		//Obtenemos la session factory
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		//Obtenemos la session
		
		
		Scanner sn = new Scanner(System.in);
		boolean salir = false;
		int opcion; // Guardaremos la opcion del usuario
		while (!salir) {
			Session sesion = sessionFactory.openSession();
			System.out.println("1. Listar Departamentos");
			System.out.println("2. Insertar Departamento");
			System.out.println("3. Eliminar Departamento");
			System.out.println("4. Modificar Departamento");
			System.out.println("5. Mostar Departamento");
			System.out.println("6. Salir");
			try {
				System.out.println();
				 String siguiente= sn.next();
				 opcion = Integer.parseInt(siguiente);
				switch (opcion) {
				case 1:
					System.out.println("\n\nHas seleccionado Listar Departamentos");
					listarDepartamentos(sesion);
					break;
				case 2:
					System.out.println("\n\nHas seleccionado Insertar Departamento");
					insertarDepartamento(sesion);
					break;
				case 3:
					System.out.println("\n\nHas seleccionado Eliminar Departamento");
					eliminarDepartamento(sesion);
					break;
				case 4:
					System.out.println("\n\nHas seleccionado Modificar Departamento");
					modificarDepartamento(sesion);
					break;
				case 5:
					System.out.println("\n\nHas seleccionado Mostrar Departamento");
					System.out.println("Introduce un id");
					int dpto_no = Integer.parseInt(sn.next());
					Departamentos d = null;
					while(d==null) {
						System.out.println("Ese id no existe, intentalo otra vez");
						dpto_no = sn.nextInt();
						d= getById(sesion, dpto_no);
					}
					System.out.println(d);
					break;
				case 6:
					salir = true;
					sesion.close();
					break;
				default:
					System.out.println("\n\nSolo números entre 1 y 5");
				}
			} catch (InputMismatchException e) {
				System.out.println("Debes insertar un número");
				sesion.close();
				sn.next();
			}
			System.out.println("\n");
			sesion.close();
			sn.close();
		}
	}
	
	
	public static void listarDepartamentos(Session sesion) {
		List<Departamentos> departamentos = listaDepartamentos(sesion);
		for (Departamentos dep : departamentos) {
			System.out.println(dep);
		}
		System.out.println();
	}
	
	public static void insertarDepartamento(Session sesion) {
		Scanner s = new Scanner(System.in);
		List<Departamentos> lista =listaDepartamentos(sesion);
		Departamentos d = new Departamentos();
		Transaction tx = sesion.beginTransaction();
		String id;
		int dpto_no=0;
		
		//recupero la lista de los números de departamentos
		boolean idPermitido = false;
		String numerosOcupados = "";
		int[] dpto_numeros = new int[lista.size()];
		for (int i = 0; i < dpto_numeros.length; i++) {
			dpto_numeros[i] = lista.get(i).getDptoNo();
			numerosOcupados += lista.get(i).getDptoNo() + " ";
		}
		
		//comprobamos que el número de departamento sea válido y no se repite
		while(!idPermitido) {
			System.out.println("Números ya ocupados " + numerosOcupados );
			System.out.println("Introduce un Número de Departamento Valido: ");
			id = s.nextLine();
			dpto_no = Integer.parseInt(id);
			for (int i = 0; i < dpto_numeros.length; i++) {
				if(dpto_no != dpto_numeros[i]) {idPermitido = true;}
			}
		}
		d.setDptoNo(dpto_no);
		String[] datos = getNombreLocalidad();
		System.out.println("Nombre del departamento:");
		d.setDnombre(datos[0]);
		System.out.println("Localidad del departamento:");
		d.setLoc(datos[1]);
		
		try {
			sesion.save(d);
			tx.commit();
			System.out.println("Departamento insertado");
		}catch (ConstraintViolationException cve) {
			System.out.println("Registro duplicado");
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Problemas al guardar:" + e.getMessage());
		}
		s.close();
	}
	
	public static void eliminarDepartamento(Session sesion) {
		Scanner s = new Scanner(System.in);
		Transaction tx = sesion.beginTransaction();
		listarDepartamentos(sesion);
		
		System.out.println("Introduce la id del departamento a eliminar:");
		int id = s.nextInt();
		
		Query q = sesion.createQuery("delete Departamentos d where d.dptoNo= :dptoNo");
		q.setInteger("dptoNo", id);
		
		int filas = q.executeUpdate();
		tx.commit();
		System.out.println("Departamentos eliminados -> "+ filas);
		s.close();
	}
	
	public static void modificarDepartamento(Session sesion) {
		Scanner s = new Scanner(System.in);
		Transaction tx = sesion.beginTransaction();
		listarDepartamentos(sesion);
		Departamentos d = null;
		
		while(d==null) {
			System.out.println("Escribe el id que deseas modificar");
			int dpto_no = s.nextInt();
			d= getById(sesion, dpto_no);
		}
		System.out.println(d+"\n");
		
		String [] datos = getNombreLocalidad();
		String nombre = datos[0];
		String localidad = datos[1];
		
		Query q = sesion.createQuery("Update Departamentos set dnombre = :dnombre, loc = :loc where dptoNo = :dptoNo ");
		q.setString("dnombre", nombre);
		q.setString("loc", localidad);
		q.setInteger("dptoNo", d.getDptoNo());
		int filas = q.executeUpdate();
		tx.commit();
		s.close();
		System.out.println(filas+" filas afectadas");
	}
	
	//Lista de todos departamentos
	public static List<Departamentos> listaDepartamentos(Session sesion){
		Query q = sesion.createQuery("from Departamentos");
		ArrayList<Departamentos> departamentos = (ArrayList<Departamentos>) q.list();
		return departamentos;
	}
	
	//Get departamento por id
	public static Departamentos getById(Session sesion,int id) {
		Query q = sesion.createQuery("from Departamentos d where d.dptoNo = :dpto_No");
		q.setInteger("dpto_No", id);
		Departamentos dep = (Departamentos) q.uniqueResult();
		return dep;
	}
	
	//Comprobación longitud nombre y localidad
	public static String[] getNombreLocalidad() {
		Scanner s = new Scanner(System.in);
		boolean longitudPermitida = false;
		String [] datos = new String [2];
		
		while(!longitudPermitida) {
			System.out.println("Introduce el nuevo nombre de departamento");
			String nombre = s.next();
			System.out.println("Introduce la nueva localidad de departamento");
			String localidad = s.next();
			if(nombre.length()>15 || localidad.length()>15) {
				System.out.println("Has introducido nombres muy largos, longitud máxima 15.");
			}else {
				datos[0] = nombre;
				datos[1] = localidad;
				longitudPermitida=true;
			}
		}
		s.close();
		return datos;
	}
}
