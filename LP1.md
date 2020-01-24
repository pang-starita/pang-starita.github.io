% Aula 2 de Lógica de Programação
% Paulino Ng
% 2019-08-20

Nesta aula são vistos alguns conceitos básicos de computação para podermos
entender melhor alguns conceitos de programação que serão vistos posteriormente.
Começamos pela arquitetura de *von Neumann* que descreve conceitualmente
a estrutura dos computadores modernos. Veremos como isto afeta a
programação dos computadores e como as linguagens de programação procuram
fornecer uma abstração de alto nível para que não tenhamos de programar
num nível conceitual próximo ao da máquina computacional. Em seguida, veremos
conceitos básicos de linguagens de programação.

Lembre-se de que nesta disciplina só nos interessa o computador digital.
No computador digital, a unidade de informação é um *bit*.
Um *bit* é algo que pode ter apenas 2 valores \(estados\), **0** ou **1**.
Fisicamente o bit pode ser um sinal elétrico do tipo tensão
\(tensão baixa, quase zero, é **0**, alta, 2 a 5V,
  ou mais, é **1**, presença de corrente é **1**, corrente nula é **0**,
  frequência baixa é **1**, alta é **0**, enfim, escolha-se uma convenção para
  um tipo de implementação e defina-se  o significado do bit e seus valores\),
pode-se ter diversas outras *convenções*.

## Arquitetura de *von Neumann*

