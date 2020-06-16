package proyecto4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.GregorianCalendar;

public class Principal {

	public static void main(String args[]) {
		
		Administrador jefe = new Administrador("Juan", 80000, 2005,12,15);
		jefe.setIncentivo(5000);
		
		Empleado[] personal = new Empleado[3];
		
		personal[0] = jefe;
		personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
		personal[2] = new Empleado("Luis", 18000,2012,9,15);
		
		try {
			ObjectOutputStream escribiendo = new ObjectOutputStream(new FileOutputStream("C:\\Users\\Admin\\eclipse-workspace\\proyecto1\\empleado.txt"));
			escribiendo.writeObject(personal);
			escribiendo.close();
			ObjectInputStream recuperandoFichero = new ObjectInputStream(new FileInputStream("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\proyecto1\\\\empleado.txt"));
			
			try {
				Empleado[] personalRecuperado = (Empleado[]) recuperandoFichero.readObject();
				recuperandoFichero.close();
				
				for(Empleado e: personalRecuperado)
				{
					System.out.println(e);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			recuperandoFichero.read();
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class Empleado implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Empleado( String n, double s, int agno,int mes, int dia) {
		
		nombre = n;
		sueldo	 = s;
		GregorianCalendar calendario = new GregorianCalendar(agno,mes-1,dia);
		fechaContratos = calendario.getTime();
		
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public double getSueldo() {
		return sueldo;
	}
	
	public Date getFechaContrato() {
		return fechaContratos;
	}
	
	public void subirSueldo(double porcentaje) {
		
		double aumento = sueldo*porcentaje/100;
		
		sueldo+=aumento;
	}
	
	public String toString() {
		return "Nombre: " + nombre +". Sueldo: " + sueldo + ". Fecha de contrato: " + fechaContratos;
	}
	
	private String nombre;
	private double sueldo;
	private Date fechaContratos;	
}

class Administrador extends Empleado{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Administrador(String n, double s, int agno,int mes, int dia) {
		super(n,s,agno,mes,dia);
		incentivo = 0;
		
	}
	
	public double getSueldo() {
		double sueldoBase = super.getSueldo();
		return sueldoBase+incentivo;
	}
	
	public void setIncentivo(double b) {
		incentivo = b;
	}
	
	public String toString() {
		return super.toString() + ". Incentivo: " + incentivo;
	}
	double incentivo;
	
}