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
		if(n==1) 
		{
			System.out.println();
			System.out.println("--Gestion de Empleados--");
			for (int i = 0; i < opcionesEmpleado.length; i++) {
				System.out.println(opcionesEmpleado[i]);
			}
			int e=s.nextInt();
			switch (e) {
				case 1:
					InsertarEmpleado(c);
					break;
				case 2:
					ModificarEmpleado(c);
					break;
				case 3:
					BorrarEmpleado(c);
					break;
				case 4:
					ListarEmpleados(c);
					break;
				case 5:
					ListarEmpleadosDepartamento(c);
					break;
				case 6:
					EmpleadoNif(c);
					break;
				case 7:
					ListaEmpleadosSueldoSuperior(c);
					break;
				case 8:
					ListaEmpleadosSueldoInferior(c);
					break;
				default:
					System.out.println("Has salido");
					System.exit(0);
				
				
			}
		}
		else if(n==2) 
		{			
			System.out.println();
			System.out.println("--Gestión de Departamentos--");
			for (int i = 0; i < opcionesDepartamento.length; i++) {
				System.out.println(opcionesDepartamento[i]);
			}
			int d=s.nextInt();
			switch (d) {
			case 1:
				InsertarDepartamento(c);
				break;
			case 2:
				ModificarDepartamento(c);
				break;
			case 3:
				EliminarDepartamento(c);
				break;
			case 4:
				ListaDepartamentos(c);
				break;
			case 5:
				DepartamentoID(c);
				break;
			case 6:
				DepartamentoNombre(c);
				break;
			default:
				System.out.println("Has salido");
				System.exit(0);
			}		
		}
		
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
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
		System.out.println("Introduce el nombre del empleado a modificar");
		String nombre= s.next();
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
			PreparedStatement ps1= c.prepareStatement("select id from empleados where nombre = ? ");
			ps1.setString(1,nombre);
			ResultSet rs= ps1.executeQuery();
			if(rs.next()) {
				int id = rs.getInt(1);
				String sql="UPDATE empleados set nombre=?, nif=?, salario=?, dpto=? where nombre = ?";
				PreparedStatement ps = c.prepareStatement(sql);
				ps.setString(1, e.getNombre());
				ps.setString(2, e.getNif());
				ps.setDouble(3, e.getSalario());
				ps.setInt(4, e.getDpto());
				ps.setInt(5, id);
				int consulta=ps.executeUpdate();
				System.out.println(consulta+" "+e);
				ps.close();
			}
			ps1.close();
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
			if(consulta>0) {
				System.out.println("Empleado borrado correctamente");
			}
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
			e.printStackTrace();
		}
	}
	public static void ListarEmpleadosDepartamento(Connection c) {
		Scanner s= new Scanner(System.in);
		System.out.println("Introduce el id de depatamento");
		int dpto=s.nextInt();
		try {
			Empleado e=new Empleado();
			PreparedStatement ps = c.prepareStatement("SELECT * FROM empleados WHERE dpto = ?");
			ps.setInt(1, dpto);
			ResultSet resultado= ps.executeQuery();
			while(resultado.next()) {
				e.setID(resultado.getInt(1));
				e.setNombre(resultado.getString(2));
				e.setNif( resultado.getString(3));
				e.setSalario(resultado.getDouble(4));
				e.setDpto(resultado.getInt(5));
				System.out.println(e);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		s.close();
	}
	public static void EmpleadoNif(Connection c) {
		Empleado e= new Empleado();
		Scanner s= new Scanner(System.in);
		System.out.println("Introduce el nif del empleado");
		String dni= s.next();
		
		try {
			PreparedStatement ps1= c.prepareStatement("select id from empleados where nif = ? ");
			ps1.setString(1,dni);
			ResultSet rs= ps1.executeQuery();
			if(rs.next()) {
				e.setID(rs.getInt(1));
				e.setNombre(rs.getString(2));
				e.setNif( rs.getString(3));
				e.setSalario(rs.getDouble(4));
				e.setDpto(rs.getInt(5));
				System.out.println(e);
			}
			ps1.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		s.close();
	}
	public static void ListaEmpleadosSueldoSuperior(Connection c) {
		System.out.println("Introduce el sueldo");
		Scanner scan= new Scanner(System.in);
		scan.nextDouble();
		try {
			Empleado e=new Empleado();
			Statement s = c.createStatement();
			ResultSet resultado= s.executeQuery("SELECT * FROM empleados WHERE sueldo > ?");
			while(resultado.next()) {
				e.setID(resultado.getInt(1));
				e.setNombre(resultado.getString(2));
				e.setNif( resultado.getString(3));
				e.setSalario(resultado.getDouble(4));
				e.setDpto(resultado.getInt(5));
				System.out.println(e);
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scan.close();
	}
	public static void ListaEmpleadosSueldoInferior(Connection c) {
		System.out.println("Introduce el sueldo");
		Scanner scan= new Scanner(System.in);
		scan.nextDouble();
		try {
			Empleado e=new Empleado();
			Statement s = c.createStatement();
			ResultSet resultado= s.executeQuery("SELECT * FROM empleados WHERE sueldo < ?");
			while(resultado.next()) {
				e.setID(resultado.getInt(1));
				e.setNombre(resultado.getString(2));
				e.setNif( resultado.getString(3));
				e.setSalario(resultado.getDouble(4));
				e.setDpto(resultado.getInt(5));
				System.out.println(e);
			}
			s.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		scan.close();
	}
	public static void InsertarDepartamento(Connection c) {
		Departamento d= new Departamento();
		Scanner s= new Scanner(System.in);
		System.out.println("Introduce los datos del departamento");
		System.out.println("Nombre:");
		d.setNombre(s.next());
		try {
			String sql="insert into departamentos (nombre) values(?)";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, d.getNombre());
			ps.execute();
			System.out.println(d);
			ps.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		s.close();
	}
	public static void ModificarDepartamento(Connection c) {
		Departamento d= new Departamento();
		Scanner s= new Scanner(System.in);
		System.out.println("Introduce el nombre del departamento que quieres modificar");
		d.setNombre(s.next());
		System.out.println("Introduce el nuevo nombre:");
		String nombre = s.next();
		try {
			String sql="UPDATE departamentos set nombre=? where nombre=?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, nombre);
			ps.setString(2, d.getNombre());
			ps.execute();
			System.out.println(d);
			ps.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		s.close();
	}
	public static void EliminarDepartamento(Connection c) {
		Departamento d= new Departamento();
		Scanner s= new Scanner(System.in);
		System.out.println("Introduce los datos del departamento");
		System.out.println("Nombre:");
		d.setNombre(s.next());
		try {
			String sql="DELETE from departamento where nombre = ?";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, d.getNombre());
			ps.execute();
			System.out.println(d);
			ps.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		s.close();
	}
	public static void ListaDepartamentos(Connection c) {
		try {
			Departamento d=new Departamento();
			Statement s = c.createStatement();
			ResultSet resultado= s.executeQuery("SELECT * FROM departamentos");
			while(resultado.next()) {
				d.setID(resultado.getInt(1));
				d.setNombre(resultado.getString(2));
				System.out.println(d);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void DepartamentoID(Connection c) {
		Departamento d= new Departamento();
		Scanner s= new Scanner(System.in);
		System.out.println("Introduce el id del departamento");
		int id= s.nextInt();
		
		try {
			PreparedStatement ps1= c.prepareStatement("select id from departamento where id = ? ");
			ps1.setInt(1,id);
			ResultSet rs= ps1.executeQuery();
			if(rs.next()) {
				d.setID(rs.getInt(1));
				d.setNombre(rs.getString(2));
				System.out.println(d);
			}
			ps1.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		s.close();
	}
	public static void DepartamentoNombre(Connection c) {
		Departamento d= new Departamento();
		Scanner s= new Scanner(System.in);
		System.out.println("Introduce el nombre del departamento");
		String id= s.next();
		
		try {
			PreparedStatement ps1= c.prepareStatement("select id from departamento where nombre = ? ");
			ps1.setString(1,id);
			ResultSet rs= ps1.executeQuery();
			if(rs.next()) {
				d.setID(rs.getInt(1));
				d.setNombre(rs.getString(2));
				System.out.println(d);
			}
			ps1.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		s.close();
	}
	
	
}
