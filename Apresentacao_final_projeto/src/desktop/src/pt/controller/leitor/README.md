## Componente `Leitor`

Responsável por ler dados de arquivos de texto.

![Componente](diagramas/componentes/comando.png)

**Ficha Técnica**
item | detalhamento
----- | -----
Classe | `src.pt.controller.leitor` <br> 
Autores | `Gabriel Sanders Pereira Sobral`
Interfaces | `ILeitor, ILeitura`

### Interfaces

Interfaces associadas a esse componente:

![Diagrama Interfaces](diagrama-interfaces.png)

Interface agregadora do componente em Java:

~~~java
public interface ILeitor extends ILeitura {
	
}
~~~

## Detalhamento das Interfaces

### Interface `ILeitura`

Interface provida por componentes que fornecam a leitura de dados sobre a caverna e as texturas de arquivos de texto

~~~java
public interface ILeitura {
	public int[] getTamanhoCaverna() throws ArquivoAusente, ArquivoMalFormatado;
	public String[][] getAtoresCaverna() throws ArquivoAusente, ArquivoMalFormatado;
	public String[][] getTexturas() throws ArquivoAusente, ArquivoMalFormatado;
	public String[][] getLayers() throws ArquivoAusente, ArquivoMalFormatado;
	public String[] getNomeArquivosTexturas() throws ArquivoAusente, ArquivoMalFormatado;
}
~~~

Método | Objetivo
-------| --------
`getTamanhoCaverna`| Faz a leitura e retorna um vetor de 2 posições, contendo [tamanho em x da caverna, tamanho em y da caverna]
`getAtoresCaverna`| Faz a leitura e retorna um vetor de informações sobre os atores da caverna, onde cada posição tem informações de um ator na forma: [NOME DO ATOR, DIRECAO, POSICAO X, POSICAO Y]
`getTexturas`| Faz a leitura e retorna um vetor de informações sobre os arquivos de texturas, onde cada posição tem informações sobre uma textura na forma: [NOME DO ATOR, DIRECAO, ARQUIVO DE TEXTURA, X TEXTURA, Y TEXTURA]
`getLayers`| Faz a leitura e retorna um vetor de informações sobre o layer da textura de um ator, na forma: [NOME DO ATOR, DIRECAO, LAYER]
`getNomeArquivosTexturas`| Faz a leitura e retorna um vetor contendo o nome de todos os arquivos que contém texturas do jogo
