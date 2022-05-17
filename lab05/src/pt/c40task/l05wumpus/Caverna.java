package pt.c40task.l05wumpus;

public class Caverna {
	/**
	 * Retorna o char que representa aquele tipo de componente
	 */
	private static char representacao(String tipoComponente) {
		char representacao = '*';

		if (tipoComponente.equals("ouro"))
			representacao = 'O';
		else if (tipoComponente.equals("buraco"))
			representacao = 'B';
		else if (tipoComponente.equals("wumpus"))
			representacao = 'W';
		else if (tipoComponente.equals("heroi"))
			representacao = 'H';
		else if (tipoComponente.equals("fedor"))
			representacao = 'f';
		else if (tipoComponente.equals("brisa"))
			representacao = 'b';

		return representacao;
	}


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
		boolean movimentoValido;
		removerComponente(comp.getTipoComponente(), comp.getX(), comp.getY());
		movimentoValido = inserirComponente(comp, novoX, novoY);
		
		if (movimentoValido) {
			comp.setX(novoX);
			comp.setY(novoY);
		}
		
		return movimentoValido;
	}
	
	/**
	 * Torna a sala em (x, y) visivel.
	 */
	public void tornarVisivel(int x, int y) {
		salas[x][y].setVisivel(true);
	}
	
	
	/**
	 * retorna o char que representa a sala em (x, y)
	 */
	private char representacaoSala(int x, int y) {
		char repr;

		if (!salas[x][y].getVisivel())
			repr = '-';
		else if (salas[x][y].estaVazia())
			repr = '#';
		else {
			String maiorPrio = salas[x][y].getMaiorPrioridade();
			repr = representacao(maiorPrio);
		}
		
		return repr;
	}
	
	
	public void imprimeCaverna() {
		for (int i = 0; i < tamX; i++) {
			for (int j = 0; j < tamY; j++) 
				System.out.print(representacaoSala(i, j));
			System.out.println();
		}
	}
}
