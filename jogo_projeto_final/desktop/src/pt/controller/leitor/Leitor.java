package pt.controller.leitor;

import java.io.*;
import java.util.*;
import java.util.Arrays;
import java.util.regex.Pattern;

import pt.controller.exceptions.ArquivoAusente;
import pt.controller.exceptions.ArquivoMalFormatado;
import pt.model.caverna.Caverna;
import pt.model.caverna.Celula;

public class Leitor implements ILeitor {

	// essa classe devera ser singleton
	
	// coloquei uns valor padrao aqui pro codigo funcionar
	// mas tem que ler eles do cave.txt
	
	public int[] getTamanhoCaverna() throws ArquivoAusente, ArquivoMalFormatado {
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
	        
	        if (split.length != 3)
	        	throw new ArquivoMalFormatado("cave.txt", 1);
	        
	        int x = Integer.parseInt(split[1]);
	        int y =Integer.parseInt(split[2]);
	        
	        int [] tamanho =  {x,y};
	        return tamanho;
	        
			    }catch (FileNotFoundException e){//Catch exception if any
			  throw new ArquivoAusente("cave.txt");
			 }	catch (IOException e) {
				 throw new ArquivoMalFormatado("cave.txt");
			 } catch (NumberFormatException e) {
				 throw new ArquivoMalFormatado("cave.txt", 1);
			}
	}
	
	
	public String[][] getAtoresCaverna() throws ArquivoAusente, ArquivoMalFormatado {
		int linha = 5;
		try{
			  FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "/src/pt/controller/cave.txt");
			  
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String linhaAtor;
	        //fazer arraylist
	
			ArrayList<String[]> matrix = new ArrayList<String[]>();
			
			//pula as 4 primeiras linhas
			for (int i = 0 ; i < 4; i++)
				br.readLine();

			
	        while ((linhaAtor = br.readLine()) != null)   {
	        	String patternString = ";";
		        Pattern pattern = Pattern.compile(patternString);	        
		        String[] split = pattern.split(linhaAtor);
		        
		        if (split.length != 4)
		        	throw new ArquivoMalFormatado("cave.txt", linha);
		       
		        ArrayList<String> row = new ArrayList<String>(Arrays.asList(split[0],split[1],split[2],split[3]));
		        matrix.add(split);
		
		        	
		        
		        linha++;
	        }
	        
	        String [][] atoresCaverna = new String[matrix.size()][4];
	        for (int i=0;i < matrix.size(); i++) {
	        	atoresCaverna[i] = matrix.get(i); 
	        }
	        
	        return atoresCaverna;
	        
	        	
	        
			    }catch (FileNotFoundException e){//Catch exception if any
			   throw new ArquivoAusente("cave.txt");
			 } catch (IOException e) {
				 throw new ArquivoMalFormatado("cave.txt", linha);
			 }
	}
	
	
	public String[][] getTexturas() throws ArquivoAusente, ArquivoMalFormatado {
		int linha = 1;
		try{
			  FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "/src/pt/controller/textures.txt");
			  
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String linhaTexturas;
	        //fazer arraylist
			//MOLDE: nomeator; direcao; arquivo da textura; x textura; y textura; layer
			//  [NOME DO ATOR, DIRECAO, ARQUIVO DE TEXTURA, X TEXTURA, Y TEXTURA]
			ArrayList<String[]> matrix = new ArrayList<String[]>();
			
	        while ((linhaTexturas = br.readLine()) != null)   {
	        	String patternString = ";";
		        Pattern pattern = Pattern.compile(patternString);	        
		        String[] split = pattern.split(linhaTexturas);
		        
		        if (split.length != 6)
		        	throw new ArquivoMalFormatado("textures.txt", linha);
		        
		        matrix.add(split);
		        
		        linha++;
	        }
	        
	        String [][] texturasCaverna = new String[matrix.size()][4];
	        for (int i=0;i < matrix.size(); i++) {
	        	texturasCaverna[i] = matrix.get(i); 
	        }
	        
	        return texturasCaverna;
	        
	        	
	        
			    }catch (FileNotFoundException e){//Catch exception if any
			  throw new ArquivoAusente("textures.txt");
			 } catch (IOException e) {
				 throw new ArquivoMalFormatado("textures.txt", linha);
			 }
		
	}
	
	
	public String[][] getLayers() throws ArquivoAusente, ArquivoMalFormatado {
		int linha = 1;
		try{
			  FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "/src/pt/controller/textures.txt");
			  
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String linhaLayers;
	        //fazer arraylist
			//MOLDE: nomeator; direcao; arquivo da textura; x textura; y textura; layer
			 // [NOME DO ATOR, DIRECAO, LAYER]
			ArrayList<String[]> matrix = new ArrayList<String[]>();
			
	        while ((linhaLayers = br.readLine()) != null)   {
	        	String patternString = ";";
		        Pattern pattern = Pattern.compile(patternString);	        
		        String[] split = pattern.split(linhaLayers);
		        
		        if (split.length != 6)
		        	throw new ArquivoMalFormatado("textures.txt", linha);
		        
		        ArrayList<String> row = new ArrayList<String>(Arrays.asList(split[0],split[1],split[5]));
		        
		        String[] rowS = new String[3];
		        
		        for (int i = 0; i < 3; i++)
		        	rowS[i] = row.get(i);
		        matrix.add(rowS);
		        
		        linha++;
	        }
	        
	        String [][] layersCaverna = new String[matrix.size()][3];
	        for (int i=0;i < matrix.size(); i++) {
	        	layersCaverna[i] = matrix.get(i); 
	        }
	        
	        return layersCaverna;
	        
	        	
		    }catch (FileNotFoundException e){//Catch exception if any
				  throw new ArquivoAusente("textures.txt");
				 } catch (IOException e) {
					 throw new ArquivoMalFormatado("textures.txt", linha);
				 }
		
	}
	
	
	public String[] getNomeArquivosTexturas() throws ArquivoAusente, ArquivoMalFormatado {
		int linha = 1;
		try{
			FileInputStream fstream = new FileInputStream(System.getProperty("user.dir") + "/src/pt/controller/textures.txt");
			  
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String linhaTexturas;
		Set<String> nomeTexturas = new HashSet<String>();
		
        while ((linhaTexturas = br.readLine()) != null)   {
        	String patternString = ";";
	        Pattern pattern = Pattern.compile(patternString);	        
	        String[] split = pattern.split(linhaTexturas);
	        
	        if (split.length != 6)
	        	throw new ArquivoMalFormatado("textures.txt", linha);
	        
	        nomeTexturas.add(split[2]);
	        
	        linha++;
        }
        
        String [] texturasCaverna = new String[nomeTexturas.size()];
        
        int i = 0;
        for (String x : nomeTexturas) {
            texturasCaverna[i++] = x;
        }
        
        return texturasCaverna;
         	
	    }catch (FileNotFoundException e){//Catch exception if any
			  throw new ArquivoAusente("textures.txt");
			 } catch (IOException e) {
				 throw new ArquivoMalFormatado("textures.txt", linha);
			 }
		
	}

}
