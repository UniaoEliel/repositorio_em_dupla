package pt.model.ator;

public abstract class AtorAtaque extends Ator {
	protected int duracao;
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
	
	
	public void atacar(int dano) {
		IAtor[] atores = cave.getAtores(x, y);
		
		if (atores != null) {
			for (IAtor ator : atores) {
				ator.receberAtaque(autor, dano);
			}
		}
	}
	
	
	public void atacar(String autor, int dano) {
		IAtor[] atores = cave.getAtores(x, y);
		
		if (atores != null) {
			for (IAtor ator : atores) {
				ator.receberAtaque(autor, dano);
			}
		}
	}
}


