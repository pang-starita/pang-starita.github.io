---
title: Aula Lógica de Programação
author: Paulino Ng
date: 2019-10-19
...

### Revisão

#### Exercícios

1. Cite pelo menos 5 **conceitos** de Lógica de Programação:

> * variável
> * escopo de variáveis
> * ciclo de vida de variáveis
> * classes de armazenamento de variáveis
> * linguagem de Programação
> * tipo de dados
> * compilação de códigos
> * interpretação de Códigos
> * subprogramas: função e procedimento
> * algoritmo
> * expressão
> * operador
> * declaração
> * instrução

2. Calcule o MDC de:

  a. 15 e 16

  b. 35 e 15

  c. 45 e 81

### Algoritmo para calcular o MDC de Euclides

Entradas: inteiros positivos a e b

Saida: mdc

1. calcule r = resto da divisão de a por b
2. se r == 0 então mdc = b
   senão a = b; b = r; vá para 1

#### Exercicio:

Use um teste de mesa para verificar que o algoritmo de Euclides calcula
corretamente o MDC do exercício 3. acima.

a. 15 e 16

---------------
  a    b    r
---- ---- ----
 15   16   15

 16   15   1

 15    1   0
--------------

#### Código em Python

```Python
a = int(input('a = '))
b = int(input('b = '))
while b != 0:
  r = a % b
  a = b
  b = r
print('mdc =', a)
```

Este código é o que normalmente aparece nos livros para o cálculo do MDC
com o algoritmo de Euclides. Ele parece diferente do algoritmo informal
escrito antes. Um código mais próximo do algoritmo dado é:

```Python
a = int(input('a = '))
b = int(input('b = '))
while True:
  r = a % b
  if r == 0: break
  a = b
  b = r
print('mdc =', b)
```

### Laboratório

1. Teste o programa para o cálculo do MDC dado em aula.

2. Escreva um programa em Python que implementa um jogo de forca.

```Python
import random
palavras = ['absolutismo', 'totalitarismo', 'inconstitucionalista',
            'oba', 'oca', 'asa', 'aba', 'tab', 'ola', 'ada']
palavra = palavras[random.randrange(len(palavras))]
mostra = []
for ch in palavra:
  mostra.append('_')
print('Adivinhe a palavra:', end=' ')
for ch in mostra: print(ch, end=' ')
print('letra por letra')
chutes = 0
maxchutes = 6
acertos = 0
chs = ''
while chutes < maxchutes:
  ch = input('Chute uma letra: ')
  if ch in chs:
    print('letra ja tentada')
    continue
  else:
    chs += ch
  acertou = False
  for i in range(len(palavra)):
    if ch == palavra[i]:
      acertos += 1
      mostra[i] = ch
      acertou = True
  if not acertou:
    chutes += 1
    print(ch, 'nao aparece na palavra')
  else:
    for ch in mostra: print(ch, end=' ')
    print()
  if acertos == len(palavra): break
if acertos == len(palavra): print("Parabens!")
else:
  print('Que pena, maximo de', maxchutes, 'foi atingido')
  forca = '''
   _________
  |         |
  |        ---
  |      /     \\
  |     | o   o |
  |     |   ^   |
  |      \\  -  /
  |        ---
  |         |
  |        /|\\
  |       / | \\
  |      /  |  \\
  |         |
  |         |
  |        / \\
  |       /   \\
  |     _/     \\_
  |
  |
__|__________________'''
  print(forca)
```
