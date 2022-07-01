package pt.view.viewCaverna;

import pt.controller.exceptions.ArquivoAusente;
import pt.controller.exceptions.ArquivoMalFormatado;
import pt.model.caverna.ICavernaProperties;


public interface IRCavernaProperties {
	public void connect(ICavernaProperties caverna) throws ArquivoAusente, ArquivoMalFormatado ;
}
