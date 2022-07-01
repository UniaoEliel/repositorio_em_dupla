package pt.model.ator;
/**
 * Define atores que não interagem de forma alguma, como paredes e lava
 */
public class ObjetoEstatico extends AtorObjeto {
	public ObjetoEstatico() {
		solido = true;
		
		velocidade = 0;
	}
}
