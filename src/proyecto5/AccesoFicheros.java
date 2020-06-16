package proyecto5;

import java.io.File;

public class AccesoFicheros {

	public static void main(String args[])
	{
		
		File directorioALeer = new File("C:"+File.separator+"Users"+File.separator+"Admin"+File.separator+"eclipse-workspace"+File.separator+"proyecto1");
		
		String[] listado = directorioALeer.list();
		
		for(String e : listado) {
			System.out.println(e);
			
			File subDirectorios = new File(directorioALeer.getPath(),e);
			
			if(subDirectorios.isDirectory()) {
				String[] subListado = subDirectorios.list();
				for(String g:subListado)
				System.out.println("  -" + g);
			}
			
		}
		
	}
	
	
}
