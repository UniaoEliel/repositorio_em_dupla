## Componente `viewCaverna`

Responsável por mostrar na tela o estado atual da caverna e seus atores.

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.view.viewCaverna` <br> 
Autores | `Elias Santos Martins e Gabriel Sanders Pereira Sobral`
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



### Interface `IPlotarCaverna`

Interface de componentes que fornecem o serviço de mostrar na tela o estado atual da caverna e seus atores.

~~~java
public interface IPlotarCaverna {
	public void plotarCaverna(SpriteBatch batch, BitmapFont font);
	public void dispose();
}
~~~

Método | Objetivo
-------| --------
`plotarCaverna`| Utilizando os objetos do libGDX para impressão na tela `batch` e `font`, imprime na tela o estado atual da caverna e de seus componentes, com o herói centralizado
`dispose`| Desaloca a memória utilizada por objetos do libGDX


### Interface `IRCavernaProperties`

Interface requerida de um componente que forneca as propriedades de uma caverna

~~~java
public interface IRCavernaProperties {
	public void connect(ICavernaProperties caverna) throws ArquivoAusente, ArquivoMalFormatado ;
}
~~~

Método | Objetivo
-------| --------
`connect`| conecta aos componente que fornece as propriedades, informado através do parâmetro `caverna`. As exceptions `ArquivoAusente` e `ArquivoMalFormatado` podem ocorrer pois na hora que o viewCaverna é conectado ele lê as texturas dos arquivos de texturas. Ao ocorrer a conexão, é criado uma matriz de viewCelulas e cada viewCelula é conectado a sua célula correspondente no componente `caverna`