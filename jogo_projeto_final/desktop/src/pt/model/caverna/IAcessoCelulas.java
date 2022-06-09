package pt.model.caverna;

import pt.model.ator.*;

public interface IAcessoCelulas {
	public void inserirAtor(Ator a, int x, int y);
	
	public void removerAtor(Ator a, int x, int y);
	
	public void moverAtor(Ator a, int novox, int novoy);
	
	public AtorVivo getAtoresVivos(int x, int y);
	
	public AtorObjeto getAtoresObjeto(int x, int y);
}
