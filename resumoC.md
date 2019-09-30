% Resumo de Programação C
% Paulino Ng
% 2019-09-30

## Programa Alo

Seguindo os passos de [1], este resumo começa com o programa alo.c, cujo código
é:

```C
#include <stdio.h>

int main() {
  printf("Alo!\n");
  return 0;
}
```

A linha `#include <stdio.h>` pede para o pré-compilador do C incluir o arquivo
`stdio.h` no lugar da linha. Isto permite usar a chamada da função `printf()`.

Todo programa C deve ter uma implementação da função `main()`. Esta é a função
que o sistema operacional *chama* ao carregar o programa para a execução.

A função `main()` retorna um valor inteiro para indicar se o programa executou
corretamente ou não. Se a `main()` retorna `0` (zero), o programa executou sem
erros. Se executar com algum tipo de erro, o valor do retorno é diferente de
`0`.

Além da instrução de retorno, a única instrução dentro do corpo da `main()` é
a chamada à função `printf()`. A função `printf()` imprime uma mensagem
(*texto*) na tela do usuário (na *console* do usuário). A mensagem é o
argumento da chamada da função, `"Alo!\n"`. Este texto é chamado de *string* e
consiste na sequência de caracteres `'A'`, `'l'`, `'o'`, `'!'`, `'\n'` e `'\0'`.
O carácter `'\n'` é para terminar a linha do `"Alo!"` e começar um nova.

As instruções em C terminam com um `;` obrigatório.

## Pré-processador

### `#include`

Pelo fato do C ser uma linguagem de programação bastante simples, não existe
muita coisa pronta na linguagem. Por outro lado, o C possui uma grande
quantidade de bibliotecas de funções que podem ser reutilizadas nos
programas poupando muito esforço de programação. Estas bibliotecas estão em
arquivos `.a` ou `.so` no Unix, ou `.lib` ou `.dll` no MS Windows.
O editor de ligações estáticas ou dinâmicas vai incluir o código destas
funções ao código executável, mas, antes disto, o compilador precisa conhecer
o protótipo das funções antes das
funções serem chamadas nos programas dos programadores-usuários das bibliotecas.

Esta é uma das funções dos arquivos cabeçalho, fornecer os protótipos das
funções das bibliotecas. Além disso, é nos arquivos cabeçalhos onde estruturas
de dados, constantes e variáveis globais são declaradas em programas C.

Os arquivos cabeçalho de C, geralmente, usam a extensão `.h`. Os arquivos
cabeçalho das bibliotecas costumam está em diretórios do sistema de compilação.
Mas, o programador pode criar seus próprios arquivos cabeçalho e colocá-los em
qualquer diretório.

Como as declarações dos arquivos cabeçalho são necessárias para poder usar
as bibliotecas, o programador teria de copiá-los em cada arquivo de código que
utilizasse as funções das bibliotecas. Para evitar estas cópias, os arquivos
de códigos C (tanto fonte como cabeçalho), pedem para um pré-compilador(ou
  pré-processador) para
incluir os arquivos cabeçalho. A instrução `#include <stdio.h>` é uma
instrução para o pré-compilador de C substituir esta linha pelo conteúdo do
arquivo `stdio.h`. Os `<>` servem para indicar que o arquivo deve ser procurado
nos diretórios de sistema. No lugar de `<>` (*bicudos*), podemos usar `""`.
Isto é, `#include "stdio.h"`, neste caso, o pré-compilador procura o arquivo
`stdio.h` no diretório do código fonte antes dos diretórios de sistema.

### `#define`

Além do `#include`, o pré-compilador C permite criar *macros*. Na sua forma mais
simples *macros* servem para definir constantes. Por exemplo, para definir a
constante &pi; em C, pode-se fazer:

```
#define PI 3.141592653589793
```

Se dentro do código C aparecer o nome da *macro* (`PI`), o nome vai ser
substituído pelo valor associado. Por exemplo:

```C
    printf("%f", sin(PI/4));
```

O pré-compilador vai substituir `PI` pelo valor e o código que será compilado é:

```C
    printf("%f", sin(3.141592653589793/4));
```

As macros podem ser parametrizadas, isto é, podemos colocar parâmetros para as
macros. Uma maneira inocente de definir uma macro para calcular o menor
valor (o valor mínimo) entre 2 números é:

```C
#define MIN(x,y) (x < y) ? x : y
```

Macros parametrizadas são muito avançadas para este resumo.

### `#ifdef` e `#ifndef`

Os arquivos cabeçalho incluem outros arquivos cabeçalho e pode ocorrer de numa
sequência de inclusões, um mesmo arquivo ser incluído mais de uma vez. Para
evitar o erro de múltiplas declarações (o que não é permitido em C), é
necessário usar um esquema de exclusão de múltiplas declarações. Isto é obtido
pelo uso do condicional do pré-compilador. A estrutura que todos os arquivos
de cabeçalho usam é:

```C
#ifndef _nome_do_arquivo.H_
#define _nome_do_arquivo.H_

// declarações e outros conteúdos do arquivo cabeçalho

#endif
```

Estas instruções para o pré-compilador permitem que um arquivo cabeçalho seja
incluído múltiplas vezes sem provocar dupla declaração de variáveis, protótipos,
etc.

## Comentários em C

O C tem 2 tipos de comentários: `//` e `/* */`. `//` inicia um comentário que
vai até o final da linha. `/*` inicia um comentário que termina quando `*/` é
encontrado. Isto permite comentários em múltiplas linhas e comentários no
meio de uma linha. Por exemplo:

```C
  x = 0; // x é inicializado com 0 (comentário idiota)
  /* comentário de várias linhas
   * são usados para explicar uso de funções e estruturas e algoritmos.
   */
  y = 1 + /* este é um comentário mal posto */ 41;
```

## Declaração de variáveis em C

O C atualmente é uma linguagem fortemente tipada com tipagem estática. Isto é,
todas as variáveis em C precisam ser declaradas antes de serem utilizadas e
o tipo das variáveis não pode mudar durante a execução do programa.

As variáveis são sempre declaradas com uma das seguintes sintaxes:

```
<tipo> nome_da_var;
<tipo> <lista de nomes de variáveis>;
<tipo> nome_da_var = <expressão com valor calculável durante a compilação>;
```

A seguir, tem-se algumas declarações válidas em C:

```C
int x, y, z;  // x, y e z são variáveis inteiras (32 bits com o gcc atual)
log int lx, ly, lz; // lx, ly e lz são variáveis inteiras com mais bits do que int
long lx1;    // lx1 é long int, o int é opcional
short sx, sy; // sx e sy são inteiros com um número menor de bits do que int
float f, g; // f e g são variáveis de ponto flutuante com 32 bits
double ff, gg;  // ff e gg são variáveis de ponto flutuante com 64 bits
char ch;  // ch é uma variável do tipo carácter
char linha_nova = '\n'; // linha_nova é uma variável do tipo carácter inicializada
                        // com \n
char nome[80];          // nome é uma variável capaz de guardar 80 caracteres
```

[1]. Kernighan, B.W. & Ritche, D.M., The C Programming Language, Prentice-Hall.
