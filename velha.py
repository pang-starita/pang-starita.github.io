import random

def sorteio():
    global tab
    global vez          # precisamos declarar as variáveis globais que serão alteradas
    global pecaUser
    global pecaMaq
    # inicializa tabuleiro vazio
    tab = [[' ',' ',' '],[' ',' ',' '],[' ',' ',' ']]
    vez = random.randrange(2)
    if vez == 0:
        pecaUser = input('Parabéns, você começa, qual o tipo de peça você quer usar? (O ou X): ')
        if pecaUser[0] == 'O' or pecaUser[0] == 'o':
            pecaMaq = 'X'
        else:
            pecaMaq = 'O'
        if pecaMaq == 'O':
            pecaUser = 'X'
        else:
            pecaUser = 'O'
    else:
        pecaUser = 'O'
        pecaMaq = 'X'
        print('Ganhei o sorteio, minhas peças serão:', pecaMaq, 'Suas pecas são:', pecaUser)
    return

def imprimeTab():
    a00 = tab[0][0]
    a01 = tab[0][1]
    a02 = tab[0][2]
    a10 = tab[1][0]
    a11 = tab[1][1]
    a12 = tab[1][2]
    a20 = tab[2][0]
    a21 = tab[2][1]
    a22 = tab[2][2]
    saida = '''Jogada: {}
3  {} | {} | {}
  ---|---|---
2  {} | {} | {}
  ---|---|---
1  {} | {} | {}
   a   b   c
'''.format(vez // 2, a00,a01,a02,a10,a11,a12,a20,a21,a22)
    print(saida)
#    print('3 ',a00,'|',a01,'|',a02)
#    print('  ',3*'-','|',3*'-','|',3*'-',sep='')
#    print('2 ',a10,'|',a11,'|',a12)
#    print('  ',3*'-','|',3*'-','|',3*'-',sep='')
#    print('1 ',a20,'|',a21,'|',a22)
#    print('   a   b   c')
    return

def ganhoup():
    linha1 = tab[2][0] == tab[2][1] == tab[2][2] != ' '
    linha2 = tab[1][0] == tab[1][1] == tab[1][2] != ' '
    linha3 = tab[0][0] == tab[0][1] == tab[0][2] != ' '
    cola = tab[2][0] == tab[1][0] == tab[0][0] != ' '
    colb = tab[2][1] == tab[1][1] == tab[0][1] != ' '
    colc = tab[2][2] == tab[1][2] == tab[0][2] != ' '
    diagp = tab[0][0] == tab[1][1] == tab[2][2] != ' '
    diags = tab[0][2] == tab[1][1] == tab[2][0] != ' '
    return linha1 or linha2 or linha3 or cola or colb or colc or diagp or diags

def empatoup():
    if ganhoup(): return False
    for lin in range(3):
        for col in range(3):
            if tab[lin][col] == ' ': return False
    return True

def terminou():
    return ganhoup() or empatoup()

def leJogadaUser():
    global tab
    jogada = input('Por favor, forneça as coordenadas (p.ex.: a2) de onde você quer jogar sua peça: ')
    if jogada[0] not in 'abc' or jogada[1] not in '123':
        print('Jogada com coordenadas erradas')
        leJogadaUser()
        return
    if jogada[0] == 'a': col = 0
    elif jogada[0] == 'b': col = 1
    else: col = 2
    if jogada[1] == '1': lin = 2
    elif jogada[1] == '2': lin = 1
    else: lin = 0
    # print('coord(',jogada,') lin(',jogada[1],') =', lin, 'col(',jogada[0],') =', col)
    if tab[lin][col] != ' ':
        print('Posição', jogada, 'já está ocupada')
        leJogadaUser()
        return
    tab[lin][col] = pecaUser
    pass

def jogaMaquina():
    global tab
    # joga na primeira casa livre
    for lin in range(3):
        for col in range(3):
            if tab[lin][col] == ' ':
                tab[lin][col] = pecaMaq
                return
    return

def jogaMaquina2():
    global tab
    # joga aleatoriamente numa casa livre
    livres = []
    for lin in range(3):
        for col in range(3):
            if tab[lin][col] == ' ':
                livres.append((lin,col))
    jogada = livres[random.randrange(len(livres))]
    tab[jogada[0]][jogada[1]] = pecaMaq
    return
 
sorteio()
while not terminou():
    if vez % 2 == 0:
        imprimeTab()
        leJogadaUser()
    else:
        jogaMaquina2()
    vez += 1
imprimeTab()
if empatoup():
    print('Empatou')
else:
    if vez % 2 == 0:
        print('Ha, ha, voce perdeu.')
    else:
        print('Bua, perdi, você ganhou.')