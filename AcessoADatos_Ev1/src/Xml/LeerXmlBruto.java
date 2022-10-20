package Xml;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;


public class LeerXmlBruto {

	public static void main(String[] args) {
		File file= new File("src/Xml/pokemon2.xml");
			DocumentBuilderFactory dbFactory=DocumentBuilderFactory.newInstance();
			try {
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc= dBuilder.parse(file);
				doc.getDocumentElement().normalize();
				NodeList pokedex= doc.getElementsByTagName("pokemon");
				for (int i = 0; i < pokedex.getLength(); i++) {
					Node pokemon= pokedex.item(i);
					if(pokemon.getNodeType()== Node.ELEMENT_NODE) {
						Element element=(Element) pokemon;
						System.out.println("Nombre: "+ element.getElementsByTagName("nombre").item(0).getTextContent());
						if(element.getElementsByTagName("tipo").getLength()>1) {
							System.out.println("Tipo: "+ element.getElementsByTagName("tipo").item(0).getTextContent());
							System.out.println("Tipo: "+ element.getElementsByTagName("tipo").item(1).getTextContent());
						}else {
							System.out.println("Tipo: "+ element.getElementsByTagName("tipo").item(0).getTextContent());
						}
						if(element.getElementsByTagName("ataque").getLength()>1) {
							
							Element ataque1= (Element) element.getElementsByTagName("ataque").item(0);
							Element ataque2= (Element) element.getElementsByTagName("ataque").item(1);
							
							if(ataque1.getNodeType()==Node.ELEMENT_NODE&&ataque2.getNodeType()==Node.ELEMENT_NODE) {
								Element atq1= (Element) ataque1; Element atq2=(Element) ataque2;
								System.out.println("Ataque 1: "+ atq1.getElementsByTagName("a_nombre").item(0).getTextContent()
										+ " potencia "+ atq1.getElementsByTagName("potencia").item(0).getTextContent());
								System.out.println("Ataque 2: "+ atq2.getElementsByTagName("a_nombre").item(0).getTextContent()
										+ " potencia "+ atq2.getElementsByTagName("potencia").item(0).getTextContent());
							}
							
						}
						else {
							Element ataque= (Element) element.getElementsByTagName("ataque").item(0);
							System.out.println("Ataque :"+ ataque.getElementsByTagName("a_nombre").item(0).getTextContent() 
									+ " potencia: "+ ataque.getElementsByTagName("potencia").item(0).getTextContent());
						}
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
