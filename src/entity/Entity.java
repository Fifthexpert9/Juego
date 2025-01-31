package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.PanelJuego;

public abstract class Entity {
	
	PanelJuego gp;

	public int x, y, originalY, jumpHeight;
	public int speed, jumpSpeed;
	
	public BufferedImage right1, right2, right3, right4, right5, right6, right7, right8, left1, left2, left3, left4, left5, left6, left7, left8, static1, static2, static3, static4, static5, static6, static7, static8,
						jump1, jump2, jump3, jump4, jump5, jump6, jump7, jump8, attack1, attack2, attack3, attack4, attack5, 
						attack6, attack7, attack8;

	public String direction;
	public boolean attack;
	
	public int spriteCounter = 0;
	public int spriteNum = 1;
	
	public Entity(PanelJuego gp) {
		this.gp = gp;
	}
	
	public void update() {}
	
	public void draw(Graphics2D g2) {}
}