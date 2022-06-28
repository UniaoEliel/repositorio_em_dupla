package pt.view.viewHeroi;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface IViewHeroiProperties {
	public void setPixelsX(int pixelsX);


	public void setPixelsY(int pixelsY);
	
	public boolean heroiEstaVivo();
	
	
	public void setTexturas(Map<String, TextureRegion> textures);
}
