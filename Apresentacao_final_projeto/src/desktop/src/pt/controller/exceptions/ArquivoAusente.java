package pt.controller.exceptions;

public class ArquivoAusente extends Exception {
	public ArquivoAusente() {
		super();
	}
	
	
	public ArquivoAusente(String nomeArquivo) {
		super("Arquivo faltando: " + nomeArquivo);
	}
	
	
	public ArquivoAusente(String nomeArquivo, String nomePasta) {
		super("Arquivo faltando: " + nomeArquivo + " na pasta " + nomePasta);
	}
}
