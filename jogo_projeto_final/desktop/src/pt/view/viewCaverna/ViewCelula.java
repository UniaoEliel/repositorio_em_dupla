package pt.view.viewCaverna;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import pt.model.caverna.ICelula;

public class ViewCelula implements IViewCelula {
	// guarda as texturas de cada componente
	private static Map<String, TextureRegion> textures;
	
	private static Prioridades prio;
	
	
	protected static void iniciarTexturas() {
		String[] arquivosTexturas = {"tex_caverna.png", "hero.png"};
		String[][] localizacaoTexturas = {
				{"chao", "-", "tex_caverna.png", "0", "0"},
				{"heroi", "s", "hero.png", "0", "0"}
		};
		
		String nomeTextura;
		TextureRegion texRegionAtual;
	
		
		HashMap<String, Texture> texs = new HashMap<String, Texture>();
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
	
	private ICelula celula;
	
	
	
	public ViewCelula() {
	}
	
	
	protected void plotar(SpriteBatch batch, int x, int y) {
		PriorityQueue<String> pt = new PriorityQueue<String>(prio);
		String[] elementos = celula.getAtores();
		String atual;
		
		for (int i = 0; i < elementos.length; i++)
			pt.add(elementos[i]);
		
		while (!pt.isEmpty()) {
			atual = pt.poll();
			batch.draw(textures.get(atual), x, y);
		}
	}
	
	
	public void connect(ICelula celula) {
		this.celula = celula;
	
	}


	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
