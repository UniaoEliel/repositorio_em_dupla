package pt.model.caverna;

import java.util.Map;

import pt.model.ator.*;

public interface IAcessoCelulas {
	public void inserirAtor(IAtor a, int x, int y);
	
	public void removerAtor(IAtor a, int x, int y);
	
	public void moverAtor(IAtor a, int novox, int novoy);
	
	public Map<String, IAtorVivo> getAtoresVivos(int x, int y);
	
	public Map<String, IAtorObjeto> getAtoresObjeto(int x, int y);
	
	public boolean verificaValidade(int x, int y);
}
