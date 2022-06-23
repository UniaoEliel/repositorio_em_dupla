package pt.model.ator;

import pt.model.inventario.IInventarioProperties;

public interface IHeroiProperties {
	public int getVidaTotal();
	public int getVidaAtual();
	
	public IInventarioProperties getInventario();
	
	
	public boolean isVivo();
	
	
	public boolean ganhou();
	
	public void setComandoAtual(char comandoAtual);
	
	public int getNumItem();
}
