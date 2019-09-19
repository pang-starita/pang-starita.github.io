% Aula 6 de Lógica de Programação
% Paulino Ng
% 2019-09-17

## Laboratório

## Resolução dos exercícios com Python no Jupyter-notebook

Vamos primeiro executar o jupyter-notebook e usá-lo para executar algumas
instruções de Python.

Para executar instruções Python no notebook, acione o botão <kbd>New</kbd>, no
topo a direita na barra de ferramentas. Selecione a opção `Python 3` do menu.
Você foi redirecinado para uma nova página com uma área de texto esperando pelo
seu código Python. Esta área é chamada de *célula* do notebook.

### Execute nas células do notebook

Coloque na célula, a expressão abaixo:

```Python
'Alo, Mamae!'
```

Execute a célula pelo teclado com <kbd>Shift</kbd>+<kbd>Enter</kbd> ou com o
*mouse* clicando no botão <kbd>Run</kbd> na barra de ferramentas.

Ao executar uma célula, o notebook escreve o resultado do cálculo da última
instrução se ela resulta num valor e abre uma nova célula para o usuário
colocar/calcular novas instruções. A instrução que foi "executada", na verdade
"calculou" o valor textual `Alo, Mamae!`. Muitas linguagens de programação
não consideram uma instrução válida um *valor literal* solto como o dado. Mas
o Python considera um valor como uma instrução válida (inútil, mas válida).

Experimente "calcular" outros valores como (uma linha em cada célula):

```Python
42
```

```Python
14 * 3
```

```Python
'Alo, ' + 'Mamae!'
```

### Atribuição de valores a variáveis

Vamos colocar (atribuir) valores em variáveis usando o operador de atribuição
`=`.

Coloque numa célula:

```Python
x = 42
```

Execute esta célula. Observe que diferente de quando "executamos" valores
(cálculo de expressões), a execução da célula não resultou em nenhum valor.
Isto porque em Python, a atribuição não gera um valor. Em muitas linguagens (C,
  C++, Java), a atribuição resulta no valor atribuído. Isto permite atribuições
em cascata como: `a = b = c = 42`. Este tipo de atribuição não é possível em
Python.

Para verificar que a variável `x` tem o valor `42`, vamos pedir para imprimir o
valor da variável `x` com a função `print()`. Na célula nova, coloque:

```Python
print(x)
```

Execute e veja que o valor `42` é impresso. Isto porque o `print()` imprime o
valor de seus argumentos.

Vamos trocar o valor de `x` por `'Alo, Mamae!'`.

```Python
x = 'Alo, Mamae!'
print(x)
```

Observe que o valor `42` da variável `x` foi substituído pelo texto
`Alo, Mamae!`. Diferente de linguagens fortemente tipadas como o C, C++, Java,
o Python não exige (na verdade, não permite) a declaração de variáveis com
tipos e permite que o tipo dos valores guardados numa variável mude.

O Python também permite que *múltiplas atribuições* sejam realizadas numa
mesma instrução:

```
x,y,z = 7,11,13
print('x =', x)
print('y =', y)
print('z =', z)
```

### Diferença entre atribuições simultâneas e sequenciais

O Python é uma das raras linguagens que permitem atribuições simultâneas, estas
atribuições simultâneas são diferentes das atribuições sequenciais. Por exemplo,
sejam as atribuições simultâneas abaixo:

```Python
x,y = 1,2
x,y = y,x+y
print('x =', x, '\ty =', y)
```

Este código imprime: `x = 2   y = 3`

Se a segunda atribuição simultânea for realizada sequencialmente:

```Python
x,y = 1,2
x = y
y = x+y
print('x =', x, '\ty =', y)
```

Este código imprime: `x = 2   y = 4`

Se invertermos a ordem das atribuições de `x` e `y`, temos:

```Python
x,y = 1,2
y = x+y
x = y
print('x =', x, '\ty =', y)
```

Este código imprime: `x = 3   y = 3`

A diferença está em que quando a atribuição simultânea foi feita, o
interpretador Python calculou os valores que estavam à direita da atribuição
antes de realizar a atribuição. Isto é, calculou `y,x+y` e encontrou `2,3`.
Aí, atribuiu `2` ao `x` e `3` ao `y`. Nos outros dois casos, os valores de
`x` e `y` foram modificados antes das atribuição desejada. Este fenômeno é
conhecido como *efeito colateral* da concorrência das atribuições. Ele é
particularmente complexo quando existem acessos simultâneos a bancos de dados.

### Cálculo do fatorial de n

Vamos resolver com Python o cálculo do fatorial de um número. Lembrando que:

$$n~!=1~.~2~.~ \dots ~.~ n$$

Numa primeira tentativa para o cálculo do fatorial, vamos fixar o valor de `n`
para um valor cujo fatorial sabemos calcular. Por exemplo, sabemos que $5~!=120$.

O código abaixo usa uma técnica de acumulador para as multiplicações, o `1` é
usado para inicializar o acumulador pois qualquer coisa multiplicada por 1 é
a própria coisa. Isto é, o 1 é neutro na multiplicação. Vamos usar uma estrutura
de repetição para fazer as sucessivas multiplicações. Multiplicamos
sucessivamente o acumulador pela variável de controle que vai variar de 2 até
n (5, neste protótipo/exemplo).

```Python
n = 5
acc = 1
i = 2
while i <= n:
    acc *= i
    i += 1
print('fatorial de ', n, 'eh', acc)
```

A instrução `acc *= i` é uma atribuição com operação, ela é o mesmo que
`acc = acc * i`. Isto é, coloque no acumulador `acc`, o valor da multiplicação
do conteúdo de `acc` com o conteúdo de `i`. Isto é, na primeira iteração, `1 * 2`,
pois `acc` e `i` valem, respectivamente, `1` e `2`. Agora o `acc` tem o valor
`2`. Na instrução seguinte, a variável de controle `i` recebe `2 + 1`. Como
`3 <= 5` é verdadeiro, temos uma segunda iteração, no fim da qual, `acc` e `i`
adquirem os valores `6` e `4`. Após a terceira iteração temos: `24` e `5`.
Após a quarta iteração, `120` e `6`. Como `6 <= 5` é falso, o `while` termina.
Aí, o `print()` é executado.

#### Função que calcula o fatorial

Agora que  sabemos como calcular o fatorial de n, para podermos reutilizar
o código para uso futuro, vamos transformar o código numa função e usá-lo:

```Python
def fatorial(n):
  ...

### Cálculo do n-ésimo elemento da sequência de Fibonacci

Vamos aproveitar a atribuição
