package pt.c40task.l05wumpus;

public class Wumpus extends Componente {
	
	private boolean vida;
	
	public Wumpus(int x, int y, Caverna caverna) {
		super(x,y,caverna,"wumpus");
		this.vida = true;
	}
	
	public void insereCaverna() {
		caverna.inserirComponente(this,this.x,this.y);
		
	}
	
	public void insereFedor() {
		Fedor fedorWumpus = new Fedor(x,y,caverna);
		fedorWumpus.insereCaverna();
	}
}
