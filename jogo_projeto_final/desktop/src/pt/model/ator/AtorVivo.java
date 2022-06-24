package pt.model.ator;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import pt.model.caverna.IAcessoCelulas;

/**
 * Define um ator que pode se mover e atacar na caverna
 * @author elias
 *
 */
public abstract class AtorVivo extends Ator {
	protected int vidaTotal, vidaAtual, ataque, defesa, raioAtaque;
	// iniciativa vai acumulando quando as rodadas se passam.
	// quando chega no valor 100 o ator pode atacar
	protected int iniciativaAtual;
	
	protected int rodadasMover, rodadasAtacar;
	
	// contadores para saber o cooldown do movimento, do ataque, e da imobilizacao
	protected int countMover, countAtacar, countImobilizado;

	/**
	 * Utiliza busca em largura para achar um caminho
	 * 
	 * @param xAtual x atual
	 * @param yAtual y atual
	 * @param xDest x destino
	 * @param yDest y destino
	 * @param maxProfundidade profundidade maxima da busca
	 * @return vetor com os movimentos em ordem caso existir caminho,
	 * null caso nao existir
	 */
	public char[] buscarCaminho(int xAtual, int yAtual, int xDest, int yDest, int maxProfundidade) {
		char[] caminhoResposta = null;
		Caminho caminho, cloneCaminho;
		int xCam, yCam;
		Queue<Caminho> caminhos = new LinkedList<Caminho>();
		
		caminhos.add(new Caminho(xAtual, yAtual));
		
		while (!caminhos.isEmpty()) {
			caminho = caminhos.poll();
			xCam = caminho.getX();
			yCam = caminho.getY();
			
			if (cave.distanciaQuadrado(xCam, yCam, xDest, yDest) < 4) {
				caminhoResposta = caminho.getCaminho();
				break;
			}
			else if (caminho.getTamanho() < maxProfundidade) {
				if (cave.entravel(xCam, yCam + 1)) {
					cloneCaminho = caminho.clone();
					cloneCaminho.inserirMovimento('w');
					caminhos.add(cloneCaminho);
				}
				if (cave.entravel(xCam, yCam - 1)) {
					cloneCaminho = caminho.clone();
					cloneCaminho.inserirMovimento('s');
					caminhos.add(cloneCaminho);
				}
				if (cave.entravel(xCam + 1, yCam)) {
					cloneCaminho = caminho.clone();
					cloneCaminho.inserirMovimento('d');
					caminhos.add(cloneCaminho);
				}
				if (cave.entravel(xCam - 1, yCam)) {
					cloneCaminho = caminho.clone();
					cloneCaminho.inserirMovimento('a');
					caminhos.add(cloneCaminho);
				}
			}
		}
		caminhos.clear();
		
		return caminhoResposta;
	}
	
	
	public AtorVivo() {
		this.solido = true;
		iniciativaAtual = 0;
		
		countMover = 0;
		countAtacar = 0;
		
		raioAtaque = 1;
	}
	
	public void mover(char direcao) {
		switch (direcao) {
			case 'w':
				cave.moverAtor(this, x, y + 1);
				break;
			case 's':
				cave.moverAtor(this, x, y - 1);
				break;
			case 'a':
				cave.moverAtor(this, x - 1, y);
				break;
			case 'd':
				cave.moverAtor(this, x + 1, y);
	
			default:
				break;
		}
		
		orientacao = direcao;
		
		countMover = rodadasMover;
	}
	
	
	public int getVidaTotal() {
		return vidaTotal;
	}


	public int getVidaAtual() {
		return vidaAtual;
	}
	
	
	/**
	 * Ataca os atores de uma célula se puder
	 * se não nao faz nada
	 * @param x x da célula
	 * @param y y da célula
	 */
	protected void atacar(int x, int y) {
		if (podeAtacar()) {
			AtaquePadrao objAtaque = new AtaquePadrao();
			
			objAtaque.setAutor(tipo);
			objAtaque.setDuracao(8);
			objAtaque.setDano(this.ataque);
			
			objAtaque.setX(x);
			objAtaque.setY(y);
			
			objAtaque.connect(cave);
			// renicia o contador
			countAtacar = rodadasAtacar;
		}
			
			
		}

	
	
	public void receberAtaque(String nomeAtacante, int dano) {
		int danoCausado = (int) (dano * ((double) dano / (dano + defesa)));
		vidaAtual -= danoCausado;
		
		cave.inserirNoLog(nomeAtacante + " atacou " + tipo + " e deu " + danoCausado + " de dano.");
		if (vidaAtual <= 0) {
			morrer();
		}
	}
	
	
	protected void morrer() {
		cave.inserirNoLog(tipo + " morreu");
		cave.removerAtor(this, x, y);
	}
	
	
	/**
	 * Faz um movimento em alguma das 4 direçoes
	 */
	protected void movimentoAleatorio() {
		int move = aleatorio.nextInt(4);
		
		if (move == 0)
			mover('w');
		else if (move == 1)
			mover('s');
		else if (move == '2')
			mover('a');
		else
			mover('d');
	}
	
	
	/**
	 * se move em direcao a uma celula
	 * @param x x da celula
	 * @param y y da celula
	 */
	protected void seMoverEmDirecaoA(int xDest, int yDest) {
		char[] caminho = buscarCaminho(x, y, xDest, yDest, 50);
		
		if (caminho != null && caminho.length > 0)
			mover(caminho[0]);
		else
			movimentoAleatorio();
	}
	
	
	protected boolean podeAtacar() {
		return (countAtacar == 0 && countImobilizado == 0);
	}
	
	
	protected boolean podeMover() {
		return (countMover == 0 && countImobilizado == 0);
		
	}
	
	
	public void passarRodada() {
		if (countMover > 0)
			countMover--;
		if (countAtacar > 0)
			countAtacar--;
		if (countImobilizado > 0)
			countImobilizado--;
	}
	
	/**
	 * 
	 * @return os atores na sala diretamente em frente do ator
	 */
	protected void atacarFrente() {
		if (orientacao == 'w')
			atacar(x, y+1);
		else if (orientacao == 's')
			atacar(x, y-1);
		else if (orientacao == 'a')
			atacar(x-1, y);
		else
			atacar(x+1, y);
	}
}
