package mongo;

import java.net.UnknownHostException;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class Main {

	public static void main(String[] args) throws UnknownHostException {
		MongoClient mongo1= new MongoClient("localhost",27017);
		DB bdd1 = mongo1.getDB("CatalagoPintura");
		
		DBCollection coll1 = bdd1.createCollection("Pintores", null);
		
		BasicDBObject d1 = new BasicDBObject("Name","Kandinsky").append("Pais", "Rusia");
		BasicDBObject d2 = new BasicDBObject("Name","Velazquez").append("Pais", "España");
		
		coll1.insert(d1);
		coll1.insert(d2);
		
	}
}
