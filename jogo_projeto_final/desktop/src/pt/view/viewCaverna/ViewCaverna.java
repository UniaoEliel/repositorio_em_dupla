package pt.view.viewCaverna;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pt.model.caverna.ICaverna;

public class ViewCaverna implements IViewCaverna {
	private int pixelsX, pixelsY, tamCelula, tamX, tamY;
	
	private ViewCelula[][] viewCelulas;
	
	public ViewCaverna() {
		tamX = 5;
		tamY = 5;
		
	}
	
	
	public void connect(ICaverna caverna) {
		tamX = caverna.getTamX();
		tamY = caverna.getTamY();
		create();
		
		for (int i = 0; i < tamX; i++)
			for (int j = 0; j < tamY; j++)
				viewCelulas[i][j].connect(caverna.getCelula(i, j));
	}
	
	public void setTamX(int tamX) {
		this.tamX = tamX;
	}


	public void setTamY(int tamY) {
		this.tamY = tamY;
	}
	
	
	public void create() {
		viewCelulas = new ViewCelula[tamX][tamY];

		for (int i = 0; i < tamX; i++)
			for (int j = 0; j < tamY; j++)
				viewCelulas[i][j] = new ViewCelula();
		
		ViewCelula.iniciarTexturas();
	}


	public int getPixelsX() {
		return pixelsX;
	}


	public void setPixelsX(int pixelsX) {
		this.pixelsX = pixelsX;
	}


	public int getPixelsY() {
		return pixelsY;
	}


	public void setPixelsY(int pixelsY) {
		this.pixelsY = pixelsY;
	}


	public int getTamCelula() {
		return tamCelula;
	}


	public void setTamCelula(int tamCelula) {
		this.tamCelula = tamCelula;
	}


	public void plotarCaverna(SpriteBatch batch) {
		int celulasX = pixelsX/tamCelula;
		int celulasY = pixelsY/tamCelula;
		
		for (int i = 0; i < celulasX; i++)
			for (int j = 0; j < celulasY; j++)
				viewCelulas[i][j].plotar(batch, tamCelula * i, tamCelula * j);
	}
	
	
	public void dispose() {
		ViewCelula.dispose();
	}
}
