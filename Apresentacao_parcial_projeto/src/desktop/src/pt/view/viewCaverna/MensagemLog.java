package pt.view.viewCaverna;

public class MensagemLog {
	private String mensagem;
	
	private int tempo;
	
	protected MensagemLog(String mensagem, int tempo) {
		this.mensagem = mensagem;
		this.tempo = tempo;
	}
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tempo) {
		this.tempo = tempo;
	}
	
	public void passarTempo() {
		tempo--;
	}
}
