package mongo;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.QueryBuilder;

public class Consultas {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongo1= new MongoClient("localhost",27017);
		DB bdd1 = mongo1.getDB("CatalagoPintura");
		DBCollection coll = bdd1.getCollection("Pintores");
		
		DBCursor cursor = coll.find();
		
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
		
		//BUSCAR FILTRADO
		//BasicDBObject obj = new BasicDBObject("Name","Velazquez");
		//cursor = coll.find(obj);
		//while(cursor.hasNext()) {
			//System.out.println(cursor.next());
		//}
		
		//BUSCAR POR QUERY
		//QueryBuilder qry = QueryBuilder.start("Pais").greaterThan("Esp");
		//BasicDBObject Velazquez = new BasicDBObject();
		//DBCursor cursor2= coll.find(qry.get(),Velazquez);
		//while(cursor2.hasNext()) {
			//System.out.println(cursor2.next());
		//}
		
		//AÑADIR NUEVOS REGISTROS
		//BasicDBObject o1 = new BasicDBObject("Name","Chuck Close").append("Pais", "EEUU").append("Edad", 83);
		//BasicDBObject o2 = new BasicDBObject("Name","Damien Hirst").append("Pais", "Inglaterra").append("Edad", 58);
		//coll.insert(o1);coll.insert(o2);
		
		//MODIFICAR UN CAMPO
		//BasicDBObject find =new BasicDBObject("Edad",new BasicDBObject("$gt",80));
		//BasicDBObject update =new BasicDBObject("$inc",new BasicDBObject("Edad",100));
		//coll.update(find, update,false,true);
		
		//MODIFICAR UN OBJETO AÑADIENDO UN CAMPO
		//BasicDBObject find = new BasicDBObject("Name","Velazquez");
		//BasicDBObject update = new BasicDBObject().append("$set", new BasicDBObject().append("Localidad", "Sevilla"));
		//coll.update(find, update);
		
		//MODIFICAR EL OBJETO ANTERIOR PARA QUITAR EL CAMPO AÑADIDO
		//BasicDBObject find = new BasicDBObject("Name","Velazquez");
		//BasicDBObject update = new BasicDBObject().append("$unset", new BasicDBObject().append("Localidad", "Sevilla"));
		//coll.update(find, update);
		
		//DELETE
		//BasicDBObject delete = new BasicDBObject("Name","Kandinsky");
		//coll.remove(delete);
		
		cursor = coll.find();
		while(cursor.hasNext()) {
			System.out.println(cursor.next());
		}
	}
}
