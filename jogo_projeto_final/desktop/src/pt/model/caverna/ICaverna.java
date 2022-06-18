package pt.model.caverna;

import pt.model.ator.IAtorObjeto;
import pt.model.ator.IAtorVivo;

public interface ICaverna extends ICavernaProperties, IAcessoCelulas
	, IRHeroiCoord{
	/**
	 * Inicia a caverna, criando suas celulas
	 */
	public void start();
}
