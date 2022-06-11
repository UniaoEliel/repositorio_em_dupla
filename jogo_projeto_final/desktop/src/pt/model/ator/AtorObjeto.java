package pt.model.ator;

import pt.model.caverna.IAcessoCelulas;

public abstract class AtorObjeto extends Ator implements IAtorObjeto {
	
	
	
	
	public void connect(IAcessoCelulas cave) {
		this.cave = cave;
		cave.inserirAtor(this, x, y);
	}
}
