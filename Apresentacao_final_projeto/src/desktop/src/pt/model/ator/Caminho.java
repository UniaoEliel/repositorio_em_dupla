package pt.model.ator;

import java.util.ArrayList;

public class Caminho {
	char movimentoInicio;
	int tamanho;
	int xAtual, yAtual;
	
	protected Caminho(int xOrigem, int yOrigem) {
		movimentoInicio = '-';
		xAtual = xOrigem;
		yAtual = yOrigem;
		tamanho = 0;
		
	}
	
	protected int getTamanho() {
		return tamanho;
	}
	
	
	protected void inserirMovimento(char movimento) {
		
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
		if (movimentoInicio == '-')
			movimentoInicio = movimento;
		
		tamanho++;
	}
	
	
	protected char getPrimeiroMove() {
		return movimentoInicio;
	}
	
	
	protected int getX() {
		return xAtual;
	}
	
	
	protected int getY() {
		return yAtual;
	}
	
	
	protected Caminho clone() {
		Caminho clone = new Caminho(xAtual, yAtual);
		clone.movimentoInicio = movimentoInicio;
		clone.tamanho = tamanho;
		return clone;
	}
}
