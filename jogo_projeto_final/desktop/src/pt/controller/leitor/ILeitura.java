package pt.controller.leitor;

import pt.controller.exceptions.ArquivoAusente;
import pt.controller.exceptions.ArquivoMalFormatado;

public interface ILeitura {
	// as funcoes tem que retornar uma matriz sem posicoes vazias, 
	// com o tamanho igual a quantidade de elementos
	/**
	 * 
	 * @return [tamanho x, tamanho y] da caverna
	 */
	public int[] getTamanhoCaverna() throws ArquivoAusente, ArquivoMalFormatado;
	
	
	/**
	 * 
	 * @return vetor de strings onde cada posicao tem
	 * [NOME DO ATOR, DIRECAO, POSICAO X, POSICAO Y]
	 */
	public String[][] getAtoresCaverna() throws ArquivoAusente, ArquivoMalFormatado;
	
	
	/**
	 * 
	 * @return vetor de strings onde cada posicao tem
	 * [NOME DO ATOR, DIRECAO, ARQUIVO DE TEXTURA, X TEXTURA, Y TEXTURA]
	 */
	public String[][] getTexturas() throws ArquivoAusente, ArquivoMalFormatado;
	
	
	/**
	 * 
	 * @return vetor de strings onde cada posicao tem
	 * [NOME DO ATOR, DIRECAO, LAYER]
	 */
	public String[][] getLayers() throws ArquivoAusente, ArquivoMalFormatado;
	
	
	/**
	 * 
	 * @return vetor de strings com os nomes de arquivos de texturas
	 */
	public String[] getNomeArquivosTexturas() throws ArquivoAusente, ArquivoMalFormatado;
}