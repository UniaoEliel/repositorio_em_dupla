package pt.view.viewCaverna;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pt.model.caverna.ICaverna;
import pt.model.caverna.ICavernaProperties;

public class ViewCaverna implements IViewCaverna {
	private int pixelsX, pixelsY, tamCelula, tamX, tamY;
	
	private ViewCelula[][] viewCelulas;
	
	private ICaverna caverna;
	
	// coordenadas da celula que e impressa no canto esquerdo superior
	// usado como referencia para o resto
	private int coordXPlot, coordYPlot;
	
	public ViewCaverna() {
		tamX = 5;
		tamY = 5;
		coordXPlot = 0;
		coordYPlot = 0;
	}
	
	
	public void connect(ICaverna caverna) {
		this.caverna = caverna;
		
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
	
	
	public boolean verificaValidade(int x, int y) {
		return ((x >= 0) && (x < this.tamX) && (y >= 0) && (y < this.tamY));
	}
	
	/**
	 * Faz com que o heroi esteja sempre a 1/3 de distancia da borda
	 * da tela
	 */
	private void atualizarCelulaImpressao() {
		int xHeroi = caverna.getXHeroi(), yHeroi = caverna.getYHeroi();
		int celulasX = pixelsX/tamCelula;
		int celulasY = pixelsY/tamCelula;
		
		if (xHeroi - coordXPlot < celulasX / 3)
			coordXPlot = xHeroi - celulasX / 3;
		else if (xHeroi - coordXPlot > 2 * celulasX / 3)
			coordXPlot = xHeroi - 2 * celulasX / 3;
		
		if (yHeroi - coordYPlot < celulasY / 3)
			coordYPlot = yHeroi - celulasY / 3;
		
		else if (yHeroi - coordYPlot > 2 * celulasY / 3)
			coordYPlot = yHeroi - 2 * celulasY / 3;
	}


	public void plotarCaverna(SpriteBatch batch) {
		int celulasX = pixelsX/tamCelula;
		int celulasY = pixelsY/tamCelula;
		
		atualizarCelulaImpressao();
		
		for (int i = coordXPlot; i < coordXPlot + celulasX; i++)
			for (int j = coordYPlot; j < coordYPlot + celulasY; j++)
				if (verificaValidade(i, j))
					viewCelulas[i][j].plotar(batch,
						tamCelula * (i - coordXPlot), tamCelula * (j - coordYPlot));
	}
	
	
	public void dispose() {
		ViewCelula.dispose();
	}
}
