package pt.model.ator;

public class Aranha extends AtorInimigo {
	
	public Aranha() {
		this.ataque = 15;
		this.vidaTotal = 30;
		this.vidaAtual = this.vidaTotal;
	}

	@Override
	public void receberAtaque(int dano) {
		// TODO Auto-generated method stub

	}

}
