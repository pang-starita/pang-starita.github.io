def reverte(txt):
    acc = ""
    for ch in txt:
        acc = ch + acc
    return acc

texto = 'este eh o texto a ser revertido'
print(texto , '->', reverte(texto))