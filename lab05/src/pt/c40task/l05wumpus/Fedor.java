package pt.c40task.l05wumpus;

public class Fedor extends Componente {

	public Fedor(int x, int y, Caverna caverna) {
		super(x,y,caverna,"fedor");
	}
	
	public void insereCaverna() {
		caverna.inserirComponente(this,this.x + 1,this.y);
		caverna.inserirComponente(this,this.x - 1,this.y);
		caverna.inserirComponente(this,this.x,this.y + 1);
		caverna.inserirComponente(this,this.x ,this.y - 1);
		
	}
}
