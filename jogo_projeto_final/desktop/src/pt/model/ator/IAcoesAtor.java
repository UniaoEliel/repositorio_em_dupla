package pt.model.ator;

public interface IAcoesAtor {
	/**
	 * Faz as interações de um ator quando ele entra em uma célula
	 */
	public void entrouCelula();
	
	/**
	 * Faz as interações de um ator quando ele sai de uma célula
	 */
	public void saiuCelula();
	
	/**
	 * Chamado toda vez que uma rodada passa
	 */
	public void passarRodada();
	
	
	public void receberAtaque(String nomeAtacante, int dano);
	
	
	public void interagir(IHeroi heroi);
	
	
	public void imobilizar(int rodadas);
}
