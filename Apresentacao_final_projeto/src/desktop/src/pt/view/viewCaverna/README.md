## Componente `Comando`

Responsável por ler a entrasa do jogador e a passar para o herói. Oferece o serviço de ler uma tecla do teclado e a passar ao componente herói, e de consultar se o herói ganhou ou perdeu o jogo.

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.view.viewCaverna` <br> 
Autores | `Elias Santos Martins`
Interfaces | `IViewCaverna, IViewCavernaProperties, IPlotarCaverna, IRCavernaProperties`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IViewCaverna extends IViewCavernaProperties, IPlotarCaverna, IRCavernaProperties {
	public void create() throws ArquivoAusente, ArquivoMalFormatado;
}
~~~

## Detalhamento das Interfaces

### Interface `IViewCaverna`

Interface provida por componentes que fornecam a interface gráfica da caverna.

~~~java
public interface IViewCaverna extends IViewCavernaProperties, IPlotarCaverna, IRCavernaProperties {
	public void create() throws ArquivoAusente, ArquivoMalFormatado;
}
~~~

Método | Objetivo
-------| --------
`create`| Cria as estruturas necessárias para a interface gráfica, realizando a leitura das texturas. Levanta exceções em caso de falta ou erro nos arquivos de texturas.


### Interface `IViewCavernaProperties`

Interface das propriedades do componente ViewCaverna.

~~~java
public interface IViewCavernaProperties {
	public void setPixelsX(int pixelsX);
	public void setPixelsY(int pixelsY);
	public void setTamCelula(int tamCelula);
	public void setTamX(int tamX);
	public void setTamY(int tamY);
	public Map<String, TextureRegion> getTexturas();
}
~~~

Método | Objetivo
-------| --------
`setPixelsX`| Configura a quantidade de pixels na direção x presentes na tela, informado por `pixelsX`
`setPixelsY`| Configura a quantidade de pixels na direção y presentes na tela, informado por `pixelsY`
`setTamCelula`| Configura o tamanho em pixels que uma célula deve ter, informado por `tamCelula`
`setTamX`| Configura a quantidade de células na direção x representadas no modelo, informado por `tamX`
`setTamY`| Configura a quantidade de células na direção y representadas no modelo, informado por `tamY`
`getTexturas`| Se chamado após o método `create`, retorna o Map de texturas utilizadas pelo jogo