[John von Neumann](https://en.wikipedia.org/wiki/John_von_Neumann), um
cientista, matemático e físico húngaro-americano, considerado como o
último dos grandes matemáticos, é o autor de um artigo que descreve um dos
primeiros computadores da história. Não vou reproduzir exatamente a arquitetura
do artigo, mas resumir de maneira mais moderna o que foi proposto.

Antes, vamos entender o conceito de arquitetura de computador. É bem similar
ao conceito de arquitetura de edificações. É óbvio que a arquitetura tem
a ver com a estrutura física, mas não necessariamente com a realização
material dela.
Como na construção civil, o engenheiro civil está preocupado com
a realização física do prédio, o arquiteto está preocupado com aspectos
funcionais, estéticos, ambientais, visuais, ...
Na computação, o arquiteto de um
computador se preocupa com funcionalidades dos componentes do computador,
conjunto de instruções do processador, protocolos de comunicação entre os
componentes do computador, ...
Os engenheiros de computação, projetistas de hardware, HW, são as pessoas
preocupadas em realizar fisicamente, dizemos implementar o computador.
Veremos a arquitetura, não a implementação.

### Componentes da arquitetura de *von Neumann*

Os componentes da arquitetura de *von Neumann* são:

* **Processador**: responsável por executar as instruções.
* **Memória**: responsável por armazenar os dados e as instruções.
* **Barramento**: responsável pela comunicação entre os componentes.
* **Entradas**: responsável por capturar/receber os dados externos ao computador.
* **Saídas**: responsável por enviar os dados para o meios externos ao computador.

![Fig. 1 - Arquitetura de um computador monoprocessador](monoprocessador.png)

### Memória principal do computador

Ela é formada pelos módulos de memória DDR nos PCs e notebooks que os alunos
usam. As instruções e os dados a serem acessados pelo processador ficam na
memória principal.
A memória pode ser entendida como uma tabela onde são guardados os dados e as
instruções do computador. Na tecnologia atual, a tabela tem uma única coluna
e em cada linha temos um *byte* \(8 bits\).
Para acessar um *byte* específico, é preciso fornece a linha onde ele está.
A linha é chamada de *endereço*. A memória é acessada através de 3 barramentos:

* **Barramento de dados**: por onde circulam os *bytes* de dados da memória.
* **Barramento de endereços**: determinam o endereço \(linha\) do\(s\) byte\(s\).
* **Barramento de controle**: determina o tipo de operação que é feita no
  endereço. Se for *leitura*, a memória coloca o dado do endereço solicitado no
  barramento de dados, se for *escrita*, a memória grava o dado do barramento
  no endereço solicitado.

### Processador

O processador é responsável pela *execução* das instruções dos programas.
Os principais blocos funcionais de um processador \(*CPU - Central Processing
  Unit*\) são ilustrados na figura 2.

![Fig. 2 - Blocos funcionais de um processador](images/cpu.png)  

A figura 2 não mostra as interconexões, barramentos internos, que ligam os
blocos funcionais e suas ligações com o exterior.

* ALU - *Arithmetic Logic Unit*: Unidade Lógico-Aritmética \(ULA\), circuito
combinacional que recebe 2 operandos e realiza operações de adição, substração,
multiplicação e divisão inteira em representação de complemento de 2 e as
operações lógicas bit-a-bit nos 2 operandos, os sinais vindos da decodificação
da instrução comandam a operação a ser feita. Os operandos vêm dos registradores
e o resultado é armazenado em algum registrador. A decodificação determina
quais são os registradores envolvidos.

* Registradores: circuitos de memorização rápidos \(*SRAM*\). Cada registrador
armazena uma palavra \(*vários bytes*\). Servem para armazenar os
dados que são manipulados pelas instruções do processador. Na tecnologia atual,
a manipulação direta de dados na memória principal causaria muito retardo na
execução das instruções. Isto porque o aumento de velocidade dos circuitos
digitais da ALU não foi acompanhado pela velocidade de acesso à memória
*DRAM*.

* *Status*: Registrador da palavra de *status* que contém as *flags* que
armazenam condições resultantes da execução da última instrução. *Flags* são
*bits* de memória que indicam, por exemplo, que a última operação da ALU
resultou em ZERO, um valor negativo, positivo, *overflow* \(estouro\), ...
Existem instruções que testam estas condições e realizam desvios condicionais
no fluxo de instruções de acordo com o valor de uma *flag*.

* UC - Unidade de Controle: Como o nome sugere, este é o circuito que controla
as operações realizadas no processador e gera sinais de controle também para os
outros componentes dos computador \(estes sinais são transmitidos através dos
  barramentos\). Os sinais de controle são gerados pelos circuitos interpretando
as instruções que o processador deve executar.
A unidade de controle é um circuito sequencial bastante complexo e diferentes
técnicas foram usadas para o projeto da unidade de controle. Nos primeiros
circuitos VLSI era comum usar PLAs, microprogramação, nanoprogramação. Apenas
os processadores mais simples usavam *lógica aleatória*. Com o aumento da
velocidade, uso de técnicas de *pipeline* com muitos estágios, etc. O uso de
lógica aleatória se tornou obrigatório.

* IR - *Instruction Register*: registrador de instrução, armazena a instrução que
está sendo executada neste instante.

* Decodificação Instrução: a máquina de estado que decodifica a instrução do IR
e gera os sinais de controle para a execução da instrução.

* Próxima Instrução: calcula o endereço da próxima instrução. No modelo da
máquina de von Neumann, o endereço da próxima instrução, em geral, é a instrução
seguinte. Isto é, o endereço da instrução atual mais o número de bytes da
instrução. A exceção é se a instrução atual causa um desvio condicional, ou
não. Ou se existe um desvio provocado por uma condição de *HW* \(interrupção\).

* PC - *Program Counter*: registrador que armazena o endereço da próxima
instrução.

O processador funciona basicamente seguindo continuamente um ciclo de busca
de instrução na memória primária e execução. O projeto lógico do processador
determina o conjunto de instruções que o processador é capaz de executar.
Os blocos funcionais e o *conjunto de instruções* do processador formam
a arquitetura de um processador e, em geral, determinam a arquitetura de um
computador.
Os circuitos descritos anteriormente permitem que o processador execute
diferentes instruções que no todo formam o conjunto de instruções dele.

Detalhes do projeto das instruções de um processador são cobertos na disciplina
de *arquitetura de computadores*. O que nos interessa nesta introdução é que as
instruções que um processador digital é capaz de executar estão divididas nas
seguintes categorias:

- **instruções de transferência de dados**: como o aluno deve ter percebido,
existem lugares onde os dados podem estar: arquivos em discos, memória
principal, registradores, memória cache, dispositivos de entrada e saída. O
processador possui instruções que permitem transferir \(às vezes dizemos que os
  dados são movimentados\) os dados de um local para outro. Em particular,
existem instruções que transferem dados da memória para um registrador do
processador \(`load`\), ou de um registrador para um endereço de memória
\(`store`\), de um registrador para outro, de um dispositivo de entrada ou
saída para um registrador ou no sentido contrário.

- **instruções de manipulação de dados**: instruções que operam nos dados \(em
  geral presentes num registrador\). As operações são as aritméticas ou lógicas
que a ALU é capaz de executar.

- **instruções de desvio na sequência de instruções**: instruções que permitem
desviar da sequência normal de endereços. Estas instruções incluem os desvios
condicionais e os incondicionais. Além dos desvios simples, a maioria dos
processadores possuem instruções de desvio que *empilham* o endereço seguinte
para um retorno. Estas instruções são denominadas de *chamadas de rotinas*.

- **instruções de controle de hardware e outras**: existem instruções que são
destinadas a controlar o hardware \(por exemplo, instruções que interagem com
  o gerenciador de memória principal, ou com dispositivos de entrada e saída\)
e outras para facilitar a implementação de mecanismos necessários para o
sistemas operacionais modernos \(virtualização de núcleos de processamento, ...\).

### Barramento

Sistema de comunicação que interliga os outros componentes permitindo a
transferência de dados/instruções entre eles. Existem barramentos entre os
componentes e existem barramentos internos aos componentes. Como os barramentos
implicam em conexões entre os componentes, muitas vezes, os barramentos são
compartilhados, isto é, uma conexão não liga apenas dois componentes, mas
vários componentes simultaneamente.
Os barramentos podem ainda serem subdivididos pelo tipo de sinal que eles
transferem:

- **barramento de dados**: os dados fluem entre todos os componentes. Em geral,
todos os componentes do computador podem ser fontes de dados e receptores de
dados, portanto, o barramento de dados é bidirecional.

- **barramento de endereços**: para selecionar a posição de memória cujo dado
está sendo acessado, é necessário que o endereço da posição seja fornecido
pelo processador. O processador é uma fonte de endereços. Na maioria das
arquiteturas modernas de computadores, um controlador de DMA \(Direct Memory
  Access\) também pode fornecer endereços. A memória só recebe endereços.

- **barramento de controle**: neste barramento tem-se os sinais de controle para
a memória e os dispositivos de entrada e saída. Sinais como leitura de memória,
escrita de memória, leitura de dispositivo de entrada e saída, escrita em
dispositivo de entrada e saída. Além desses sinais, existem as linhas de
interrupção, *reset* e sinais que são usados para controlar a comunicação com o
barramento.

### Entradas e Saídas

Componentes que permitem adquirir dados de e enviar dados para fora do
computador. Geralmente, são compostos por duas partes: um controlador
de dispositivo e um periférico. Exemplos de periféricos são: teclado,
*mouse*, camera, disco rígido, monitor, conexão de rede, ...
Exemplos de controladores de dispositivos são: controlador de vídeo, controlador
de interface serial/paralela, controlador USB, interface de rede, ...

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
é o programa que converte o texto *Assembly* em linguagem de máquina.
Em português, chamamos o *Assembler* de *montador*.

Alguns pequenos programas \(subprogramas\) são escritos em *Assembly* por
precisarem acessar detalhes de *hardware* que não seriam acessíveis em linguagens
de alto nível, como partes de um *driver* de *SO* ou por necessitarem de
um desempenho melhor do que o compilador pode oferecer. Observe que compiladores
modernos são capazes de otimizar o código muito melhor do que a maioria dos
programadores. A programação de microcontroladores muitas vezes ainda é
realizada em *Assembly*.

### Conceitos de mais alto nível

As linguagens de programação procuram proporcionar conceitos de mais alto nível
e esconder conceitos de baixo nível. No lugar de trabalhar com endereços de
memória, as linguagens de programação fornecem o conceito de variável. Uma
variável corresponde a uma área de memória com um endereço inicial. No lugar
de usar o endereço, usa-se o nome da variável.
As linguagens de programação *entendem* tipos de dados que representam melhor
os dados como os seres humanos os entendem do que os dados como os circuitos
entendem. Os dados do ponto de vista dos circuitos são palavras binárias, do
ponto de vista humano são números, textos, cores, texturas, ...
Linguagens de programação estruturadas fornecem
estruturas de fluxo de instruções que eliminam os desvios que
Dijkstra denunciou como culpados por muitos erros de programação. No lugar de
desvios, usam-se estruturas sequenciais, condicionais, de repetição e chamada
de subprogramas \(funções ou procedimentos\).

#### Tipos de dados

O hardware do computador praticamente só conhece valores binários \(digitais\).
Estes não são facilmente interpretados por seres humanos. É mais compreensível
entender os dados do mundo real com números decimais, reais e textos.
As linguagens de programação fornecem representações binárias para estes tipos
de dados livrando o programador das representações binárias na maior parte do
tempo. Assim, as linguagens de programação oferecem tipos de dados inteiros,
ponto flutuante para números reais, caracteres em algum tipo de codificação.
Atualmente, usa-se muito a codificação ASCII e a UTF-8. Os textos são formados
com sequências de caracteres.

#### Estruturas de controle de fluxo de instrução

As instruções na maioria das linguagens de programação são supostas serem
executadas **sequencialmente**. A sequência das instruções pode precisar
seguir caminhos diferentes dependendo do valor de alguns dados. Isto é obtido
com instruções condicionais. Em que o valor de uma condição determina o fluxo
de instruções a ser seguido.

Frequentemente, uma sequência de instruções precisa ser repetida, para tanto,
usa-se as **instruções de repetição**.

Muitas vezes, percebe-se que trechos de código realizam um tipo de processamento
bastante específico e precisamos usar este tipo de processamento em diferentes
programas e partes de programas. Este tipo de ideia sugere que existem
subprogramas que são repetidamente usados nos programas. O conceito de
subprograma foi expandido e a instrução que usa um subprograma é denominada
de **chamada de subprograma**. Apesar de rodar o mesmo código em cada chamada
de subprograma, podemos querer mudar alguns dados que são processados pelo
subprograma. Estes dados que mudam de chamada para chamada de subprograma são
chamados de **parâmetros** dos subprogramas. Os valores dos dados que são passados
para os subprogramas são chamados de **argumentos**. Muitas vezes os termos
parâmetros e argumentos são usados como sinônimos, apesar de não serem. Nesta
disciplina vamos usá-los como sinônimos.

Os subprogramas podem ser divididos em 2 tipos diferentes: **funções** e
**procedimentos**. As funções procuram calcular algo baseados nos valores dos
argumentos na chamada. Elas sempre retornam um valor. Os procedimentos podem
realizar tarefas diferentes, em geral, interações com os meios externos ou
alterações dos estados de dados globais. Os procedimentos não retornam valores.

A chamada de um subprograma desvia o fluxo de instruções para o subprograma. O
subprograma retorna ao programa \(ou subprograma\) que o chamou quando termina.

### Subprogramas

A ideia de subprograma é bastante simples: Existem trechos de programas que
precisamos escrever repetidamente. Para evitar estas reescritas que deixam
o texto do programa muito grande. Sempre que estes trechos repetitivos
executam uma tarefa muito bem definida, transformamos estes trechos em
subprogramas. No lugar onde escreveríamos estes trechos de código, chamamos
o subprograma que realiza a tarefa. Em linguagens antigas, existia uma
instrução `CALL` para chamar os subprogramas. Em linguagens mais modernas,
os subprogramas são chamados de *funções* quando retornam valores e
*procedimentos* quando não retornam nenhum valor. A chamada dos subprogramas
não precisam mais de um `CALL` explicito, basta escrever o nome da função, ou
do procedimento e a lista de argumentos, quando houver, entre parênteses, `()`.

A definição do código da função ou do procedimento é chamado de *implementação*
da função. O código do que a função deve executar é chamado de *corpo da função*.
