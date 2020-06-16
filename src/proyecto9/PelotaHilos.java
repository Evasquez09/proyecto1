package proyecto9;

import java.awt.Component;

public class PelotaHilos implements Runnable{

	private Component componente;
	Pelota pelota;
	
	public PelotaHilos(Pelota unaPelota, Component unComponente) {
		
		pelota = unaPelota;
		componente = unComponente;
		
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//for(int i = 1; i<=1000000000 ; i++)
		while(!Thread.currentThread().isInterrupted()){
			
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Conteo no pudo continuar");
			}
			
			pelota.muevePelota(componente.getBounds());
			componente.repaint();
		}

	}

}
