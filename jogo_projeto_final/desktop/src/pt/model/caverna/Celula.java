package pt.model.caverna;

import java.util.HashMap;
import java.util.Iterator;
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
		atoresVivos = new HashMap<String, IAtorVivo>();
		atoresObjeto = new HashMap<String, IAtorObjeto>();
	}

	
	public void connect(IViewCelula view) {
		this.view = view;
		view.connect(this);
	}
	
	public String[] getAtores() {
		String[] atores = new String[atoresVivos.size() + atoresObjeto.size() + 1];
		
		atores[0] = "chao";
		int k = 1;
		
		for (Map.Entry<String,IAtorObjeto> pair : atoresObjeto.entrySet()) {
			atores[k] = pair.getKey();
			if (pair.getValue().getOrientacao() != '-')
				atores[k] += "-" + pair.getValue().getOrientacao();
			k++;
		}
		
		
		for (Map.Entry<String,IAtorVivo> pair : atoresVivos.entrySet()) {
			atores[k] = pair.getKey();
			if (pair.getValue().getOrientacao() != '-')
				atores[k] += "_" + pair.getValue().getOrientacao();
			k++;
		}
		
		return atores;
	}
	
	
	protected void inserirAtor(IAtorObjeto a) {
		atoresObjeto.put(a.getTipo(), a);
	}
	
	
	protected void inserirAtor(IAtorVivo a) {
		atoresVivos.put(a.getTipo(), a);
	}

	
	protected void removerAtor(IAtorObjeto a) {
		atoresObjeto.remove(a.getTipo());
	}
	
	
	protected void removerAtor(IAtorVivo a) {
		atoresVivos.remove(a.getTipo());
	}
	
	
	protected Map<String, IAtorVivo> getAtoresVivos() {
		return atoresVivos;
	}
	
	
	protected Map<String, IAtorObjeto> getAtoresObjeto() {
		return atoresObjeto;
	}


	public boolean isSolida() {
		boolean solida = false;

		for (Map.Entry<String,IAtorVivo> pair : atoresVivos.entrySet()) {
			if (pair.getValue().isSolido()) {
				solida = true;
				break;
			}
		}
		
		for (Map.Entry<String,IAtorObjeto> pair : atoresObjeto.entrySet()) {
			if (pair.getValue().isSolido()) {
				solida = true;
				break;
			}
		}
		
		return solida;
	}
	
	
	protected boolean podeEntrar(IAtorObjeto a) {
		boolean pode = true;
		if (isSolida())
			pode = false;
		else if (atoresObjeto.containsKey(a.getTipo()))
			pode = false;
		
		return pode;
	}
	
	
	protected boolean podeEntrar(IAtorVivo a) {
		boolean pode = true;
		if (isSolida())
			pode = false;
		else if (atoresVivos.containsKey(a.getTipo()))
			pode = false;
		
		return pode;
	}
}
