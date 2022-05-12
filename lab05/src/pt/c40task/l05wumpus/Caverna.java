package pt.c40task.l05wumpus;

public class Caverna {
	private Sala salas[][];
	private int tamX, tamY;
	
	
	public Caverna(int tamX, int tamY) {
		this.tamX = tamX;
		this.tamY = tamY;
		this.salas = new Sala[tamX][tamY];
		
		for (int i = 0; i < tamX; i++)
			for (int j = 0; j < tamY; j++)
				this.salas[i][j] = new Sala();
	}
	
	
	/**
	 * retorna se a posição está dentro da caverna.
	 */
	public boolean checarValidadePosicao(int x, int y) {
		boolean valida = true;
		
		if (x < 0 || x >= tamX || y < 0 || y >= tamY)
			valida = false;
		
		return valida;
	}
	
	
	/**
	 * insere comp na sala em (x, y).
	 * retorna true se a inserção for válida.
	 */
	public boolean inserirComponente(Componente comp, int x, int y) {
		boolean insercaoValida = true;

		if (checarValidadePosicao(x, y))
			insercaoValida = salas[x][y].inserirComponente(comp);
		else
			insercaoValida = false;
		
		return insercaoValida;
	}
	
	
	/**
	 * remove o componente por seu tipo da sala em (x, y).
	 */
	public void removerComponente(String tipoComponente, int x, int y) {
		if (checarValidadePosicao(x, y))
			salas[x][y].removerComponente(tipoComponente);
	}
	
	
	/**
	 * move comp para a sala em novoX, novoY.
	 * retorna true se o movimento for valido.
	 */
	public boolean mover(Componente comp, int novoX, int novoY) {
		removerComponente(comp.getTipoComponente(), comp.getX(), comp.getY());
		return inserirComponente(comp, novoX, novoY);
	}
}
