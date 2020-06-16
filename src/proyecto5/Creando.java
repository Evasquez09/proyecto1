package proyecto5;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Creando {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File directorioALeer = new File("C:"+File.separator+"Users"+File.separator+"Admin"+File.separator+"eclipse-workspace"+File.separator+"proyecto1"+File.separator+"NuevoArchivo.txt");
		//directorioALeer.mkdir();
		
		//try {
		//	directorioALeer.createNewFile();
		//} catch (IOException e) {
		//	e.printStackTrace();
		//}
		
		String archivoDestino = directorioALeer.getAbsolutePath();
		
		Escribiendo  accedeEs = new  Escribiendo();
		accedeEs.escribir(archivoDestino);
		
		
	}

}

class Escribiendo{
	public void escribir(String ruta) {
		
		String frase =  "Esto es un ejemplo";
		
		 
		try {
			FileWriter escritura = new FileWriter(ruta);
			for(int i = 0; i< frase.length(); i++) {
				escritura.write(frase.charAt(i));
			}
			escritura.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
