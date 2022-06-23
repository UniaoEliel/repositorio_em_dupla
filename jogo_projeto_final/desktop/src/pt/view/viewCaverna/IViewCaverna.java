package pt.view.viewCaverna;

import pt.controller.exceptions.ArquivoAusente;
import pt.controller.exceptions.ArquivoMalFormatado;

public interface IViewCaverna extends IViewCavernaProperties, IPlotarCaverna, IRCaverna {
	public void create() throws ArquivoAusente, ArquivoMalFormatado;
}
