#!/usr/bin/python3
#
# Calcula o centesimo elemento da sequencia de Fibonacci

# funcao de fibonacci

def fibonacci(n):
    if n < 0: return -1
    if n == 1: return 0
    fMenos2 = 0
    fMenos1 = 1
    i = 2
    while i < n:
        soma = fMenos1 + fMenos2
        i += 1
        fMenos2 = fMenos1
        fMenos1 = soma
    return soma

# impressao do valor do centesimo elemento, observe como o valor é alto
print("fibo de 100 =", fibonacci(100))