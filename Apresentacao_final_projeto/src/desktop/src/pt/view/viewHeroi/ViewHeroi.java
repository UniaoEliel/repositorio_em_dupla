package pt.view.viewHeroi;

import java.util.Map;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import pt.model.ator.IHeroiProperties;

public class ViewHeroi implements IViewHeroi {
	private int pixelsX, pixelsY;
	
	private Map<String, TextureRegion> textures;

	private IHeroiProperties heroi;
	
	private ViewInventario viewInventario;
	
	
	public ViewHeroi() {
		this.viewInventario = new ViewInventario();
	}
	
	
	public void setPixelsX(int pixelsX) {
		this.pixelsX = pixelsX;
	}


	public void setPixelsY(int pixelsY) {
		this.pixelsY = pixelsY;
	}


	public void plotarHeroi(SpriteBatch batch, BitmapFont font) {
		String vida = heroi.getVidaAtual() + " / " + heroi.getVidaTotal();
		// vermelho
		font.setColor(255, 0, 0, 1);
		
		font.draw(batch, vida, pixelsX / 10, pixelsY / 10);
		
		font.setColor(Color.WHITE);
		font.draw(batch, "X:" + heroi.getX() + " Y:" + heroi.getY(), 30, pixelsY - 30);
		viewInventario.plotarInventario(batch, font, textures);
	}


	public void dispose() {
		// TODO Auto-generated method stub
		
	}


	public void connect(IHeroiProperties heroi) {
		this.heroi = heroi;
		this.viewInventario.connect(heroi);
	}
	
	
	public boolean heroiEstaVivo() {
		return heroi.isVivo();
	}


	@Override
	public void setTexturas(Map<String, TextureRegion> textures) {
		this.textures = textures;
	}
}
