package pt.model.ator;

import pt.model.inventario.IInventarioProperties;

public interface IHeroiProperties {
	public int getVidaTotal();
	public int getVidaAtual();
	public void setVidaAtual(int NovaVida);
	
	public IInventarioProperties getInventario();
	
	
	public boolean isVivo();
	
	
	public boolean ganhou();
	
	public void setComandoAtual(char comandoAtual);
	
	public int getNumItem();
	
<<<<<<< HEAD
	public String getNomeItemSelecionado();
=======
	public int getAtaque();
	
	public void setAtaque(int novoAtaque);
>>>>>>> 208e8c6 (Cria espada einventario)
}
