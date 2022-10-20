package Repaso;

import java.io.File;

public class Clase01 {

	public static void main(String[] args) {
		File actual= new File("C:\\Users\\DAMDUALAlu7\\eclipse-workspace\\HolaMundo\\src\\varios\\Clase01.java");

		System.out.printf("El fichero %s ¿Existe? %b ¿Es fichero? %b ¿Es directorio? %b ¿Se pude ejecutar? %b "
				+ "¿Se pude leer? %b \nPath absoluto %s \nPertenece a %s",
				actual.getName(),actual.exists(),actual.isFile(),actual.isDirectory(),actual.canExecute(),actual.canRead(),
				actual.getAbsolutePath(),actual.getParent());
	}

}
