package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlTeclado implements KeyListener{
	
	public boolean upPressed, downPressed, leftPressed, rigthPressed, spaceTyped, kTyped, kPressed;

	@Override
	public void keyTyped(KeyEvent e) {
		
		int code = e.getKeyChar();
		
		if (code == KeyEvent.VK_SPACE) {
			spaceTyped = true;
		}
		
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {

		int code = e.getKeyCode();
		
		if(code == KeyEvent.VK_K) {
			kPressed = true;
		}
		
		if (code == KeyEvent.VK_S) {
			
			downPressed = true;
		}
		
		if (code == KeyEvent.VK_A) {
			
			leftPressed = true;
		}
		
		if (code == KeyEvent.VK_D) {
			
			rigthPressed = true;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
		int code = e.getKeyCode();
		
		
		
		if (code == KeyEvent.VK_W) {
			
			upPressed = false;
		}
		
		if (code == KeyEvent.VK_S) {
			
			downPressed = false;
		}
		
		if (code == KeyEvent.VK_A) {
			
			
			
			leftPressed = false;
		}
		
		if (code == KeyEvent.VK_D) {
			
			
			
			rigthPressed = false;
		}
		
	
	}

	
}