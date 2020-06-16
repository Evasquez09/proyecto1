package proyecto13;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Banco {	

	public Banco() {
		
		cargarCuentas();
		
		
		HiloDeTransferencia hilo = new HiloDeTransferencia(IndicesMontosCuentas);
		hilo.run();
		
		
		
		
		
		
		
	}
	

	
	
	
	


	private void cargarCuentas() {
		
		for(int i = 0; i < IndicesMontosCuentas.length; i++) {
			
			IndicesMontosCuentas[i] = new BigDecimal(2000.00);
		}
		System.out.println("Banco creado. Cuentas cargadas con un saldo de " + IndicesMontosCuentas[0]);
	}
	
	private BigDecimal[] IndicesMontosCuentas = new BigDecimal[101];
	
	
	BigDecimal montoGlobal = new BigDecimal(0);
	
	
	
}


