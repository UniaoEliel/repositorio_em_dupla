package pt.model.ator;

public class Goblin extends AtorInimigo {
	public Goblin() {
		super();
		this.ataque = 5;
		this.vidaTotal = 18;
		this.vidaAtual = vidaTotal;
		
		this.rodadasAtacar = 3;
		this.rodadasMover = 3;
		
		this.tipo = "goblin";
		
	}
}
