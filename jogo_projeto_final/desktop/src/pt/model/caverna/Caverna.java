package pt.model.caverna;

import java.util.ArrayList;
import java.util.PriorityQueue;

import pt.model.ator.IAcoesAtor;
import pt.model.ator.IAtor;
import pt.model.ator.IHeroiCoord;

public class Caverna implements ICaverna {
	private int tamX, tamY;
	private Celula[][] celulas;
	private IHeroiCoord heroi;
	private PriorityQueue<IAtor> pq;
	private ArrayList<String> logRodada;
	
	// define em qual raio ao redor do heroi a caverna vai
	// se atualizar ao fim de uma rodada
	private int raioRodada;
	
	public Caverna() {
		tamX = 5;
		tamY = 5;
		pq = new PriorityQueue<IAtor>(new ControleRodada());
		raioRodada = 16;
		logRodada = new ArrayList<String>();
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
	
	
	public ICelula getCelula(int x, int y) {
		return celulas[x][y];
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
	
	
	public int distanciaQuadrado(int x1, int y1, int x2, int y2) {
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
	
	
	public void connect(IHeroiCoord heroi) {
		this.heroi = heroi;
	}
	
	//Verifica se a posição na caverna é válida
	public boolean verificaValidade(int x, int y) {
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
	
	
	public void removerAtor(String tipo, int x, int y) {
		if  (verificaValidade(x,y)) {
			celulas[x][y].removerAtor(tipo);
		}
	}
	
	
	public void moverAtor(IAtor a, int novox, int novoy) {
		if  (verificaValidade(novox,novoy) && celulas[novox][novoy].podeEntrar(a)) {
			removerAtor(a, a.getX(), a.getY());
			
			a.setX(novox);
			a.setY(novoy);

			inserirAtor(a,novox,novoy);
			
		}
	}

	public void passarRodada() {
		ArrayList<IAtor> atores;
		int x = heroi.getX(), y = heroi.getY();
		
		// renicia o log
		logRodada.clear();
		
		// adiciona todos os elementos numa fila de prioridade com
		// base na velocidade
		for (int i = x - raioRodada; i <= x + raioRodada; i++) {
			for (int j = y - raioRodada; j <= y + raioRodada; j++) {
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
	
	
	public IAcoesAtor[] getAtores(int x, int y) {
		ArrayList<IAtor> atores = null;
		IAcoesAtor[] atoresV = null;

		if (verificaValidade(x, y)) {
			
			atores = celulas[x][y].getAtores();
			
			atoresV = new IAtor[atores.size()];
			
			int k = 0;
			
			for (IAtor ator : atores) {
				atoresV[k++] = ator;
			}
		}
		
		return atoresV;
	}


	public int getXHeroi() {
		return heroi.getX();
	}


	public int getYHeroi() {
		return heroi.getY();
	}
	
	
	public boolean entravel(int x, int y) {
		if (verificaValidade(x, y) && !celulas[x][y].isSolida())
			return true;
		return false;
	}
	
	
	public void inserirNoLog(String acontecimento) {
		logRodada.add(acontecimento);
	}
	
	
	public String[] getLogRodada() {
		String[] log = new String[logRodada.size()];
		int k = 0;
		
		for (String acontecimento : logRodada) {
			log[k++] = acontecimento;
		}
		return log;
	}
	
}
