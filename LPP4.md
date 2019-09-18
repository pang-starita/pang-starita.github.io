% Aula de Linguagem de Programação Procedural 5
% Paulino Ng
% 2019-09-13

Vimos em *Lógica de Programação* o uso de estruturas de repetição para resolver
3 exercícios:

1. calcular o fatorial de um número
2. calcular o n-ésimo elemento da sequência de Fibonacci
3. calcular a *string* reversa de uma *string* dada

A estes exercícios são acrescentadas os seguintes:

4. ler as notas P1 e P2 de um aluno e calcular a média, tendo a P1 peso 1 e a P2 peso 2
5. o programa a seguir deveria imprimir na saída:
```
Nome: Raul Andrade,     P1 =  4.5,      P2 =  7.0
```
Mas não apresenta os resultados desejados, corrija-o para que a saída seja da
forma desejada.

```C
#include <string.h>
#include <stdio.h>

int main () {
    char str[80] = "Raul Andrade; 4.5; 7";
    char nome[64];
    char* cursor;
    float p1, p2;
    int i;
    for (cursor = str, i = 0; *cursor && *cursor != ';'; cursor++, i++)
        nome[i] = *cursor;
    nome[i+1]='\0';
    sscanf(cursor, ";%f", &p1);
    sscanf(cursor, ";%f", &p2);
    printf("Nome: %s,\tP1 = %4.1f,\tP2 = %4.1f\n", nome, p1, p2);
    return(0);
}
```

[Solução 1: realizando a leitura das 2 notas no mesmo scanf](notas1.c)

[Solução 2: saltando os dados entre o primeiro ; e o segundo](notas2.c)
