package Repaso;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class LecturayEscrituraBytes {

	public static void main(String[] args) {
		File fichero= new File("C:\\users\\DAMDUALAlu7\\fichero1.txt");
		try {
		FileOutputStream fos = new FileOutputStream(fichero);
		FileInputStream fis= new FileInputStream(fichero);
		int i;
		for (int j = 0; j < 100; j++) {
			fos.write(j);
		}
		while((i= fis.read())!=-1) {
			System.out.println(i);
		}
		fis.close();
		fos.close();
		}catch (Exception e){	
		}
	}

}
