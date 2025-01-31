package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.PanelJuego;

public class Skeleton extends Mob {
	
	public Skeleton(PanelJuego gp) {
		super(gp);
		
		setDefaultValues();
		getSkeletonImage();
	}
	
	public void setDefaultValues() {
		x = 320;
		y = 170;
		direction = "right";
	}
	
	public void getSkeletonImage() {
		
		try {
			
			right1 = ImageIO.read(getClass().getResourceAsStream("/enemy/skeleton/Derecha1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/enemy/skeleton/Derecha2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/enemy/skeleton/Derecha3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/enemy/skeleton/Derecha4.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update() {
		
		spriteCounter++;
		
		if(spriteCounter > 8) {
			if (spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 3;
			}else if (spriteNum == 3) {
				spriteNum = 4;
			} else if (spriteNum == 4) {
				spriteNum = 1;
			}
			
			spriteCounter = 0;
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch (direction) {
			case "right":
				if (spriteNum == 1) {
					image = right1;
				}
				if (spriteNum == 2) {
					image = right2;
				}
				if (spriteNum == 3) {
					image = right3;
				}
				if (spriteNum == 4) {
					image = right4;
				}
				break;
		}
		
		g2.drawImage(image, x, y, 150*2, 150*2, null );
	}
}
