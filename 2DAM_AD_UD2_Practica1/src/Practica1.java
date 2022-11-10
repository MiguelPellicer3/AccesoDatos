import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Practica1 {

	public static void main(String[] args) {
		
		Connection c= Conexion.conectar();
		String[] opcionesPrincipales= {"1.Gestión empleados","2.Gestión Departamentos"};
		String[] opcionesEmpleado= {"1.Insertar Empleado","2.Modificar Empleado","3.Borrar Empleado","4.Lista todos los empleados",
				"5.Listar todos los empleados de un departamento","6.Consultar empleados por nif/dni","7.Consultar empleados que tengan un salario superior al introducido por el usuario"
				,"8.Consultar empleados que tengan un salario igual o inferior al introducido porel usuario"};
		String[] opcionesDepartamento= {"1.Insertar Departamento","2.Modificar Derpatamento","3.Eliminar Departamento","4.Listado Departamentos",
				"5.Seleccionar Departamento por ID","6.Seleccionar Departamento por Nombre"};
		
		System.out.println("--Elige una opcion--");
		for (int i = 0; i < opcionesPrincipales.length; i++) {
			System.out.println(opcionesPrincipales[i]);
		}
		Scanner s= new Scanner(System.in);
		int n=s.nextInt();
		if(n==1) {
			System.out.println("--Gestion de Empleados--");
			for (int i = 0; i < opcionesEmpleado.length; i++) {
				System.out.println(opcionesEmpleado[i]);
			}
			int e=s.nextInt();
			switch (e) {
				case 1:
					InsertarEmpleado(c);
				case 2:
					ModificarEmpleado(c);
				case 3:
					BorrarEmpleado(c);
				case 4:
					ListarEmpleados(c);
				case 5:
					ListarEmpleadosDepartamento(c);
				case 6:
					EmpleadoNif(c);
				case 7:
					ListaEmpleadosSueldoSuperior(c);
				case 8:
					ListaEmpleadosSueldoInferior(c);
				default:
					System.exit(0);
					
			}
		}
		else if(n==2) {
			System.out.println("--Gestión de Departamentos--");
			for (int i = 0; i < opcionesDepartamento.length; i++) {
				System.out.println(opcionesDepartamento[i]);
			}
			int d=s.nextInt();
			switch (d) {
			case 1:
				InsertarDepartamento(c);
			case 2:
				ModificarDepartamento(c);
			case 3:
				EliminarDepartamento(c);
			case 4:
				ListaDepartamentos(c);
			case 5:
				DepartamentoID(c);
			case 6:
				DepartamentoNombre(c);
			default:
				System.exit(0);
			}
		}
		
		
		s.close();
	}
	
	public static void InsertarEmpleado(Connection c) {
		Empleado e= new Empleado();
		Scanner s= new Scanner(System.in);
		System.out.println("Introduce los datos del empleado");
		System.out.println("Nombre:");
		e.setNombre(s.next());
		System.out.println("NIF:");
		e.setNif(s.next());
		System.out.println("Salario:");
		e.setSalario(s.nextDouble());
		System.out.println("Codigo Departamento:");
		e.setDpto(s.nextInt());
		try {
			String sql="insert into empleados (nombre,nif,salario,dpto) values(?,?,?,?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getNif());
			ps.setDouble(3, e.getSalario());
			ps.setInt(4, e.getDpto());
			int consulta=ps.executeUpdate();
			System.out.println(consulta+" "+e);
			ps.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		s.close();
	}
	public static void ModificarEmpleado(Connection c) {
		Empleado e= new Empleado();
		Scanner s= new Scanner(System.in);
		System.out.println("Introduce los datos del empleado");
		System.out.println("Nombre:");
		e.setNombre(s.next());
		System.out.println("NIF:");
		e.setNif(s.next());
		System.out.println("Salario:");
		e.setSalario(s.nextDouble());
		System.out.println("Codigo Departamento:");
		e.setDpto(s.nextInt());
		try {
			String sql="UPDATE empleados set nombre=?, nif=?, salario=?, dpto=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, e.getNombre());
			ps.setString(2, e.getNif());
			ps.setDouble(3, e.getSalario());
			ps.setInt(4, e.getDpto());
			int consulta=ps.executeUpdate();
			System.out.println(consulta+" "+e);
			ps.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		s.close();
	}
	public static void BorrarEmpleado(Connection c) {
		Scanner s= new Scanner(System.in);
		System.out.println("Introduce el id que quieres eliminar");
		int id= s.nextInt();
		
		try {
			String sql="Delete FROM empleados WHERE ID = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, id);
			int consulta=ps.executeUpdate();
			ps.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		s.close();
	}
	public static void ListarEmpleados(Connection c) {
		try {
			Empleado e=new Empleado();
			Statement s = c.createStatement();
			ResultSet resultado= s.executeQuery("SELECT * FROM empleados");
			while(resultado.next()) {
				e.setID(resultado.getInt(1));
				e.setNombre(resultado.getString(2));
				e.setNif( resultado.getString(3));
				e.setSalario(resultado.getDouble(4));
				e.setDpto(resultado.getInt(5));
				System.out.println(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void ListarEmpleadosDepartamento(Connection c) {
		try {
			Empleado e=new Empleado();
			Statement s = c.createStatement();
			ResultSet resultado= s.executeQuery("SELECT * FROM empleados WHERE dpto = ?");
			while(resultado.next()) {
				e.setID(resultado.getInt(1));
				e.setNombre(resultado.getString(2));
				e.setNif( resultado.getString(3));
				e.setSalario(resultado.getDouble(4));
				e.setDpto(resultado.getInt(5));
				System.out.println(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void EmpleadoNif(Connection c) {
		
	}
	public static void ListaEmpleadosSueldoSuperior(Connection c) {
		
	}
	public static void ListaEmpleadosSueldoInferior(Connection c) {
		
	}
	public static void InsertarDepartamento(Connection c) {
		
	}
	public static void ModificarDepartamento(Connection c) {
		
	}
	public static void EliminarDepartamento(Connection c) {
		
	}
	public static void ListaDepartamentos(Connection c) {
		
	}
	public static void DepartamentoID(Connection c) {
		
	}
	public static void DepartamentoNombre(Connection c) {
		
	}
	
	
}
