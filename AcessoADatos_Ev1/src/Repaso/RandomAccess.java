package Repaso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccess {
	
		
	public static void main(String[] args) {
		EscribirRandom();
		LeerRandom();
	}
	
	public static void EscribirRandom() {
		
		String apellido[]= {"FERNANDEZ","GIL","LOPEZ","RAMOS","SEVILLA","CASILLA","REY"};
		int departamento[]= {10,20,10,10,10,30,30,20};
		double salarios[]= {1000.45,2400.60,3000.0,1500.56,2200.0,1435.87,2000.0};
		File f;
		StringBuffer buffer=null;
		int numObjetos= apellido.length;
		
		try {
			f= new File("C:\\Users\\DAMDUALAlu7\\ficheroRandom.dat");
			RandomAccessFile raf;
			raf= new RandomAccessFile(f, "rw");
			for (int i = 0; i < numObjetos; i++) {
				raf.writeInt(i+1);
				buffer= new StringBuffer(apellido[i]);
				buffer.setLength(10);
				raf.writeChars(buffer.toString());
				raf.writeInt(departamento[i]);
				raf.writeDouble(salarios[i]);				
			}
			raf.close();
		}catch(FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void LeerRandom() {
		File f;
		RandomAccessFile rauf;
		System.out.printf("Id	Apellido	Dto	Salario	%n");
		try {
			 f=new File("C:\\Users\\DAMDUALAlu7\\ficheroRandom.dat");
			 rauf=new RandomAccessFile(f, "r");
			int id,departamento,posicion=0;
			double salario;
			char c[]= new char[10];
			for (;;) {
				rauf.seek(posicion);
				 id=rauf.readInt(); 
				 for (int j = 0; j < 10; j++) {
					 c[j]=rauf.readChar();
				}
				
				departamento= rauf.readInt();
				salario= rauf.readDouble();
				if(id>0) {
				System.out.printf("%d	%s	%d	%.2f	%n",id,c,departamento,salario);
				}
				posicion+=36;
				c= new char[20];
				if(rauf.getFilePointer()== rauf.length())break;
			}
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
