package modelo;
// Generated 1 dic 2022 17:53:55 by Hibernate Tools 4.3.6.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Departamentos generated by hbm2java
 */
public class Departamentos implements java.io.Serializable {

	private int dptoNo;
	private String dnombre;
	private String loc;
	private Set<Empleados> empleadoses = new HashSet<Empleados>(0);

	public Departamentos() {
	}

	public Departamentos(int dptoNo) {
		this.dptoNo = dptoNo;
	}

	public Departamentos(int dptoNo, String dnombre, String loc, Set<Empleados> empleadoses) {
		this.dptoNo = dptoNo;
		this.dnombre = dnombre;
		this.loc = loc;
		this.empleadoses = empleadoses;
	}

	public int getDptoNo() {
		return this.dptoNo;
	}

	public void setDptoNo(int dptoNo) {
		this.dptoNo = dptoNo;
	}

	public String getDnombre() {
		return this.dnombre;
	}

	public void setDnombre(String dnombre) {
		this.dnombre = dnombre;
	}

	public String getLoc() {
		return this.loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public Set<Empleados> getEmpleadoses() {
		return this.empleadoses;
	}

	public void setEmpleadoses(Set<Empleados> empleadoses) {
		this.empleadoses = empleadoses;
	}

	@Override
	public String toString() {
		String empleados = "";
		for (Empleados emp : empleadoses) {
			empleados += emp + "\n\t" ;
		}
		return "Departamento " + dptoNo + ", Nombre=" + dnombre + ", Localidad=" + loc;
	}

}
