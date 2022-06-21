package pt.model.ator;

public class Morcego extends AtorInimigo {
	
	public Morcego() {
		super();
		this.tipo = "morcego";
		this.ataque = 4;
		this.velocidade = 20;
		this.vidaTotal = 20;
		this.vidaAtual = vidaTotal;
	}

	@Override
	public void receberAtaque(int dano) {
		// TODO Auto-generated method stub

	}

}
