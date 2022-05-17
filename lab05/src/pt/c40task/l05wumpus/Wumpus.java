package pt.c40task.l05wumpus;

public class Wumpus extends Componente {
	
	private boolean vida;
	
	public Wumpus(int x, int y, Caverna caverna) {
		super(x,y,caverna,"wumpus");
		this.vida = true;
	}
	
	public void insereCaverna() {
		caverna.inserirComponente(this,this.x,this.y);
		insereFedor();
	}
	
	public void insereFedor() {
		Componente fedorWumpus = new Fedor(x - 1, y, caverna);
		fedorWumpus.insereCaverna();

		fedorWumpus = new Fedor(x + 1, y, caverna);
		fedorWumpus.insereCaverna();

		fedorWumpus = new Fedor(x, y - 1, caverna);
		fedorWumpus.insereCaverna();

		fedorWumpus = new Fedor(x, y + 1, caverna);
		fedorWumpus.insereCaverna();
	}
}
