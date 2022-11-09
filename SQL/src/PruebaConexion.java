import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;



public class PruebaConexion {

	public static void main(String[] args) {
		
		try {
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection conexion= DriverManager.getConnection("jdbc:mysql://localhost:3306/consulta","usuario","usuario");
			//System.out.println("Conectado");
			
			Connection conexion= Conexion.conectar();
			
			Statement sentencia= (Statement) conexion.createStatement();
			String sql= "SELECT * FROM usuario";
			ResultSet resul= sentencia.executeQuery(sql);
			
			while(resul.next()) {
				int idUusario= resul.getInt(1);
				String usuario= resul.getString(2);
				String clave= resul.getString(3);
				
				System.out.println(idUusario+" - "+usuario+ " - "+ clave);
			}
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
