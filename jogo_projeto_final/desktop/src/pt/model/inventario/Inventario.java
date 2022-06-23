package pt.model.inventario;

public class Inventario implements IInventario {
	private int tamanho;
	
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int getTamanho() {
		return 7;
	}
	@Override
	public IItem getItem(int posicao) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getQuantidadeItens() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public void setTamanho() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void inserirItem(IItem item) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void removerItem(IItem item) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void passarRodada() {
		// TODO Auto-generated method stub
		
	}
}
