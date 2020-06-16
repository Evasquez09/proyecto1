package proyecto7;

class ClaseGenerica<T> {
	
	public ClaseGenerica() {
		datoInterno = null;
	}
	
	public void setDato(T recibido) {
		
		datoInterno = recibido;
		
	}
	
	public T getDato() {
		return datoInterno;
	}
	
	private T datoInterno;
}