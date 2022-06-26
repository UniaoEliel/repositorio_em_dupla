import random

class Ator:
    def __init__(self, nome, orientacao):
        self.nome = nome
        self.orientacao = orientacao


def imprimeCaverna(cave):
    caverna = open('cave.txt', 'w')

    caverna.write(f"SIZE;{len(cave)};{len(cave[0])}\n")

    caverna.write("\nMOLDE; x;y;nomeAtor;direcao;\n\n")
    for linha in range(len(cave)):
        for coluna in range(len(cave[linha])):
            if cave[linha][coluna] != 0:
                caverna.write(f"{linha};{coluna};{cave[linha][coluna].nome};{cave[linha][coluna].orientacao}")
                caverna.write("\n")
    
    caverna.close()


def posicaoAleatoria(cave):
    x = random.randint(0, len(cave) - 1)
    y = random.randint(0, len(cave[0]) - 1)

    return x, y


def posicaoValida(cave, x, y):
    return (0 <= x < len(cave)) and (0 <= y < len(cave[0]))


def colocarQuadrado(cave, tipo, x, y, tamX, tamY):
    for i in range(x, x + tamX, 1):
        if posicaoValida(cave, i, y):
            if (cave[i][y] == 0):
                cave[i][y] = Ator(tipo, 's')
            else:
                cave[i][y] = Ator(tipo, '-')

        if posicaoValida(cave, i, y + tamY - 1):
            if (cave[i][y + tamY - 1]  == 0):
                cave[i][y + tamY - 1] = Ator(tipo, 'w')
            else:
                cave[i][y + tamY - 1] = Ator(tipo, '-')

    for j in range(y + 1, y + tamY - 1, 1):
        if posicaoValida(cave, x, j):
            if (cave[x][j] == 0):
                cave[x][j] = Ator(tipo, 'a')
            else:
                cave[x][j] = Ator(tipo, '-')

        if posicaoValida(cave, x + tamX - 1, j):
            if (cave[x + tamX - 1][j] == 0):
                cave[x + tamX - 1][j] = Ator(tipo, 'd')
            else:
                cave[x + tamX - 1][j] = Ator(tipo, '-')
    
    for i in range(x + 1, x + tamX - 1, 1):
        for j in range(y + 1, y + tamY - 1, 1):
            if posicaoValida(cave, i, j):
                cave[i][j] = Ator(tipo, '-')
    


def colocarInimigos(cave, qtdInimigos):
    inimigos = ["aranha", "goblin", "morcego"]
    direcoes = ["w", "a", "s", "d"]
    
    for i in range(qtdInimigos):
        x, y = posicaoAleatoria(cave)
        if cave[x][y] == 0:
            cave[x][y] = Ator(random.choice(inimigos), random.choice(direcoes))
        else:
            i -= 1


def colocarBaus(cave, qtdBaus):
    for i in range(qtdBaus):
        x, y = posicaoAleatoria(cave)

        if cave[x][y] == 0:
            cave[x][y] = Ator("bau", "s")
        else:
            i -= 1


def colocarParedes(cave):
    for i in range(len(cave)):
        cave[i][0] = Ator("parede", "w")
        cave[i][len(cave[i]) - 1] = Ator("parede", "s")

    for j in range(len(cave[i])):
        cave[0][j] = Ator("parede", "d")
        cave[len(cave) - 1][j] = Ator("parede", "a")
    

def colocarQuadradosParedes(cave, qtdQuadrados):
    for i in range(qtdQuadrados):
        colocarQuadrado(cave, "parede", 
            random.randint(0, len(cave)), random.randint(0, len(cave[0]) - 1), 
            random.randint(3, 7), random.randint(3, 7))


def colocarQuadradosLava(cave, qtdQuadrados):
    for i in range(qtdQuadrados):
        colocarQuadrado(cave, "lava", 
            random.randint(0, len(cave)), random.randint(0, len(cave[0]) - 1), 
            random.randint(3, 5), random.randint(3, 5))


def colocarGravetos(cave, qtdGravetos):
     for i in range(qtdGravetos):
        x, y = posicaoAleatoria(cave)
        if cave[x][y] == 0:
            cave[x][y] = Ator("graveto", '-')
        else:
            i -= 1

def colocarPedras(cave, qtdPedras):
    for i in range(qtdPedras):
        x, y = posicaoAleatoria(cave)
        if cave[x][y] == 0:
            cave[x][y] = Ator("pedra", '-')
        else:
            i -= 1

def main():
    tamX = 50
    tamY = 50
    cave = [[0 for x in range(tamY)] for y in range(tamX)]

    cave[1][1] = Ator("heroi", "w")
    

    colocarParedes(cave)

    colocarQuadradosLava(cave, 7)

    colocarQuadradosParedes(cave, 30)

    colocarInimigos(cave, 50)
    colocarBaus(cave, 50)
    colocarGravetos(cave, 50)
    colocarPedras(cave, 50)

    cave[tamX - 1][int(tamY/2)] = Ator("saida", "s")

    for i in range(tamX - 2, int(tamX/2), -1):
        cave[i][int(tamY/2)] = 0
    imprimeCaverna(cave)

    

    


    

if __name__ == "__main__":
    main()
