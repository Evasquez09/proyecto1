package proyecto12;

public class Principal {

	public static void main(String args[]) {

		HilosVarios hilo1 = new HilosVarios(),hilo2 = new HilosVarios(),hilo3 = new HilosVarios();
		HilosVarios2 hiloV2 = new HilosVarios2(hilo1);
		
		hiloV2.start();
		hilo1.start();


		
		

	}

}
