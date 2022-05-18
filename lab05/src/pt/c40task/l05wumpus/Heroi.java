package pt.c40task.l05wumpus;

import java.util.Random;

public class Heroi extends Componente {
	private boolean pegouOuro, vivo, ganhou, sentindoFedor, sentindoBrisa, vendoOuro;
	private int pontuacao,flecha;
	
	
	public Heroi(int x, int y, Caverna caverna) {
		super(x,y,caverna,"heroi");
		this.flecha = 0; // 0 = Não tentou equipar; 1 = Equipou; 2 = Ja equipou e perdeu 
		this.pegouOuro = false;
		this.pontuacao = 0;
		this.ganhou = false;
		this.sentindoFedor = false;
		this.sentindoBrisa = false;
		this.vendoOuro = false;
		this.vivo = true;
	}
	
	public void insereCaverna() {
		super.insereCaverna();
	}
	
	/**
	 * a partir do char de entrada, pede a caverna para que mova o heroi)
	 */
	public void mover(char direcao) {
		boolean moveu = false;
		if (direcao == 'w')
			moveu = this.caverna.mover(this, this.x - 1, this.y);
		
		else if(direcao == 's')
			moveu = this.caverna.mover(this, this.x + 1, this.y);
		
		else if(direcao == 'a')
			moveu = this.caverna.mover(this, this.x, this.y - 1);
		
		else if(direcao == 'd')
			moveu = this.caverna.mover(this, this.x, this.y + 1);
		
		if (moveu == true) {
			entraSala();
			if (this.flecha == 1) {
				this.flecha = 2;
				this.pontuacao -= 100;
			}
			caverna.tornarVisivel(x, y);
			pontuacao -= 15;
		}
	}
	
	
	public void equiparFlecha() {
		if (this.flecha == 0)
			this.flecha = 1;
	}

	
	public void pegarOuro() {
		if (this.vendoOuro) {
			this.pegouOuro = true;
			this.caverna.removerComponente("ouro", this.x,this.y);
			this.vendoOuro = false;
		}
	}
	
	
	public int getPontuacao() {
		return pontuacao;
	}

	
	/**
	 * primeiro verifica se o usuario ganhou. se não, pega os componentes
	 * da sala e faz as interações deles com o herói.
	 */
	public void entraSala(){
		sentindoFedor = false;
		sentindoBrisa = false;
		
		
		// se pegou o ouro e está na sala (1, 1)
		if (pegouOuro && this.x == 0 && this.y == 0) {
			this.ganhou = true;
			this.pontuacao += 1000;
		}
		else {
			String[] componentesSala = caverna.getComponentesSala(this.x,this.y);
			
			for (int i = 0; i < componentesSala.length; i++) {
				if (componentesSala[i].equals("wumpus")) {
					if (this.flecha == 1 && mataWumpus()) {
						caverna.remover("wumpus", this.x, this.y);
						pontuacao += 500; // por matar o wumpus
					}
					else {
						this.vivo = false;
						pontuacao -= 1000;
						break;
					}
				}
				
				else if (componentesSala[i].equals("buraco")) {
					this.vivo = false;
					pontuacao -= 1000;
					break;
				}
				
				else if (componentesSala[i].equals("brisa")) {
					sentindoBrisa = true;
				}
				
				else if (componentesSala[i].equals("fedor")) {
					sentindoFedor = true;
				}
				
				else if (componentesSala[i].equals("ouro")) {
					vendoOuro = true;
				}
			}
		}
	}
	
	/**
	 * Sorteia um numero entra 1 e 0, se for 1 o heroi mata, se for 2 ele morre
	 */
	public boolean mataWumpus() {
		Random sorte = new Random();
			if (sorte.nextInt(2) == 1) {
				return true;
			}
			else {
				return false;
			}
	}
	
	public boolean isVivo() {
		return vivo;
	}


	public boolean getGanhou() {
		return ganhou;
	}
	
	
	public boolean isSentindoFedor() {
		return sentindoFedor;
	}
	
	public boolean isSentindoBrisa() {
		return sentindoBrisa;
	}	
}