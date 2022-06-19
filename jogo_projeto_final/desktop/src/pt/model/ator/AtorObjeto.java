package pt.model.ator;

import pt.model.caverna.IAcessoCelulas;

/**
 * Define um ator que não se move nem combate na caverna
 * @author elias
 *
 */
public abstract class AtorObjeto extends Ator {
	
	
	public void connect(IAcessoCelulas cave) {
		this.cave = cave;
		cave.inserirAtor(this, x, y);
	}
}
