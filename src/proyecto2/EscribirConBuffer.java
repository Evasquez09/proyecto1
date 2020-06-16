package proyecto2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EscribirConBuffer {
	public EscribirConBuffer() {
		
		
		try(FileWriter fw = new FileWriter("C:\\Users\\Admin\\eclipse-workspace\\proyecto1\\ejemplo.txt", true);
			    BufferedWriter bw = new BufferedWriter(fw);
			    PrintWriter out = new PrintWriter(bw))
			    {
			        out.println("the text");
			        //more code
			        out.println("more text");
			        //more code
			} catch (IOException e) {
			    //exception handling left as an exercise for the reader
			}		
	}	
}