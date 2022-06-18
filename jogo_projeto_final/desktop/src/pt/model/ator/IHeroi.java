package pt.model.ator;

public interface IHeroi extends IAtorVivo, IHeroiCoord{
	/**
	 * Realiza um comando
	 * @param comando char que representa o comando
	 */
	public void realizarComando(char comando);
}
