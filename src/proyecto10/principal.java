package proyecto10;

public class principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread hilo1 = new Thread(new Hilo("a"));
		Thread hilo2 = new Thread(new Hilo("b"));
		
		hilo1.start();
		hilo2.start();
	}

}
