package pt.view.viewCaverna;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.GdxRuntimeException;

import pt.controller.exceptions.ArquivoAusente;
import pt.controller.exceptions.ArquivoMalFormatado;
import pt.controller.leitor.ILeitor;
import pt.controller.leitor.Leitor;
import pt.model.caverna.ICelula;
import pt.model.caverna.ICelulaProperties;

public class ViewCelula {
	// guarda as texturas de cada componente
	private static Map<String, TextureRegion> textures;
	private static HashMap<String, Texture> texs;
	
	private static Prioridades prio;
	
	private ICelulaProperties celula;
	
	protected static Map<String, TextureRegion> getTexturas() {
		return textures;
	}
	
	
	private static void abrirArquivosTexturas(ILeitor leitor) throws ArquivoAusente, ArquivoMalFormatado {
		int i = -1;
		String[] arquivosTexturas = leitor.getNomeArquivosTexturas();
		Texture texAtual;

		try {
			for (i = 0; i < arquivosTexturas.length; i++) {
				texAtual = new Texture(Gdx.files.internal(arquivosTexturas[i]));
				texs.put(arquivosTexturas[i], texAtual);
			}
		} catch (GdxRuntimeException e) {
			if (i != -1)
				throw new ArquivoAusente(arquivosTexturas[i], "assets");
			else
				throw new ArquivoAusente();
		}
	}
	
	
	private static void iniciarPedacosTexturas(ILeitor leitor) throws ArquivoAusente, ArquivoMalFormatado {
		String[][] localizacaoTexturas = leitor.getTexturas();
		String nomeTextura;
		TextureRegion texRegionAtual;
		
		for (int j = 0; j < localizacaoTexturas.length; j++) {
			nomeTextura = localizacaoTexturas[j][0];
			if (localizacaoTexturas[j][1].charAt(0) != '-')
				nomeTextura += "_" + localizacaoTexturas[j][1];
			
			texRegionAtual = new TextureRegion(texs.get(localizacaoTexturas[j][2]), 
						Integer.parseInt(localizacaoTexturas[j][3]), Integer.parseInt(localizacaoTexturas[j][4]),
						32, 32);
			
			textures.put(nomeTextura, texRegionAtual);
			
		}
	}

	protected static void iniciarTexturas() throws ArquivoAusente, ArquivoMalFormatado {
		ILeitor leitor = new Leitor();
		
		String[][] localizacaoTexturas = leitor.getTexturas();
		
		String nomeTextura;
		TextureRegion texRegionAtual;

		texs = new HashMap<String, Texture>();
		textures = new HashMap<String, TextureRegion>();

		abrirArquivosTexturas(leitor);
		
		iniciarPedacosTexturas(leitor);
		
		prio = new Prioridades();
	}
	
	
	public ViewCelula() {
	}
	
	/**
	 * Desaloca as coisas do libGDX
	 */
	protected static void dispose() {
		for (Map.Entry<String,Texture> pair : texs.entrySet())
			pair.getValue().dispose();
	}
	
	
	/**
	 * coloca a camada de escuridao com base na luz atual da sala
	 * @param batch spritebatch que esta sendo usado no desenho
	 * @param x coordenada x na tela em pixels
	 * @param y coordenada y na tela em pixels
	 */
	private void plotarEscuridao(SpriteBatch batch, int x, int y) {
		int iluminacao = celula.getIluminacao();
		
		if (iluminacao <= 0)
			batch.draw(textures.get("escuro100"), x, y);
		else if (iluminacao <= 25)
			batch.draw(textures.get("escuro75"), x, y);
		if (iluminacao <= 50)
			batch.draw(textures.get("escuro50"), x, y);
		if (iluminacao <= 75)
			batch.draw(textures.get("escuro25"), x, y);
		
	}
	
	
	/**
	 * Plota a sala e seus elementos na tela
	 * @param batch spritebatch que esta sendo usado no desenho
	 * @param x coordenada x na tela em pixels
	 * @param y coordenada y na tela em pixels
	 */
	protected void plotar(SpriteBatch batch, int x, int y) {
		PriorityQueue<String> pt = new PriorityQueue<String>(prio);
		String[] elementos = celula.getNomeRepresentacoes();
		String atual;
		
		for (int i = 0; i < elementos.length; i++)
			pt.add(elementos[i]);
		
		while (!pt.isEmpty()) {
			atual = pt.poll();
			batch.draw(textures.get(atual), x, y);
		}
		
		plotarEscuridao(batch, x, y);
	}
	
	
	public void connect(ICelulaProperties celula) {
		this.celula = celula;
	}
}
