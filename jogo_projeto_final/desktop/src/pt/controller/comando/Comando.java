package pt.controller.comando;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import pt.model.ator.IHeroi;

public class Comando implements IComando {
	private IHeroi jogador;
	private int[] keys = {Keys.W, Keys.S, Keys.A, Keys.D};
	
	
	public void lerComando() {
		String comando;
		char letraComando;
		for (int i = 0; i < keys.length; i++) {
			if (Gdx.input.isKeyPressed(keys[i])) {
				comando = Keys.toString(keys[i]);
				comando = comando.toLowerCase();
				letraComando = comando.charAt(0);
				
				jogador.realizarComando(letraComando);
			}
		}
	}
	
	public void connect(IHeroi jogador) {
		this.jogador = jogador;
	}
	
}
