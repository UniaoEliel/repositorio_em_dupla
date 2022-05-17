package pt.c40task.l05wumpus;

public class Montador {
	/**
	 * Retorna se a caverna é válida, isto é
	 * se há no mínimo 2 e no máximo 3 buracos, se
	 * há 1 wumpus, 1 ouro e 1 herói, e se o herói está
	 * em (1, 1)
	 */
	private static boolean checarValidadeCaverna(String localizacoes[][]) {
		int qtdOuro = 0, qtdWumpus = 0, qtdBuracos = 0;
		boolean cavernaValida = true;
		
		// se o heroi nao esta na posicao 1, 1
		if (!localizacoes[0][2].equals("P"))
			cavernaValida = false;
		else {
			for (int i = 1; i < localizacoes.length; i++) {
				if (localizacoes[i][2].equals("W")) {
					qtdWumpus++;
					if (qtdWumpus > 1) {
						cavernaValida = false;
						break;
					}
				}
				
				if (localizacoes[i][2].equals("O")) {
					qtdOuro++;
					if (qtdOuro > 1) {
						cavernaValida = false;
						break;
					}
				}
				
				if (localizacoes[i][2].equals("B")) {
					qtdBuracos++;
					if (qtdBuracos > 3) {
						cavernaValida = false;
						break;
					}
				}
			}
		}
		
		if (qtdBuracos < 2 || qtdWumpus != 1 || qtdOuro != 1)
			cavernaValida = false;

		
		return cavernaValida;
	}
	
	
	/**
	 * Instancia o componente na classe herdeira correspondente e o retorna
	 */
	private static Componente instanciarComponente(int x, int y, Caverna cave, String tipoComponente) {
		Componente comp = null;

		if (tipoComponente.equals("B"))
			comp = new Buraco(x, y, cave);
		else if (tipoComponente.equals("P"))
			comp = new Heroi(x, y, cave);
		else if (tipoComponente.equals("W"))
			comp = new Wumpus(x, y, cave);
		else if (tipoComponente.equals("O"))
			comp = new Ouro(x, y, cave);

		return comp;
	}
	
	
	
	private Heroi hero;
	/**
	 * se a caverna for valida, a monta e retorna,
	 * se nao for valida, retorna null.
	 */
	public Caverna montarCaverna(String localizacoes[][]) {
		Caverna cave;
		
		if (!checarValidadeCaverna(localizacoes))
			cave = null;
		else {
			Componente comp;
			cave = new Caverna(4, 4);
			for (int i = 0; i < localizacoes.length; i++) {
				if (!localizacoes[i][2].equals("_")) {
					comp = instanciarComponente(Integer.parseInt(localizacoes[i][0]) - 1,
												Integer.parseInt(localizacoes[i][1]) - 1,
												cave, localizacoes[i][2]);
					
					if (localizacoes[i][2].equals("P"))
						hero = (Heroi) comp;
					
					comp.insereCaverna();
				}
						
			}
		}
		
		return cave;
	}
	
	
	public Heroi getHeroi() {
		return hero;
	}
}
