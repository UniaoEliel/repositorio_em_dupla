package pt.model.ator;

import java.util.ArrayList;

public class Caminho {
	ArrayList<Character> movimentos;
	int xAtual, yAtual;
	
	protected Caminho(int xOrigem, int yOrigem) {
		movimentos = new ArrayList<Character>();
		xAtual = xOrigem;
		yAtual = yOrigem;
		
	}
	
	protected int getTamanho() {
		return movimentos.size();
	}
	
	
	protected void inserirMovimento(char movimento) {
		movimentos.add(movimento);
		
		switch (movimento) {
		case 'w':
			yAtual += 1;
			break;
		case 's':
			yAtual -= 1;
			break;
		case 'd':
			xAtual += 1;
			break;
		case 'a':
			xAtual -= 1;
			break;
		}
	}
	
	
	protected char[] getCaminho() {
		char[] caminho = new char[movimentos.size()];
		
		for (int i = 0; i < movimentos.size(); i++)
			caminho[i] = movimentos.get(i);

		return caminho;
	}
	
	
	protected int getX() {
		return xAtual;
	}
	
	
	protected int getY() {
		return yAtual;
	}
	
	
	protected Caminho clone() {
		Caminho clone = new Caminho(xAtual, yAtual);
		for (Character move : movimentos) {
			clone.movimentos.add(move);
		}
		return clone;
	}
}
