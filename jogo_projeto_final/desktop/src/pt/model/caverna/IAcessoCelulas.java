package pt.model.caverna;

import java.util.ArrayList;
import java.util.Map;

import pt.model.ator.*;

public interface IAcessoCelulas {
	public void inserirAtor(IAtor a, int x, int y);
	
	public void removerAtor(IAtor a, int x, int y);
	
	public void moverAtor(IAtor a, int novox, int novoy);
	
	public void somaIluminacao(int iluminacao, int x, int y);
	
	public int getIluminacao(int x, int y);
	
	
	/**
	 * Ilumina as celulas em um circulo ao redor de (x, y)
	 * 
	 * @param x x do centro do circulo
	 * @param y y do centro do circulo
	 * @param raio raio do circulo
	 */
	public void iluminarCelulas(int x, int y, int raio);
	
	/**
	 * Retira a luz das celulas em um circulo ao redor de (x, y)
	 * 
	 * @param x x do centro do circulo
	 * @param y y do centro do circulo
	 * @param raio raio do circulo
	 */
	public void desiluminarCelulas(int x, int y, int raio);
	
	/**
	 * Avisa todos os componentes da caverna, na ordem do mais rápido
	 * para o mais lento, que uma rodada passou.
	 */
	public void passarRodada();

	
	/**
	 * 
	 * @param x x da celula
	 * @param y y da celula
	 * @return a lista com os atores na celula
	 */
	public ArrayList<IAtor> getAtores(int x, int y);

	
	/**
	 * 
	 * @param x x da celula
	 * @param y y da celula
	 * @return se a celula está dentro da caverna
	 */
	public boolean verificaValidade(int x, int y);
	
	
	/**
	 * insere no log da rodada
	 * @param acontecimento o que aconteceu
	 */
	public void inserirNoLog(String acontecimento);
}
