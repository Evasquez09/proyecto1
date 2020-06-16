package proyecto9;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Marco extends JFrame{

	LaminaSuperior lamina;
	
	public Marco() {
		
		setBounds(450,200,450,350);
		setTitle("Rebota");
		
		lamina = new LaminaSuperior();
		
		add(lamina,BorderLayout.CENTER);
		
		JPanel laminaBotones = new JPanel();
		
		ponerBoton(laminaBotones,"Dale!",new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				comienza_el_juego();
			}
			
		});
		
		ponerBoton(laminaBotones,"Salir",new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});
		
		ponerBoton(laminaBotones,"Detener hilo",new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				detenerHilo(hilo);
			}
			
		});
		
		
		add(laminaBotones,BorderLayout.SOUTH);
		
		
	}
	
	public void ponerBoton(Container c, String titulo,ActionListener oyente) {
		JButton boton = new JButton(titulo);
		boton.addActionListener(oyente);
		c.add(boton);
	}
	
	public void comienza_el_juego() {
		Pelota pelota = new Pelota();
		lamina.add(pelota);
		
		Runnable ejecucion = new PelotaHilos(pelota,lamina);
		//Thread hilos = new Thread(ejecucion);
		hilo.add(new Thread(ejecucion));
		
		try {
			hilo.get(contador).start();
		}catch(IllegalThreadStateException e) {
			System.out.println("No se pueden inicializar los hilos. Contador es igual a: " + contador);
		}
		
		
		//hilo[0].start();
		contador++;
		
	}
	
	public void detenerHilo(ArrayList<Thread> hiloacerrar) {
		if (contador==0) {
			System.out.println("No hay mas hilos para detener. Contador es igual a: " + contador);
			//hilo.clear();
		}else if(contador == 1){
			hiloacerrar.get(contador-1).stop();
			contador--;
			hilo.clear();
		}
		else {
			hiloacerrar.get(contador-1).stop();
			contador--;
		}
		
	}

	private ArrayList<Thread> hilo = new ArrayList<Thread>();
	private int contador = 0;
}
