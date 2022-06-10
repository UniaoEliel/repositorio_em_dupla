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
		textures = new HashMap<String, TextureRegion>();
		
		Texture teste = new Texture(Gdx.files.internal("cave.png"));

		TextureRegion teste2 = new TextureRegion(teste, 0, 144, 32, 32);
		TextureRegion teste3 = new TextureRegion(teste, 0, 288, 32, 32);
		TextureRegion heroi = new TextureRegion(teste, 100, 100, 32, 32);
		textures.put("chao", teste2);
		textures.put("chao2", teste3);
		textures.put("heroi", heroi);
		
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
