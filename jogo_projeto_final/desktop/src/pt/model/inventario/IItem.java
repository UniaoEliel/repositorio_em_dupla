package pt.model.inventario;

public interface IItem extends IRHeroi, IRCaverna {
	public String getNome();
	
	public void passarRodada();
	
	public void entrouCelula();
	
	public void saiuCelula();
	
	public void usar();
	
	public void equipar();
	
	public void desequipar();
	
	
	public String getNome();
}
	
