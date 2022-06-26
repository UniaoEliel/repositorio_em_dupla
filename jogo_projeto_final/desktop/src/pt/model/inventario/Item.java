package pt.model.inventario;

import pt.model.ator.IHeroi;
import pt.model.caverna.ICaverna;

public abstract class Item implements IItem {
	protected IHeroi heroi;
	protected ICaverna cave;
	protected Inventario inventario;
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
	
	public void passarRodada(int x, int y) {
	}
	
	public void entrouCelula(int x, int y) {
	}
	
	public void saiuCelula(int x, int y) {
	}
	
	public void entrouCelula() {
	}
	
	public void saiuCelula() {	
	}
	
	public void usar() {
	}
	
	public void equipar() {
		entrouCelula();
	}
	
	public void desequipar() {
		saiuCelula();
	}
	
	
	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}
	
	public String getNome() {
		return this.nome;
	}
}
