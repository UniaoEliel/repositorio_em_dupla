package pt.model.caverna;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

import pt.model.ator.*;
import pt.view.viewCaverna.IViewCelula;

public class Celula implements ICelula {
	private static Random aleatorio = new Random();
	private ArrayList<IAtor> atores;
	// luz da sala, um valor de 0 a 100
	private int iluminacao;
	private String tipoChao;
	


	public Celula() {
		iluminacao = 0;
		atores = new ArrayList<IAtor>(5);
		
		if (aleatorio.nextInt(100) <= 80)
			tipoChao = "chao";
		else
			tipoChao = "chao" + Integer.toString(2 + aleatorio.nextInt(8));
	}
	
	

	public int getIluminacao() {
		return iluminacao;
	}


	public void somaIluminacao(int iluminacao) {
		this.iluminacao += iluminacao;
	}

	
	public String[] getNomeRepresentacoes() {
		String[] nomeAtores = new String[atores.size() + 1];
		nomeAtores[0] = tipoChao;
		int k = 1;
		
		for (IAtor ator : atores) {
			nomeAtores[k++] = ator.getNomeRepresentacao();
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
