package pt.model.ator;

import pt.model.caverna.IAcessoCelulas;

public abstract class Ator implements IAtor {
	protected int x, y;
	protected String tipo;
	protected boolean solido;
	

	
	
	protected char orientacao;
	protected IAcessoCelulas cave;
	
	public Ator() {
		
	}
	
	
	public abstract void connect(IAcessoCelulas cave);
	
	
	public String getTipo() {
		return tipo;
	}


	public char getOrientacao() {
		return orientacao;
	}
	
	public boolean isSolido() {
		return solido;
	}
	public int getX() {
		return this.x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return this.y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
