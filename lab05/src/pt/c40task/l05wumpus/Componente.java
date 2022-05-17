package pt.c40task.l05wumpus;

public abstract class Componente {
	protected String tipoComponente;
	protected Caverna caverna;
	protected int x, y;
	
	public Componente(int x, int y, Caverna caverna, String tipoComponente) {
		this.x = x;
		this.y = y;
		this.caverna = caverna;
		this.tipoComponente = tipoComponente;
		// instancia os atributos gerais
	}
	

	public void insereCaverna() {
		caverna.inserirComponente(this, x, y);
	}
	

	public int getX() {
		return x;
	}
	
	
	public void setX(int x) {
		this.x = x;
	}
	
	
	public int getY() {
		return y;
	}
	
	
	public void setY(int y) {
		this.y = y;
	}
	
	
	public String getTipoComponente() {
		return tipoComponente;
	}
}
