package pt.model.ator;

public class Heroi extends AtorVivo implements IHeroi {
	private int luz;
	public Heroi() {
		tipo = "heroi";
		orientacao = 's';
		luz = 100;
		
		velocidade = 10;
	}

	@Override
	public void realizarComando(char comando) {
		super.mover(comando);
	}
	
	
	public void passarRodada() {
		saiuCelula();
		
		luz--;
		
		entrouCelula();
	}

	
	public void entrouCelula() {
		cave.iluminarCelulas(x, y, luz / 10);	
	}
	
	public void saiuCelula() {
		cave.desiluminarCelulas(x, y, luz / 10);
	}
}
