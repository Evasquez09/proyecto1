package proyecto11;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Pelota{

	public void moverPelota(Rectangle2D limites) {
		x+=dx;
		y+=dy;
		
		if(x < limites.getMinX()) {
			x = limites.getMinX();
			dx = -dx;
		}
		
		if(y < limites.getMinY()) {
			y = limites.getMinY();
			dy = -dy;
		}
		
		if(x + TAMX> limites.getMaxX()) {
			x = limites.getMaxX() - TAMX;
			dx = -dx;
		}
		
		if(y + TAMY> limites.getMaxY()) {
			y = limites.getMaxY() - TAMY;
			dy = -dy;
		}
	}
	public Ellipse2D crearPelota() {
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
	}
	private double x=0,y=0,dx=1,dy=1,TAMX=15,TAMY=15;
}
