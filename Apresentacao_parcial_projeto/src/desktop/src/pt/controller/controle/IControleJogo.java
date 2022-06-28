package pt.controller.controle;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import pt.controller.exceptions.ArquivoAusente;
import pt.controller.exceptions.ArquivoMalFormatado;

public interface IControleJogo {
	public void iniciarJogo() throws ArquivoAusente, ArquivoMalFormatado;
	
	
	public void passarRodada();
	
	
	public void plotarJogo(SpriteBatch batch, BitmapFont font);
	
	
	public boolean perdeu();
	
	
	public boolean ganhou();
	
	
	public void dispose();
}
