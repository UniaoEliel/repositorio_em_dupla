package pt.model.caverna;

import java.util.HashMap;
import java.util.Map;
import pt.model.ator.*;
import pt.view.viewCaverna.IViewCelula;

public class Celula implements ICelula {
	// dicionarios que guardam os atores
	private Map<String, IAtorVivo> atoresVivos;
	private Map<String, IAtorObjeto> atoresObjeto;
	// luz da sala, um valor de 0 a 100
	private int iluminacao; 
	private IViewCelula view;
	
	public Celula() {
		iluminacao = 0;
	}

	
	public void connect(IViewCelula view) {
		this.view = view;
		view.connect(this);
	}
	
	public String[] getAtores() {
		String[] test = {"chao", "chao2"};
		
		return test;
	}
}
