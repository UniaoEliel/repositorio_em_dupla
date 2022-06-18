package pt.model.caverna;

public interface ICavernaProperties {
	public void setTamX(int tamX);
	public void setTamY(int tamY);
	
	public int getTamX();
	public int getTamY();
	
	public ICelula getCelula(int x, int y);
	
	public int getXHeroi();
	public int getYHeroi();
}
