package pt.model.ator;

public class AtaquePadrao extends AtorAtaque {
	private int dano;

	public AtaquePadrao() {
		super();
		this.tipo = "ataquepadrao";
	}
	
	
	public void entrouCelula() {
		IAtor[] atores = cave.getAtores(x, y);
		
		if (atores != null) {
			for (IAtor ator : atores) {
				ator.receberAtaque(autor, dano);
			}
		}
	}


	public void setDano(int dano) {
		this.dano = dano;
	}
}
