## Componente `Ator`

Responsável por representar um ator do jogo e administrar suas interações com outros atores e com as células

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.model.ator` <br> 
Autores | `Elias Santos Martins`
Interfaces | `IAtor, IAtorProperties, IRAcessoCelulas ,IAcoesAtor`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IAtor extends IAtorProperties, IRAcessoCelulas
		, IAcoesAtor {

}
~~~

## Detalhamento das Interfaces

### Interface `IAtorProperties`

Interface das propriedades do componente Ator

~~~java
public interface IAtorProperties {
	public String getTipo();
	public String getNomeRepresentacao();
	public void setTipo(String tipo);
	public char getOrientacao();
	public void setOrientacao(char orientacao);
	public boolean isSolido();
	public int getX();
	public void setX(int x);
	public int getY();
	public void setY(int y);
	public int getVelocidade();
}
~~~

Método | Objetivo
-------| --------
`getTipo`| Retorna qual o tipo do ator
`getNomeRepresentacao`| Retorna o nome da textuea que representa o ator naquele instante
`setTipo`| Configura o tipo do ator (método não utilizado)
`getOrientacao`| Retorna qual a direção do ator. '-' significa que não há direção, e as outras direções são 'w' (pra cima), 's' (pra baixo), 'a' (pra esquerda), e 'd' (pra direita)
`setOrientacao`| Configura a orientação do ator
`isSolido`| Retorna se um ator é sólido, isto é, se não é possível atravessar por ele
`getX`| Retorna a coordenada x do ator no sistema de células que está conectado
`setX`| Informa ao ator sua coordenada x
`getY`| Retorna a coordenada y do ator no sistema de células que está conectado
`setY`| Informa ao ator sua coordenada y



### Interface `IRAcessoCelulas`

Interface requerida de um componente que forneca acesso a um sistema de células.

~~~java
public interface IRAcessoCelulas {
	public void connect(IAcessoCelulas cave);
}
~~~

Método | Objetivo
-------| --------
`connect`| Conecta o componente a outro que forneca acesso a células, informado pelo parâmetro `cave`



### Interface `IAcoesAtor`

Interface fornecida por componentes que fornecam acesso as interações que um ator pode sofrer

~~~java
public interface IAcoesAtor {
	public void entrouCelula();
	public void saiuCelula();
	public void passarRodada();
	public void receberAtaque(String nomeAtacante, int dano);
	public void interagir(IHeroi heroi);
	public void imobilizar(int rodadas);
	public String getTipo();
}
~~~

Método | Objetivo
-------| --------
`entrouCelula`| Faz as interações necessárias com as células e com os atores presentes nela ao entrar em uma célula. Cada objeto define dentro de si essas interações. Por exemplo, o objeto AtaquePadrao causa dano em todos os atores presentes na célula que entrou
`saiuCelula`| Faz as ões necessárias com as células e com os atores presentes nela ao sair de uma célula
`passarRodada`| Realiza ações com base em sua classe. O herói executará o comando do jogador e os inimigos perseguirão o herói
`receberAtaque`| Recebe um ataque de `nomeAtacante` com um dano informado por `dano`. Cada objeto define dentro de si como sofre esse dano
`interagir`| Avisa ao objeto que uma interação foi chamada pelo herói. Cada objeto define dentro de si essa interação. Por exemplo, o baú colocará um item no inventário do herói
`imobilizar`| Deixa o ator sem poder realizar ações por uma quantidade de rodadas informada por `rodadas`
`getTipo`| Retorna o tipo do ator



## Componente `Heroi`

Responsável por representar o herói do jogo, administrar os itens e receber comandos

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.model.ator` <br> 
Autores | `Elias Santos Martins`
Interfaces | `IHeroi, IAtor, IHeroiCoord, IHeroiProperties, IRInventario, IHeroiComando`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IHeroi extends IAtor, IHeroiCoord, IHeroiProperties, IRInventario, IHeroiComando {
	public void ganhar();
}
~~~

## Detalhamento das Interfaces

### Interface `IHeroi`

Interface do componente heroi

~~~java
public interface IHeroi extends IAtor, IHeroiCoord, IHeroiProperties, IRInventario, IHeroiComando {
	public void ganhar();
}
~~~

Método | Objetivo
-------| --------
`ganhar`| Avisa o herói que ele ganhou o jogo


### Interface `IHeroiCoord`

Interface provida por componentes que fornecam acesso as coordenadas do heroi

~~~java
public interface IHeroiCoord {
	public int getX();
	public int getY();
}
~~~

Método | Objetivo
-------| --------
`getX`| Retorna a coordenada x do herói
`getY`| Retorna a coordenada y do herói



### Interface `IHeroiProperties`

Interface das propriedades do componente heroi

~~~java
public interface IHeroiProperties extends IAtorProperties {
	public int getVidaTotal();
	public int getVidaAtual();
	public void setVidaAtual(int NovaVida);
	public IInventarioProperties getInventario();
	public boolean isVivo();
	public boolean ganhou();
	public int getNumItem();
	public String getNomeItemSelecionado();
	public int getAtaque();
	public void setpossuiEspada(boolean x);
	public void setAtaque(int novoAtaque);
	public void receberItem(IItem item);
}
~~~

Método | Objetivo
-------| --------
`getVidaTotal`| Retorna a vida total do herói
`getVidaAtual`| Retorna a vida atual do herói
`setVidaAtual`| Configura a vida atual do herói para `NovaVida`
`isVivo`| Retorna se o herói está vivo
`ganhou`| Retorna se o herói ganhou o jogo
`getNumItem`| Retorna qual o número do item que o herói tem selecionado
`getNomeItemSelecionado`| Retorna qual o nome do item que o herói tem selecionado
`getAtaque`| Retorna o ataque do herói
`setPossuiEspada`| Configura se o herói possui espada, informado pelo parâmetro `x`
`setAtaque`| Configura o ataque para `novoAtaque`
`receberItem`| Adiciona o item `item` em seu inventário




### Interface `IRInventario`

Interface requerida de um componente Inventario

~~~java
public interface IRInventario {
	public void connect(IInventario inventario);
}
~~~

Método | Objetivo
-------| --------
`connect`| Conecta o componente a um componente Inventario, informado através do parâmetro `inventario`



### Interface `IHeroiComando`

Interface provida por componentes que possam receber comandos do jogador e retornar o estado

~~~java
public interface IHeroiComando {
	public void setComandoAtual(char comandoAtual);
	public boolean isVivo();
	public boolean ganhou();
}
~~~

Método | Objetivo
-------| --------
`setComandoAtual`| Configura o último comando recebido como `comandoAtual`
`isVivo`| Retorna se o herói está vivo
`ganhou`| Retorna se o herói ganhou o jogo





