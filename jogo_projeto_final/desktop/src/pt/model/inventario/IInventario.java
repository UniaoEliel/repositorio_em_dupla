package pt.model.inventario;

public interface IInventario extends IInventarioProperties, IRHeroi, IRCaverna {
	public void inserirItem(IItem item);
	
	public void removerItem(IItem item);
	
	/**
	 * Avisa os itens que uma rodada se passou.
	 */
	public void passarRodada();
	
	
	
}

