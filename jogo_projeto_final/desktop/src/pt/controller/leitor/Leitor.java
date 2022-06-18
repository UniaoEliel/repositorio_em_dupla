package pt.controller.leitor;

import pt.model.caverna.Caverna;
import pt.model.caverna.Celula;

public class Leitor implements ILeitor {

	// essa classe devera ser singleton
	
	// coloquei uns valor padrao aqui pro codigo funcionar
	// mas tem que ler eles do cave.txt
	
	public int[] getTamanhoCaverna() {
		int[] tamanhos = {100, 100};
		return tamanhos;
	}
	
	
	public String[][] getAtoresCaverna(){
		String[][] atores = {
				{"heroi", "w", "5", "5"},
				{"parede", "s", "6", "6"},
				{"parede", "s", "6", "7"}
		};
		return atores;
	}
	
	
	public String[][] getTexturas(){
		
	}
	
	
	public String[][] getLayers(){
		
	}
	
	
	public String[] getNomeArquivosTexturas() {
		
	}
}
