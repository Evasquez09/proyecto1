package proyecto9;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pelota {

	// Mueve la pelota invirtiendo la posicion si choca con los limites
	
	public void muevePelota(Rectangle2D limites) { //este metodo define el limite, no dibuja la pelota
		
		x+=dx;
		y+=dy;
		
		
		//evitar que se salga de los lados
		
		if(x<limites.getMinX()) {
			x= limites.getMinX();
			dx=-dx;
		}
		
		if (x + TAMX>= limites.getMaxX()){
			x=limites.getMaxX() - TAMX;
			dx=-dx;
		}
		
		if(y<limites.getMinY()) {
			y=limites.getMinY();
			dy=-dy;
		}
		
		if(y + TAMY >= limites.getMaxY()) {
			y = limites.getMaxY() - TAMY;
			dy=-dy;
			//System.out.println(dy);
			
		}
		////////////////////////////////////////////////////////////////////////////
	}
	
	public Ellipse2D getShape() { // Este metodo si crea la pelota mas no la dibuja
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
	}
	
	
	
	private static final int TAMX=15,TAMY=15;// tamano de la esfera
	private double x=0,y=0,dx=1,dy=1;// lugar donde se encuentra la esfera (Posicion)
	
}
