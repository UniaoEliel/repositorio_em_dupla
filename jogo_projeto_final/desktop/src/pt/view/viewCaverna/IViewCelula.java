package pt.view.viewCaverna;

import pt.model.caverna.ICelula;

public interface IViewCelula {
	/**
	 * Atualiza a vizualizacao
	 * Deve ser chamado toda vez que a celula sofre uma alteracao
	 */
	public void update();
	
	public void connect(ICelula celula);
}
