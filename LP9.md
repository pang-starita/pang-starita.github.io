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
> * subprogramas
> * algoritmo

2. ...


3. Calcule o MDC de:

a. 15 e 16
b. 35 e 15
c. 45 e 81

### Algoritmo para calcular o MDC de Euclides

Entradas: inteiros positivos a e b

Saida: mdc

1. calcule r = resto da divisão de a por b
2. se r == 0 então mdc = b
   senão a = b; b = r; vá para 1

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

Escreva um programa em Python que implementa um jogo de forca.
