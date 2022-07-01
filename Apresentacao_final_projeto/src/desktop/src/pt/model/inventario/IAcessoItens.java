package pt.model.inventario;

public interface IAcessoItens {
	public void inserirItem(IItem item);
	
	public void removerItem(IItem item);
	
	/**
	 * Avisa os itens que uma rodada se passou.
	 */
	public void passarRodada();
	
	public IItem getItem(int posicao);
	
	public String getNomeItem(int indice);
}
