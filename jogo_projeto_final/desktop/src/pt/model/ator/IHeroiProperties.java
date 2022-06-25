package pt.model.ator;

import pt.model.inventario.IInventarioProperties;
import pt.model.inventario.IItem;

public interface IHeroiProperties {
	public int getVidaTotal();
	public int getVidaAtual();
	public void setVidaAtual(int NovaVida);
	
	public IInventarioProperties getInventario();
	
	
	public boolean isVivo();
	
	
	public boolean ganhou();
	
	public void setComandoAtual(char comandoAtual);
	
	public int getNumItem();
	
	public String getNomeItemSelecionado();

	public int getAtaque();
	
	public void setpossuiEspada(boolean x);
	
	public void setAtaque(int novoAtaque);

	public void receberItem(IItem item);
}
