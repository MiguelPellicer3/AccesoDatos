package artistas;

import java.net.UnknownHostException;
import java.util.Arrays;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

public class Consultas {

	public static void main(String[] args) {
		MongoClient mongo1;
		try {
			mongo1 = new MongoClient("localhost",27017);
			DB bdd1 = mongo1.getDB("mibasesdedatos");
			DBCollection coll = bdd1.getCollection("empleados");
			BasicDBObject obj;
			DBCursor cursor;
			
			//BUSQUEDA DE DEPARTAMENTOS 10 y 20
			//obj = new BasicDBObject("dep",new BasicDBObject("$in",Arrays.asList(10,20)));
			//cursor = coll.find(obj);
			
			// SALARIO >1300 Y PROFESORA
			//obj = new BasicDBObject("salario",new BasicDBObject("$gt",1300)).append("oficio", "Profesora");
			//cursor = coll.find(obj);
			
			//SUBIR 100 AL SALRIO DE LOS ANALISTAS
			//BasicDBObject find =new BasicDBObject("oficio","Analista");
			//BasicDBObject update =new BasicDBObject("$inc",new BasicDBObject("salario",100));
			//coll.update(find, update);
			
			// -20 COMISION SOLO EL QUE LA TENGA
			//BasicDBObject find =new BasicDBObject();
			//BasicDBObject update =new BasicDBObject("$inc",new BasicDBObject("comisión",-20));
			//coll.update(find, update, false, true);
			
			//ANALISTAS 1100-1500 Y QUE TENGAN ESPECIALIDAD MySQL
			/*
			obj = new BasicDBObject("salario",new BasicDBObject("$gt",100).append("$lt", 15000))
					.append("oficio", "Analista")
					.append("especialidades", new BasicDBObject("$elemMatch", new BasicDBObject("$eq", "MySQL")))
					;
			*/
			
			//AGREGAR MONGODB A TODOS LOS QUE NO LA TENGAN
			//BasicDBObject find =new BasicDBObject("especialidades",new BasicDBObject("$ne", "MongoDB"));
			//BasicDBObject update =new BasicDBObject("$push",new BasicDBObject("especialidades","MongoDB"));
			//coll.update(find,update,false,true);
			
			cursor = coll.find();
			while(cursor.hasNext()) {
				System.out.println(cursor.next());
			}
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
