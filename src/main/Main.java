package main;

import javax.swing.JFrame;

public class Main {

	public static void main(String[] args) {
		
		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setTitle("Aventura 2D");
		
		PanelJuego panelJuego = new PanelJuego();
		window.add(panelJuego);
		
		window.pack();
		
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		panelJuego.startGameThread();
		
	}

}
