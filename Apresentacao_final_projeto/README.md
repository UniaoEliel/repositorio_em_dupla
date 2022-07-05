# Projeto 'Nictofobia'

# Descrição Resumida do Projeto/Jogo

O projeto é um jogo onde o jogador se encontra em uma caverna escura com apenas uma tocha que vai se apagando. A escuridão é perigosa, e a caverna está lotada de monstros, baús e gravetos que podem virar tocha. Seu objetivo é sair da caverna vivo.

# Equipe
* Elias Santos Martins - 247057
* Gabriel Sanders Pereira Sobral - RA

# Arquivo Executável do Jogo

[Arquivo JAR](https://drive.google.com/file/d/1S9cACZ-sS0ul9WTPu7YXQKtS0VLTWt6X/view?usp=sharing)

# Slides do Projeto

## Slides da Prévia
[Slides](https://drive.google.com/file/d/14FVyU6uTYqqIJiO0VbpYSVwQkQQt--oc/view?usp=sharing)

## Slides da Apresentação Final
[Slides](https://docs.google.com/presentation/d/1APJYX9cu8l4tpm9bBZRFFNDrj554BkNwClB65h1eNm4/edit?usp=sharing)


## Relatório de Evolução

> Relatório de evolução, descrevendo as evoluções do design do projeto, dificuldades enfrentadas, mudanças de rumo, melhorias e lições aprendidas. Referências aos diagramas e recortes de mudanças são bem-vindos.

# Destaques de Código
## Destaque 1 - Administração de rodadas da caverna
Por eficiência, a caverna só avisa que uma rodada passou para atores em um raio de 16 do herói, e faz isso considerando as velocidades de cada um, do maior pro menor.
~~~java
public class Caverna implements ICaverna {
	private PriorityQueue<IAtor> pq;
	private int raioRodada;

   public void passarRodada() {
		int x = heroi.getX(), y = heroi.getY();
		
		for (int i = x - raioRodada; i <= x + raioRodada; i++) {
			for (int j = y - raioRodada; j <= y + raioRodada; j++) {
				if (verificaValidade(i ,j)) {
					atores = celulas[i][j].getAtores();
					for (IAtor ator : atores) {
						pq.add(ator);
		...
      while (!pq.isEmpty())
            pq.poll().passarRodada();
   }
}
~~~

# Destaques de Orientação a Objetos

## Destaque 1 - Hierarquia do componente ator
Destacamos a hierarquia de classes abstratas componente ator, que faz grande uso do polimorfismo e herança para administrar os comportamentos de cada ator diferente na caverna. A classe Ator define o comportamento comum de todos os atores e de suas interações com a caverna. A classe AtorAtaque define o comportamento dos ataques e alertas gerados pelos atores, controlando a duração, a aplicação do dano. A classe AtorObjeto define o comportamento dos objetos como parede, lava, pedra, que não interagem. A classe AtorVivo define o comportamento de atores vivos, administrando vida, ataque, defesa, quantidade de rodadas pra se mover e atacar, oferece métodos de movimento e busca de caminhos. Por fim, a classe AtorInimigo define o comportamento dos inimigos, sobreescrevendo passarRodada() para eles perseguirem o herói e controlando o sistema de dropar itens quando morrem. Isso tudo permite a fácil inserção de novos atores, basta fazê-los herdeiros da classe abstrata correta e definir neles somente comportamentos específicos, usando sobrecarga de métodos presentes nas classes abstratas.

### Diagrama de Classes usada no destaque OO:
![Diagrama das classes abstraras](diagramas/atorabstrato.png)

### Código do Destaque OO
Para exemplificar a utilidade da hierarquia, vamos tomar o código do inimigo aranha. Ele precisa apenas definir valores para os atributos e escrever seus comportamentos específicos, que são a forma de ataque (sobrecarga método atacar()) e a forma de dropar itens (sobrecarga método droparItem())
~~~java
public class Aranha extends AtorInimigo {
	private int countPocaVenenosa, countTeia;
	
	public Aranha() {
		super();
		this.ataque = 12;
		this.vidaTotal = 25;
		this.defesa = 4;
		this.vidaAtual = this.vidaTotal;
		...
	}
	
	
	private void pocaVenenosa(int x, int y) {
		Veneno veneno = new Veneno();
		veneno.setDuracao(50);
		AlertaAtaque alerta = gerarAlertaAtaque(veneno, 5, x, y);
		alerta.connect(cave);
		...
	}
	
	
	private void lancarTeia(int x, int y) {
		...
	}

	@Override
	public void atacar(int x, int y) {
		...
      int ale = aleatorio.nextInt(100);
      if (countPocaVenenosa == 0 && ale <= 30) 
         pocaVenenosa(x, y);
      else if (countTeia == 0 && ale >= 30 && ale <= 50) 
         lancarTeia(x, y);
      else if (cave.distanciaQuadrado(x, y, this.x, this.y) < 4)
         super.atacar(x, y);
      else if (podeMover()) {
         seMoverEmDirecaoA(x, y);
		...
	}
	
	
	@Override
	public void passarRodada() {
		super.passarRodada();
		if (countPocaVenenosa > 0)
			countPocaVenenosa--;
		...
	}


	@Override
	protected void droparItem() {
		...
		if (ale <= 50)
			item = new Graveto();
		else if (ale <= 70)
			item = new PocaoVida();
		
		if (item != null)
			colocarItemChao(item, this.x, this.y);
	}
}
~~~

Tomando como segundo exemplo a saída da caverna, ela precisa apenas definir sua interação com o herói e iluminar células
~~~java
public class Saida extends AtorObjeto {
	public Saida() {
		this.solido = true;
		this.orientacao = 's';
		this.tipo = "saida";
	}
	
	
	@Override
	public void entrouCelula() {
		cave.iluminarCelulas(x, y, 3);
	}
	
	@Override
	public void interagir(IHeroi heroi) {
		heroi.ganhar();
	}
}
~~~
Entre outros. Toda a dinâmica do jogo é definida por esse método

## Destaque 2 - método passarRodada
O comportamento de cada ator ou item é definido no que ele faz ao passar uma rodada. Todos os atores, itens e a prórpia caverna tem esse método, o que simplifica a chamada e explora o polimorfismo. Cada objeto define dentro de si seu comportamento. A caverna avisa os atores que a rodada passou, os inimigos vão tentar perseguir e atacar o herói, o herói vai realizar o comando do jogador e avisar seus itens que a rodada passou, a tocha vai se apagar um pouco, pedras e paredes não irão fazer nada, etc.

### Diagrama do destaque OO
![Diagrama da chamada](diagramas/rodada.png)
### Código do destaque OO
Exemplo na classe atorInimigo, os inimigos tem o comportamento de perseguir o herói
~~~java
public abstract class AtorInimigo extends AtorVivo {
   public void passarRodada() {
		int xHeroi = cave.getXHeroi(), yHeroi = cave.getYHeroi();
		...
			if (distanciaAoHeroi <= raioAtaque * raioAtaque + 1)
				atacar(xHeroi, yHeroi);
			
			else if (podeMover() && distanciaAoHeroi >= raioAtaque * raioAtaque &&
					distanciaAoHeroi <= raioAlcance * raioAlcance)
				seMoverEmDirecaoA(xHeroi, yHeroi);
			
			else if (podeMover() && aleatorio.nextInt(100) <= 20)
					movimentoAleatorio();
			}
      ...
}
~~~
No herói, ele tenta realizar seu comando e avisa seu item
~~~java
public class Heroi extends AtorVivo implements IHeroi {
   public void passarRodada() {
		super.passarRodada();
		realizarComando(comandoAtual);
      if (itemSelecionado != null)
			itemSelecionado.passarRodada();
		...
	}
}
~~~
A tocha é apagada um pouco, e se sua luz apagar ela some
~~~java
public class Tocha extends Item {
   public void passarRodada() {
		luz--;
		if (luz == 0)
			inventario.removerItem(this);
		...
	}
}
~~~

## Destaque 3 - Ataque como ator
A realização de ataque entre atores no jogo é feita criando um objeto AtorAtaque e o colocando na caverna. Esse objeto, quando entra em uma célula, aplica seu efeito a todos os outros atores presentes na célula. Isso faz com que seja fácil programar diferentes tipos de ataque, e facilita a integração com a interface gráfica

# Destaques de Pattern

## Destaque 1 - facade
O componente ControleJogo implementa o pattern facade, ao ter métodos simples como iniciarJogo, passarRodada, heroiGanhou, heroiPerdeu, através da interface IControleJogo. 

### Diagrama do Pattern
![Diagrama das classes abstraras](diagramas/controlejogo.png)

### Código do Pattern
Interface com comandos gerais
~~~java
public interface IControleJogo {
	public void iniciarJogo() throws ArquivoAusente, ArquivoMalFormatado;
	public void passarRodada();
	public void plotarJogo(SpriteBatch batch, BitmapFont font);
	public boolean perdeu();
	public boolean ganhou();
	public void dispose();
}
~~~
Os métodos usam vários componentes para realizar a tarefa
~~~java
public class ControleJogo implements IControleJogo {
   private IComando leitorComandos;
	private IViewCaverna viewCave;
   private IViewHeroi viewHeroi;
   private ICaverna cave;
   ...
   
	public void passarRodada() {
		leitorComandos.lerComando();
		cave.passarRodada();
	}

	public void plotarJogo(SpriteBatch batch, BitmapFont font) {
		viewCave.plotarCaverna(batch, font);
		viewHeroi.plotarHeroi(batch, font);
	}
}
~~~
O pattern faz isso reunindo vários componentes atrás de si e escondendo sua complexidade, de modo que todas as chamadas necessárias para controlar o estado do jogo são feitas por meio dele. As vantagens disso são que é fácil controlar o fluxo de acontecimentos do jogo e a adaptabilidade, ja que por trás do facade pode se ter qualquer jogo baseado em turnos em uma caverna, onde o jogador pode ganhar e perder, ou seja, o código que chama o pattern não precisa saber detalhes sobre qual é o jogo.

## Destaque 2 - Singleton
Usamos o pattern singleton para evitar duplicidades em componentes que precisam somente de uma instância, como ControleJogo e Montador
### Código do pattern
~~~java
public class Montador implements IMontador {
	private static final Montador instance = new Montador();
	
	private Montador() {
		...
	}
	
	
	public static Montador getInstance() {
		return instance;
	}
}
~~~
O componente deixa seu construtor privado, de modo que ninguém possa instanciá-lo, e oferece sua instância através de getInstance.

# Conclusões e Trabalhos Futuros

> Apresente aqui as conclusões do projeto e propostas de trabalho futuro. Esta é a oportunidade em que você pode indicar melhorias no projeto a partir de lições aprendidas e conhecimentos adquiridos durante a realização do projeto, mas que não puderam ser implementadas por questões de tempo. Por exemplo, há design patterns aprendidos no final do curso que provavelmente não puderam ser implementados no jogo -- este é o espaço onde você pode apresentar como aplicaria o pattern no futuro para melhorar o jogo.

# Documentação dos Componentes

O vídeo a seguir apresenta um detalhamento de um projeto baseado em componentes:

[![Projeto baseado em Componentes](http://img.youtube.com/vi/1LcSghlin6o/0.jpg)](https://youtu.be/1LcSghlin6o)

# Diagramas

## Diagrama Geral da Arquitetura do Jogo

Arquitetura dos componentes quando o jogo inicia
![alt tag](https://i.imgur.com/eE0ZNH3.png)
Arquitetura dos componentes quando o jogo está rodando
![alt tag](https://i.imgur.com/HpDbqfX.png)

## Diagrama Geral de Componentes

> Se você adotou componentes de software, apresente a documentação de componentes conforme o modelo.


# Plano de Exceções

## Diagrama da hierarquia de exceções
![Hierarquia Exceções](diagramas/exceptions.png)

## Descrição das classes de exceção

Classe | Descrição
----- | -----
ArquivoAusente | Indica que um dos arquivos de texto ou texturas do jogo não foi localizada
ArquivoMalFormatado | Indica que um dos arquivos de texto do jogo está fora do formato padrão ou com dados faltando, o que não permite seu uso
