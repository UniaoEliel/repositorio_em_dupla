package pt.model.caverna;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

import pt.model.ator.Ator;
import pt.model.ator.IAtor;
import pt.model.ator.IAtorObjeto;
import pt.model.ator.IAtorVivo;
import pt.model.ator.IHeroiCoord;
import pt.view.viewCaverna.IViewCaverna;

public class Caverna implements ICaverna {
	private int tamX, tamY;
	private Celula[][] celulas;
	private IHeroiCoord heroi;
	private ControleRodada controle;
	private PriorityQueue<IAtor> pq;
	
	public Caverna() {
		tamX = 5;
		tamY = 5;
		pq = new PriorityQueue<IAtor>(new ControleRodada());
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
	
	
	public void somaIluminacao(int iluminacao, int x, int y) {
		if  (verificaValidade(x,y))
			celulas[x][y].somaIluminacao(iluminacao);
	}
	
	public int getIluminacao(int x, int y) {
		int iluminacao = 0;
		
		if  (verificaValidade(x,y))
			iluminacao = celulas[x][y].getIluminacao();
		
		return iluminacao;
	}
	
	
	private int distanciaQuadrado(int x1, int y1, int x2, int y2) {
		return (x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1);
	}
	
	
	public void iluminarCelulas(int x, int y, int raio) {
		int dist;
		
		for (int i = x - raio; i <= x + raio; i++)
			for (int j = y - raio; j <= y + raio; j++) {
				dist = distanciaQuadrado(x, y, i, j);
				
				if (dist >= (raio + 1) * (raio + 1))
					somaIluminacao(0, i, j);
				else if (dist == 0)
					somaIluminacao(100, i, j);
				else if (dist >= (raio) * (raio))
					somaIluminacao(25, i, j);
				else if (dist >= (raio - 1) * (raio - 1))
					somaIluminacao(50, i, j);
				else if (dist >= (raio - 2) * (raio - 2))
					somaIluminacao(75, i, j);
				else if (dist < raio * raio)
					somaIluminacao(100, i, j);
			}
	}
	
	
	public void desiluminarCelulas(int x, int y, int raio) {
		int dist;
		
		for (int i = x - raio; i <= x + raio; i++)
			for (int j = y - raio; j <= y + raio; j++) {
				dist = distanciaQuadrado(x, y, i, j);
				
				if (dist >= (raio + 1) * (raio + 1))
					somaIluminacao(0, i, j);
				else if (dist == 0)
					somaIluminacao(-100, i, j);
				else if (dist >= (raio) * (raio))
					somaIluminacao(-25, i, j);
				else if (dist >= (raio - 1) * (raio - 1))
					somaIluminacao(-50, i, j);
				else if (dist >= (raio - 2) * (raio - 2))
					somaIluminacao(-75, i, j);
				else if (dist < raio * raio)
					somaIluminacao(-100, i, j);
			}
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
	
	
	public void connect(IHeroiCoord heroi) {
		this.heroi = heroi;
	}
	
	
	public boolean verificaValidade(int x, int y) {//Verifica se a posição na caverna é válida
		if ((x >= 0) && (x < this.tamX) && (y >= 0) && (y < this.tamY)) {
			return true;
		}
		else {
			return false;
		}
	}


	public void inserirAtor(IAtorVivo a, int x, int y) {
		if  (verificaValidade(x,y)) {
			celulas[x][y].inserirAtor(a);
		}	
	}
	
	public void removerAtor(IAtorVivo a, int x, int y) {
		if  (verificaValidade(x,y)) {
			celulas[x][y].removerAtor(a);
		}
	}
	

	public void inserirAtor(IAtorObjeto a, int x, int y) {
		if  (verificaValidade(x,y)) {
			celulas[x][y].inserirAtor(a);
		}	
	}
	
	public void removerAtor(IAtorObjeto a, int x, int y) {
		if  (verificaValidade(x,y)) {
			celulas[x][y].removerAtor(a);
		}
	}
	
	
	
	public void moverAtor(IAtorVivo a, int novox, int novoy) {
		if  (verificaValidade(novox,novoy) && celulas[novox][novoy].podeEntrar(a)) {
			removerAtor(a, a.getX(), a.getY());
			
			a.setX(novox);
			a.setY(novoy);

			inserirAtor(a,novox,novoy);
			
		}		
	}
	
	public void moverAtor(IAtorObjeto a, int novox, int novoy) {
		if  (verificaValidade(novox,novoy) && celulas[novox][novoy].podeEntrar(a)) {
			removerAtor(a, a.getX(), a.getY());
			inserirAtor(a,novox,novoy);
		}		
	}

	
	public Map<String, IAtorVivo> getAtoresVivos(int x, int y){
		if (verificaValidade(x,y)) {
			return celulas[x][y].getAtoresVivos();
		}
		return null;
	}
	
	public Map<String, IAtorObjeto> getAtoresObjeto(int x, int y){
		if (verificaValidade(x,y)) {
			return celulas[x][y].getAtoresObjeto();
		}
		return null;
	}

	@Override
	public void passarRodada() {
		ArrayList<IAtor> atores;
		int x = heroi.getX(), y = heroi.getY();
		
		// adiciona todos os elementos numa fila de prioridade com
		// base na velocidade
		for (int i = x - 16; i <= x + 16; i++) {
			for (int j = y - 16; j <= y + 16; j++) {
				if (verificaValidade(i ,j)) {
					atores = celulas[i][j].getAtores();
					for (IAtor ator : atores) {
						pq.add(ator);
					}
				}
			}
		}
		
		
		while (!pq.isEmpty())
			pq.poll().passarRodada();
		
	}
	
}
