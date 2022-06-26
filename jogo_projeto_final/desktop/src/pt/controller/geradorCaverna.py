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
    

    xp = random.randint(0, len(cave[i]) - 1)

    cave[xp][len(cave) - 1] = Ator("saida", "s")

def main():
    tamX = 80
    tamY = 30
    cave = [[0 for x in range(tamX)] for y in range(tamY)]

    cave[2][2] = Ator("heroi", "w")

    colocarParedes(cave)

    colocarInimigos(cave, 50)
    colocarBaus(cave, 100)

    imprimeCaverna(cave)

    

    


    

if __name__ == "__main__":
    main()