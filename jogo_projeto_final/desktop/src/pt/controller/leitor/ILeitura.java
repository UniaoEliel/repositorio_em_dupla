package pt.controller.leitor;

public interface ILeitura {
	// as funcoes tem que retornar uma matriz sem posicoes vazias, 
	// com o tamanho igual a quantidade de elementos
	/**
	 * 
	 * @return [tamanho x, tamanho y] da caverna
	 */
	public int[] getTamanhoCaverna();
	
	
	/**
	 * 
	 * @return vetor de strings onde cada posicao tem
	 * [NOME DO ATOR, DIRECAO, POSICAO X, POSICAO Y]
	 */
	public String[][] getAtoresCaverna();
	
	
	/**
	 * 
	 * @return vetor de strings onde cada posicao tem
	 * [NOME DO ATOR, DIRECAO, ARQUIVO DE TEXTURA, X TEXTURA, Y TEXTURA]
	 */
	public String[][] getTexturas();
	
	
	/**
	 * 
	 * @return vetor de strings onde cada posicao tem
	 * [NOME DO ATOR, LAYER]
	 */
	public String[][] getLayers();
	
	
	/**
	 * 
	 * @return vetor de strings com os nomes de arquivos de texturas
	 */
	public String[] getNomeArquivosTexturas();
}