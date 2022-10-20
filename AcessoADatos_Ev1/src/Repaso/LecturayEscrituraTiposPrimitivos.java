package Repaso;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class LecturayEscrituraTiposPrimitivos {

	public static void main(String[] args) {
		File fichero= new File("C:\\users\\DAMDUALAlu7\\fichero1.txt");
		try {
			FileOutputStream fos = new FileOutputStream(fichero);
			FileInputStream fis= new FileInputStream(fichero);
			DataInputStream dis= new DataInputStream(fis);
			DataOutputStream dos= new DataOutputStream(fos);
			
			String[] nombres= {"Ana","Luis Miguel","Alicia","Pedro","Pedro","Manuel","Andres","Julio","Antonio","Maria Jesus"};
			int[] edades= {14,15,13,15,16,12,16,14,13};
			
			for (int i = 0; i < edades.length; i++) {
				dos.writeUTF(nombres[i]);
				dos.writeInt(edades[i]);
			}
			String nombre;
			int edad;
			while(dis.available()>0) {
				nombre= dis.readUTF();
				edad= dis.readInt();
				System.out.printf("Nombre: %s Edad: %d\n", nombre,edad );
			}      
			
			fis.close();
			fos.close();
			dis.close();
			dos.close();
			} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
