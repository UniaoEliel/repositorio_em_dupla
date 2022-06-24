package pt.model.ator;

import pt.model.inventario.Espada;
import pt.model.inventario.IItem;
import pt.model.inventario.PocaoVida;
import pt.model.inventario.Tocha;

public class Bau extends AtorObjeto {
	private boolean aberto;
	private IItem item;
	
	public Bau() {
		super();
		aberto = false;
		item = gerarItemAleatorio();
		orientacao = '-';
		solido = true;
	}
	
	
	private IItem gerarItemAleatorio() {
		int possib = aleatorio.nextInt(100);
		IItem item;
		
		if (possib <= 50) 
			item = new PocaoVida();
		else if (possib <= 90)
			item = new Tocha();
		else
			item = new Espada();
		
		return item;
	}
	
	
	public void interagir(IHeroi heroi) {
		if (!aberto) {
			heroi.receberItem(this.item);
			aberto = true;
		}
	}
	
	
	public String getNomeRepresentacao() {
		String nome = "bau";
		if (aberto)
			nome += "aberto";
		
		return nome;
	}
}
