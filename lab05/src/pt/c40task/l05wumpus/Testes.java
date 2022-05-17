package pt.c40task.l05wumpus;

public class Testes {

   public static void main(String[] args) {
      Testes.executaJogo(
            (args.length > 0) ? args[0] : null,
            (args.length > 1) ? args[1] : null,
            (args.length > 2) ? args[2] : null);
   }
   
   public static void executaJogo(String arquivoCaverna, String arquivoSaida,
                                  String arquivoMovimentos) {
      Toolkit tk = Toolkit.start(arquivoCaverna, arquivoSaida, arquivoMovimentos);
      
      String cave[][] = tk.retrieveCave();
      
      for (int i = 0; i < cave.length; i++)
    	  System.out.println(cave[i][0] + " " + cave[i][1] + " " + cave[i][2]);
      
      Caverna c;
      c = Montador.montarCaverna(cave);
      
      c.tornarVisivel(0, 0);
      c.tornarVisivel(1, 1);
      c.tornarVisivel(1, 3);
      c.tornarVisivel(2, 3);
      c.tornarVisivel(1, 2);
      c.tornarVisivel(0, 3);
      c.tornarVisivel(0, 2);
      
      c.imprimeCaverna();
      
      tk.stop();
   }
   
}