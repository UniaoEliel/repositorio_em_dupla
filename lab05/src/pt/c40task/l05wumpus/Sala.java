package pt.c40task.l05wumpus;

import java.util.ArrayList;
import java.util.HashSet;

public class Sala {
	// guarda as combinacoes invalidas de componentes na sala
	private static String[][] combinacoesInvalidas = {{"ouro", "wumpus"}, 
										{"ouro", "buraco"},
										{"buraco", "wumpus"}};
	
	private static String[] ordemPrioridade = {"ouro", "buraco", "wumpus", "heroi", "fedor", "brisa"};
	
	
	private static String maiorPrioridade(String[] tipoComponentes) {
		String maiorPrioridade = "vazio";
		HashSet<String> tipos = new HashSet<String>(tipoComponentes.length);
		
		for (int i = 0; i < tipoComponentes.length; i++) 
			tipos.add(tipoComponentes[i]);
		
		for (int j = 0; j < ordemPrioridade.length; j++) {
			if (tipos.contains(ordemPrioridade[j])) {
				maiorPrioridade = ordemPrioridade[j];
				break;
			}
		}
		
		return maiorPrioridade;
	}

	
	private ArrayList<Componente> componentes;
	private boolean visivel;
	
	public Sala() {
		componentes = new ArrayList<Componente>(2);
		visivel = false;
	}
	
	
	/**
	 * Verifica se a insercao de um componente na sala é valida, caso for
	 * o insere e retorna true. se não for retorna false.
	 */
	public boolean inserirComponente(Componente comp) {
		String tipoNovo = comp.getTipoComponente(), tipoComp;
		boolean insercaoValida = true;
		
	

		for (int i = 0; i < componentes.size(); i++) {
			tipoComp = componentes.get(i).getTipoComponente();
			if (tipoComp == tipoNovo) {
				insercaoValida = false;
				break;
			}

			for (int j = 0; j < combinacoesInvalidas.length; j++) {
				if ((tipoNovo == combinacoesInvalidas[j][0] 
					&& tipoComp == combinacoesInvalidas[j][1])
					|| (tipoComp == combinacoesInvalidas[j][0] 
					&& tipoNovo == combinacoesInvalidas[j][1])) {
						insercaoValida = false;
						break;
				}
			}
		}
		
		if (insercaoValida)
			componentes.add(comp);
		
		return insercaoValida;
	}
	
	
	/**
	 * Se o componente estiver na sala, o remove, se não estiver
	 * não faz nada
	 */
	public void removerComponente(String tipoComponente) {
		String[] tipoComponentes = getTipoComponentes();
		
		for (int i = 0; i < componentes.size(); i++)
			if (tipoComponentes[i] == tipoComponente)
				componentes.remove(i);
	}
	
	
	/**
	 * Retorna um vetor de string contendo os tipos de todos
	 * os componentes da sala.
	 */
	public String[] getTipoComponentes() {
		String[] tipoComponentes = new String[componentes.size()];

		for (int i = 0; i < componentes.size(); i++)
			tipoComponentes[i] = componentes.get(i).getTipoComponente();
		
		return tipoComponentes;
	}
	
	
	
	
	public boolean getVisivel() {
		return visivel;
	}

	
	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}
	
	
	public boolean estaVazia() {
		return componentes.size() == 0;
	}
	
	
	public String getMaiorPrioridade() {
		String maior = "vazia";
		if (!estaVazia())
			maior = maiorPrioridade(getTipoComponentes());
		return maior;
	}


	public Componente getComponente(String tipoComponente) {
		Componente comp = null;
		String[] tipos = getTipoComponentes();
		for (int i = 0; i < tipos.length; i++)
			if (tipos[i].equals(tipoComponente))
				comp = componentes.get(i);
		
		return comp;
	}
}
