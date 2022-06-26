package pt.model.inventario;

public interface IItem extends IRHeroi, IRCaverna {
	public String getNome();
	
	public void passarRodada();
	
	public void passarRodada(int x, int y);
	
	public void entrouCelula();
	
	public void entrouCelula(int x, int y);
	
	public void saiuCelula(int x, int y);
	
	public void saiuCelula();
	
	public void usar();
	
	public void equipar();
	
	public void desequipar();
	
	
	public void setInventario(Inventario inventario);
}
	
