
public class Departamento {
	private int ID;
	private String nombre;
	
	public Departamento() {}
	public Departamento(int iD, String nombre) {
		super();
		ID = iD;
		this.nombre = nombre;
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


	@Override
	public String toString() {
		return "Depatamento [ID=" + ID + ", nombre=" + nombre + "]";
	}
	
	
}
