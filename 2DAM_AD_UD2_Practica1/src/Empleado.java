
public class Empleado {
	private int ID;
	private String nombre;
	private String nif;
	private double Salario;
	private int dpto;
	public Empleado() {}
	public Empleado(int iD, String nombre, String nif, double salario, int dpto) {
		super();
		ID = iD;
		this.nombre = nombre;
		this.nif = nif;
		Salario = salario;
		this.dpto = dpto;
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNif() {
		return nif;
	}
	public void setNif(String nif) {
		this.nif = nif;
	}
	public double getSalario() {
		return Salario;
	}
	public void setSalario(double salario) {
		Salario = salario;
	}
	public int getDpto() {
		return dpto;
	}
	public void setDpto(int dpto) {
		this.dpto = dpto;
	}
	@Override
	public String toString() {
		return "Empleado [ID=" + ID + ", nombre=" + nombre + ", nif=" + nif + ", Salario=" + Salario + ", dpto=" + dpto
				+ "]";
	}
	
	
}
