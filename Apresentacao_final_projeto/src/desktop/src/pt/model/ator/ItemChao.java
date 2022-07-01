package pt.model.ator;

import pt.model.inventario.IItem;
import pt.model.inventario.Tocha;

public class ItemChao extends AtorObjeto {
	IItem item;
	
	public ItemChao() {
		this.solido = false;
		this.velocidade = 0;
		this.orientacao = '-';
		this.tipo = "itemchao";
	}
	
	
	public void setItem(IItem item) {
		this.item = item;
	}
	
	
	@Override
	public void interagir(IHeroi heroi) {
		if (heroi.getNomeItemSelecionado().equals("tocha") && item.getNome().equals("graveto")) {
			ItemChao tochaChao = new ItemChao();
			
			Tocha tocha = new Tocha();
			tocha.connect(cave);
			tochaChao.setItem(tocha);
			tochaChao.setX(x);
			tochaChao.setY(y);
			
			tochaChao.connect(cave);
			
			cave.removerAtor(this, x, y);
		}
		else {
			heroi.receberItem(this.item);
			cave.removerAtor(this, x, y);
		}
	}
	
	
	@Override
	public void passarRodada() {
		item.passarRodada(x, y);
	}
	
	
	@Override
	public void entrouCelula() {
		item.entrouCelula(x, y);
	}
	
	
	@Override
	public void saiuCelula() {
		item.saiuCelula(x, y);
	}
	
	
	@Override
	public String getNomeRepresentacao() {
		return item.getNome();
	}
}
