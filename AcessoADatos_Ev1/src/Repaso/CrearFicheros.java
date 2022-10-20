package Repaso;

import java.io.File;
import java.io.IOException;

public class CrearFicheros {

	public static void main(String[] args) {
		try {
			File directorio= new File(".\\Directorio");
			if(directorio.mkdir())
				System.out.println("Directorio creado correctamente");
			else
				System.out.println("No se pudo crear");
			
			File f1= new File(directorio,"Ficherito1.txt");
			File f2= new File(directorio,"Ficherito2.txt");
			if (f1.createNewFile())
				System.out.println("Archivo creado correctamente");
			else
				System.out.println("Ocurrio algún problema");
			if (f2.createNewFile())
				System.out.println("Archivo creado correctamente");
			else
				System.out.println("Ocurrio algún problema");
				
			if(f2.exists())
				f2.renameTo(new File(directorio,"FicheritoNuevo.txt"));
			File ft= new File(directorio,"FicheritoNuevo.txt");
			if(f2.delete()&& ft.delete())
				System.out.println("se borro wey");
			else
				System.out.println("No se borro pendejo");
		}catch (IOException ioe) {
			ioe.printStackTrace();
		}catch (Exception e) {
			
		}

	}

}
