package pt.model.ator;

public class Velho extends AtorVivo {
	private int xSaida, ySaida;
	private int xAlvo, yAlvo;
	private boolean indoSaida;
	private int countReinicio;
	
	public Velho() {
		xSaida = 49;
		ySaida = 25;
		indoSaida = false;
		this.solido = true;
		
		vidaAtual = 10000;
		
		tipo = "velho";
		
		rodadasMover = 10;
		countMover = rodadasMover;
		countReinicio = 0;
	}
	
	
	public void interagir(IHeroi heroi) {
		if (!indoSaida) {
			cave.inserirNoLog("Velho: Venha, vou te levar a saída");
			indoSaida = true;
		}
	}
	
	
	public void passarRodada() {
		if (indoSaida && podeMover()) {
			if (countReinicio == 0) {
				reniciaAlvo();
				countReinicio = 6;
			}
			else
				countReinicio--;
			seMoverEmDirecaoA(xAlvo, yAlvo);
		} else if (podeMover()) {
			if (aleatorio.nextInt(100) < 40)
				movimentoAleatorio();
		} else
			super.passarRodada();
	}
	
	
	private void reniciaAlvo() {
		if (x < xSaida) {
			xAlvo = Math.min(x + 3, x + xSaida);
		} else if (x > xSaida) {
			xAlvo = Math.min(x - 3, x - xSaida);
		} else if (y < ySaida) {
			yAlvo = Math.min(y - 3, y - ySaida);
		} else if (y > ySaida) {
			yAlvo = Math.min(y + 3, y + ySaida);
		}
	}
}
