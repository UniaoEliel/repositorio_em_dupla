package pt.model.ator;

public class Goblin extends AtorInimigo {
	private int countGiro, countInvestida;

	public Goblin() {
		super();
		this.ataque = 5;
		this.vidaTotal = 18;
		this.vidaAtual = vidaTotal;
		
		this.rodadasAtacar = 12;
		this.rodadasMover = 3;
		
		this.tipo = "goblin";
		
		// em quantas rodadas pode dar o giro
		countGiro = 50;
		
		countInvestida = 60;
	}
	
	
	private void giro() {
		for (int i = x - 1; i <= x + 1; i++)
			for (int j = y - 1; j <= y + 1; j++) {
				if (!(i == x && j == y)) {
					AtaquePadrao giro = new AtaquePadrao();
					giro.setDano(ataque * 2);
					AlertaAtaque alerta = gerarAlertaAtaque(giro, 2 * ataque, 20, i, j);
					alerta.connect(cave);
				}
			}
		countGiro = 50;
		countImobilizado = 25;

		countAtacar = rodadasAtacar;
	}
	
	
	private void investida(int x, int y) {
		if (x == this.x) {
			if (y < this.y) {
				for (int i = y; i >= y - 2; i--) {
					AtaquePadrao giro = new AtaquePadrao();
					giro.setDano(ataque * 2);
					AlertaAtaque alerta = gerarAlertaAtaque(giro, 2 * ataque, 10, this.x, i);
					
					alerta.connect(cave);
				}
			} else {
				for (int i = y; i <= y + 2; i++) {
					AtaquePadrao giro = new AtaquePadrao();
					giro.setDano(ataque * 2);
					AlertaAtaque alerta = gerarAlertaAtaque(giro, 2 * ataque, 10, this.x, i);
					
					alerta.connect(cave);
				}
			}
			countInvestida = 60;
			countAtacar = rodadasAtacar;
			countImobilizado = 15;
				
		}
		
		if (y == this.y) {
			if (x < this.x) {
				for (int i = x; i >= x - 2; i--) {
					AtaquePadrao giro = new AtaquePadrao();
					giro.setDano(ataque * 2);
					AlertaAtaque alerta = gerarAlertaAtaque(giro, 2 * ataque, 10, i, y);
					
					alerta.connect(cave);
				}
			}
			else {
				for (int i = x; i <= x + 2; i++) {
					AtaquePadrao giro = new AtaquePadrao();
					giro.setDano(ataque * 2);
					AlertaAtaque alerta = gerarAlertaAtaque(giro, 2 * ataque, 10, i, y);
					
					alerta.connect(cave);
				}
			}
			countInvestida = 60;
			countAtacar = rodadasAtacar;
			countImobilizado = 15;
		}
}

	
	
	protected void atacar(int x, int y) {
		if (podeAtacar()) {
			int ale = aleatorio.nextInt(100);
			if (ale <= 20 && countGiro == 0) {
				giro();
			} else if (ale <= 1000 && countInvestida == 0) {
				investida(x, y);
			}
			else
				super.atacar(x, y);
		}
	}
	
	public void passarRodada() {
		super.passarRodada();
		if (countGiro > 0)
			countGiro--;
		if (countInvestida > 0)
			countInvestida--;
	}
}
