import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.jasperreports.*;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;


public class JasperReport {

    
    public static void main(String[] args) throws JRException, SQLException {
        Connection conection = null;
        try {

            Class.forName("com.mysql.jdbc.Driver");

             conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/empleados", "root",
                    "root");

            System.out.println("Conectado");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        
        String reportResource="./reports/Empleados.jrxml";
        
        String reportPDF="./reports/Listado.pdf";
        
       
        conection.close();

    }
}
