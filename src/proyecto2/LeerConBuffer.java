package proyecto2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeerConBuffer {
	public LeerConBuffer() {
		try {
			FileReader archivoLeido = new FileReader("C:\\Users\\Admin\\eclipse-workspace\\proyecto1\\ejemplo.txt");
			BufferedReader bufferDeLectura = new BufferedReader(archivoLeido);
			String linea = "";
			while(linea != null) {
				linea = bufferDeLectura.readLine();
				System.out.println((linea !=null) ? linea : "");
			}
			bufferDeLectura.close();
			archivoLeido.close();
		}catch(IOException e) {
			System.out.println("Archivo no encontrado");
		}
	}
}