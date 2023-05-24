package main;

import java.net.UnknownHostException;
import java.util.Scanner;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Main {

	static Scanner scanner = new Scanner(System.in); //Sirve para recoger texto por consola

	static int select = -1; //opción elegida del usuario

	static int num1 = 0, num2 = 0; //Variables

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int opcion;

		do {
			System.out.println();
			System.out.println("Bienvenido al sistema CRUD");
			System.out.println("1. Insertar Juego");
			System.out.println("2. Buscar por género");
			System.out.println("3. Eliminar un juego  (por título)");
			System.out.println("4. Eliminar todos los juegos de un mismo género");
			System.out.println("5. Subir el precio a todos los juegos");
			System.out.println("6. Mostrar el importe total de todos los juegos (SUMA TOTAL)");
			System.out.println("7. Exit");

			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				crearRegistro();
				break;
			case 2:
				buscarPorGenero();
				break;
			case 3:
				eliminarJuegoPorTitulo();
				break;
			case 4:
				eliminarJuegoPorGenero();
				break;
			case 5:
				subirPrecioATodosLosJuegos();
				break;
			case 6:
				precioTotalJuegos();
				break;
			case 7:
				System.out.println("Hasta luego");
				break;
			default:
				System.out.println("Opción inválida");
			}

		} while (opcion != 7);

		scanner.close();

	}

	public static boolean crearRegistro() {
		MongoClient mongo1;
		try {
			mongo1 = new MongoClient("localhost", 27017);
			DB bdd1 = mongo1.getDB("Surtido");
			DBCollection coll = bdd1.getCollection("Juegos");

			//pedir datos
			System.out.println("Ingrese el Titulo del Juego:");
			String titulo = scanner.nextLine();
			if(comprobarNombre(titulo)) {
				System.out.println("Título ya ingresado");
				return false;
			}
			System.out.println("Ingrese el Genero del Juego:");
			String genero = scanner.nextLine();
			System.out.println("Ingrese el Precio del Juego:");
			double precio = scanner.nextDouble();
			System.out.println("Ingrese la fecha de Lanzamiento (dd/mm/yyyy):");
			String fechalanza = scanner.next();
			scanner.nextLine(); // Consumir el salto de línea después de leer la fecha

			BasicDBObject doc = new BasicDBObject("título", titulo).append("genero", genero).append("precio", precio)
					.append("fechalanzamiento", fechalanza);

			coll.insert(doc);

			System.out.println("Registro creado con éxito.");
			mongo1.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return true;

	}
	
	private static boolean comprobarNombre(String titulo) {
		boolean existe = false;
		MongoClient mongo;
	    try {
	        mongo = new MongoClient("localhost", 27017);
	        DB database = mongo.getDB("Surtido");
	        DBCollection collection = database.getCollection("Juegos");
	        
	        BasicDBObject query = new BasicDBObject();
	        query.put("título", titulo);
	        
	        DBCursor cursor = collection.find(query);
	        if (cursor.hasNext()) {
	           existe = true;
	        }
	        mongo.close();
	    } catch (UnknownHostException e) {
	        e.printStackTrace();
	    }
	    return existe;
	}

	public static void buscarPorGenero() {
	    System.out.println("Ingrese el Genero para filtrar:");
	    String genero = scanner.nextLine();
	    
	    MongoClient mongo;
	    try {
	        mongo = new MongoClient("localhost", 27017);
	        DB database = mongo.getDB("Surtido");
	        DBCollection collection = database.getCollection("Juegos");
	        
	        BasicDBObject query = new BasicDBObject();
	        query.put("genero", genero);
	        BasicDBObject mostrar = new BasicDBObject("_id", false).append("precio", true).append("título", true);
	        
	        DBCursor cursor = collection.find(query,mostrar);
	        while (cursor.hasNext()) {
	            System.out.println(cursor.next());
	        }
	        mongo.close();
	    } catch (UnknownHostException e) {
	        e.printStackTrace();
	    }
	}


	public static void eliminarJuegoPorTitulo() {
		MongoClient mongo1;
		try {
			mongo1 = new MongoClient("localhost", 27017);
			DB bdd1 = mongo1.getDB("Surtido");
			DBCollection coll = bdd1.getCollection("Juegos");

			System.out.println("Ingrese el Titulo del Juego a eliminar:");
			String titulo = scanner.nextLine();

			BasicDBObject query = new BasicDBObject("título", titulo);
			coll.remove(query);

			System.out.println("Registro eliminado con éxito.");
			mongo1.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public static void eliminarJuegoPorGenero() {
		MongoClient mongo1;
		try {
			mongo1 = new MongoClient("localhost", 27017);
			DB bdd1 = mongo1.getDB("Surtido");
			DBCollection coll = bdd1.getCollection("Juegos");

			System.out.println("Ingrese el Genero para eliminar TODOS los que pertenezcan a ese genero:");
			String genero = scanner.nextLine();

			BasicDBObject query = new BasicDBObject("genero", genero);
			coll.remove(query);

			System.out.println("Registros eliminados con éxito.");
			mongo1.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}


	public static void subirPrecioATodosLosJuegos() {
		MongoClient mongo1;
		try {
			mongo1 = new MongoClient("localhost", 27017);
			DB bdd1 = mongo1.getDB("Surtido");
			DBCollection coll = bdd1.getCollection("Juegos");

			System.out.println("Ingrese el Importe a Subir a TODOS los Juegos:");
			double precio= Double.parseDouble(scanner.nextLine());

			BasicDBObject find = new BasicDBObject();
			BasicDBObject update =new BasicDBObject("$inc",new BasicDBObject("precio",precio));
			coll.updateMulti(find, update);

			System.out.println("Registro eliminado con éxito.");
			mongo1.close();

		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}

	public static void precioTotalJuegos() {
		double suma = 0;
		MongoClient mongo1;
		try {
			mongo1 = new MongoClient("localhost", 27017);
			DB bdd1 = mongo1.getDB("Surtido");
			DBCollection coll = bdd1.getCollection("Juegos");

			DBCursor cursor = coll.find();
			while (cursor.hasNext()) {
	           suma += Double.parseDouble(cursor.next().get("precio").toString()) ;
	        }
			mongo1.close();
			System.out.println(suma);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
}
