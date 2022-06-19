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

	
	/**
	 * Cria o componentes e os conecta a caverna
	 * @param cave caverna
	 */
	private void colocarAtoresCaverna(ICaverna cave) {
		String[][] atoresCaverna = leitor.getAtoresCaverna();
		IAtor ator;
		
		for (int i = 0; i < atoresCaverna.length; i++) {
			ator = criarAtor(atoresCaverna[i][0]);
			
			// seta as coordenadas
			ator.setOrientacao(atoresCaverna[i][1].charAt(0));
			ator.setX(Integer.parseInt(atoresCaverna[i][2]));
			ator.setY(Integer.parseInt(atoresCaverna[i][3]));
			
			ator.connect(cave);
		}
	}
	
	
	/**
	 * Cria o ator na classe correta de acordo com seu tipo
	 * @param tipoAtor o tipo do ator
	 * @return o ator
	 */
	private IAtor criarAtor(String tipoAtor) {
		IAtor ator = null;
		
		if (tipoAtor == "parede") {
			ator = new ObjetoEstatico();
			ator.setTipo("parede");
		}
		
		if (tipoAtor == "heroi") {
			// guarda o heroi
			heroi = new Heroi();
			heroi.setTipo("heroi");
			ator = heroi;
		}
		
		return ator;
	}


	public void connect(ILeitura leitor) {
		this.leitor = leitor;
	}



	public IHeroi getHeroi() {
		return heroi;
	}
}
