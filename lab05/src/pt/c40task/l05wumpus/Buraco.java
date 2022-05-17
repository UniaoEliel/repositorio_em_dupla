package pt.c40task.l05wumpus;

public class Buraco extends Componente {

	public Buraco(int x, int y, Caverna caverna) {
		super(x, y, caverna,"buraco");
	}
	
	
	public void insereCaverna() {
		caverna.inserirComponente(this,this.x,this.y);
		
	}
	
	
	public void insereBrisa() {
		Brisa brisaBuraco = new Brisa(x,y,caverna);
		brisaBuraco.insereCaverna();
	}
}

	
	

