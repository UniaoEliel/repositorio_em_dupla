## Componente `Montador`

Responsável por criar a caverna, instanciar os componentes ator presentes nela e os conectá-los a caverna, e armazenar o herói durante essa criação

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.controller.montador` <br> 
Autores | `Elias Santos Martins`
Interfaces | `IMontador, IRLeitura`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface IMontador extends IRLeitura {
	public ICaverna criarCaverna() throws ArquivoAusente, ArquivoMalFormatado;
	public IHeroi getHeroi();
}
~~~

## Detalhamento das Interfaces

### Interface `IMontador`

Interface provida por componentes que fornecam a montagem da caverna.

~~~java
public interface IMontador extends IRLeitura {
	public ICaverna criarCaverna() throws ArquivoAusente, ArquivoMalFormatado;
	public IHeroi getHeroi();
}
~~~

Método | Objetivo
-------| --------
criarCaverna| Cria a caverna e conecta os componentes ator a ela. Levanta exceções caso o leitor não consiga ler os atores de cave.txt
getHeroi| Se chamado após a criação da caverna, retorna o componente herói conectado a caverna


### Interface `IRLeitura`

Interface requerida de um componente que possa fazer a leitura dos atores da caverna.

~~~java
public interface IRLeitura {
	public void connect(ILeitura leitor);
}
~~~

Método | Objetivo
-------| --------
`connect`| Conecta o componente a outro que possa realizar a leitura, informado através do parâmetro `leitor`.