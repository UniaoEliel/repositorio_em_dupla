package pt.model.ator;

public interface IAtor extends IAtorProperties, IRAcessoCelulas
		, IAcoesAtor {

	public int getX();
	public void setX(int x);
	public int getY();
	public void setY(int y);
	
}
