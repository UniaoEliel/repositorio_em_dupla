package pt.model.caverna;

import java.util.Map;

import pt.model.ator.*;

public interface IAcessoCelulas {
	public void inserirAtorVivo(IAtorVivo a, int x, int y);
	
	public void removerAtorVivo(IAtorVivo a, int x, int y);
	
	public void inserirAtorObjeto(IAtorObjeto a, int x, int y);
	
	
	public void removerAtorObjeto(IAtorObjeto a, int x, int y);
	
	
	public void moverAtorVivo(IAtorVivo a, int novox, int novoy);
	
	public void moverAtorObjeto(IAtorObjeto a, int novox, int novoy);
	
	public Map<String, IAtorVivo> getAtoresVivos(int x, int y);
	
	public Map<String, IAtorObjeto> getAtoresObjeto(int x, int y);
	
	public boolean verificaValidade(int x, int y);
}
