package pt.controller.montador;

import pt.controller.exceptions.ArquivoAusente;
import pt.controller.exceptions.ArquivoMalFormatado;
import pt.model.ator.IHeroi;
import pt.model.caverna.ICaverna;

public interface IMontador extends IRLeitura {
	/**
	 * Cria a caverna e coloca os atores definidos no arquivo
	 * cave.txt nela
	 * @return caverna criada
	 */
	public ICaverna criarCaverna() throws ArquivoAusente, ArquivoMalFormatado;
	
	/**
	 * 
	 * @return o heroi da caverna, se for chamado apos a criacao dela.
	 * Se nao retorna null
	 */
	public IHeroi getHeroi();
}
