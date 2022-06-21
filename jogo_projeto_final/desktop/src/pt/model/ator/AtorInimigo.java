package pt.model.ator;
/**
 * Define os inimigos da caverna
 * @author ra247057
 *
 */
public abstract class AtorInimigo extends AtorVivo {

	public void passarRodada() {
		super.passarRodada();

		int xHeroi = cave.getXHeroi(), yHeroi = cave.getYHeroi();
		
		int distanciaAoHeroi;
		if (cave.getIluminacao(x, y) > 0 ) {
			distanciaAoHeroi = cave.distanciaQuadrado(x, y, xHeroi, yHeroi);
			// se esta de 2 a 9 de distancia
			if (distanciaAoHeroi >= 4 &&
					distanciaAoHeroi <= 25)
				seMoverEmDirecaoA(xHeroi, yHeroi);
			
			else if (distanciaAoHeroi < 4)
				atacar(xHeroi, yHeroi);
			
			else {
				// 20% de chance de fazer um movimento aleatorio
				if (aleatorio.nextInt(100) <= 20)
					movimentoAleatorio();
			}
		}
	}

}
