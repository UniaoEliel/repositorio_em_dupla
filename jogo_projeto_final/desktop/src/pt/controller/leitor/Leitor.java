package pt.controller.leitor;

import pt.model.caverna.Caverna;
import pt.model.caverna.Celula;

public class Leitor implements ILeitor {

	
	
	public int[] getTamanhoCaverna(Caverna caverna) {
		int[] tamanho = new int [2];
		tamanho[0] = caverna.getTamX();
		tamanho[1] = caverna.getTamY();
		return tamanho;	
	}
	
	
	public String[][] getAtoresCaverna(Caverna caverna, Celula celula){
		
	}
	
	
	public String[][] getTexturas(){
		
	}
	
	
	public String[][] getLayers(){
		
	}
	
	
	public String[] getNomeArquivosTexturas() {
		
	}
}
