package proyecto11;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;

public class LaminaSuperior extends JPanel{
	
	public void agregarPelota(Pelota p) {
		pelotas.add(p);
	}
	
	public void paintComponent(Graphics g) { //este metodo si dibuja la pelota
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for(Pelota b: pelotas) {
			g2.fill(b.crearPelota());
			Toolkit.getDefaultToolkit().sync();
		}
	}

	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
	
}
