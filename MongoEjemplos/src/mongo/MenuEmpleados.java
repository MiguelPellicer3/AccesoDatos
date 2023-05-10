package mongo;

import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class MenuEmpleados {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println();
			System.out.println("Bienvenido al sistema CRUD");
			System.out.println("1. Crear registro");
			System.out.println("2. Leer registro");
			System.out.println("3. Actualizar registro");
			System.out.println("4. Eliminar registro");
			System.out.println("5. Lista de Empleados por Departamento");
			System.out.println("6. Salir");

			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				crearRegistro();
				break;
			case 2:
				leerRegistro();
				break;
			case 3:
				actualizarRegistro();
				break;
			case 4:
				eliminarRegistro();
				break;
			case 5:
				leerRegistroPorDepartamento();
				break;
			case 6:
				System.out.println("Hasta luego");
				break;
			default:
				System.out.println("Opción inválida");
			}

		} while (opcion != 6);

		scanner.close();

	}

	public static void crearRegistro() {
		MongoClient mongo1;
		try {
			mongo1 = new MongoClient("localhost", 27017);
			DB bdd1 = mongo1.getDB("mibasesdedatos");
			DBCollection coll = bdd1.getCollection("empleados");

			System.out.println("Ingrese el número de empleado:");
			int emp_no = scanner.nextInt();
			scanner.nextLine(); // Consumir el salto de línea después de leer el número entero
			System.out.println("Ingrese el nombre del empleado:");
			String nombre = scanner.nextLine();
			System.out.println("Ingrese el número de departamento:");
			int dep = scanner.nextInt();
			System.out.println("Ingrese el salario:");
			double salario = scanner.nextDouble();
			System.out.println("Ingrese la fecha de alta (dd/mm/yyyy):");
			String fechaalta = scanner.next();
			scanner.nextLine(); // Consumir el salto de línea después de leer la fecha
			System.out.println("Ingrese el oficio:");
			String oficiosString = scanner.nextLine();
			System.out.println("Ingrese las especialidades (separadas por comas):");
			String especialidadesString = scanner.nextLine();
			String[] especialidades = especialidadesString.split(",");
			System.out.println("Ingrese la comisión:");
			double comision = scanner.nextDouble();

			BasicDBObject doc = new BasicDBObject("Emp_no", emp_no).append("nombre", nombre).append("dep", dep)
					.append("salario", salario).append("fechaalta", fechaalta)
					.append("especialidades", Arrays.asList(especialidades)).append("comision", comision)
					.append("oficio", oficiosString);

			coll.insert(doc);

			System.out.println("Registro creado con éxito.");
			mongo1.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	}

	public static void leerRegistro() {
		MongoClient mongo1;
		try {
			mongo1 = new MongoClient("localhost", 27017);
			DB bdd1 = mongo1.getDB("mibasesdedatos");
			DBCollection coll = bdd1.getCollection("empleados");

			DBCursor cursor = coll.find();
			while (cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			mongo1.close();

		} catch (UnknownHostException e) {

			e.printStackTrace();
		}
	}

	public static void leerRegistroPorDepartamento() {
	    System.out.println("Ingrese el número de departamento a filtrar:");
	    int numDepartamento = scanner.nextInt();
	    scanner.nextLine();
	    
	    MongoClient mongo;
	    try {
	        mongo = new MongoClient("localhost", 27017);
	        DB database = mongo.getDB("mibasesdedatos");
	        DBCollection collection = database.getCollection("empleados");
	        
	        BasicDBObject query = new BasicDBObject();
	        query.put("dep", numDepartamento);
	        
	        DBCursor cursor = collection.find(query);
	        while (cursor.hasNext()) {
	            System.out.println(cursor.next());
	        }
	        mongo.close();
	    } catch (UnknownHostException e) {
	        e.printStackTrace();
	    }
	}


	public static void actualizarRegistro() {
		MongoClient mongo1;
		try {
			mongo1 = new MongoClient("localhost", 27017);
			DB bdd1 = mongo1.getDB("mibasesdedatos");
			DBCollection coll = bdd1.getCollection("empleados");

			System.out.println("Ingrese el número de empleado a actualizar:");
			int emp_no = scanner.nextInt();

			BasicDBObject query = new BasicDBObject("Emp_no", emp_no);
			DBObject empleado = coll.findOne(query);

			if (empleado != null) {
				System.out.println("Ingrese el nuevo nombre del empleado:");
				String nombre = scanner.next();
				System.out.println("Ingrese el nuevo número de departamento:");
				int dep = scanner.nextInt();
				System.out.println("Ingrese el nuevo salario:");
				double salario = scanner.nextDouble();
				System.out.println("Ingrese la nueva fecha de alta (dd/mm/yyyy):");
				String fechaalta = scanner.next();
				System.out.println("Ingrese las nuevas especialidades (separadas por comas):");
				String especialidadesString = scanner.next();
				String[] especialidades = especialidadesString.split(",");
				System.out.println("Ingrese la nueva comisión:");
				double comision = scanner.nextDouble();

				empleado.put("nombre", nombre);
				empleado.put("dep", dep);
				empleado.put("salario", salario);
				empleado.put("fechaalta", fechaalta);
				empleado.put("especialidades", Arrays.asList(especialidades));
				empleado.put("comision", comision);

				coll.update(query, empleado);

				System.out.println("Registro actualizado con éxito.");

			} else {
				System.out.println("No se encontró el registro con el número de empleado ingresado.");
			}
			mongo1.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static void eliminarRegistro() {
		MongoClient mongo1;
		try {
			mongo1 = new MongoClient("localhost", 27017);
			DB bdd1 = mongo1.getDB("mibasesdedatos");
			DBCollection coll = bdd1.getCollection("empleados");

			System.out.println("Ingrese el número de empleado a eliminar:");
			int emp_no = scanner.nextInt();

			BasicDBObject query = new BasicDBObject("Emp_no", emp_no);
			coll.remove(query);

			System.out.println("Registro eliminado con éxito.");
			mongo1.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
