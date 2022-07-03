## Componente `viewHeroi`

Responsável por mostrar na tela o estado atual do herói, de sua vida e seu inventário

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.view.viewHeroi` <br> 
Autores | `Elias Santos Martins`
Interfaces | `IViewHeroi, IViewHeroiProperties, IPlotarHeroi, IRHeroiProperties`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IViewHeroi extends IViewHeroiProperties, IPlotarHeroi, IRHeroiProperties {

}
~~~

## Detalhamento das Interfaces

### Interface `IViewHeroiProperties`

Interface dos atributos do componente viewHeroi.

~~~java
public interface IViewHeroiProperties {
	public void setPixelsX(int pixelsX);
	public void setPixelsY(int pixelsY);
	public boolean heroiEstaVivo();
	public void setTexturas(Map<String, TextureRegion> textures);
}

~~~

Método | Objetivo
-------| --------
`setPixelsX`| Configura a quantidade de pixels na direção x presentes na tela, informado pelo parâmetro `pixelsX`
`setPixelsY`| Configura a quantidade de pixels na direção y presentes na tela, informado pelo parâmetro `pixelsY`
`heroiEstaVivo`| Retorna se o herói está vivo. Essa função não foi utilizada
`setTexturas`| Configura o Map de texturas que o componente deve usar na impressão


### Interface `IPlotarHeroi`

Interface provida por componentes que oferecam a vizualização do estado atual do herói, de sua vida e de seu inventário

~~~java
public interface IPlotarHeroi {
	public void plotarHeroi(SpriteBatch batch, BitmapFont font);
	public void dispose();
}
~~~

Método | Objetivo
-------| --------
`plotarCaverna`| Utilizando os objetos do libGDX para impressão na tela `batch` e `font`, imprime na tela o estado atual do herói, de sua vida e de seu inventário
`dispose`| Desaloca a memória utilizada por objetos do libGDX


### Interface `IRHeroiProperties`

Interface requerida de um componente que forneca acesso as propriedades de um herói, de sua vida e de seu inventário

~~~java
public interface IRHeroiProperties {
	public void connect(IHeroiProperties heroi);
}
~~~

Método | Objetivo
-------| --------
`connect`| Conecta o componente a outro que forneca as propriedades de um herói, informado através do parâmetro `heroi`