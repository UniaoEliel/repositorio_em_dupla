package pt.view.viewCaverna;

import pt.controller.exceptions.ArquivoAusente;
import pt.controller.exceptions.ArquivoMalFormatado;
import pt.model.caverna.ICaverna;

public interface IRCaverna {
	public void connect(ICaverna caverna) throws ArquivoAusente, ArquivoMalFormatado ;
}
