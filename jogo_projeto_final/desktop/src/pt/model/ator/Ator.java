package pt.model.ator;

import pt.model.caverna.IAcessoCelulas;

/**
 * Define um ator da caverna
 * @author elias
 *
 */
public abstract class Ator implements IAtor {
	protected int x, y;
	protected String tipo;
	protected boolean solido;
	

	
	
	protected char orientacao;
	protected IAcessoCelulas cave;
	
	protected int velocidade;
	
	public Ator() {
		velocidade = 0;
	}
	
	
	public abstract void connect(IAcessoCelulas cave);
	
	
	public String getTipo() {
		return tipo;
	}

	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public char getOrientacao() {
		return orientacao;
	}

	
	public void setOrientacao(char orientacao) {
		this.orientacao = orientacao;
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
	
	
	public int getVelocidade() {
		return velocidade;
	}
	

	public void entrouCelula() {
	}

	
	public void saiuCelula() {
	}
	
	
	public void passarRodada() {
	}
}
