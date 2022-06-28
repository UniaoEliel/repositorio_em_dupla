package pt.model.ator;

public interface IHeroiComando {
	public void setComandoAtual(char comandoAtual);
	
	public boolean isVivo();
	
	public boolean ganhou();
}
