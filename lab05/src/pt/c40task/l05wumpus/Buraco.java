package pt.c40task.l05wumpus;

public class Buraco extends Componente {

	public Buraco(int x, int y, Caverna caverna) {
		super(x, y, caverna,"buraco");
	}
	
	
	public void insereCaverna() {
		super.insereCaverna();
		insereBrisa();
	}
	
	
	public void insereBrisa() {
		Componente brisaBuraco = new Brisa(x - 1, y, caverna);
		brisaBuraco.insereCaverna();

		brisaBuraco = new Brisa(x + 1, y, caverna);
		brisaBuraco.insereCaverna();

		brisaBuraco = new Brisa(x, y - 1, caverna);
		brisaBuraco.insereCaverna();

		brisaBuraco = new Brisa(x, y + 1, caverna);
		brisaBuraco.insereCaverna();
	}
}

	
	

