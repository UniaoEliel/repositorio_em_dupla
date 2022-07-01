package pt.model.ator;

public interface IHeroi extends IAtor, IHeroiCoord, IHeroiProperties, IRInventario, IHeroiComando {
	public void ganhar();
}
