package Repaso;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EscrituraCaracteres {

	public static void main(String[] args) {
		File f= new File ("C:\\\\users\\\\DAMDUALAlu7\\\\ficheroEscritura.txt");
		if(!f.exists()) {
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		String cadena="Probando probando";
		char[] cad= cadena.toCharArray();
		//Escribir
		try {
			FileWriter fw= new FileWriter(f);
			fw.write(cad);
			fw.append("*");
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String prov[]= {"Cadiz","Huesca","Zaragoza","Teruel"};
		//Añadir
		try {
			FileWriter fw= new FileWriter(f);
			for (String string : prov) {
				for (char c : string.toCharArray()) {
					fw.append(c);
				} 
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
