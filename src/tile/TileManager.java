package tile;

import java.awt.Graphics2D;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.Panel_Juego;

public class TileManager {
	
	Panel_Juego gp;
	Tile[] tile;
	
	public TileManager(Panel_Juego gp) {
		
		this.gp = gp;
		
		tile = new Tile[10];
		
		getTileImage();
	}
	
	public void getTileImage() {
		
		try {
			
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tile1.png")); 
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tile2.png")); 
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tile3.png")); 
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tile4.png")); 
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/Tile5.png")); 
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void draw(Graphics2D g2) {
		
		
		g2.drawImage(tile[0].image, 0, 0, 100, 60, null);
	}

}
