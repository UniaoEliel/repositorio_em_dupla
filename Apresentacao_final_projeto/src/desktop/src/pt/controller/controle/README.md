## Componente `Controle`

Responsável por iniciar e controlar o jogo, funciona como um facade e um builder

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.controller.controle` <br> 
Autores | `Elias Santos Martins`
Interfaces | `IControleJogo`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

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

## Detalhamento das Interfaces

### Interface `IControleJogo`

Interface provida por componentes que fornecam a iniciação e controle de um jogo baseado em rodadas

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

Método | Objetivo
-------| --------
`iniciarJogo`| Inicia o jogo, instanciando todos os componentes necessários para o seu funcionamento
`passarRodada`| Passa uma rodada no espaço do jogo, avisando todos os componentes
`plotarJogo`| Recebe os objetos do libGDX de interface gráfica `batch` e `font` e os utiliza para mostrar na tela o estado atual do jogo
`perdeu`| Retorna se o jogo está ganho
`ganhou`| Retorna se o jogo está perdido
`dispose`| Libera a memória de objetos do libGDX usados pelo jogo