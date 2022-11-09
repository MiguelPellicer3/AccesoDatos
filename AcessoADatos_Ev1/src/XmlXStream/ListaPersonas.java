package XmlXStream;

import java.util.ArrayList;

public class ListaPersonas {

	private ArrayList<Persona> lista;
	

	public ListaPersonas() {
		lista= new ArrayList<Persona>();
	}

	@Override
	public String toString() {
		return "ListaPersonas [lista=" + lista + "]";
	}

	public ArrayList<Persona> getLista() {
		return lista;
	}

	public void setLista(ArrayList<Persona> lista) {
		this.lista = lista;
	}
	
	
}
