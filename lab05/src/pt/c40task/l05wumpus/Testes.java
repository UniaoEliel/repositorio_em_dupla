package pt.c40task.l05wumpus;

public class Testes {

	public static void main(String[] args) {
		Caverna c = new Caverna(4, 4);
		c.tornarVisivel(0, 0);
		c.tornarVisivel(2, 2);
		
		c.imprimeCaverna();
	}

}
