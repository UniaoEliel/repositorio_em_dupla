package pt.model.ator;

import pt.model.caverna.IAcessoCelulas;

public abstract class Ator implements IAtor {
	private int x, y;
	private String tipo;
	

	
	
	private char orientacao;
	private IAcessoCelulas cave;
	
	
	public void connect(IAcessoCelulas cave) {
		this.cave = cave;
		cave.inserirAtor(this, x, y);
	}
	
	
	public String getTipo() {
		return tipo;
	}


	public char getOrientacao() {
		return orientacao;
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
