% Aula 2 de Lógica de Programação
% Paulino Ng
% 2019-08-20

Nesta aula veremos alguns conceitos básicos de computação para podermos
entender melhor os conceitos de programação que serão vistos posteriormente.
Vamos começar pela arquitetura de *von Neumann* que descreve conceitualmente
a estrutura física dos computadores modernos. Veremos como isto afeta a
programação dos computadores e como as linguagens de programação procuram
fornecer uma abstração de alto nível para que não tenhamos de programar
num nível conceitual próximo ao da máquina computacional.

Lembro que nesta disciplina só nos interessa o computador digital. No computador
digital a unidade de informação é um *bit*. Um *bit* é algo que pode ter
apenas 2 valores \(estados\), **0** ou **1**. Fisicamente o bit pode ser um
sinal elétrico do tipo tensão \(tensão baixa, quase zero, é **0**, alta, 2 a 5V,
  ou mais, é **1**, presença de corrente é **1**, corrente nula é **0**,
  frequência baixa é **1**, alta é **0**, enfim, escolha-se uma convenção para
  um tipo de implementação e defina-se  o significado do bit e seus valores\),
pode ser diversas outras *convenções*.

## Arquitetura de *von Neumann*

[John von Neumann](https://en.wikipedia.org/wiki/John_von_Neumann), um
cientista, matemático e físico húngaro-americano, considerado como o
último dos grandes matemáticos, é o autor de um artigo que descreve um dos
primeiros computadores da história. Não vou reproduzir exatamente a arquitetura
do artigo, mas resumir de maneira mais moderna o que foi proposto.

Antes, vamos entender o conceito de arquitetura de computador. É bem similar
ao conceito de arquitetura de edificações. É óbvio que a arquitetura tem
a ver com a estrutura física, mas não necessariamente com a realização
material. Como na construção civil, o engenheiro civil está preocupado com
a realização física do prédio, o arquiteto está preocupado com aspectos
funcionais, estéticos, ambientais, ... Na computação, o arquiteto de um
computador se preocupa com funcionalidades dos componentes do computador,
conjunto de instruções do processador, protocolos de comunicação entre os
componentes do computador, ... Os engenheiros de computação, projetistas de
hardware, HW, são as pessoas preocupadas em realizar fisicamente, dizemos
implementar o computador. Veremos a arquitetura, não a implementação.

### Componentes da arquitetura de *von Neumann*

Os componentes da arquitetura de *von Neumann* são:

1. **Processador**: responsável por executar as instruções
2. **Memória**: responsável por armazenar os dados e as instruções
3. **Barramento**: responsável pela comunicação entre os componentes
4. **Entradas**: responsável por capturar/receber os dados externos ao computador
5. **Saídas**: responsável por enviar os dados para o meios externos ao computador

### Memória principal do computador

Ela é formada pelos módulos de memória DDR nos PCs que os alunos usam.
A memória pode ser entendida como uma tabela onde são guardados os dados e as
instruções do computador. Na tecnologia atual, a tabela tem uma única coluna
e em cada linha temos um *byte* \(8 bits\).

### Processador

- ciclo de busca e execução
- cjto de instruções
- cálculo da próxima instrução
- sequencialidade das instruções na arquitetura de von Neumann
- interação com os barramentos

### Barramento

Sistema de comunicação que interliga os outros componentes permitindo a
transferência de dados/instruções.

### Entradas e Saídas

Componentes que permitem adquirir dados de e enviar dados para fora do
computador. Geralmente, são compostos por duas partes: um controlador
de dispositivo e um periférico.

## Linguagens de Programação

Programar diretamente na linguagem do computador é muito complicado para
seres humanos. A linguagem mais próxima da linguagem de máquina é a linguagem
*Assembly* que usa mnemônicos para as instruções. Os mnemônicos são palavras, ou
siglas/abreviações, que em inglês lembram o que a instrução faz. Exemplos de
mnemônicos são: MOV, CPY, CMP, JMP, JZ, JC, ADD, SUB, MUL, DIV, ...
Algumas instruções de máquina precisam dos endereços de memórias de dados ou de
instruções, para não ficar usando números sem significados, o *Assembly* permite
o uso de *rótulos* para os endereços e o programador pode definir o valor destes
*rótulos* ou deixar o *Assembler* calcular o endereço a ser usado. O *Assembler*
é o programa que converte o texto *Assembly* \(programa *Assembly*\) em
linguagem de máquina. Em português, chamamos o *Assembler* de *montador*.

Alguns pequenos programas \(subprogramas\) são escritos em *Assembly* por
precisarem acessar detalhes de *hardware* que não são acessíveis com linguagens
de alto nível, como partes de um *driver* de *SO* ou por necessitarem de
um desempenho melhor do que o compilador pode oferecer. Observe que compiladores
modernos são capazes de otimizar o código muito melhor do que a maioria dos
programadores. A programação de microcontroladores muitas vezes é realizada em
*Assembly*.

### Conceitos de + alto nível

#### tipos de dados

#### estruturas de controle de fluxo de instrução

##### condicionais

##### repetição

##### subprogramas: funções e procedimentos
