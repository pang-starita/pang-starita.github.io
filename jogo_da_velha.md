
## Enunciado

Neste documento teremos a especificação de um programa para jogar o jogo
da velha e a lógica de programação para implementar este jogo.

Inicialmente, o jogador automático não terá nenhum tipo de *inteligência*,
seus lances serão totalmente *aleatórios*. Depois tentaremos introduzir algum
tipo de inteligência.

Primeiro precisamos de uma *especificação*. Como se joga o jogo da velha?

O jogo é um jogo de 2 jogadores, num *tabuleiro* `3 x 3`. Os jogadores
jogam alternadamente, marcando com um `O` ou um `X` uma casa livre do tabuleiro.
O primeiro jogador a completar uma *linha*, uma *coluna* ou uma *diagonal*
com suas marcas vence. Se todas as casa forem ocupadas sem nenhum vencedor, há
empate.

Dadas estas regras podemos começar a projetar o programa para jogar jogo da
velha contra um usuário. Não vamos procurar num projeto inicial especificar uma
interface gráfica para o jogo. A interface de jogo será a mais simples possível,
usando a interface de linha.

### Estruturas de dados

Primeiro, vamos pensar em quais são as estruturas de dados que precisamos para
o jogo. Parece bastante claro que precisamos memorizar o tabuleiro, uma
primeira tentativa é memorizar o tabuleiro numa matriz 3 x 3. Cada posição
do tabuleiro/matriz é chamada de casa. Cada casa está num estado: limpa, `X` ou
`O`. 
