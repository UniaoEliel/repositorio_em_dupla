package pt.model.ator;

import pt.model.caverna.IAcessoCelulas;

public abstract class AtorVivo extends Ator implements IAtorVivo {
	private int vidaTotal, vidaAtual, ataque, defesa;
	
	public static IAtorVivo criarAtorVivo(String tipo) {
		if (tipo == "jogador")
			return new Heroi();
		return null;
	}

	
	public void connect(IAcessoCelulas cave) {
		this.cave = cave;
		cave.inserirAtorVivo(this, x, y);
	}
	
	
	public void mover(char direcao) {
		switch (direcao) {
		case 'w':
			cave.moverAtorVivo(this, x, y + 1);
			break;
		case 's':
			cave.moverAtorVivo(this, x, y - 1);
			break;
		case 'a':
			cave.moverAtorVivo(this, x - 1, y);
			break;
		case 'd':
			cave.moverAtorVivo(this, x + 1, y);

		default:
			break;
		}
		
		orientacao = direcao;
	}
}
