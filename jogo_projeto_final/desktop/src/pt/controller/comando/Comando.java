package pt.controller.comando;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;

import pt.model.ator.IHeroi;
import pt.model.ator.IHeroiComando;

public class Comando implements IComando {
	private IHeroiComando jogador;
	private int[] keys = {Keys.W, Keys.S, Keys.A, Keys.D, Keys.J, Keys.K, Keys.L, Keys.U,
			Keys.NUM_1, Keys.NUM_2, Keys.NUM_3, Keys.NUM_4, Keys.NUM_5, Keys.NUM_6, Keys.NUM_7};
	
	
	public void lerComando() {
		String comando;
		char letraComando;
		for (int i = 0; i < keys.length; i++) {
			if (Gdx.input.isKeyPressed(keys[i])) {
				comando = Keys.toString(keys[i]);
				comando = comando.toLowerCase();
				letraComando = comando.charAt(0);
				
				jogador.setComandoAtual(letraComando);
			}
		}
	}
	
	public void connect(IHeroiComando jogador) {
		this.jogador = jogador;
	}
	
	
	public boolean ganhou() {
		return jogador.ganhou();
	}
	
	
	public boolean perdeu() {
		return !jogador.isVivo();
	}
}
