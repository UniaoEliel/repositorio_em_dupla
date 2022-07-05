## Componente `Caverna`

Responsável por controlar e coordenar as células, oferecer acesso as células e aos atores presentes nela, administrar a validade dos movimentos e localizar o herói nas células.

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.model.caverna` <br> 
Autores | `Elias Santos Martins e Gabriel Sanders Pereira Sobral`
Interfaces | `ICaverna ICavernaProperties, IAcessoCelulas,IRHeroiCoord`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface ICaverna extends ICavernaProperties, IAcessoCelulas, IRHeroiCoord{
	
}
~~~

## Detalhamento das Interfaces

### Interface `ICavernaProperties`

Interface das propriedades do componente caverna.

~~~java
public interface ICavernaProperties {
	public void setTamX(int tamX);
	public void setTamY(int tamY);
	public int getTamX();
	public int getTamY();
	public ICelula getCelula(int x, int y);
	public int getXHeroi();
	public int getYHeroi();
	public int distanciaQuadrado(int x1, int y1, int x2, int y2);
	public String[] getLogRodada();
	public void start();
}
~~~

Método | Objetivo
-------| --------
`setTamX`| Configura a quantidade de células na direção x que a caverna deve ter, informado pelo parâmetro `tamX`
`setTamY`| Configura a quantidade de células na direção y que a caverna deve ter, informado pelo parâmetro `tamY`
`getTamX`| Retorna a quantidade de células na direção x na caverna
`getTamY`| Retorna a quantidade de células na direção y na caverna
`getCelula`| Se `x`, `y` for uma posição dentro da caverna, retorna a célula em (`x`, `y`), caso contrário retorna null.
`getXHeroi`| Retorna a posição x do herói presente na caverna
`getYHeroi`| Retorna a posição y do herói presente na caverna
`getLogRodada`| Retorna um vetor de strings onde cada posição contém uma interação entre os atores da caverna ocorrido na última rodada que se passou
`start`| Inicia a caverna, alocando suas células


### Interface `IAcessoCelulas`

Interface provida por componentes que oferecam acesso a seu sistema de células

~~~java
public interface IAcessoCelulas {
	public void inserirAtor(IAtor a, int x, int y);
	public void removerAtor(IAtor a, int x, int y);
	public void removerAtor(String tipo, int x, int y);
	public void moverAtor(IAtor a, int novox, int novoy);
	public void somaIluminacao(int iluminacao, int x, int y);
	public int getIluminacao(int x, int y);
	public void iluminarCelulas(int x, int y, int raio);
	public void desiluminarCelulas(int x, int y, int raio);
	public void passarRodada();
	public IAcoesAtor[] getAtores(int x, int y);
	public boolean verificaValidade(int x, int y);
	public void inserirNoLog(String acontecimento);
	public boolean entravel(int x, int y);
	public int getXHeroi();
	public int getYHeroi();
	public int distanciaQuadrado(int x1, int y1, int x2, int y2);;
}
~~~

Método | Objetivo
-------| --------
`inserirAtor`| Insere o ator `a` na célula em (`x`, `y`), se a posição em (`x`, `y`) for válida e o ator `a` puder entrar na célula, caso contrário não faz nada
`removerAtor`| Remove um ator na célula em (`x`, `y`) se ele estiver presente lá, e o avisa que ele foi removido, caso contrário não faz nada. Pode ser informado o ator que irá ser removido atraves do parâmetro `a` ou o tipo de ator a ser removido, através do parâmetro `tipo`. Se a posição for inválida ou o ator não for encontrado, não faz nada
`moverAtor`| move o ator `a` para a célula em (`novox`, `novoy`), se a posição em (`novox`, `novoy`) for válida e o ator `a` puder entrar na célula, e avisa o ator do movimento. Se o movimento for inválido, não faz nada.
`somaIluminacao`| Soma a quantidade de luz `iluminacao` na luz da célula em (`x`, `y`), se a posição em (`x`, `y`) for válida, se não não faz nada.
`iluminarCelulas`| Ilumina as células válidas em um círculo ao redor da posição (`x`, `y`), de forma que o centro do círculo tem iluminação máxima e a luz vai caindo quanto mais perto da borda do círculo. O raio do círculo é informado através do parâmetro `raio`.
`desiluminarCelulas`| Retira a luz válidas em um círculo ao redor da posição (`x`, `y`). O raio do círculo é informado através do parâmetro `raio`.
`passarRodada`| Avisa todos os componentes ator em um raio de 16 células ao redor do herói da caverna que uma rodada se passou.
`getAtores`| Retorna um vetor dos componentes ator presentes na célula em (`x`, `y`), se a posição em (`x`, `y`) for válida, se não retorna null.
`verificaValidade`| Verifica se uma posição (`x`, `y`) é válida, isto é, se ela está dentro da caverna
`inserirNoLog`| Insere um acontecimento, informado através do parâmetro `acontecimento`, no log da rodada em curso
`entravel`| Retorna se é possível entrar na célula em (`x`, `y`). Se a posição for inválida retorna false
`getXHeroi`| Retorna a posição x do herói presente na caverna
`getYHeroi`| Retorna a posição y do herói presente na caverna
`distanciaQuadrado`| Retorna a distância ao quadrado entre a célula (`x1`, `y1`) e (`x2`, `y2`)



### Interface `IRHeroiCoord`

Interface requerida de um componente que forneca as coordenadas do herói presente na caverna

~~~java
public interface IRHeroiCoord {
	public void connect(IHeroiCoord heroi);
}
~~~

Método | Objetivo
-------| --------
`connect`| Conecta a caverna a um componente que ofereca as coordenadas do heroi, informado através do parâmetro `heroi`


### Interface `ICelulaProperties`

Interface das propriedades de uma célula, necessária na conexão com o viewCaverna

~~~java
public interface ICelulaProperties {
	public String[] getNomeRepresentacoes();
	public int getIluminacao();
}
~~~

Método | Objetivo
-------| --------
`getNomeRepresentacoes`| Retorna um vetor de strings contendo o nome da representação atual de cada componente Ator presente na célula
`getIluminacao`| Retorna a iluminação atual da célula



## Componente `Celula`

Responsável por representar uma célula, armazenar os atores e controlar a entrada e saída dos atores, verificando se são válidas

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.model.caverna` <br> 
Autores | `Elias Santos Martins`
Interfaces | `ICelula, ICelulaProperties`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface ICelula extends ICelulaProperties{

}
~~~

## Detalhamento das Interfaces

### Interface `ICelulaProperties`

Interface das propriedades do componente celula.

~~~java
public interface ICelulaProperties {
	public String[] getNomeRepresentacoes();
	public int getIluminacao();

~~~

Método | Objetivo
-------| --------
`getNomeRepresentacoes`| Retorna o nome das texturas de todos os atores presentes na celula, e o nome da textura do chão da célula
`getIluminacao`| Retorna a iluminação atual da célula