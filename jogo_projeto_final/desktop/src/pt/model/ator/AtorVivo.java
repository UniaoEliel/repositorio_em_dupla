package pt.model.ator;

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
}
