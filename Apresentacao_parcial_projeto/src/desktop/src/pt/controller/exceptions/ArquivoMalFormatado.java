package pt.controller.exceptions;

public class ArquivoMalFormatado extends Exception {
	public ArquivoMalFormatado() {
		super();
	}
	
	
	public ArquivoMalFormatado(String nomeArquivo) {
		super("Arquivo mal formatado: " + nomeArquivo);
	}
	
	
	public ArquivoMalFormatado(String nomeArquivo, int linha) {
		super("Arquivo mal formatado: " + nomeArquivo + " na linha " + linha);
	}
}
