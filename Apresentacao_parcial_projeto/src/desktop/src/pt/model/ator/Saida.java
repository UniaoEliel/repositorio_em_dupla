package pt.model.ator;

public class Saida extends AtorObjeto {
	public Saida() {
		this.solido = true;
		this.orientacao = 's';
		this.tipo = "saida";
	}
	
	
	@Override
	public void entrouCelula() {
		cave.iluminarCelulas(x, y, 3);
	}
	
	@Override
	public void interagir(IHeroi heroi) {
		heroi.ganhar();
	}
}
