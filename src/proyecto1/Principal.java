package proyecto1;

public class Principal {
	public static void main(String args[]) {

		Suma opracionSumar = new Suma();
		Resta opracionRestar = new Resta();
		Multiplica opracionMultiplicar = new Multiplica();
		Divide opracionDividir = new Divide();
		
		System.out.println(opracionSumar.calcula(8,8));
		System.out.println(opracionRestar.calcula(8,8));
		System.out.println(opracionMultiplicar.calcula(8,8));
		System.out.println(opracionDividir.calcula(8,8));
	}
}