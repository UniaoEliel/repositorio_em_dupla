package pt.model.ator;

public class Veneno extends AtorAtaque {
	private int rodadasDano, countDano, dano;
	
	public Veneno() {
		super();
		rodadasDano = 10;
		countDano = rodadasDano;
		tipo = "ataqueveneno";
		dano = 5;
	}
	
	
	public void atacar() {
		IAtor[] atores = cave.getAtores(x, y);
		
		if (atores != null) {
			for (IAtor ator : atores) {
				if (!ator.getTipo().equals("aranha"))
					ator.receberAtaque("veneno", dano);
			}
		}
	}
	
	public void passarRodada() {
		super.passarRodada();
		if (countDano == 0) {
			atacar();
			countDano = rodadasDano;
		} else
			countDano--;
	}
}
