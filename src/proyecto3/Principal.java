package proyecto3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

class Principal{
	public static void main(String[] args) {
		new LeerArchivo();
	}
}

class LeerArchivo{
	public LeerArchivo() {
		boolean validador = true;
		int contador = 0;
		int[] arreglo = new int[36000];
		try {
			FileInputStream archivoLeido = new  FileInputStream("C:\\Users\\Admin\\Desktop\\Nueva carpeta\\imagen.jpg");
			FileOutputStream archivoEscrito = new  FileOutputStream("C:\\Users\\Admin\\Desktop\\Nueva carpeta\\imagen2.jpg");
			try {
				int a = 0;
				while (validador) {
					
					a = archivoLeido.read();
					
					if(a != -1) {
						System.out.println(a);
						arreglo[contador] = a;
						archivoEscrito.write(arreglo[contador]);
						contador++;
					}else {
						validador = false;
					}
			
				}
				System.out.println(contador);
				//System.out.println(arreglo.length);
				archivoLeido.close();
				archivoEscrito.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Archivo origen no pudo ser interpretado");
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Archivo origen no pudo ser leido");
		}
		
	}
}