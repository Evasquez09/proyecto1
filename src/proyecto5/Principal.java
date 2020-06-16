package proyecto5;

import java.io.File;

public class Principal {

	public static void main(String args[]) {
		
		File archivo = new File("bin");
		System.out.println(archivo.getAbsolutePath());
		System.out.println(archivo.exists());
		
	}
}
