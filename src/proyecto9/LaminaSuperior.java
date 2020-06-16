package proyecto9;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JPanel;

public class LaminaSuperior extends JPanel{

	public void add(Pelota b) { // anadir pelota al array de pelotas 
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g) { //este metodo si dibuja la pelota
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;
		for(Pelota b: pelotas) {
			g2.fill(b.getShape());
			Toolkit.getDefaultToolkit().sync();
		}
		
	}
	private ArrayList<Pelota> pelotas = new ArrayList<Pelota>();
	
}
