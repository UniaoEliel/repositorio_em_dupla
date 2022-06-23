package pt.model.ator;


import java.util.Random;

import pt.model.caverna.IAcessoCelulas;
import pt.model.caverna.ICaverna;

/**
 * Define um ator da caverna
 * @author elias
 *
 */
public abstract class Ator implements IAtor {
	protected static Random aleatorio = new Random();
	
	protected int x, y;
	protected String tipo;
	protected boolean solido;
	
	

	
	
	protected char orientacao;
	protected ICaverna cave;
	
	protected int velocidade;
	
	public Ator() {
		velocidade = 0;
	}
	
	
	public String getNomeRepresentacao() {
		String representacao = tipo;
		
		if (orientacao != '-')
			representacao += "_" + orientacao;
		
		return representacao;
	}
	
	
	public void connect(ICaverna cave) {
		this.cave = cave;
		cave.inserirAtor(this, x, y);
	}
	
	
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
	
	
	public void receberAtaque(int nomeAtacante, int dano) {
	}
}
