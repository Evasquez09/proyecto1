package proyecto2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Leer{
	public static void main(String args[]) {
		leerArchivos leerArchivo = new leerArchivos();
		leerArchivo.leer();
	}
}

class leerArchivos {
	
	public void leer() {
		try {
			FileReader leer = new FileReader("C:\\Users\\Admin\\eclipse-workspace\\proyecto1\\ejemplo.txt");
			BufferedReader miBuffer = new BufferedReader(leer);
			try {
				//int c = 0;
				String linea = "";
				do {
					//c = leer.read();
					//char cc = (char) c;
					//System.out.print(cc);
					linea = miBuffer.readLine();
					if(linea!=null)
					System.out.println(linea);
				}while(linea != null);
				
				leer.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("No se ha podido leer el archivo");
			}
			}catch(FileNotFoundException e){
				System.out.println("Archivo no encontrado");
			}
	}
}