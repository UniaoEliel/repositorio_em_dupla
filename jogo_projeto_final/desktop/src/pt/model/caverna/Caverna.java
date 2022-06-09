package pt.model.caverna;

import java.util.Iterator;

import pt.view.viewCaverna.IViewCaverna;

public class Caverna implements ICaverna {
	private int tamX, tamY;
	private Celula[][] celulas;
	
	public Caverna() {
		tamX = 5;
		tamY = 5;
	}
	
	public int getTamX() {
		return tamX;
	}


	public int getTamY() {
		return tamY;
	}
	
	public void setTamX(int tamX) {
		this.tamX = tamX;
	}
	
	
	public void setTamY(int tamY) {
		this.tamY = tamY;
	}
	
	
	public void start() {
		celulas = new Celula[tamX][tamY];
		
	    for (int i = 0; i < tamX; i++) {
	    	for (int j = 0; j < tamY; j++) {
				celulas[i][j] = new Celula();
			}
		}
	}
	
	
	public void connect(IViewCaverna viewCaverna) {
		
	}
}
