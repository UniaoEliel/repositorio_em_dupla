package pt.c40task.l05wumpus;

import java.util.Scanner;

public class Controle {
	private Heroi hero;
	
	
	private void realizarComando(char direcao) {
		// pede o comando pro heroi
		this.hero.mover(direcao);
	}
	
	
	public void lerComandosTerminal() {
		Scanner entrada = new Scanner(System.in);		
		char comando = entrada.next().charAt(0);
		this.realizarComando(comando);
		entrada.close();
	}
	
	
	public void realizarComandosEntrada(char movimentos[]) {
		// para o arquivo de entrada
	}
}
