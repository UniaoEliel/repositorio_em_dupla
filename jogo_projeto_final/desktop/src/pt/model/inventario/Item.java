package pt.model.inventario;

import pt.model.ator.IHeroi;
import pt.model.caverna.ICaverna;

public abstract class Item implements IItem {
	protected IHeroi heroi;
	protected ICaverna cave;
	protected int durabilidadeTotal, durabilidadeAtual;
	protected String nome;

	
	public void connect(ICaverna caverna) {
		this.cave = caverna;	
	}
	
	public void connect(IHeroi heroi) {
		this.heroi = heroi;
	}

	public void passarRodada() {
	}
	
	public void entrouCelula() {
	}
	
	public void saiuCelula() {	
	}
	
	public void usar() {
	}
}
