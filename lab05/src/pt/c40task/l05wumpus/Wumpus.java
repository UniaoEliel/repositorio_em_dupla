package pt.c40task.l05wumpus;

public class Wumpus extends Componente {

	
	public Wumpus(int x, int y, Caverna caverna) {
		super(x,y,caverna,"wumpus");
	}
	
	public void insereCaverna() {
		caverna.inserirComponente(this,this.x,this.y);
		
	}
	
	public void insereFedor() {
		
	}
}
