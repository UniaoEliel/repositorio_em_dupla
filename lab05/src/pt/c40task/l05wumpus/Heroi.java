package pt.c40task.l05wumpus;

public class Heroi extends Componente {
	private boolean pegouOuro, vida;
	private int pontuacao,flecha;
	
	
	public Heroi(int x, int y, Caverna caverna) {
		super(x,y,caverna,"heroi");
		this.flecha = 0; // 0 = Não tentou equipar; 1 = Equipou; 2 = Ja equipou e perdeu 
		this.pegouOuro = false;
		this.pontuacao = 0;
	}
	
	public void insereCaverna() {
		super.insereCaverna();
	}
	
	public void mover(char direcao) {
		boolean moveu = false;
		if (direcao == 'w')
			moveu = this.caverna.mover(this, this.x - 1, this.y);
		
		else if(direcao == 's')
			moveu = this.caverna.mover(this, this.x + 1, this.y);
		
		else if(direcao == 'a')
			moveu = this.caverna.mover(this, this.x, this.y - 1);
		
		else if(direcao == 'd')
			moveu = this.caverna.mover(this, this.x, this.y + 1);
		
		if (moveu == true) {
			if (this.flecha == 1)
				this.flecha = 2;
			caverna.tornarVisivel(x, y);
		}
		// solicita a caverna o movimento
	}
	
	
	public void equiparFlecha() {
		if (this.flecha == 0)
			this.flecha = 1;
	}

	
	public void pegarOuro() {
		
		this.pegouOuro = true;
		this.caverna.removerComponente("ouro", this.x,this.y);
	}
	
	
	public int getPontuacao() {
		return pontuacao;
	}
}
