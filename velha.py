import random

tab = [['O',' ','X'],['O',' ','X'],[' ',' ',' ']]

def sorteio():
    global vez          # precisamos declarar as variáveis globais que serão alteradas
    global pecaUser
    global pecaMaq
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
    print('3 ',a00,'|',a01,'|',a02)
    print('  ',3*'-','|',3*'-','|',3*'-',sep='')
    print('2 ',a10,'|',a11,'|',a12)
    print('  ',3*'-','|',3*'-','|',3*'-',sep='')
    print('1 ',a20,'|',a21,'|',a22)
    print('   a   b   c')
    
def terminou():
    linha1 = tab[2][0] == tab[2][1] == tab[2][2] != ' '
    linha2 = tab[1][0] == tab[1][1] == tab[1][2] != ' '
    linha3 = tab[0][0] == tab[0][1] == tab[0][2] != ' '
    cola = tab[2][0] == tab[1][0] == tab[0][0] != ' '
    colb = tab[2][1] == tab[1][1] == tab[0][1] != ' '
    colc = tab[2][2] == tab[1][2] == tab[0][2] != ' '
    diagp = tab[0][0] == tab[1][1] == tab[2][2] != ' '
    diags = tab[0][2] == tab[1][1] == tab[2][0] != ' '
    return linha1 or linha2 or linha3 or cola or colb or colc or diagp or diags

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
    
sorteio()
imprimeTab()
leJogadaUser()
imprimeTab()
terminou()