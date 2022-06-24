package pt.model.inventario;

import java.util.*;

public class Inventario implements IInventario {
	private int tamanho;
	private ArrayList <IItem> itens;
	
	public Inventario() {
		itens = new ArrayList<IItem>();
	}
	
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
	}
	public int getTamanho() {
		return 7;
	}
	
	
	public IItem getItem(int posicao) {
		return itens.get(posicao - 1);
	}
	
	public int getQuantidadeItens() {
		return itens.size();
	}

	
	public void inserirItem(IItem item) {
		if (this.getQuantidadeItens() < 7) {
			itens.add(item);
		}	
	}
	
	
	public void removerItem(IItem item) {
		itens.remove(item); 
	}
	
	public void passarRodada() {
		Iterator<IItem> iterate = itens.iterator();
		
	    while(iterate.hasNext()){
	    	
	      IItem element = iterate.next();
	      element.passarRodada();	
	    }
	}
		
}

