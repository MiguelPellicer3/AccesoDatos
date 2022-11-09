package XmlXStream;

//Miguel Pellicer Cerezuela 13/10/2022

import javax.xml.parsers.*;
//import javax.xml.transform.*;
//import javax.xml.transform.dom.*;
//import javax.xml.transform.stream.*;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.*;

public class LeerXml {

	public static void main(String[] args) {
		File file= new File("src/Xml/pokemon2.xml");
		DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
		try {
			//Recupero el Documento normalizado
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc= dBuilder.parse(file);
			doc.getDocumentElement().normalize();
			//Consigo el nodelist
			NodeList pokedex= doc.getElementsByTagName("pokemon");
			//Recorro todos los pokemons
			for (int i = 0; i < pokedex.getLength(); i++) {
				Node pokemon= pokedex.item(i);
				if(pokemon.getNodeType()== Node.ELEMENT_NODE) {
					Element element=(Element) pokemon;
					//Recupero el Nombre
					System.out.println("Nombre: "+ element.getElementsByTagName("nombre").item(0).getTextContent());
					//Recorro todos los tipos y los printo
					for (int j = 0; j < element.getElementsByTagName("tipo").getLength(); j++) {
						System.out.println("Tipo: "+ element.getElementsByTagName("tipo").item(j).getTextContent());
					}
					//Recorro todos los ataques y los printo
					for (int j = 0; j < element.getElementsByTagName("ataque").getLength(); j++) {
						Element ataque= (Element) element.getElementsByTagName("ataque").item(j);
						System.out.println("Ataque: "+ ataque.getElementsByTagName("a_nombre").item(0).getTextContent()
								+"\t"+ ataque.getElementsByTagName("potencia").item(0).getTextContent()+" de potencia");
					}
					//Resto de atriburtos
					System.out.println("Poder de Combate: "+element.getElementsByTagName("pc").item(0).getTextContent());
					System.out.println("Capturado el año: "+element.getAttribute("f_captura"));
					System.out.println();
				}
			}
		}catch (SAXException | IOException e) {
				e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
	}

}
