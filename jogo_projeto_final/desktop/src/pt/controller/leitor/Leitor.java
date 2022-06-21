package pt.controller.leitor;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import pt.model.caverna.Caverna;
import pt.model.caverna.Celula;

public class Leitor implements ILeitor {

	// essa classe devera ser singleton
	
	// coloquei uns valor padrao aqui pro codigo funcionar
	// mas tem que ler eles do cave.txt
	
	public int[] getTamanhoCaverna() {
		 try{
			  FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "/src/pt/controller/cave.txt");
			  
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String linhaTamanho;
			  
			  //Le a primeira linha do arquivo cave.txt
			  linhaTamanho = br.readLine();
			 
		 
		 	//Separa o texto em Strings a partir do padrão
	        String patternString = ";";
	        Pattern pattern = Pattern.compile(patternString);	        
	        String[] split = pattern.split(linhaTamanho);
	        
	        int x = Integer.parseInt(split[1]);
	        int y =Integer.parseInt(split[2]);
	        
	        int [] tamanho =  {x,y};
	        return tamanho;
	        
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			 }	
	    
		int[] tamanhos = {100, 100};
		return tamanhos;
	}
	
	
	public String[][] getAtoresCaverna(){
		try{
			  FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "/src/pt/controller/cave.txt");
			  
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String linhaAtor;
	        //fazer arraylist
	
			ArrayList<String[]> matrix = new ArrayList<String[]>();
			
	        while ((linhaAtor = br.readLine()) != null)   {
	        	String patternString = ";";
		        Pattern pattern = Pattern.compile(patternString);	        
		        String[] split = pattern.split(linhaAtor);
		        
		        if (split.length == 4) {
		        ArrayList<String> row = new ArrayList<String>(Arrays.asList(split[0],split[1],split[2],split[3]));
		        matrix.add(split);
		        }
	        }
	        
	        String [][] atoresCaverna = new String[matrix.size()][4];
	        for (int i=0;i < matrix.size(); i++) {
	        	atoresCaverna[i] = matrix.get(i); 
	        }
	        
	        return atoresCaverna;
	        
	        	
	        
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
			 }
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
