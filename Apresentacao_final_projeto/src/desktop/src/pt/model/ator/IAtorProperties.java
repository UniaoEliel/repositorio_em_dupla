package pt.model.ator;

public interface IAtorProperties {
	public String getTipo();
	
	public String getNomeRepresentacao();
	
	public void setTipo(String tipo);
	
	public char getOrientacao();
	
	public void setOrientacao(char orientacao);
	
	public boolean isSolido();
	
	public int getX();

	public void setX(int x);

	public int getY();

	public void setY(int y);
	
	public int getVelocidade();
}
