package pt.model.inventario;

import java.util.*;

import pt.model.ator.IHeroi;
import pt.model.caverna.IAcessoCelulas;
import pt.model.caverna.ICaverna;

public class Inventario implements IInventario {
	private int tamanho;
	private IItem[] itens;
	private IHeroi heroi;
	private IAcessoCelulas caverna;
	
	public Inventario() {
	}
	
	
	public void setTamanho(int tamanho) {
		this.tamanho = tamanho;
		itens = new IItem[tamanho];
		for (int i = 0; i < 7; i++)
			itens[i] = null;
	}
	public int getTamanho() {
		return 7;
	}
	
	
	public IItem getItem(int posicao) {
		return itens[posicao - 1];
	}
	
	public int getQuantidadeItens() {
		int quant = 0;

		for (IItem item : itens) {
			if (item != null)
				quant++;
		}
		
		return quant;
	}

	
	public void inserirItem(IItem item) {
		for (int i = 0; i < itens.length; i++)
			if (itens[i] == null) {
				itens[i] = item;
				item.connect(heroi);
				item.connect(caverna);
				item.setInventario(this);
				break;
			}
	}
	
	
	public void connect(IHeroi heroi) {
		this.heroi = heroi;
	}
	
	public void removerItem(IItem item) {
		for (int i = 0; i < itens.length; i++)
			if (itens[i] == item)
				itens[i] = null;
	}
	
	public void passarRodada() {
		for (IItem item : itens) {
			if (item != null)
				item.passarRodada();
		}
	}


	@Override
	public String getNomeItem(int indice) {
		String nome = "nada";
		
		if (itens[indice - 1] != null)
			nome = itens[indice - 1].getNome();
		
		return nome;
	}


	public void connect(IAcessoCelulas caverna) {
		this.caverna = caverna;
		for (IItem item : itens) {
			if (item != null)
				item.connect(caverna);
		}
	}
		
}

