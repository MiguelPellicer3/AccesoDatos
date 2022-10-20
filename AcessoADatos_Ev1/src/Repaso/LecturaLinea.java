package Repaso;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class LecturaLinea {

	public static void main(String[] args) {
		try {
			File file= new File("C:\\Users\\DAMDUALAlu7\\ficheroEscritura.txt");
			BufferedReader br= new BufferedReader(new FileReader(file));
			String line;
			while((line= br.readLine())!=null) {
				System.out.println(line);
			}
			br.close();
		}catch(Exception e){
			
		}
	}

}
