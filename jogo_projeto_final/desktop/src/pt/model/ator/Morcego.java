package pt.model.ator;

public class Morcego extends AtorInimigo {
	
	public Morcego() {
		super();
		this.tipo = "morcego";
		this.ataque = 4;
		this.velocidade = 20;
		this.vidaTotal = 20;
		this.vidaAtual = vidaTotal;
		
		this.rodadasMover = 7;
		this.rodadasAtacar = 15;
	}

}
