package pt.model.caverna;

import java.util.Map;

import pt.model.ator.*;

public interface IAcessoCelulas {
	public void inserirAtor(IAtorVivo a, int x, int y);
	
	public void inserirAtor(IAtorObjeto a, int x, int y);

	
	public void removerAtor(IAtorVivo a, int x, int y);
	
	public void removerAtor(IAtorObjeto a, int x, int y);
	
	
	public void moverAtor(IAtorVivo a, int novox, int novoy);
	
	public void moverAtor(IAtorObjeto a, int novox, int novoy);
	
	
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

	
	public Map<String, IAtorVivo> getAtoresVivos(int x, int y);
	
	public Map<String, IAtorObjeto> getAtoresObjeto(int x, int y);
	
	public boolean verificaValidade(int x, int y);
}
