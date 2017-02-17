base = open('basecode.py', 'r')
cmd = open('codigoGerado.txt', 'r')

texto_base = base.read()
texto_cmd= cmd.read()

texto_cmd += "gameOver()"
codigo = texto_base + texto_cmd
jogo = open('codeFunGame.py', 'w')
jogo.write(codigo)

base.close()
cmd.close()
jogo.close()
