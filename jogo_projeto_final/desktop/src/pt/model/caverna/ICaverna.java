package pt.model.caverna;

public interface ICaverna extends ICavernaProperties, IAcessoCelulas
	, IRHeroiCoord{
	/**
	 * Inicia a caverna, criando suas celulas
	 */
	public void start();
}
