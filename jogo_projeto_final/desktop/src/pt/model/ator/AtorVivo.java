package pt.model.ator;

import java.util.ArrayList;

import pt.model.caverna.IAcessoCelulas;

/**
 * Define um ator que pode se mover e atacar na caverna
 * @author elias
 *
 */
public abstract class AtorVivo extends Ator {
	protected int vidaTotal, vidaAtual, ataque, defesa;
	// iniciativa vai acumulando quando as rodadas se passam.
	// quando chega no valor 100 o ator pode atacar
	protected int iniciativaAtual;
	
	public AtorVivo() {
		this.solido = true;
		iniciativaAtual = 0;
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
		ArrayList<IAtor> atores = cave.getAtores(x, y);
		
		if (atores != null && podeAtacar()) {
			for (IAtor ator : atores)
				ator.receberAtaque(this.tipo, this.ataque);
			
			iniciativaAtual -= 100;
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
	protected void seMoverEmDirecaoA(int x, int y) {
		if (this.x < x)
			mover('d');
		else if (this.x > x)
			mover('a');
		else if (this.y < y)
			mover('w');
		else if (this.y > y)
			mover('s');
	}
	
	
	protected boolean podeAtacar() {
		boolean pode = false;
		if (iniciativaAtual >= 100)
			pode = true;
		
		return pode;
	}
	
	
	public void passarRodada() {
		iniciativaAtual += velocidade;
	}
	
	/**
	 * 
	 * @return os atores na sala diretamente em frente do ator
	 */
	protected Arraylist<IAtor> getAtoresEmFrente() {
		
	}
}
