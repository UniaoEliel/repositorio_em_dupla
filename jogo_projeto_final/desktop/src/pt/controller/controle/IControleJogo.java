package pt.controller.controle;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public interface IControleJogo {
	public void iniciarJogo();
	
	
	public void passarRodada();
	
	
	public void plotarJogo(SpriteBatch batch, BitmapFont font);
	
	
	public boolean perdeu();
	
	
	public boolean ganhou();
	
	
	public void dispose();
}
