package pt.view.viewCaverna;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import pt.controller.leitor.ILeitor;
import pt.controller.leitor.Leitor;
import pt.model.ator.IAtorObjeto;
import pt.model.caverna.ICelula;

public class ViewCelula {
	// guarda as texturas de cada componente
	private static Map<String, TextureRegion> textures;
	private static HashMap<String, Texture> texs;
	
	private static Prioridades prio;
	
	private ICelula celula;
	

	protected static void iniciarTexturas() {
		ILeitor leitor = new Leitor();
		String[] arquivosTexturas = {"tex_caverna.png", "hero.png","HeroiTochaBaixa.png", "morcego.png"};
		
		String[][] localizacaoTexturas = leitor.getTexturas();
		
		
		
		String nomeTextura;
		TextureRegion texRegionAtual;
	
		
		texs = new HashMap<String, Texture>();
		textures = new HashMap<String, TextureRegion>();
		Texture texAtual;
		
		// carrega os arquivos de texturas
		for (int i = 0; i < arquivosTexturas.length; i++) {
			texAtual = new Texture(Gdx.files.internal(arquivosTexturas[i]));
			texs.put(arquivosTexturas[i], texAtual);
		}
		
		
		for (int j = 0; j < localizacaoTexturas.length; j++) {
			nomeTextura = localizacaoTexturas[j][0];
			if (localizacaoTexturas[j][1].charAt(0) != '-')
				nomeTextura += "_" + localizacaoTexturas[j][1];
			
			texRegionAtual = new TextureRegion(texs.get(localizacaoTexturas[j][2]), 
						Integer.parseInt(localizacaoTexturas[j][3]), Integer.parseInt(localizacaoTexturas[j][4]),
						32, 32);
			
			textures.put(nomeTextura, texRegionAtual);
			
		}
		
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
		String[] elementos = celula.getNomeAtores();
		String atual;
		
		for (int i = 0; i < elementos.length; i++)
			pt.add(elementos[i]);
		
		while (!pt.isEmpty()) {
			atual = pt.poll();
			batch.draw(textures.get(atual), x, y);
		}
		
		plotarEscuridao(batch, x, y);
	}
	
	
	public void connect(ICelula celula) {
		this.celula = celula;
	}
}
