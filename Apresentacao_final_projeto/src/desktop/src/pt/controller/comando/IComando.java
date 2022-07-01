package pt.controller.comando;

public interface IComando extends IRHeroiComando {
	public void lerComando();
	
	public boolean ganhou();
	
	
	public boolean perdeu();
}
