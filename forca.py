import random
palavras = ['absolutismo', 'totalitarismo', 'inconstitucionalista',
            'oba', 'oca', 'asa', 'aba', 'tab', 'ola', 'ada']
palavra = palavras[random.randrange(len(palavras))]
mostra = []
for ch in palavra:
  mostra.append('_')
print('Adivinhe a palavra:', end=' ')
for ch in mostra: print(ch, end=' ')
print('letra por letra')
chutes = 0
maxchutes = 6
acertos = 0
chs = ''
while chutes < maxchutes:
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
  else:
    for ch in mostra: print(ch, end=' ')
    print()
  if acertos == len(palavra): break
if acertos == len(palavra): print("Parabens!")
else:
  print('Que pena, maximo de', maxchutes, 'foi atingido')
  forca = '''
   _________
  |         |
  |        ---
  |      /     \\
  |     | o   o |
  |     |   ^   |
  |      \\  -  /
  |        ---
  |         |
  |        /|\\
  |       / | \\
  |      /  |  \\
  |         |
  |         |
  |        / \\
  |       /   \\
  |     _/     \\_
  |
  |
__|__________________'''
  print(forca)