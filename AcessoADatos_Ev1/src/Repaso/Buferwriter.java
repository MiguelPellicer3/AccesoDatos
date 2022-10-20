package Repaso;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Buferwriter {

	public static void main(String[] args) {
		FileWriter fw;
		try {
			fw = new FileWriter("C:\\Users\\DAMDUALAlu7\\ficheroEscritura.txt");
			BufferedWriter bw= new BufferedWriter(fw);
			for (int i = 0; i < 10; i++) {
				bw.write("Estoy en la linea "+ (i+1));
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
