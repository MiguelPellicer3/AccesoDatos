package Repaso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersonaMain {

	public static void main(String[] args) {
		Persona p1= new Persona("Josete",25);
		Persona p2= new Persona("Rosa",18);
		File f= new File("C:\\Users\\DAMDUALAlu7\\fichero.txt");
		FileOutputStream fos;
		FileInputStream fis;
		try {
			fos = new FileOutputStream(f);
			fis= new FileInputStream(f);
			ObjectOutputStream oos= new ObjectOutputStream(fos);
			ObjectInputStream ois= new ObjectInputStream(fis);
			oos.writeObject(p1);oos.writeObject(p2);
			
			Persona px= (Persona) ois.readObject();
			Persona py= (Persona) ois.readObject();
			System.out.println(px+"\n"+py);
			oos.close();
			fos.close();
			ois.close();
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
