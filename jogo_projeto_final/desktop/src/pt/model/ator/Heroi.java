package pt.model.ator;

public class Heroi extends AtorVivo implements IHeroi {
	public Heroi() {
		tipo = "heroi";
		orientacao = 's';
	}

	@Override
	public void realizarComando(char comando) {
		super.mover(comando);
	}
	
	
	
	
	public void entrouCelula() {
		cave.iluminarCelulas(x, y, 8);
		
				
	}
	
	public void saiuCelula() {
		cave.desiluminarCelulas(x, y, 8);
	}
}
