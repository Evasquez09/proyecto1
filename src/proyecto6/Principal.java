package proyecto6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class Principal {

	public static void main(String args[]) {
		
		Administrador jefe = new Administrador("Juan", 80000, 2005,12,15);
		jefe.setIncentivo(5000);
		
		ArrayList<Empleado> personal = new ArrayList<Empleado>();
		//personal.ensureCapacity(11);
		personal.add(jefe);
		personal.add(new Empleado("Ana", 25000, 2008, 10, 1));
		personal.add(new Empleado("Luis", 18000,2012,9,15));
		personal.add(new Empleado("Ana", 25000, 2008, 10, 1));
		personal.add(new Empleado("Luis", 18000,2012,9,15));
		personal.add(jefe);
		personal.add(new Empleado("Ana", 25000, 2008, 10, 1));
		personal.add(new Empleado("Luis", 18000,2012,9,15));
		personal.add(new Empleado("Ana", 25000, 2008, 10, 1));
		personal.add(new Empleado("Luis", 18000,2012,9,15));
		personal.add(new Empleado("Olga", 18000,2012,9,15));
		
		//personal.trimToSize();
		
	//	personal.indexOf(0);
		System.out.println(personal.size());
		/*Empleado[] personal = new Empleado[3];
		
		personal[0] = jefe;
		personal[1] = new Empleado("Ana", 25000, 2008, 10, 1);
		personal[2] = new Empleado("Luis", 18000,2012,9,15);
		*/
	//	for(Empleado e : personal) {
		//	System.out.println(e);
		//}
		
		Iterator<Empleado> miIterador = personal.iterator();
		
		while(miIterador.hasNext()) {
			System.out.println(miIterador.next().toString());
		}
		
	}
}

class Empleado implements Serializable{

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