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

	
	public void connect(IAcessoCelulas cave) {
		this.cave = cave;
		cave.inserirAtor(this, x, y);
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
	 * Ataca os atores de uma célula
	 * @param x x da célula
	 * @param y y da célula
	 */
	protected void atacar(int x, int y) {
		ArrayList<IAtor> atores = cave.getAtores(x, y);
		
		if (atores != null)
			for (IAtor ator : atores)
				ator.receberAtaque(this.ataque);
	}
	
	
	public void receberAtaque(int dano) {
		vidaAtual -= (int) dano * ((double) dano / (dano + defesa));
		if (vidaAtual <= 0)
			morrer();
	}
	
	
	protected void morrer() {
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
}
