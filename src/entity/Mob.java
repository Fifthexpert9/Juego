package entity;

import main.PanelJuego;

public abstract class Mob extends Entity {
	
	public int maxHealth;
	public int health;
	
	public Mob(PanelJuego gp) {
		super(gp);
	}

}
