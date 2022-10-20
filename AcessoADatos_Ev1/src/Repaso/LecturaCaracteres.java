package Repaso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LecturaCaracteres {

	public static void main(String[] args) {
		File fichero1= new File("C:\\users\\DAMDUALAlu7\\fichero1.txt");
		//Lectura de un fichero caracter a caracter
		try {
			FileReader fr= new FileReader(fichero1);			
			int valor = fr.read();
			while(valor!=-1) {
				
				System.out.println((char)valor);
				valor=fr.read();
			}
			fr.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("\n");
		
		//Lectura de un fichero de 2 en 2 carácteres
		try {
			FileReader fr= new FileReader(fichero1);
			char[] b = new char[2];
			while((fr.read(b))!=-1) {
				System.out.println(b);
			}
			fr.close();
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}