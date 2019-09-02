% Aula 3 de Lógica de Programação
% Paulino Ng
% 2019-08-27

## Fluxogramas

Este é um recurso gráfico antigo usado para modelar programas/algoritmos.
Este recurso, por muito tempo, foi relegado a um segundo plano devido ao uso de
pseudo-linguagens estruturadas para representar algoritmos. Agora, os
fluxogramas têm um renascimento devido ao uso da modelagem gráfica para o
projeto de sistemas de software com o *UML* - *Unified Modeling Languagem*.
Os fluxogramas são bastante usados para modelar/documentar *software* de
microcontroladores e sistemas de automação. Eles também são muito usados
quando o *SW* é escrito em *Assembly*.

Algoritmos são sempre descritos com um `início`, sequência de passos para
resolver um problema, `fim`. Os blocos básicos de um fluxograma são
representados abaixo:

![Blocos básico de fluxograma.](images/blocos_fluxograma.png)

Fonte: [Página da Wikipedia sobre Flowchart](https://en.wikipedia.org/wiki/Flowchart)

A *elipse* é usada para representar o início e o fim do algoritmo/programa.
Um *retângulo* índica uma ação \(um passo, um processo\) que deve ser executado.
Um *losango* indica um teste que pode ter 2 \(ou 3\) resultados diferentes,
dependendo do resultado, o fluxo de passos muda.
O *paralelogramo* indica entrada ou saída de dados.
Os 2 últimos símbolos, os conectores, servem para indicar *continuações* do
fluxo de instruções/ações quando a página do desenho/gráfico acaba. A *bolinha*
indica que a continuação está na mesma página. O *pentagono* com a ponta para
baixo indica que a continuação está em outra página.
O *retângulo com barras* indica a ativação/chamada de um
sub-processo/subprograma.

Usaremos fluxogramas para entender inicialmente as estruturas de programação
para a repetição de blocos de instruções e instruções condicionais.
Em geral, não usaremos os fluxogramas no dia-a-dia.

## Estruturas de Repetição

É muito comum precisarmos repetir um bloco de instruções \(passos\) nos
programas, as estruturas de programação que permitem estas repetições são:

- `repita <bloco de instrução> até <condição de parada>`, ou o equivalente `faça <bloco de instruções> enquanto <condição de continuidade>`
- `enquanto <condição de continuidade> faça <bloco de instruções>`
- `para <inicialização>; <condição de continuidade>; <incremento> faça <bloco>`

Observe que a primeira destas estruturas é a única que obrigatoriamente executa
o bloco de instruções pelo menos uma vez, as outras podem não executar o
bloco de instruções se a condição de continuidade for falsa desde o início.

É óbvio que se desejamos que a repetição se encerre em algum momento, o bloco de
instruções deve resultar em continuidade falsa ou parada verdadeira em algum
momento. Se não teremos um *loop infinito*, i.e., uma malha de repetição que
continua a executar seu bloco de instruções até que o computador seja desligado
ou o processo de execução terminado externamente.

A seguir, as mas 3 malhas de repetição são ilustradas com os fluxogramas
equivalentes, para melhor fixar o funcionamento das estruturas.

### `repeat ... until condição` ou `do { ... } while (condição)`

![Fluxograma do repeat ... until condição](images/repeat.png)

### `while (condição) ...`

![Fluxograma do while (condição) ... ](images/while.png)

### `for (...; ...; ...) { ... }`

![Fluxograma do for (...; ...; ...) { ... }](images/for.png)

Equivalência entre o for e o while do C/C++/Java.

```
inicialização;
while ( teste ) {
  { instruções a repetir; }
  incremento;
}
```

Observe que o `for` de linguagens como Pascal, Pyhton, ... difere desta
estrutura popularizada pelo C. Nestas outras linguagens, o `for` é uma estrutura
de repetição de contagem e executa a repetição um número exato de vezes que pode
ser determinado na entrada da malha de repetição.

## Exercícios

1. Calcular o fatorial de um N dado usando o for

2. Calcular o n-ésimo elemento da sequência de Fibonacci (para casa)

3. Dado um texto, numa variável str, calcule o texto reverso. Suponha
disponíveis `length(str)`, função que retorna o número de caracteres de `str`,
`[i]` operador de índice que permite acessar o i-ésimo caracter da string e
`str.anexa(c)` que anexa, coloca no final, o caracter `c` na string `str`.

### Teste das soluções com *teste de mesa*
