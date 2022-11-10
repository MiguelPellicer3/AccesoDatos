import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

	private static final String CONTROLADOR="com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/practica1";
	private static final String USUARIO = "usuario";
	private static final String PASSWORD = "usuario";
	
	public static Connection conectar() {
		Connection conexion= null;
			try {
				Class.forName(CONTROLADOR);
				conexion= DriverManager.getConnection(URL,USUARIO,PASSWORD);
				System.out.println("Conexion OK");
			} catch (SQLException e) {
				System.out.println("Error en la conexion");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("Error al cargar el controlador");
				e.printStackTrace();
			}	
		return conexion;
	}
}
