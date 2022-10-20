package Repaso;

import java.io.File;

public class Ficheros {

	public static void main(String[] args) {
		//System.out.println("Hola Mundo!");
		//System.out.println(System.getProperties());
		//System.out.println(System.getProperty("user.home"));
		File fichero1= new File("C:\\Users\\DAMDUALAlu7\\fichero1.txt");
		File fichero2= new File("C:\\Users\\DAMDUALAlu7","fichero1.txt");
		File dir= new File("C:\\Users\\DAMDUALAlu7");
		File fichero3= new File(dir,"fichero1.txt");
	
		if (fichero1.exists()&& fichero1.isFile()) {
			System.out.println("El fichero "+ fichero1+ " existe");
		}
		if (fichero2.exists()&& fichero2.isFile()) {
			System.out.printf("El fichero %s existe \n", fichero2);
		}
		if (fichero3.exists()&& fichero3.isFile()) {
			System.out.printf("El fichero %s existe %n", fichero3);
		}
	
		
		for ( File f : dir.listFiles()) {
			System.out.printf(f.getName());
			if(f.isFile()) {
				System.out.println(" es un archivo");
			}
			if(f.isDirectory()) {
				System.out.println(" es un directorio");
			}
		}
		
		File dir2= new File(".");
		for ( File f : dir2.listFiles()) {
			System.out.printf(f.getName());
			if(f.isFile()) {
				System.out.println(" es un archivo");
			}
			if(f.isDirectory()) {
				System.out.println(" es un directorio");
			}
		}
		System.out.printf("En el directorio %s hay %d objetos \n",dir2.getName(),dir2.length());
		for ( File f : dir2.listFiles()) {
			System.out.printf("El archivo %s -> ¿es directorio? %b ¿es fichero? %b \n"
					,f.getName(), f.isDirectory(),f.isFile());
		}
		
	}
}
