package pt.c40task.l05wumpus;

public class Wumpus extends Componente {

	public Wumpus(int x, int y, Caverna caverna) {
		super(x,y,caverna,"wumpus");
	}
	
	public void insereCaverna() {
		super.insereCaverna();
		insereFedor();
	}
	
	
	public void removeCaverna() {
		super.removeCaverna();
		removeFedor();
	}
	
	private void insereFedor() {
		Componente fedorWumpus = new Fedor(x - 1, y, caverna);
		fedorWumpus.insereCaverna();

		fedorWumpus = new Fedor(x + 1, y, caverna);
		fedorWumpus.insereCaverna();

		fedorWumpus = new Fedor(x, y - 1, caverna);
		fedorWumpus.insereCaverna();

		fedorWumpus = new Fedor(x, y + 1, caverna);
		fedorWumpus.insereCaverna();
	}
	
	
	private void removeFedor() {
		caverna.remover("fedor", x + 1, y);
		caverna.remover("fedor", x - 1, y);
		caverna.remover("fedor", x, y + 1);
		caverna.remover("fedor", x, y - 1);
	}


	public void teste() {
		caverna.remover("fedor", x, y + 1);
	}
}