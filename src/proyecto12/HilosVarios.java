package proyecto12;

public class HilosVarios extends Thread{

	public HilosVarios() {
		// TODO Auto-generated constructor stub
	}
	
	public void run() {
		for(int i = 1 ; i <=5; i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getName());
			
		}
		
	}

}





class HilosVarios2 extends Thread{

	public HilosVarios2(Thread hilo) {
		this.hilo = hilo;
	}
	
	public void run() {
		
		try {
			hilo.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		for(int i = 1 ; i <=5; i++) {
			try {
				sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(this.getName());
			
		}
		
	}
	private Thread hilo;
}


