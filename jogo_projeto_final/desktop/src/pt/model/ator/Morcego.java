package pt.model.ator;

import pt.model.inventario.Graveto;
import pt.model.inventario.IItem;
import pt.model.inventario.PocaoVida;

public class Morcego extends AtorInimigo {
	
	public Morcego() {
		super();
		this.tipo = "morcego";
		this.ataque = 4;
		this.velocidade = 20;
		this.vidaTotal = 20;
		this.vidaAtual = vidaTotal;
		this.raioAlcance = 6;
		this.raioAtaque = 3;
		
		this.rodadasMover = 7;
		this.rodadasAtacar = 18;
	}
	
	
	
	
	public void receberAtaque(String nomeAtacante, int dano) {
		if (aleatorio.nextInt(100) <= 40)
			cave.inserirNoLog("Morcego desviou do ataque de " + nomeAtacante);
		else
			super.receberAtaque(nomeAtacante, dano);
	}
	
	
	private void ataqueAfastar(int x, int y) {
		int nx = this.x, ny = this.y;
		if (x < this.x)
			nx = this.x + 1;
		else if (x > this.x)
			nx = this.x - 1;
		
		if (y < this.y)
			ny = this.y + 1;
		else if (y > this.y)
			ny = this.y - 1;
		
		AtaquePadrao ataqueAfasta = new AtaquePadrao();
		ataqueAfasta.setDano(ataque * 2);
		AlertaAtaque alerta = gerarAlertaAtaque(ataqueAfasta, 7, x, y);
		alerta.connect(cave);
		mover(nx, ny);
		imobilizar(20);
	}
	
	
	protected void atacar(int x, int y) {
		if (podeAtacar()) {
			if (aleatorio.nextInt(100) <= 70)
				ataqueAfastar(x, y);
			else
				super.atacar(x, y);
		}
	}
	
	
	protected void droparItem() {
		IItem item = null;
		
		int ale = aleatorio.nextInt(100);
		
		if (ale <= 30)
			item = new Graveto();
		else if (ale <= 40)
			item = new PocaoVida();
		
		if (item != null)
			colocarItemChao(item, this.x, this.y);
	}

}
