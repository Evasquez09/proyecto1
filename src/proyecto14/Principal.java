package proyecto14;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Principal {

	public static void main(String[] args) {
		
		Banco b = new Banco();
		
		for(int i = 0 ; i < 100 ; i++)
		{
			EjecucionTransferencias r  = new EjecucionTransferencias(b,i,2000);
			Thread t = new Thread(r);
			t.start();
			
		}
	}

}



class Banco {

	public Banco() {
		
		cuentas = new double[100];
		
		for(int i = 0; i<cuentas.length; i ++) {
			
			cuentas[i] = 2000;
		}
		
		//saldoSuficiente = ciereBanco.newCondition();
		
	}
	
	public synchronized void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad) throws InterruptedException {
		
		
		
		//ciereBanco.lock();
		
	//	try {
		
		while(cuentas[cuentaOrigen] < cantidad) {
			//return;
			
			//try {
				//saldoSuficiente.await();
			//} catch (InterruptedException e) {
				// TODO Auto-generated catch block
			//	e.printStackTrace();
			//}
			wait();
		}
		
		System.out.println(Thread.currentThread());
		
		cuentas[cuentaOrigen]-= cantidad;
		
		System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen,cuentaDestino);
		
		cuentas[cuentaDestino]+= cantidad;
		
		System.out.printf("Saldo total: %10.2f %n",getSaldoTotal());
		
		notifyAll();
		//saldoSuficiente.signalAll();
	//	}
		
	}
	
	public double getSaldoTotal() {
		double sumaCuentas = 0;
		for(double a : cuentas) {
			sumaCuentas+=a;
		}
		return sumaCuentas;
	}
	
	private final double cuentas[];
	//private Lock ciereBanco = new ReentrantLock ();
	//private Condition saldoSuficiente;
	

}

class EjecucionTransferencias implements Runnable{
	
	public EjecucionTransferencias(Banco b, int de, double max) {
		banco = b;
		deLaCuenta = de;
		cantidadMax = max;
	}
	
	public void run() {
		
		while(true) {
			int paraLaCuenta =(int) (Math.random() * 100);
			double cantidad = cantidadMax * Math.random();
			try {
				banco.transferencia(deLaCuenta, paraLaCuenta, cantidad);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				Thread.sleep((int)Math.random()*10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
	private Banco banco;
	private int deLaCuenta;
	private double cantidadMax;
}