package pt.model.ator;

import pt.model.inventario.Graveto;
import pt.model.inventario.IItem;
import pt.model.inventario.PocaoVida;

public class Aranha extends AtorInimigo {
	private int countPocaVenenosa, countTeia;
	
	public Aranha() {
		super();
		this.ataque = 12;
		this.vidaTotal = 25;
		this.defesa = 4;
		this.vidaAtual = this.vidaTotal;
		this.velocidade = 10;
		this.raioAlcance = 2;
		
		this.rodadasMover = 9;
		this.rodadasAtacar = 25;
		
		this.raioAlcance = 7;
		this.raioAtaque = 3;
		
		this.tipo = "aranha";
		
		countPocaVenenosa = 50;
		countTeia = 30;
	}
	
	
	private void pocaVenenosa(int x, int y) {
		Veneno veneno = new Veneno();
		veneno.setDuracao(50);
		AlertaAtaque alerta = gerarAlertaAtaque(veneno, 5, x, y);
		alerta.connect(cave);
		
		veneno = new Veneno();
		veneno.setDuracao(50);
		alerta = gerarAlertaAtaque(veneno, 10, x - 1, y);
		alerta.connect(cave);
		
		veneno = new Veneno();
		veneno.setDuracao(50);
		alerta = gerarAlertaAtaque(veneno, 10, x + 1, y);
		alerta.connect(cave);
		
		veneno = new Veneno();
		veneno.setDuracao(50);
		alerta = gerarAlertaAtaque(veneno, 10, x, y - 1);
		alerta.connect(cave);
		
		veneno = new Veneno();
		veneno.setDuracao(50);
		alerta = gerarAlertaAtaque(veneno, 10, x, y + 1);
		alerta.connect(cave);
		
		countAtacar = rodadasAtacar;
		imobilizar(10);
	}
	
	
	private void lancarTeia(int x, int y) {
		Teia teia = new Teia();
		
		teia.setDuracao(15);
		AlertaAtaque alerta = gerarAlertaAtaque(teia, 5, x, y);
		alerta.connect(cave);
		
		imobilizar(10);
		
	}

	@Override
	public void atacar(int x, int y) {
		if (podeAtacar()) {
			int ale = aleatorio.nextInt(100);
			if (countPocaVenenosa == 0 && ale <= 30) 
				pocaVenenosa(x, y);
			else if (countTeia == 0 && ale >= 30 && ale <= 50) 
				lancarTeia(x, y);
			else if (cave.distanciaQuadrado(x, y, this.x, this.y) < 4)
				super.atacar(x, y);
			else if (podeMover()) {
				seMoverEmDirecaoA(x, y);
				countMover = rodadasMover;
			}
		}
	}
	
	
	@Override
	public void passarRodada() {
		super.passarRodada();
		if (countPocaVenenosa > 0)
			countPocaVenenosa--;
		if (countTeia > 0)
			countTeia--;
	}


	@Override
	protected void droparItem() {
		IItem item = null;
		
		int ale = aleatorio.nextInt(100);
		
		if (ale <= 50)
			item = new Graveto();
		else if (ale <= 70)
			item = new PocaoVida();
		
		if (item != null)
			colocarItemChao(item, this.x, this.y);
	}
}
