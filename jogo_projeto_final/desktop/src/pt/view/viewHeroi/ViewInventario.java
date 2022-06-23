package pt.view.viewHeroi;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import pt.model.ator.IHeroiProperties;
import pt.model.inventario.IInventarioProperties;

public class ViewInventario {
	private IInventarioProperties inventario;
	private IHeroiProperties heroi;
	private Texture bordas;
	private TextureRegion borda, bordaSelecionada;

	
	public ViewInventario() {
		bordas = new Texture(Gdx.files.internal("bordas_inv.png"));
		borda = new TextureRegion(bordas, 0, 0, 40, 40);
		bordaSelecionada = new TextureRegion(bordas, 40, 0, 40, 40);
	}

	protected void connect(IHeroiProperties heroi) {
		this.heroi = heroi;
		this.inventario = heroi.getInventario();
	}
	
	
	protected void plotarInventario(SpriteBatch batch, BitmapFont font) {
		int inicioX = 400 - ((40 + 36 * inventario.getTamanho()) / 2);
		for (int i = 0; i < inventario.getTamanho(); i++) {
			batch.draw(borda, inicioX + 36 * i, 30);
			font.setColor(Color.WHITE);
			font.draw(batch, Integer.toString(i + 1), inicioX + 36 * i + 6, 30 + 34);
		}
		
		batch.draw(bordaSelecionada, inicioX + 36 * (heroi.getNumItem() - 1), 30);
	}
	
	protected void dispose() {
		bordas.dispose();
	}
}
