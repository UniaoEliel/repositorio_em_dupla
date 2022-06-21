package pt.model.ator;

import pt.model.caverna.IAcessoCelulas;
import pt.model.caverna.ICaverna;

/**
 * Define um ator que não se move nem combate na caverna
 * @author elias
 *
 */
public abstract class AtorObjeto extends Ator {
	
	/**
	 * nao faz nada pois é um objeto
	 */
	public void receberAtaque(int dano) {
	}
}
