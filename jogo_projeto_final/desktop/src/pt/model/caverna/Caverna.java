package pt.model.caverna;

import java.util.Iterator;
import java.util.Map;

import pt.model.ator.Ator;
import pt.model.ator.IAtor;
import pt.model.ator.IAtorObjeto;
import pt.model.ator.IAtorVivo;
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
		viewCaverna.setTamX(tamX);
		viewCaverna.setTamY(tamY);
		
		viewCaverna.create();
		
		// conecta cada celula em seu viewCelula
		for (int i = 0; i < tamX; i++) {
	    	for (int j = 0; j < tamY; j++) {
	    		celulas[i][j].connect(viewCaverna.getViewSala(i, j));
	    	}
		}
	}
	
	
	public boolean verificaValidade(int x, int y) {//Verifica se a posição na caverna é válida
		if ((x >= 0) && (x < this.tamX) && (y >= 0) && (y < this.tamY)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void inserirAtor(IAtor a, int x, int y) {
		if  (verificaValidade(x,y)) {
			celulas[x][y].inserirAtor(a);
		}	
	}
	
	public void removerAtor(IAtor a, int x, int y) {
		if  (verificaValidade(x,y)) {
			celulas[x][y].removerAtor(a);
		}
	}
	
	public void moverAtor(IAtor a, int novox, int novoy) {
		if  (verificaValidade(novox,novoy)) {
			removerAtor(a, a.getX(), a.getY());
			inserirAtor(a,novox,novoy);
		}
			
	}
	
	public Map<String, IAtorVivo> getAtoresVivos(int x, int y){
		if (verificaValidade(x,y)) {
			return celulas[x][y].getAtoresVivos();
		}
	}
	
	public Map<String, IAtorObjeto> getAtoresObjeto(int x, int y){
		if (verificaValidade(x,y)) {
			return celulas[x][y].getAtoresObjeto();
		}
	}
	
}
