package pt.c40task.l05wumpus;

import java.util.ArrayList;

public class Sala {
	private ArrayList<Componente> componentes;
	private int numComponentes;
	private boolean visivel;
	
	public Sala() {
		componentes = new ArrayList<Componente>(2);
		numComponentes = 0;
		visivel = false;
	}
	
	
	public boolean inserirComponente(Componente comp) {
		String tipoNovo = comp.getTipoComponente();
		boolean insercaoValida = true;

		for (int i = 0; i < numComponentes; i++) {
			if (componentes.get(i).getTipoComponente() == tipoNovo) {
				insercaoValida = false;
				break;
			}

			if (tipoNovo == "wumpus" && componentes.get(i).getTipoComponente() == "ouro")  {
				insercaoValida = false;
				break;
			}

			if (tipoNovo == "ouro" && componentes.get(i).getTipoComponente() == "wumpus")  {
				insercaoValida = false;
				break;
			}
		}
		
		if (insercaoValida) {
			componentes.add(comp);
			numComponentes++;
		}
		
		return insercaoValida;
	}
	
	
	public void removerComponente(String tipoComponente) {
		String[] tipoComponentes = getTipoComponentes();
		
		for (int i = 0; i < componentes.size(); i++)
			if (tipoComponentes[i] == tipoComponente)
				componentes.remove(i);
	}
	
	
	public String[] getTipoComponentes() {
		String[] tipoComponentes = new String[numComponentes];

		for (int i = 0; i < numComponentes; i++)
			tipoComponentes[i] = componentes.get(i).getTipoComponente();
		
		return tipoComponentes;
	}
	
	
	public boolean getVisivel() {
		return visivel;
	}

	
	public void setVisivel(boolean visivel) {
		this.visivel = visivel;
	}
}
