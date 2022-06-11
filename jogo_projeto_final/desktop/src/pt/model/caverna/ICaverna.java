package pt.model.caverna;

import pt.model.ator.IAtorObjeto;
import pt.model.ator.IAtorVivo;

public interface ICaverna extends ICavernaProperties, IRViewCaverna, IAcessoCelulas {
	public void start();
}
