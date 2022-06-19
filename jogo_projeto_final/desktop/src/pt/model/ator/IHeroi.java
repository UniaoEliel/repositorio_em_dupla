package pt.model.ator;

public interface IHeroi extends IAtor, IHeroiCoord, IHeroiProperties {
	/**
	 * Realiza um comando
	 * @param comando char que representa o comando
	 */
	public void realizarComando(char comando);
}
