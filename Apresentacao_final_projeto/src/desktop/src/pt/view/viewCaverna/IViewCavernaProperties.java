package pt.view.viewCaverna;

import java.util.Map;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public interface IViewCavernaProperties {
	public void setPixelsX(int pixelsX);

	public void setPixelsY(int pixelsY);
	
	public void setTamCelula(int tamCelula);
	
	public void setTamX(int tamX);
	
	public void setTamY(int tamY);
	
	public Map<String, TextureRegion> getTexturas();
}
