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
      Caverna caverna;
      Controle controleJogo;
      Montador montadorCaverna = new Montador();
      Heroi hero;
      
      String cave[][] = tk.retrieveCave();

      caverna = montadorCaverna.montarCaverna(cave);
      hero = montadorCaverna.getHeroi();
      
      
      controleJogo = new Controle(hero, caverna);
      
      caverna.tornarVisivel(0, 0);
      caverna.tornarVisivel(1, 1);
      caverna.tornarVisivel(1, 3);
      caverna.tornarVisivel(2, 3);
      caverna.tornarVisivel(1, 2);
      caverna.tornarVisivel(0, 3);
      caverna.tornarVisivel(0, 2);
      
      caverna.imprimeCaverna();
      
      tk.stop();
   }
   
   
   
   
}