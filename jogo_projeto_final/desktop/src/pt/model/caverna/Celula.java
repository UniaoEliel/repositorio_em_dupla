package pt.model.caverna;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import pt.model.ator.*;
import pt.view.viewCaverna.IViewCelula;

public class Celula implements ICelula {
	private ArrayList<IAtor> atores;
	// luz da sala, um valor de 0 a 100
	private int iluminacao;
	


	public Celula() {
		iluminacao = 0;
		atores = new ArrayList<IAtor>(5);
	}
	
	

	public int getIluminacao() {
		return iluminacao;
	}


	public void somaIluminacao(int iluminacao) {
		this.iluminacao += iluminacao;
	}

	
	public String[] getNomeAtores() {
		String[] nomeAtores = new String[atores.size() + 1];
		nomeAtores[0] = "chao";
		int k = 1;
		
		for (IAtor ator : atores) {
			nomeAtores[k] = ator.getTipo();
			if (ator.getOrientacao() != '-')
				nomeAtores[k] += "_" + ator.getOrientacao();
			
			k++;
		}
		
		return nomeAtores;
	}
	
	
	protected ArrayList<IAtor> getAtores() {
		return atores;
	}
	
	
	protected void inserirAtor(IAtor a) {
		atores.add(a);
		a.entrouCelula();
	}
	
	
	protected void removerAtor(IAtor a) {
		atores.remove(a);
		a.saiuCelula();
	}

	public boolean isSolida() {
		boolean solida = false;
		
		for (IAtor ator : atores) {
			if (ator.isSolido()) {
				solida = true;
				break;
			}
		}
		return solida;
	}
	
	
	
	private boolean contemTipo(String tipo) {
		boolean contem = false;

		for (IAtor ator : atores) {
			if (ator.getTipo() == tipo) {
				contem = true;
				break;
			}
		}
		
		return contem;
	}
	

	protected boolean podeEntrar(IAtor a) {
		boolean pode = true;
		
		if (isSolida() || contemTipo(a.getTipo()))
			pode = false;
		
		return pode;
	}
}
