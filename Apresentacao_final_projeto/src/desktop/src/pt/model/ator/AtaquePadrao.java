package pt.model.ator;

public class AtaquePadrao extends AtorAtaque {
	private int dano;

	public AtaquePadrao() {
		super();
		this.tipo = "ataquepadrao";
	}
	
	
	public void entrouCelula() {
		atacar(dano);
	}


	public void setDano(int dano) {
		this.dano = dano;
	}
}
