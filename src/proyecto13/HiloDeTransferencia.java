package proyecto13;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class HiloDeTransferencia extends Thread {

	public HiloDeTransferencia(BigDecimal[] IndicesMontosCuentas) {
		this.IndicesMontosCuentas = IndicesMontosCuentas;
		
	}
	
	
	public void run() {
		
		for(int i = 0; i <10000;i++) {
			
			
			preMonto = Math.round((Math.random()*2000) * 100) / 100d;	
			cuentaOrigen = (int)Math.round(Math.random()*100);
			cuentaDestino = (int)Math.round(Math.random()*100);
			value = new BigDecimal(preMonto);
			//value.setScale(2, RoundingMode.CEILING);
			
			procesarTransferencia(cuentaOrigen,cuentaDestino,value.setScale(2, RoundingMode.CEILING));
			for(BigDecimal a : IndicesMontosCuentas)
			{
				montoGlobal = montoGlobal.add(a);
			}
			System.out.println(montoGlobal);
			montoGlobal = new BigDecimal(0);
		}
		
	}
	
private void procesarTransferencia(int cuentaOrigen,int cuentaDestino,BigDecimal monto) {
		
		if(validarTransferencia(cuentaOrigen,monto)){
			System.out.println("------------------------------------------------");
			System.out.println(IndicesMontosCuentas[cuentaOrigen]);
			System.out.println(IndicesMontosCuentas[cuentaDestino]);
			System.out.println(monto);
			
			IndicesMontosCuentas[cuentaOrigen] = IndicesMontosCuentas[cuentaOrigen].subtract(monto);
			IndicesMontosCuentas[cuentaDestino] = IndicesMontosCuentas[cuentaDestino].add(monto);
			
			System.out.println(IndicesMontosCuentas[cuentaOrigen]);
			System.out.println(IndicesMontosCuentas[cuentaDestino]);
			System.out.println(monto);
			System.out.println("------------------------------------------------");
			
		}else {
			System.out.println("Cuenta encontrada con saldo insuficiente");
		}
		
		
	}

private boolean validarTransferencia(int cuentaOrigen, BigDecimal monto) {
	
	comparacionBigDecimal = IndicesMontosCuentas[cuentaOrigen].compareTo(monto);
			
	if(comparacionBigDecimal == 1) {
		return true;
	}else {
		return false;
	}		
}


	
	private BigDecimal[] IndicesMontosCuentas = new BigDecimal[101];
	private int comparacionBigDecimal;
	double preMonto;
	int cuentaOrigen,cuentaDestino;
	BigDecimal value;
	BigDecimal montoGlobal = new BigDecimal(0);
	
	
}

