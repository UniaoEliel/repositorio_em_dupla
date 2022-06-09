package pt.model.caverna;

import pt.model.ator.IAtorObjeto;
import pt.model.ator.IAtorVivo;

public interface ICaverna extends ICavernaProperties, IRViewCaverna, IAcessoCelulas {
	public void start();
	
	public void inserirAtorVivo(IAtorVivo a, int x, int y);
	
	public void removerAtorVivo(IAtorVivo a, int x, int y);
	
	public void inserirAtorObjeto(IAtorObjeto a, int x, int y);
	
	public void removerAtorObjeto(IAtorObjeto a, int x, int y);
}
