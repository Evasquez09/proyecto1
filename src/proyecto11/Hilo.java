package proyecto11;

public class Hilo implements Runnable{
	public Hilo(LaminaSuperior laminaSuperior,Pelota pelota) {
		this.laminaSuperior = laminaSuperior;
		this.pelota = pelota;
	}

	public void run() {
		while(!Thread.currentThread().isInterrupted()){
			try {
				Thread.sleep(3);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			pelota.moverPelota(laminaSuperior.getBounds());
			laminaSuperior.repaint();
		}
	}
	
	LaminaSuperior laminaSuperior;
	Pelota pelota;
}