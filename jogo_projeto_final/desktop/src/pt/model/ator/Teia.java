package pt.model.ator;

public class Teia extends AtorAtaque {
	
	public Teia() {
		super();
		this.tipo = "ataqueteia";
	}
	
	@Override
	public void entrouCelula() {
		IAtor[] atores = cave.getAtores(x, y);
		
		if (atores != null) {
			for (IAtor ator : atores) {
				if (!ator.getTipo().equals("aranha"))
					ator.imobilizar(this.duracao);
			}
		}
	}
}
