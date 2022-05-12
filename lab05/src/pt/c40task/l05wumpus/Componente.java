package pt.c40task.l05wumpus;

public abstract class Componente {
	protected String tipoComponente;
	protected Caverna caverna;
	protected int x, y;
	
	public Componente(int x, int y, Caverna caverna, String tipoComponente) {
		// instancia os atributos gerais
	}
	
	public abstract void insereCaverna();
	
	public int getX() {
		return x;
	}
	
	
	public void setX(int x) {
		
	}
	
	
	public int getY() {
		return y;
	}
	
	
	public void setY(int y) {
		
	}
	
	
	public String getTipoComponente() {
		return tipoComponente;
	}
}
