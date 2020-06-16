package proyecto11;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ConcurrentModificationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Marco extends JFrame{

	public Marco() {
		setBounds(400,240,500,450);
		setTitle("Rebotar pelota");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel laminaInferior = new JPanel();
		generarBoton(laminaInferior,"Lanzar",new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comenzarLanzamiento();
			}
		});
		
		generarBoton(laminaInferior,"Detener",new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//detenerHilo();
			}
		});
		
		generarBoton(laminaInferior,"Salir",new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		laminaSuperior = new LaminaSuperior();
		add(laminaSuperior,BorderLayout.CENTER);
		add(laminaInferior,BorderLayout.SOUTH);
	}

	private void generarBoton(JPanel LaminaInferior,String titulo, ActionListener accion) {
		JButton boton = new JButton(titulo);
		boton.addActionListener(accion);
		LaminaInferior.add(boton);
	}
	
	public void comenzarLanzamiento() {
		Pelota pelota = new Pelota();
		laminaSuperior.agregarPelota(pelota);
		
		Hilo hilo = new Hilo(laminaSuperior,pelota);
		Thread hiloNuevo = new Thread(hilo);
		hiloNuevo.start();
	}
	
	LaminaSuperior laminaSuperior;
	
}