package pt.controller.montador;

import java.util.HashSet;
import java.util.Set;

import pt.controller.leitor.ILeitura;
import pt.controller.leitor.Leitor;
import pt.model.ator.*;
import pt.model.caverna.Caverna;
import pt.model.caverna.ICaverna;

/**
 * Singleton, responsavel por montar a caverna com base no arquivo cave.txt
 * @author elias
 *
 */
public class Montador implements IMontador {
	private static String[] nomeAtoresObjeto = {"parede"};
	private static String[] nomeAtoresVivos	= {"heroi"};
	private static Set<String> atoresObjeto, atoresVivos;
	
	private ILeitura leitor;
	private IHeroi heroi;
	
	private static final Montador instance = new Montador();
	
	private Montador() {
		heroi = null;
		
		atoresObjeto = new HashSet<String>();
		atoresVivos = new HashSet<String>();
		
		for (int i = 0; i < nomeAtoresObjeto.length; i++)
			atoresObjeto.add(nomeAtoresObjeto[i]);
		
		for (int j = 0; j < nomeAtoresVivos.length; j++)
			atoresVivos.add(nomeAtoresVivos[j]);
		
		leitor = new Leitor();
	}
	
	
	public static Montador getInstance() {
		return instance;
	}
	
	
	public ICaverna criarCaverna() {
		ICaverna cave = new Caverna();
		
		int[] tamanhos = leitor.getTamanhoCaverna();
		cave.setTamX(tamanhos[0]);
		cave.setTamY(tamanhos[1]);
		
		cave.start();
		
		colocarAtoresCaverna(cave);
		
		return cave;
	}

	
	private void colocarAtoresCaverna(ICaverna cave) {
		String[][] atoresCaverna = leitor.getAtoresCaverna();
		IAtorVivo aVivo;
		IAtorObjeto aObjeto;
		
		for (int i = 0; i < atoresCaverna.length; i++) {
			if (atoresVivos.contains(atoresCaverna[i][0])) {
				aVivo = criarAtorVivo(atoresCaverna[i][0]);
				// seta as coordenadas
				aVivo.setOrientacao(atoresCaverna[i][1].charAt(0));
				aVivo.setX(Integer.parseInt(atoresCaverna[i][2]));
				aVivo.setY(Integer.parseInt(atoresCaverna[i][3]));
				
				aVivo.connect(cave);
			} 
			else if (atoresObjeto.contains(atoresCaverna[i][0])) {
				aObjeto = criarAtorObjeto(atoresCaverna[i][0]);

				aObjeto.setOrientacao(atoresCaverna[i][1].charAt(0));
				aObjeto.setX(Integer.parseInt(atoresCaverna[i][2]));
				aObjeto.setY(Integer.parseInt(atoresCaverna[i][3]));
				
				aObjeto.connect(cave);
			}
		}
	}
	
	
	private IAtorObjeto criarAtorObjeto(String tipoAtor) {
		IAtorObjeto aObjeto = null;

		if (tipoAtor == "parede") {
			aObjeto = new ObjetoEstatico();
			aObjeto.setTipo("parede");
		}
		
		return aObjeto;
	}


	private IAtorVivo criarAtorVivo(String tipoAtor) {
		IAtorVivo aVivo = null;

		if (tipoAtor == "heroi") {
			// guarda o heroi
			heroi = new Heroi();
			heroi.setTipo("heroi");
			aVivo = heroi;
		}
		
		return aVivo;
	}


	public void connect(ILeitura leitor) {
		this.leitor = leitor;
	}



	public IHeroi getHeroi() {
		return heroi;
	}
}
