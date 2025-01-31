package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import entity.Mob;
import entity.Player;
import entity.Skeleton;
import tile.TileManager;

public class PanelJuego extends JPanel implements Runnable {

	
	
	final int originalTileSize = 56;
	public int originalWidthSize = 116;
	final int scale = 4;
	
	public int tileSize = originalTileSize * scale;
	
	
	final int maxScreenCol = 3;
	final int maxScreenRow = 2;
	
	final int screenWidth = tileSize * maxScreenCol;
	final int screenHeight = tileSize * maxScreenRow;
	
	int FPS = 60;
	
	TileManager tileM = new TileManager(this);
	ControlTeclado keyH  = new ControlTeclado();
	Thread gameThread;
	public Player player = new Player(this, keyH);
	public List<Mob> mobs = new ArrayList<>();
	
	
	int playerX = 100;
	int playerY = 250;
	int playerSpeed = 5;
	
	
	public PanelJuego() {
		
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.DARK_GRAY);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
		
		init();
	}
	
	public void init() {
		mobs.add(player);
		mobs.add(new Skeleton(this));
	}
	
	public void drawBackground (Graphics g) {
		
		super.paintComponent(g);
		
		ImageIcon imagenFondo = new ImageIcon(getClass().getResource("/Fondo/Background_0.png"));
		g.drawImage(imagenFondo.getImage(),0,0, screenWidth,screenHeight , null);
		
		ImageIcon imagenFondo2 = new ImageIcon(getClass().getResource("/Fondo/Background_1.png"));
		g.drawImage(imagenFondo2.getImage(),0,0, screenWidth,screenHeight , null);
		
		ImageIcon imagenFondo3 = new ImageIcon(getClass().getResource("/Fondo/Grass_background_1.png"));
		g.drawImage(imagenFondo3.getImage(),0,0, screenWidth/2, screenHeight , null);
		
		ImageIcon imagenFondo4 = new ImageIcon(getClass().getResource("/Fondo/Grass_background_2.png"));
		g.drawImage(imagenFondo4.getImage(),screenWidth/2, 0, screenWidth/2,screenHeight , null);
		 
	}
	

	public void startGameThread() {
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
	@Override
	public void run() {
		
		double drawInterval = 1000000000/FPS;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
		long timer = 0;
		int drawCount = 0;
		
		while (gameThread != null) {
			
			currentTime = System.nanoTime();
			
			delta += (currentTime - lastTime) / drawInterval;
			timer += (currentTime - lastTime);
			lastTime = currentTime;
			
			if (delta >= 1) {
				update();
				repaint();
				delta--;
				drawCount++;
			}
			
			if (timer >= 1000000000) {
				System.out.println("FPS: "+drawCount);
				drawCount = 0;
				timer = 0;
			}
			
		}
		
	}
	
	
	
	public void update() {
		
		for (Mob mob : mobs) {
			mob.update();
		}
	
	}
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		drawBackground(g);
		
		tileM.draw(g2);
		
		for (Mob mob : mobs) {
			mob.draw(g2);
		}
		
		g2.dispose();
	}
}
