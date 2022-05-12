package pt.c40task.l05wumpus;

public class Caverna {
	private Sala salas[][];
	private int tamX, tamY;
	
	
	public Caverna(int tamX, int tamY) {
		
	}
	
	public boolean checarValidadePosicao(int x, int y) {
		// retorna se a posicao e valida
	}
	
	public void inserirComponente(Componente comp, int x, int y) {
		// pede pra sala inserir
	}
	
	
	public void removerComponente(char comp, int x, int y) {
		// pede pra sala remover
	}
	
	
	public void mover(Componente comp, int novox, int novoy) {
		// pede pra retirar da sala atual
		// pede pra inserir na sala destino
	}
}
