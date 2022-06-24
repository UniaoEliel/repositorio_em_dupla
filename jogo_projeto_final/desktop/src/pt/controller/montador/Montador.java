package pt.controller.montador;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import pt.controller.exceptions.ArquivoAusente;
import pt.controller.exceptions.ArquivoMalFormatado;
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
	private static Random aleatorio = new Random();
	
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
	
	
	public ICaverna criarCaverna() throws ArquivoAusente, ArquivoMalFormatado {
		ICaverna cave = new Caverna();
		
		int[] tamanhos = leitor.getTamanhoCaverna();
		cave.setTamX(tamanhos[0]);
		cave.setTamY(tamanhos[1]);
		
		cave.start();
		
		colocarAtoresCaverna(cave);
		
		return cave;
	}
	
	
	private void colocarAtor(ICaverna cave, int x, int y, String nomeAtor, char orientacao) {
		IAtor ator = criarAtor(nomeAtor);
		
		// seta as coordenadas
		ator.setOrientacao(orientacao);
		ator.setX(x);
		ator.setY(y);
		
		ator.connect(cave);
	}

	
	private void checarValidade(String[][] atoresCaverna) throws ArquivoMalFormatado {
		for (int i = 0; i < atoresCaverna.length; i++) {
			if (atoresCaverna[i].length != 4) 
				throw new ArquivoMalFormatado("cave.txt", i);
		}
	}
	/**
	 * Cria o componentes e os conecta a caverna
	 * @param cave caverna
	 * @throws ArquivoAusente 
	 */
	private void colocarAtoresCaverna(ICaverna cave)  throws ArquivoAusente, ArquivoMalFormatado {
		String[][] atoresCaverna = leitor.getAtoresCaverna();
		checarValidade(atoresCaverna);
		IAtor ator;
		int i = 0;
		
		try {
			for (i = 0; i < atoresCaverna.length; i++) {
				ator = criarAtor(atoresCaverna[i][2]);
				
				// seta as coordenadas
				ator.setOrientacao(atoresCaverna[i][3].charAt(0));
				ator.setX(Integer.parseInt(atoresCaverna[i][0]));
				ator.setY(Integer.parseInt(atoresCaverna[i][1]));
				
				ator.connect(cave);
			}
		} catch (NumberFormatException e) {
			System.err.println(e.getMessage());
			throw new ArquivoMalFormatado("cave.txt", i + 5);
		} catch (ArquivoMalFormatado e) {
			throw new ArquivoMalFormatado("cave.txt", i + 5);
		}
	}
	
	
	/**
	 * Cria o ator na classe correta de acordo com seu tipo
	 * @param tipoAtor o tipo do ator
	 * @return o ator
	 */
	private IAtor criarAtor(String tipoAtor) throws ArquivoMalFormatado {
		IAtor ator = null;
		
		if (tipoAtor.equals("parede")) {
			ator = new ObjetoEstatico();
			ator.setTipo("parede");
		}
		
		else if (tipoAtor.equals("heroi")) {
			// guarda o heroi
			heroi = new Heroi();
			heroi.setTipo("heroi");
			ator = heroi;
		}
		
		else if (tipoAtor.equals("morcego")) {
			ator = new Morcego();
		}
		
		else if (tipoAtor.equals("aranha")) {
			ator = new Aranha();
		}
		else if (tipoAtor.equals("bau")) {
			ator = new Bau();
		}
		
		else if (tipoAtor.equals("goblin")) {
			ator = new Goblin();
		} else
			throw new ArquivoMalFormatado();
		
		return ator;
	}
	
	
	private void gerarMonstrosAleatorios(ICaverna cave, int numMonstros) {
		int x, y;
		for (int i = 0; i < numMonstros; i++) {
			x = aleatorio.nextInt(16);
			y = aleatorio.nextInt(16);
			
			colocarAtor(cave, x, y, "morcego", 'w');
		}
	}


	public void connect(ILeitura leitor) {
		this.leitor = leitor;
	}



	public IHeroi getHeroi() {
		return heroi;
	}
}
