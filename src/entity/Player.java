package entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.ControlTeclado;
import main.PanelJuego;

public class Player extends Mob {

	ControlTeclado keyH;
	
	public Player (PanelJuego gp, ControlTeclado keyH) {
		super(gp);
		
		this.keyH = keyH;
		
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues () {
		
		maxHealth = 10;
		health = maxHealth;
		
		originalY = 250;
		jumpHeight = 60;
		x = 100;
		y = 250;
		speed = 5;
		direction = "static";
		attack = false;
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
			attack1 = ImageIO.read(getClass().getResourceAsStream("/player/tile002.png"));
			attack2 = ImageIO.read(getClass().getResourceAsStream("/player/tile003.png"));
			attack3 = ImageIO.read(getClass().getResourceAsStream("/player/tile004.png"));
			attack4 = ImageIO.read(getClass().getResourceAsStream("/player/tile005.png"));
			attack5 = ImageIO.read(getClass().getResourceAsStream("/player/tile006.png"));
			attack6 = ImageIO.read(getClass().getResourceAsStream("/player/tile007.png"));
			attack7 = ImageIO.read(getClass().getResourceAsStream("/player/tile008.png"));
			attack8 = ImageIO.read(getClass().getResourceAsStream("/player/tile009.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void update (){
	
		if ( keyH.leftPressed == true || keyH.rigthPressed == true || keyH.spaceTyped == true || keyH.kPressed == true) {		
			 if (keyH.leftPressed == true ) {
				keyH.spaceTyped = false;
				keyH.kPressed = false; 
				direction = "left";
				x -= speed;
			}
			 else if (keyH.rigthPressed == true) {
				keyH.spaceTyped = false;
				keyH.kPressed = false; 
				direction = "right";
				x += speed;
			}
				 if (keyH.spaceTyped && direction.equals("static")) {
					direction = "jump";
					spriteNum = 1;
				
				 }
				 if (keyH.kPressed == true && direction.equals("static")) {
					attack = true;
					direction = "animation";	
					spriteNum = 1;
				}	 	
		
		}
		 else{
			direction = "static";
		}
		
		
		if (attack == true) {
			
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
				}
				
				if (spriteNum == 8) {
					keyH.kPressed = false;
					attack = false;
				}
				
				spriteCounter = 0;
				
			}
		}

		if (direction.equals("jump")) {
	     
	        if (y > originalY - jumpHeight) {
	            y -= speed; 
	        } else {
	            direction = "falling";
	        }

	        spriteCounter++;
	        if (spriteCounter > 6) {
	            spriteNum = (spriteNum % 8) + 1; 
	            spriteCounter = 0;
	        }

	       
	        if (spriteNum == 8) {
	            direction = "falling";
	        }
	    }

	    if (direction.equals("falling")) {
	    
	    	if (y < originalY) {
	  	      	
	            y += speed; 
	        } else {
	            
	            direction = "static";
	            keyH.spaceTyped = false;
	        }
	    }
	   
	    
	   
		
		spriteCounter++;
		
		if(spriteCounter > 8) {
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
			
		
		case "falling":
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
		
		case "animation":
			
			if (spriteNum == 1) {
				image= attack1;
			}
		
			if (spriteNum == 2) {
				image= attack2;
			}
		
			if (spriteNum ==3) {
				image= attack3;
			}
		
			if (spriteNum == 4) {
				image= attack4;
			}
			if (spriteNum == 5) {
				image= attack5;
			}
		
			if (spriteNum == 6) {
				image= attack6;
			}
		
			if (spriteNum == 7) {
				image= attack7;
			}
		
			if (spriteNum == 8) {
				image= attack8;
			}
			break;
			
		}
		
		g2.drawImage(image, x, y, gp.tileSize, gp.originalWidthSize, null );
	}
}















