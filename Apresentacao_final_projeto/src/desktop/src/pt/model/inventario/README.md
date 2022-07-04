## Componente `Inventario`

Responsável por administrar um inventario de componentes Item e suas interações com o herói e o sitema de células

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.model.inventario` <br> 
Autores | `Elias Santos Martins e Gabriel Sanders Pereira Sobral`
Interfaces | `IInventario, IInventarioProperties, IAcessoItens, IRHeroi, IRAcessoCelulas`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IInventario extends IInventarioProperties, IAcessoItens, IRHeroi, IRAcessoCelulas {

}
~~~

## Detalhamento das Interfaces

### Interface `IInventarioProperties`

Interface das propriedades do componente Inventario.

~~~java
public interface IInventarioProperties {
	public IItem getItem(int posicao);
	public int getQuantidadeItens();
	public int getTamanho();
	public void setTamanho(int tamanho);
	public String getNomeItem(int indice);
}
~~~

Método | Objetivo
-------| --------
`getItem`| Retorna o item na posição informada por `posicao`. Se não houver item ou a posição for inválida, retorna null
`getQuantidadeItens`| Retorna quantos itens há no inventário
`getTamanho`| Retorna o tamanho do inventário
`setTamanho`| Faz com que o inventário tenha o tamanho informado por `tamanho`
`getNomeItem`| Retorna o nome do item na posicao informada por `indice`. Se não houver item, retorna a string "nada"


### Interface `IAcessoItens`

Interface provida por componentes que fornecam acesso a um sistema de itens

~~~java
public interface IAcessoItens {
	public void inserirItem(IItem item);
	public void removerItem(IItem item);
	public void passarRodada();
	public IItem getItem(int posicao);
	public String getNomeItem(int indice);
}
~~~

Método | Objetivo
-------| --------
`inserirItem`| Insere o item `item` no inventário e conecta o item ao componente heroi, se houver espaço
`removerItem`| Remove o item `item` do inventário, se ele estiver presente, se não estiver não faz nada
`passarRodada`| Avisa todos os itens que uma rodada se passou
`getItem`| Retorna o item na posição informada por `posicao`. Se não houver item ou a posição for inválida, retorna null
`getNomeItem`| Retorna o nome do item na posicao informada por `indice`. Se não houver item, retorna a string "nada"


### Interface `IRHeroi`

Interface requerida de um heroi

~~~java
public interface IRHeroi {
	public void connect(IHeroi heroi);
}
~~~

Método | Objetivo
-------| --------
`connect`| Conecta o inventario a um componente Heroi, informado por `heroi`. Também conecta todos os itens presentes neste componente.



### Interface `IRAcessoCelulas`

Interface requerida de um um componente que forneca acesso a um sistema de células

~~~java
public interface IRAcessoCelulas {
	public void connect(IAcessoCelulas caverna);
}
~~~

Método | Objetivo
-------| --------
`connect`| Conecta o inventario a um componente que ofereça o serviço de acesso as células, informado por `caverna`. Também conecta todos os itens presentes neste componente.

## Componente `Item`

Responsável por representar um item do jogo

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.model.inventario` <br> 
Autores | `Elias Santos Martins e Gabriel Sanders Pereira Sobral`
Interfaces | `IItem, IRHeroi, IRAcessoCelulas`

### Interface `IItem`

Interface de um item do inventário

~~~java
public interface IItem extends IRHeroi, IRAcessoCelulas {
	public String getNome();
	public void passarRodada();
	public void passarRodada(int x, int y);
	public void entrouCelula();
	public void entrouCelula(int x, int y);
	public void saiuCelula(int x, int y);
	public void saiuCelula();
	public void usar();
	public void equipar();
	public void desequipar();
	public void setInventario(Inventario inventario);
}
~~~

Método | Objetivo
-------| --------
`getNome`| Retorna o nome do item
`passarRodada`| Realiza as interaçõoes necessárias com o componente Heroi e o componente que fornece acesso as células quando uma rodada se passa. Por sobrecarga, pode não ser informado nada, quando o método é chamado do inventario do heroi, ou informado as coordenadas (`x`,`y`) da célula, quando o item está no chão. Por exemplo, a tocha ao passar uma rodada perde durabilidade
`entrouCelula`| Realiza as interações necessárias com as células e seus atores ao entrar em uma célula. Por sobrecarga, pode não ser informado nada, quando o método é chamado do inventario do heroi, ou informado as coordenadas (`x`,`y`) da célula, quando o item está no chão. Por exemplo, a tocha ao entrar em uma célula ilumina em um círculo ao redor dela
`saiuCelula`| Realiza as interações necessárias com as células e seus atores ao sair de uma célula. Por sobrecarga, pode não ser informado nada, quando o método é chamado do inventario do heroi, ou informado as coordenadas (`x`,`y`) da célula, quando o item está no chão. Por exemplo, a tocha ao sair de uma célula retira a luz em um círculo ao redor dela
`usar`| Aplica os efeitos do uso do item no componente herói. O item pode ou não sumir ao usar esse método. Por exemplo, a poção ao ser usada aumenta a vida do herói
`equipar`| Aplica os efeitos de equipar o item no componente herói. Por exemplo, a espada ao ser equipada aumenta o ataque do herói
`desequipar`| Aplica os efeitos de desequipar o item no componente herói. Por exemplo, a tocha ao ser desequipada retira a luz das células
`setInventario`| Configura a qual inventário o item pertence, informado pelo parâmetro `inventario`