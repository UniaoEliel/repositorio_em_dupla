package pt.model.inventario;

public interface IInventarioProperties {
	public IItem getItem(int posicao);
	
	public int getQuantidadeItens();
	
	public int getTamanho();
	
	public void setTamanho(int tamanho);
	
	public void setTamanho();
	
	
}
