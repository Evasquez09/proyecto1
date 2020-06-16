package proyecto10;

public class Hilo implements Runnable{
	private String proceso;
	
	public Hilo(String proceso) {
		this.proceso = proceso;
	}

	public void run() {
		// TODO Auto-generated method stub
		while(true) {
			try {
				Thread.sleep(1000);
				System.out.println("Proceso " + proceso + " ejecutandose");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
