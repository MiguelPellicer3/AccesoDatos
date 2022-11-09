package XmlXStream;


import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class Creacion_Opcion1 {

	public static void main(String[] args) {
		
		try {
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder= dbFactory.newDocumentBuilder();
			Document doc= dBuilder.newDocument();
			Element eRaiz=doc.createElement("Concesionario");
			Element coche=doc.createElement("Coche");
			Element marca= doc.createElement("Marca");
			Element modelo= doc.createElement("Modelo");
			Element cilindrada= doc.createElement("Cilindrada");
			
			coche.setAttribute("id","1");
			marca.setNodeValue("Renault");
			modelo.setNodeValue("Megane");
			cilindrada.setNodeValue("1.5");
			
			coche.appendChild(marca);
			coche.appendChild(modelo);
			coche.appendChild(cilindrada);
			eRaiz.appendChild(coche);
			doc.appendChild(eRaiz);
			
			TransformerFactory transformerFactory= TransformerFactory.newInstance();
			Transformer transformer= transformerFactory.newTransformer();
			DOMSource source= new DOMSource(doc);
			StreamResult result= new StreamResult(new File ("Directorio/concecionario.xml"));
			transformer.transform(source, result);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
