package pt.c40task.l05wumpus;

import java.util.Scanner;

public class AppWumpus {

   public static void main(String[] args) {
      AppWumpus.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   
   public static void imprimeMatriz(char[][] matriz) {
	   for (int i = 0; i < matriz.length; i++) {
		   for (int j = 0; j < matriz[i].length; j++) {
			   System.out.print(matriz[i][j] + " ");
		   }
		   System.out.println();
	   }
   }
   
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
           String arquivoMovimentos) {
		Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
		Caverna caverna;
		Controle controleJogo;
		Montador montadorCaverna = new Montador();
		Heroi hero;
		String cave[][] = tk.retrieveCave();
		
		caverna = montadorCaverna.montarCaverna(cave);
		hero = montadorCaverna.getHeroi();
		controleJogo = new Controle(hero, caverna);
		
		if (arquivoMovimentos == null)
			executaInterativo(tk, caverna, controleJogo);
		else
			executaOutro(tk, caverna, controleJogo);
	}
   
   
   public static void executaInterativo(Toolkit tk, Caverna caverna, Controle controleJogo) {
	   Scanner entrada = new Scanner(System.in);
	   char[][] cave;
		while (true) {
			cave = controleJogo.getEstadoCaverna();
			tk.writeBoard(cave, controleJogo.getPontuacao(), controleJogo.getStatus());

			imprimeMatriz(cave);
			System.out.println("Player: Sting");
			System.out.println("Score: " + controleJogo.getPontuacao());

			if (controleJogo.getStatus() == 'W') {
				System.out.println("Voce ganhou =D !!!");
				break;
			}
			if (controleJogo.getStatus() == 'L') {
				System.out.println("Voce perdeu =(...");
				break;
			}

			char comando = entrada.next().charAt(0);
			
			if (comando == 'q') {
				System.out.println("Volte sempre !");
				break;
			}
			controleJogo.realizarComando(comando);
		}

		entrada.close();
   }
   
   
   public static void executaOutro(Toolkit tk, Caverna caverna, Controle controleJogo) {
	   char[][] cave;
	   String movements = tk.retrieveMovements();
		for (int i = 0; i < movements.length(); i++) {
			cave = controleJogo.getEstadoCaverna();
			tk.writeBoard(cave, controleJogo.getPontuacao(), controleJogo.getStatus());

			imprimeMatriz(cave);
			System.out.println("Player: Sting");
			System.out.println("Score: " + controleJogo.getPontuacao());

			if (controleJogo.getStatus() == 'W') {
				System.out.println("Voce ganhou =D !!!");
				break;
			}
			if (controleJogo.getStatus() == 'L') {
				System.out.println("Voce perdeu =(...");
				break;
			}
				
			controleJogo.realizarComando(movements.charAt(i));
		}
   }
   
   /*
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
      String cave[][] = tk.retrieveCave();
 
      
      String movements = tk.retrieveMovements();
      System.out.println("=== Movimentos");
      System.out.println(movements);
      
      System.out.println("=== Caverna Intermediaria");
      char partialCave[][] = {
         {'#', '#', 'b', '-'},
         {'#', 'b', '-', '-'},
         {'b', '-', '-', '-'},
         {'p', '-', '-', '-'}
      };
      int score = -120;
      char status = 'x'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
      tk.writeBoard(partialCave, score, status);

      System.out.println("=== Última Caverna");
      char finalCave[][] = {
         {'#', '#', 'b', '-'},
         {'#', 'b', '#', 'f'},
         {'b', '-', '-', 'w'},
         {'#', '-', '-', '-'}
      };
      score = -1210;
      status = 'n'; // 'w' para venceu; 'n' para perdeu; 'x' intermediárias
      tk.writeBoard(finalCave, score, status);
      
      tk.stop();
   }
	*/
}
