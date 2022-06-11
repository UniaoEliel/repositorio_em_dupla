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

	
	public Map<String, IAtorVivo> getAtoresVivos(int x, int y);
	
	public Map<String, IAtorObjeto> getAtoresObjeto(int x, int y);
	
	public boolean verificaValidade(int x, int y);
}
