package pt.model.ator;

public abstract class AtorAtaque extends Ator {
	private int duracao;
	protected String autor;
	
	public AtorAtaque() {
		super();
		orientacao = '-';
	}
	
	
	public void passarRodada() {
		duracao--;
		if (duracao <= 0)
			cave.removerAtor(this, x, y);
	}


	public void setDuracao(int duracao) {
		this.duracao = duracao;
	}
	
	
	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public void receberAtaque(String nomeAtacante, int dano) {
	}

}
