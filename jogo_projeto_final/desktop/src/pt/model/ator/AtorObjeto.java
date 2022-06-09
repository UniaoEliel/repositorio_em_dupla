package pt.model.ator;

public abstract class AtorObjeto extends Ator implements IAtorObjeto {
	
	public static IAtorObjeto criarAtorObjeto(String tipo) {
		if (tipo == "jogador")
			return new Jogador();
	}
}
