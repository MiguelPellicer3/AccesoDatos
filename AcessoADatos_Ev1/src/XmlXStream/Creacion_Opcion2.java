package XmlXStream;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

public class Creacion_Opcion2 {

	public static void main(String[] args) throws IOException {
		File f= new File("Directorio/EmpleadosAleatorios.dat");
		RandomAccessFile raf= new RandomAccessFile(f, "r");
		int id,departamento;
		double salario;
		String apellidos; 
		char apellido[] = new char[10], aux;
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();
			DOMImplementation implementacion=  dBuilder.getDOMImplementation();
			Document document= implementacion.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0");
			
			for(;;) {
				Element raiz= document.createElement("empleado");
				document.getDocumentElement().appendChild(raiz);
				
				id= raf.readInt();
				for (int i=0; i < apellido.length; i++) {
					aux = raf.readChar(); 
					apellido[i] = aux; // los voy guardando en el array
				}
				
				// convierto a string el array
				apellidos = new String(apellido); 
				departamento= raf.readInt();
				salario= raf.readDouble();
				System.out.println(id+" "+ apellidos+" "+ departamento+ " "+ salario);
				document.getDocumentElement().appendChild(raiz);
				CrearElemento("ID", Integer.toString(id),raiz,document);
				CrearElemento("Apellido", apellidos.trim(),raiz,document);
				CrearElemento("Departamento", Integer.toString(departamento),raiz,document);
				CrearElemento("Salario", Double.toString(salario),raiz,document);
				if(raf.getFilePointer()>= raf.length())break;
				
			}
			
			TransformerFactory transformerFactory= TransformerFactory.newInstance();
			Transformer transformer= transformerFactory.newTransformer();
			DOMSource source= new DOMSource(document);
			StreamResult result= new StreamResult(new File ("Directorio/empleados.xml"));
			transformer.transform(source, result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			raf.close();
		}

	}
	static void CrearElemento(String datoEmpleado,String valor,Element raiz,Document document) {
		Element elem= document.createElement(datoEmpleado);
		Text text= document.createTextNode(valor);
		raiz.appendChild(elem);
		elem.appendChild(text);
	}

}
