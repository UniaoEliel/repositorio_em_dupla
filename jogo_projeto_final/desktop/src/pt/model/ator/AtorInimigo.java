package pt.model.ator;
/**
 * Define os inimigos da caverna
 * @author ra247057
 *
 */
public abstract class AtorInimigo extends AtorVivo {
	protected int raioAlcance;
	
	protected AtorInimigo() {
		super();
		raioAlcance = 6;
	}

	public void passarRodada() {
		super.passarRodada();

		int xHeroi = cave.getXHeroi(), yHeroi = cave.getYHeroi();
		
		int distanciaAoHeroi;
		// so vai atras do heroi se tiver luz
		if (cave.getIluminacao(x, y) > 0 ) {
			distanciaAoHeroi = cave.distanciaQuadrado(x, y, xHeroi, yHeroi);
			
			if (distanciaAoHeroi <= raioAtaque * raioAtaque + 1)
				atacar(xHeroi, yHeroi);
			
			else if (podeMover() && distanciaAoHeroi >= raioAtaque * raioAtaque &&
					distanciaAoHeroi <= raioAlcance * raioAlcance)
				seMoverEmDirecaoA(xHeroi, yHeroi);
			
			
			
			else if (podeMover() && aleatorio.nextInt(100) <= 20)
					movimentoAleatorio();
			}
		}
	}


