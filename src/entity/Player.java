package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.ControlTeclado;
import main.Panel_Juego;

public class Player extends Entity {

	
	Panel_Juego gp;
	ControlTeclado keyH;
	
	public Player (Panel_Juego gp, ControlTeclado keyH) {
		
		this.gp = gp;
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues () {
		
		
		x = 100;
		y = 100;
		speed = 6;
		direction = "static";
	}
	
	public void getPlayerImage() {
		
		try {
			
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/Derecha1.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/Derecha2.png"));
			right3 = ImageIO.read(getClass().getResourceAsStream("/player/Derecha3.png"));
			right4 = ImageIO.read(getClass().getResourceAsStream("/player/Derecha4.png"));
			right5 = ImageIO.read(getClass().getResourceAsStream("/player/Derecha5.png"));
			right6 = ImageIO.read(getClass().getResourceAsStream("/player/Derecha6.png"));
			right7 = ImageIO.read(getClass().getResourceAsStream("/player/Derecha7.png"));
			right8 = ImageIO.read(getClass().getResourceAsStream("/player/Derecha8.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/Izquierda1.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/Izquierda2.png"));
			left3 = ImageIO.read(getClass().getResourceAsStream("/player/Izquierda3.png"));
			left4 = ImageIO.read(getClass().getResourceAsStream("/player/Izquierda4.png"));
			left5 = ImageIO.read(getClass().getResourceAsStream("/player/Izquierda5.png"));
			left6 = ImageIO.read(getClass().getResourceAsStream("/player/Izquierda6.png"));
			left7 = ImageIO.read(getClass().getResourceAsStream("/player/Izquierda7.png"));
			left8 = ImageIO.read(getClass().getResourceAsStream("/player/Izquierda8.png"));
			static1 = ImageIO.read(getClass().getResourceAsStream("/player/static1.png"));
			static2 = ImageIO.read(getClass().getResourceAsStream("/player/static2.png"));
			static3 = ImageIO.read(getClass().getResourceAsStream("/player/static3.png"));
			static4 = ImageIO.read(getClass().getResourceAsStream("/player/static4.png"));
			static5 = ImageIO.read(getClass().getResourceAsStream("/player/static5.png"));
			static6 = ImageIO.read(getClass().getResourceAsStream("/player/static6.png"));
			static7 = ImageIO.read(getClass().getResourceAsStream("/player/static7.png"));
			static8 = ImageIO.read(getClass().getResourceAsStream("/player/static8.png"));
			jump1 = ImageIO.read(getClass().getResourceAsStream("/player/jump1.png"));
			jump2 = ImageIO.read(getClass().getResourceAsStream("/player/jump2.png"));
			jump3 = ImageIO.read(getClass().getResourceAsStream("/player/jump3.png"));
			jump4 = ImageIO.read(getClass().getResourceAsStream("/player/jump4.png"));
			jump5 = ImageIO.read(getClass().getResourceAsStream("/player/jump5.png"));
			jump6 = ImageIO.read(getClass().getResourceAsStream("/player/jump6.png"));
			jump7 = ImageIO.read(getClass().getResourceAsStream("/player/jump7.png"));
			jump8 = ImageIO.read(getClass().getResourceAsStream("/player/jump8.png"));
			
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void update (){
	
		if (keyH.upPressed == true || keyH.downPressed == true || 
				keyH.leftPressed == true || keyH.rigthPressed == true || keyH.spaceTyped == true) {
		
			if (keyH.downPressed == true) {
				y += speed;
			}
			else if (keyH.leftPressed == true) {
			
				direction = "left";
				x -= speed;
			}
			else if (keyH.rigthPressed == true) {
			
				direction = "right";
				x += speed;
			}
			else if (keyH.spaceTyped == true) {
				direction = "jump";
				
			}
			
					
				
		}
			
		
		 else {
			direction = "static";
		}
		spriteCounter++;
		
		if(spriteCounter > 6) {
			if (spriteNum == 1) {
				spriteNum = 2;
			}
			else if(spriteNum == 2) {
				spriteNum = 3;
			}else if (spriteNum == 3) {
				spriteNum = 4;
			}else if (spriteNum == 4) {
				spriteNum = 5;
			}else if (spriteNum == 5) {
				spriteNum = 6;
			}else if (spriteNum == 6) {
				spriteNum = 7;
			}else if (spriteNum == 7) {
				spriteNum = 8;
			}else if (spriteNum == 8) {
				spriteNum = 1;
			}
			
			if (spriteNum >= 8) {
				keyH.spaceTyped = false;
			}
			spriteCounter = 0;
		}
		
		
	
	}
	
	public void draw (Graphics2D g2) {
		
		//g2.setColor(Color.WHITE);
		
		//g2.fillRect(x, y, gp.tileSize, gp.characterHeight);
		
		BufferedImage image = null;
		
		switch (direction){
		
		case "static":
			if (spriteNum == 1) {
				image = static1;
			}
			if (spriteNum == 2) {
				image = static2;
			}
			if (spriteNum == 3) {
				image = static3;
			}
			if (spriteNum == 4) {
				image = static4;
			}
			if (spriteNum == 5) {
				image = static5;
			}
			if (spriteNum == 6) {
				image = static6;
			}
			if (spriteNum == 7) {
				image = static7;
			}
			if (spriteNum == 8) {
				image = static8;
			}
			break;
			
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
			if (spriteNum == 5) {
				image = right5;
			}
			if (spriteNum == 6) {
				image = right6;
			}
			if (spriteNum == 7) {
				image = right7;
			}
			if (spriteNum == 8) {
				image = right8;
			}
			break;
		case "left":
			if (spriteNum == 1) {
				image = left2;
			}
			if (spriteNum == 2) {
				image = left1;
			}
			if (spriteNum == 3) {
				image = left4;
			}
			if (spriteNum == 4) {
				image = left3;
			}
			if (spriteNum == 5) {
				image = left6;
			}
			if (spriteNum == 6) {
				image = left5;
			}
			if (spriteNum == 7) {
				image = left8;
			}
			if (spriteNum == 8) {
				image = left7;
			}
			
			break;
		
		case "jump":
			if (spriteNum == 1) {
				image= jump1;
			}
		
			if (spriteNum == 2) {
				image= jump2;
			}
		
			if (spriteNum ==3) {
				image= jump3;
			}
		
			if (spriteNum == 4) {
				image= jump4;
			}
		
			if (spriteNum == 5) {
				image= jump5;
			}
		
			if (spriteNum == 6) {
				image= jump6;
			}
		
			if (spriteNum == 7) {
				image= jump7;
			}
		
			if (spriteNum == 8) {
				image= jump8;
			}
			
			break;
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.originalWidthSize, null );
		
	}
}
















