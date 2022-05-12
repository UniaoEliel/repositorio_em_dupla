package pt.c40task.l05wumpus;

public class Heroi extends Componente {
	private boolean flecha, pegouOuro;
	private int pontuacao;
	
	
	public Heroi(int x, int y, Caverna caverna) {
		super(x,y,caverna,"Heroi");
	}
	
	public void mover(char direcao) {
		if (direcao == 'w')
			this.caverna.mover(this, this.x, this.y + 1);
		
		else if(direcao == 's')
			this.caverna.mover(this, this.x, this.y - 1);
		
		else if(direcao == 'a')
			this.caverna.mover(this, this.x - 1, this.y);
		
		else if(direcao == 'd')
			this.caverna.mover(this, this.x + 1, this.y);
		// solicita a caverna o movimento
	}
	
	
	public void equiparFlecha() {
		
	}

	
	public void pegarOuro() {
		
	}
}
