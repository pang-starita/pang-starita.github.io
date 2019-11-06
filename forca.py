import random
palavras = ['absolutismo', 'totalitarismo', 'inconstitucionalista']
palavra = palavras[random.randrange(len(palavras))]
mostra = []
for i in range(len(palavra)):
  mostra.append('_')
print('Adivinhe a palavra:', mostra, 'letra por letra')
chutes = 0
maxchutes = 6
acertos = 0
chs = ''
while chutes <= maxchutes:
  ch = input('Chute uma letra: ')
  if ch in chs:
    print('letra ja tentada')
    continue
  else:
    chs += ch
  acertou = False
  for i in range(len(palavra)):
    if ch == palavra[i]:
      acertos += 1
      mostra[i] = ch
      acertou = True
  if not acertou:
    chutes += 1
    print(ch, 'nao aparece na palavra')
  else: print(mostra)
  if acertos == len(palavra): break
if acertos == len(palavra): print("Parabens!")
else: print('Que pena, maximo de', maxchutes, 'foi atingido')