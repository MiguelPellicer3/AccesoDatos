package XStream;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;

public class XmlListaPersona {

	public static void main(String[] args) {
		File f= new File("Directorio\\ficheroPersonas.dat");
		try {
			FileInputStream fis= new FileInputStream(f);
			ObjectInputStream ois= new ObjectInputStream(fis);
			System.out.println("leyendo..");
			ListaPersonas lista= new ListaPersonas();
			try {
				while(true) {
					Persona p= (Persona) ois.readObject();
					lista.getLista().add(p);
				}
			}catch(EOFException eof) {
				ois.close();
			}
			XStream xstream= new XStream();
			xstream.alias("ListaDePersonas",ListaPersonas.class);
			xstream.alias("DatosPersona", Persona.class);
			xstream.addImplicitCollection(ListaPersonas.class,"lista");
			xstream.toXML(lista.getLista(),new FileOutputStream("Directorio\\Personas.xml"));			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
