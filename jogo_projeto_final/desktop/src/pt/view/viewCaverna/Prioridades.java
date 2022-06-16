package pt.view.viewCaverna;

import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
/**
 * Objeto da fila de prioridades da classe celula, serve para 
 * plotar os elementos da caverna em camadas.
 * @author ra247057
 *
 */
public class Prioridades implements Comparator<String> {
	// guarda as prioridades de cada elemento, quanto mais alta
	// mais em cima da tela ele será impresso.
	private static Map<String, Integer> prioridades;
	
	
	
	protected static void iniciarPrioridades() {
		String[][] priorid = {
				{"chao", "-", "0"},
				{"heroi", "s", "100"},
				{"heroi", "w", "100"},
				{"heroi", "a", "100"},
				{"heroi", "d", "100"},
				{"parede", "s", "1"},
				{"parede", "w", "1"},
				{"parede", "a", "1"},
				{"parede", "d", "1"},
		};
		prioridades = new HashMap<String, Integer>();
		String nomeAtual;
		
		for (int i = 0; i < priorid.length; i++) {
			nomeAtual = priorid[i][0];
			if (priorid[i][1].charAt(0) != '-')
				nomeAtual += "_" + priorid[i][1].charAt(0);
			
			prioridades.put(nomeAtual, Integer.parseInt(priorid[i][2]));
		}
	}
	
	
	protected Prioridades() {
		iniciarPrioridades();
	}
	

	public int compare(String o1, String o2) {
		int comp = 0;
		int n1 = prioridades.get(o1);
		int n2 = prioridades.get(o2);
		
		if (n2 < n1)
			comp = 1;
		else if (n2 > n1)
			comp = -1;
		
		return comp;
	}
}
