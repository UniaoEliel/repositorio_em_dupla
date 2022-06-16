package pt.model.ator;

import pt.model.caverna.IAcessoCelulas;

public abstract class AtorObjeto extends Ator implements IAtorObjeto {
	
	public static IAtorObjeto criarAtorObjeto(String tipo, char orientacao) {
		IAtorObjeto ator = null;
		
		if (tipo == "parede") {
			ator = new ObjetoEstatico();
			ator.setTipo("parede");
			
		}
		
		if (ator != null)
			ator.setOrientacao(orientacao);
		
		return ator;
	}
	
	
	public void connect(IAcessoCelulas cave) {
		this.cave = cave;
		cave.inserirAtor(this, x, y);
	}
}
