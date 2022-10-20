package Repaso;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomCreate {

	public static void main(String[] args) throws IOException{
		// 
		File fichero = new File("Directorio/EmpleadosAleatorios.dat"); 
		//declara el fichero de acceso aleatorio
		RandomAccessFile file = new RandomAccessFile(fichero, "rw"); 
		
		// arrays con los datos
		String apellidos[] = {"FERNANDEZ", "GIL", "LOPEZ", "RAMOS", "SEVILLA", "CASILLA", "REY"}; 
		int departamentos[] = {10,20,10,10,30,30,20}; 
		double salarios[] = {1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0}; 

		StringBuffer buffer = null; // buffer para almacenar el apellido
		int n = apellidos.length; // nº de eltos del array
		
		// recorro los arrays 
		for (int i = 0;  i<n; i++) {
			file.writeInt(i+1); // i+1 para identificar al empleado
			buffer = new StringBuffer(apellidos[i]); 
			buffer.setLength(10); // 10 caracteres para el apellidos
			file.writeChars(buffer.toString()); // insertar apellido
			
			file.writeInt(departamentos[i]); 				// insertar departamento
			file.writeDouble(salarios[i]); 		// insertar salario
			
		}
		
		file.close(); // cerrar fichero 

	}
}
