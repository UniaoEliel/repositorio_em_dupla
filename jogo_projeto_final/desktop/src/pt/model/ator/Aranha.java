package pt.model.ator;

public class Aranha extends AtorInimigo {
	
	public Aranha() {
		super();
		this.ataque = 15;
		this.vidaTotal = 30;
		this.vidaAtual = this.vidaTotal;
		this.velocidade = 10;
		this.raioAlcance = 2;
		
		this.rodadasMover = 9;
		this.rodadasAtacar = 20;
		
		this.tipo = "aranha";
	}

	

}
