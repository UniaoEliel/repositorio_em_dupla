package pt.controller.leitor;

import java.io.*;

import pt.model.caverna.Caverna;
import pt.model.caverna.Celula;

public class Leitor implements ILeitor {

	// essa classe devera ser singleton
	
	// coloquei uns valor padrao aqui pro codigo funcionar
	// mas tem que ler eles do cave.txt
	
	public int[] getTamanhoCaverna() {
		 try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "/src/pt/controller/cave.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  //Read File Line By Line
			  strLine = br.readLine();
			  // Print the content on the console
			  System.out.println (strLine);
			  
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			  }	
		int[] tamanhos = {100, 100};
		return tamanhos;
	}
	
	
	public String[][] getAtoresCaverna(){
		String[][] atores = {
				{"heroi", "w", "5", "5"},
				{"parede", "s", "6", "6"},
				{"parede", "s", "6", "7"}
		};
		return atores;
	}
	
	
	public String[][] getTexturas(){
		
	}
	
	
	public String[][] getLayers(){
		
	}
	
	
	public String[] getNomeArquivosTexturas() {
		
	}
}
