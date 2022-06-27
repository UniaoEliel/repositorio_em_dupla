package pt.view.viewCaverna;

import java.util.ArrayList;
import java.util.Map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import pt.controller.exceptions.ArquivoAusente;
import pt.controller.exceptions.ArquivoMalFormatado;
import pt.model.caverna.ICaverna;
import pt.model.caverna.IAcessoCelulas;
import pt.model.caverna.ICavernaProperties;

public class ViewCaverna implements IViewCaverna {
	private int pixelsX, pixelsY, tamCelula, tamX, tamY;
	
	private ViewCelula[][] viewCelulas;
	
	private ICavernaProperties caverna;
	
	
	private ArrayList<MensagemLog> logCave;
	// coordenadas da celula que e impressa no canto esquerdo superior
	// usado como referencia para o resto
	private int coordXPlot, coordYPlot;
	
	public ViewCaverna() {
		tamX = 5;
		tamY = 5;
		coordXPlot = 0;
		coordYPlot = 0;
		logCave = new ArrayList<MensagemLog>();
	}
	
	
	public void connect(ICavernaProperties caverna) throws ArquivoAusente, ArquivoMalFormatado {
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
	
	
	public void create() throws ArquivoAusente, ArquivoMalFormatado {
		viewCelulas = new ViewCelula[tamX][tamY];

		for (int i = 0; i < tamX; i++)
			for (int j = 0; j < tamY; j++)
				viewCelulas[i][j] = new ViewCelula();
		
		ViewCelula.iniciarTexturas();
	}
	
	
	public Map<String, TextureRegion> getTexturas() {
		return ViewCelula.getTexturas();
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
	
	
	private void plotarCelulas(SpriteBatch batch) {
		int celulasX = pixelsX/tamCelula;
		int celulasY = pixelsY/tamCelula;
		
		atualizarCelulaImpressao();
		
		for (int i = coordXPlot; i < coordXPlot + celulasX; i++)
			for (int j = coordYPlot; j < coordYPlot + celulasY; j++)
				if (verificaValidade(i, j))
					viewCelulas[i][j].plotar(batch,
						tamCelula * (i - coordXPlot), tamCelula * (j - coordYPlot));
	}
	
	
	private void plotarLog(SpriteBatch batch, BitmapFont font) {
		String[] log = caverna.getLogRodada();
		font.setColor(Color.WHITE);
		
		// cada mensagem dura 5 ciclos na tela
		for (int i = 0; i < log.length; i++)
			logCave.add(new MensagemLog(log[i], 15));
		
		for (int i = 0; i < logCave.size(); i++) {
			font.draw(batch, logCave.get(i).getMensagem(), 100, 100 + 20 * i);
			logCave.get(i).passarTempo();
		}
		
		// remove as mensagens que ja passaram
		for (int i = logCave.size() - 1; i >= 0; i--) {
			if (logCave.get(i).getTempo() <= 0)
				logCave.remove(i);
		}
	}


	public void plotarCaverna(SpriteBatch batch, BitmapFont font) {
		plotarCelulas(batch);
		plotarLog(batch, font);
	}
	
	
	public void dispose() {
		ViewCelula.dispose();
	}
}
