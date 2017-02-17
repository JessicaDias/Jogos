import pygame, sys
import random

pygame.init()


# # #   Inicializar # # #
screen = pygame.display.set_mode ((900,650))
pygame.display.set_caption('Jogo')
clock = pygame.time.Clock()
frente = 'nada'


# # #   Carregar imagens    # # #
bg = pygame.image.load('src/t3/Imagem/forst.png')
fim = pygame.image.load('src/t3/Imagem/perdeu.png')
img_ganhou = pygame.image.load('src/t3/Imagem/ganhou.png')
grama = pygame.image.load('src/t3/Imagem/grama.png')
livro = pygame.image.load('src/t3/Imagem/livro.png') # l
gfogo = pygame.image.load('src/t3/Imagem/fire.png') # 2
gpedra = pygame.image.load('src/t3/Imagem/ground2.png') # 3
gespinho = pygame.image.load('src/t3/Imagem/ground.png') # 4
gterra = pygame.image.load('src/t3/Imagem/ground3.png') # 5
gwater = pygame.image.load('src/t3/Imagem/water.png') # 8
tenda = pygame.image.load('src/t3/Imagem/tenda2.png') # 6
pedra = pygame.image.load('src/t3/Imagem/pedra.png') # 1
pedraterra = pygame.image.load('src/t3/Imagem/pedra_terra.png') # 7
caixa = pygame.image.load('src/t3/Imagem/caixa.png') # c - Mapeamento na matriz da fase
caixa_quebrada = pygame.image.load('src/t3/Imagem/caixa_quebrada.png') # q
fogueira = [pygame.image.load('src/t3/Imagem/fogueira2.png'),pygame.image.load('src/t3/Imagem/fogueira3.png'),pygame.image.load('src/t3/Imagem/fogueira4.png')] # f
f_apagada = pygame.image.load('src/t3/Imagem/fogueira1.png') # a
arvore = pygame.image.load('src/t3/Imagem/arvore.png') # r
a_queimada = pygame.image.load('src/t3/Imagem/a_queimada.png') # v
tronco = pygame.image.load('src/t3/Imagem/tronco.png') # t
portal = [pygame.image.load('src/t3/Imagem/portal1.png'),pygame.image.load('src/t3/Imagem/portal2.png'),
          pygame.image.load('src/t3/Imagem/portal3.png'),pygame.image.load('src/t3/Imagem/portal4.png'),
          pygame.image.load('src/t3/Imagem/portal5.png'),pygame.image.load('src/t3/Imagem/portal6.png'),
          pygame.image.load('src/t3/Imagem/portal7.png'),pygame.image.load('src/t3/Imagem/portal8.png')] # p
anima_fogo = 0
anima_portal = 0

# # #   Ler o arquivo/fase  # # #
cmd = open('codigoGerado.txt', 'r')
line = cmd.readline()
fase = line[7];
# Fase 1
inX = 4
inY = 2
iniX = 20
iniY = 20
ex = False
inDir = 'dir'
if(fase == '2'):
    inX = 6
    inY = 4
    inDir = 'esq'
    iniX = 10
    iniY = 2
    ex = True
elif(fase == '3'):
    inX = 5
    inY = 6
    inDir = 'cima'
elif(fase == '4'):
    inX = 0
    inY = 2
    inDir = 'cima'
    iniX = 4
    iniY = 6
    ex = True

    
path = 'src/t3/Fase/mapa' + fase + '.txt'
arquivo = open(path, 'r')
matriz = arquivo.read()
lmatriz = list(matriz)
arquivo.close()
cmd.close()

# # #   Usar magias em objetos do mapa    # # #
def att_matriz(magia, prox_bloco):
    if(magia == "fogo" and lmatriz[prox_bloco] == 'c'): # Fogo na caixa
        lmatriz[prox_bloco] = 'q'
    elif(magia == "fogo" and lmatriz[prox_bloco] == 'r'): # Fogo na arvore
        lmatriz[prox_bloco] = 'v'
    elif(magia == "fogo" and lmatriz[prox_bloco] == 'a'): # Fogo na fogueira apagada
        lmatriz[prox_bloco] = 'f'
    elif(magia == "agua" and lmatriz[prox_bloco] == 'f'): # Agua na fogueira
        lmatriz[prox_bloco] = 'a'
    elif(magia == "agua" and lmatriz[prox_bloco] == 't'): # Agua no tronco
        lmatriz[prox_bloco] = 'r'
    elif(magia == "ataque" and lmatriz[prox_bloco] == 'r'): # ataque na arvore
        lmatriz[prox_bloco] = 't'
    elif(magia == "fogo" and lmatriz[prox_bloco] == 'c'): # ataque na caixaelif(magia == "ataque" and lmatriz[prox_bloco] == 'c'): # ataque na caixa
        lmatriz[prox_bloco] = 'q'


# # #  Desenhar o mapeamento da fase  # # #
def mapa():
    screen.blit(bg, (0, 0))
    x = 1
    y = 1
    aux = []
    auy = []
    cont = 1
    pos = 0
    # Ignorar espacos em branco e "pular linha" do arquivo
    for i in lmatriz:
        foo = ['r', 'c', 'f']
        if(i == ' ' or i == '\n'):
            continue
        if(i == '?'):
            rand =  random.choice(foo)        
            lmatriz[pos] = rand
        pos += 2
        # Desenha os elementos do cenario de acordo com o mapeamento da matriz
        screen.blit(grama, (x+100,y+100))
        if(i == '1'):
            screen.blit(pedra, (x+100,y+100))
        elif(i == 'c'):
            screen.blit(caixa, (x+100,y+100))
        elif(i == 'q'):
            screen.blit(caixa_quebrada, (x+100,y+100))
        elif(i == 'v'):
            screen.blit(a_queimada, (x+100,y+90))
        elif(i == 'l'):
            screen.blit(livro, (x+100,y+100))
        elif(i == 'f'):
            global anima_fogo
            screen.blit(fogueira[int(anima_fogo)], (x+100,y+100))
            anima_fogo += 0.2
            if(anima_fogo >=3):
                 anima_fogo = 0
        elif(i == 'p'):
            global anima_portal
            screen.blit(portal[int(anima_portal)], (x+100,y+100))
            screen.blit(portal[int((anima_portal+3)%7 +1)], (x+100,y+100))
            anima_portal += 0.3
            if(anima_portal >= 8):
                 anima_portal = 1
        elif(i == 'a'):
            screen.blit(f_apagada, (x+100,y+100))
        elif(i == 'r'):
            screen.blit(arvore, (x+90,y+30))
            aux.append(x+90)
            aux.append(y+30)
        elif(i == 't'):
            screen.blit(tronco, (x+100,y+100))
        elif(i == '2'):
            screen.blit(gfogo, (x+100,y+100))
        elif(i == '3'):
            screen.blit(gpedra, (x+100,y+100))
        elif(i == '4'):
            screen.blit(gespinho, (x+100,y+100))
        elif(i == '5'):
            screen.blit(gterra, (x+100,y+100))
        elif(i == '6'):
            screen.blit(tenda, (x+100,y+100))
        elif(i == '7'):
            screen.blit(pedraterra, (x+100,y+100))
        elif(i == '8'):
            screen.blit(gwater, (x+101,y+101))

        # Imprimir os desenhos da matriz por linha
        x += 64
        if(cont % 11 == 0):
            y += 67
            x = 0
        cont += 1

        
    return aux
def gameOver():
    pygame.time.wait(1000)
    close = False

    screen.blit(fim, (0, 0))
    pygame.display.flip()
    while not close:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                close = True
        
    pygame.display.quit()
    pygame.quit()
    sys.exit()
    
def ganhou():
    pygame.time.wait(200)
    close = False

    screen.blit(img_ganhou, (0, 0))
    pygame.display.flip()
    while not close:
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                close = True
              
    pygame.display.quit()
    pygame.quit()
    sys.exit()

    
# # #   Inimigo # # #
class Inimigo():
     def __init__(self,initX,initY,ex,fase):
        self.existe = ex
        self.bx = initX
        self.by = initY
        self.x = 110 + (self.bx*64)
        self.y = 98 + (self.by*67)
        self.contX = 0
        self.contY = 0
        self.fase = fase
        self.control = 0
        self.bloco = ((11*(2*(self.by))) + self.bx*2)
        self.img = [pygame.image.load('src/t3/Imagem/i1.png'),
                    pygame.image.load('src/t3/Imagem/i2.png'),
                    pygame.image.load('src/t3/Imagem/i3.png'),
                    pygame.image.load('src/t3/Imagem/i4.png'),
                    pygame.image.load('src/t3/Imagem/i5.png'),
                    pygame.image.load('src/t3/Imagem/i6.png'),
                    pygame.image.load('src/t3/Imagem/i7.png'),
                    pygame.image.load('src/t3/Imagem/i8.png')]
        self.animacao = 0
        self.col = pygame.Rect(self.x, self.y, 60, 60)  ##arrumar o tamanho certo

     def desenha(self):
        screen.blit(self.img[int(self.animacao)], (self.x, self.y))
        self.animacao += 0.5
        if self.animacao >= 8:
            self.animacao = 0
        
     def controle(self):
         print(self.control)
         if(fase == '2'):
             self.control=0
             self.bx = 20
             self.by = 20
             self.x = 110 + (self.bx*64)
             self.y = 98 + (self.by*67)
             self.existe = False
         if(fase == '4'):
             if(self.control==0):
                 self.bx = 10
                 self.by = 2
                 self.x = 110 + (self.bx*64)
                 self.y = 98 + (self.by*67)
                 
                 self.control +=1

             elif(self.control==1):
                 self.bx = 10
                 self.by = 1
                 self.x = 110 + (self.bx*64)
                 self.y = 98 + (self.by*67)
                 self.control +=1
             elif(self.control==2):
                 self.bx = 5
                 self.by = 5
                 self.x = 110 + (self.bx*64)
                 self.y = 98 + (self.by*67)
                 self.control +=1
                 
             elif(self.control==3):
                 self.control=0
                 self.bx = 20
                 self.by = 20
                 self.x = 110 + (self.bx*64)
                 self.y = 98 + (self.by*67)
                 
                 self.existe = False
             
         
     def anda(self,valx,valy):
         if(valx != 0  and  valy != 0):
             valx *= 0.5
             valy *= 0.5
         
         self.bloco = ((11*(2*(self.by))) + self.bx*2)
         
         if (lmatriz[self.bloco] == "1" or lmatriz[self.bloco] == "c"  or lmatriz[self.bloco] == "r" or lmatriz[self.bloco] == "v" or lmatriz[self.bloco] == "a"):
             valx = 0
             valy = 0
             self.controle()
             att_matriz('fogo', self.bloco)
             self.bloco = ((11*(2*(self.by))) + self.bx*2)
            
         self.x += valx
         self.y += valy
         self.contX += valx
         self.contY += valy
         if(self.contX >= 64):
             self.contX -=64
             self.bx += 1
         elif(self.contX <= -64):
             self.contX +=64
             self.bx -= 1
         if(self.contY >= 67):
             self.contY -=67
             self.by += 1
         elif(self.contY <= -67):
             self.contY +=67
             self.by -= 1 
        

# # #   Jogador # # #
class Player():

    def __init__(self,initX,initY,initDir,inimigo):
        # Posicao do mapa na tela x: 110 y: 98
        self.inimigo = inimigo
        self.bx = initX
        self.by = initY
        self.x = 110 + (self.bx*64)
        self.y = 98 + (self.by*67)
        self.bloco = ((11*(2*(self.by))) + self.bx*2) # Equacao para identificar o bloco em que o jogador esta
        self.imga_dir = [pygame.image.load('src/t3/Imagem/p_dir1.png'),
                    pygame.image.load('src/t3/Imagem/p_dir2.png'),
                    pygame.image.load('src/t3/Imagem/p_dir3.png'),
                    pygame.image.load('src/t3/Imagem/p_dir2.png'),
                    pygame.image.load('src/t3/Imagem/p_dir1.png')]
        self.imga_esq = [pygame.image.load('src/t3/Imagem/p_esq1.png'),
                    pygame.image.load('src/t3/Imagem/p_esq2.png'),
                    pygame.image.load('src/t3/Imagem/p_esq3.png'),
                    pygame.image.load('src/t3/Imagem/p_esq2.png'),
                    pygame.image.load('src/t3/Imagem/p_esq1.png')]
        self.imga_cima = [pygame.image.load('src/t3/Imagem/p_cima1.png'),
                    pygame.image.load('src/t3/Imagem/p_cima2.png'),
                    pygame.image.load('src/t3/Imagem/p_cima3.png'),
                    pygame.image.load('src/t3/Imagem/p_cima2.png'),
                    pygame.image.load('src/t3/Imagem/p_cima1.png')]
        self.imga_baixo = [pygame.image.load('src/t3/Imagem/p_frente1.png'),
                    pygame.image.load('src/t3/Imagem/p_frente2.png'),
                    pygame.image.load('src/t3/Imagem/p_frente3.png'),
                    pygame.image.load('src/t3/Imagem/p_frente2.png'),
                    pygame.image.load('src/t3/Imagem/p_frente1.png')]
        self.magic_fogo = [pygame.image.load('src/t3/Imagem/fogo1.png'),
                    pygame.image.load('src/t3/Imagem/fogo2.png'),
                    pygame.image.load('src/t3/Imagem/fogo3.png'),
                    pygame.image.load('src/t3/Imagem/fogo4.png'),
                    pygame.image.load('src/t3/Imagem/fogo5.png'),
                    pygame.image.load('src/t3/Imagem/fogo6.png'),
                    pygame.image.load('src/t3/Imagem/fogo7.png'),
                    pygame.image.load('src/t3/Imagem/fogo8.png')]
        self.magic_agua = [pygame.image.load('src/t3/Imagem/agua1.png'),
                    pygame.image.load('src/t3/Imagem/agua2.png'),
                    pygame.image.load('src/t3/Imagem/agua3.png'),
                    pygame.image.load('src/t3/Imagem/agua4.png'),
                    pygame.image.load('src/t3/Imagem/agua5.png'),
                    pygame.image.load('src/t3/Imagem/agua6.png'),
                    pygame.image.load('src/t3/Imagem/agua7.png'),
                    pygame.image.load('src/t3/Imagem/agua8.png')]
        self.magic_ataque = [pygame.image.load('src/t3/Imagem/atk1.png'),
                    pygame.image.load('src/t3/Imagem/atk2.png'),
                    pygame.image.load('src/t3/Imagem/atk3.png'),
                    pygame.image.load('src/t3/Imagem/atk4.png'),
                    pygame.image.load('src/t3/Imagem/atk5.png'),
                    pygame.image.load('src/t3/Imagem/atk6.png'),
                    pygame.image.load('src/t3/Imagem/atk7.png'),
                    pygame.image.load('src/t3/Imagem/atk8.png')]

        self.animacao = 0
        self.direcao = initDir #'cima' # dir, esq, cima, baixo
        self.estado = 'andando' # andando, parado, usando_magia
        self.magia = 'fogo' # agua, fogo, ataque
        self.anima_magia = 0
        self.col = pygame.Rect(self.x, self.y, 60, 60)  ##arrumar o tamanho certo

    # # # Desenhar o jogador/animacoes do jogador e das magias na tela    # # #
    def desenha(self):
        aux = mapa()
        magicx = self.x
        magicy = self.y
        
        # Jogador virando
        if self.direcao == 'dir':
            screen.blit(self.imga_dir[int(self.animacao)], (self.x, self.y))
            magicx = player.x + 64

        if self.direcao == 'esq':
            screen.blit(self.imga_esq[int(self.animacao)], (self.x, self.y))
            magicx = player.x - 64

        if self.direcao == 'cima':
            screen.blit(self.imga_cima[int(self.animacao)], (self.x, self.y))
            magicy = player.y - 66

        if self.direcao == 'baixo':
            screen.blit(self.imga_baixo[int(self.animacao)], (self.x, self.y))
            magicy = player.y + 66

        # Jogador andando
        if self.estado == 'andando':
            self.animacao += 0.5
            if self.animacao >= 5:
                self.animacao = 0

        # Jogador passando atras da arvore
        for i in range(0,len(aux),2):
            screen.blit(arvore, (aux[i],aux[i+1] ))

        # Jogador usando magias no bloco a frente
        if self.estado == 'usando_magia':
            if self.magia == 'fogo':
                screen.blit(self.magic_fogo[int(self.anima_magia)], (magicx-4, magicy))
            if self.magia == 'agua':
                screen.blit(self.magic_agua[int(self.anima_magia)], (magicx-8+self.anima_magia, magicy-5))
            if self.magia == 'ataque':
                screen.blit(self.magic_ataque[int(self.anima_magia)], (magicx, magicy))

            self.anima_magia += 0.5
            if self.anima_magia >= 8:
                self.anima_magia = 0

        if(self.inimigo.existe):
            inimigoX=0
            inimigoY=0
            if(self.x < self.inimigo.x):
                inimigoX = -4
            elif(self.x > self.inimigo.x):
                inimigoX = 4
            if(self.y < self.inimigo.y):
                inimigoY=-4
            elif(self.y > self.inimigo.y):
                inimigoY= 4
                
            self.inimigo.anda(inimigoX,inimigoY)
            self.inimigo.desenha()

            self.col = pygame.Rect(self.x, self.y, 60, 60)
            self.inimigo.col = pygame.Rect(self.inimigo.x, self.inimigo.y, 60, 60)
           
            if(self.col.colliderect(self.inimigo.col)):
               print("inimigo")
               gameOver()
        clock.tick(60)
        pygame.display.flip()

    # # #   Animacao do jogador em movimento usando a equacao para identificar posicao  # # #
    def andar(self):
        finaliza = False
        self.estado = 'andando'
        if self.direcao == 'dir':
            self.bloco = ((11*(2*(player.by))) + (player.bx+1)*2)
            if(self.x > 750 ):
                finaliza = True
        if self.direcao == 'esq':
            self.bloco = ((11*(2*(player.by))) + (player.bx-1)*2)
            if(self.x < 150 ):
                finaliza = True
        if self.direcao == 'cima':
            self.bloco = ((11*(2*(player.by-1))) + (player.bx)*2)
            if(self.y < 110 ):
                finaliza = True
        if self.direcao == 'baixo':
            self.bloco = ((11*(2*(player.by+1))) + (player.bx)*2)
            if(self.y > 480 ):
                finaliza = True
                self.bloco = 0

        # Detecta colisao ao andar
        andarei = 2
        # Fim do jogo quando:
        #   Jogador anda em cima do fogo
        #   Jogador ultrapassa limite do mapa
        
       
        
        if (lmatriz[player.bloco] == "f" or lmatriz[player.bloco] == "8" or finaliza == True):
            gameOver()
        # Quando o bloco esta livre, anda
        elif (lmatriz[player.bloco] == "0"):
            andarei = 2
        # Quando o bloco esta com obstaculo, para
        elif (lmatriz[player.bloco] == "1" or lmatriz[player.bloco] == "c"  or lmatriz[player.bloco] == "r" or lmatriz[player.bloco] == "v"):
            andarei = 0
        # Quando o jogador entra no portal
        elif (lmatriz[player.bloco] == "p" or lmatriz[player.bloco] == "6" or lmatriz[player.bloco] == "l") :
           ganhou()
        else:
            andarei = 2


        # Andando por bloco
        if self.estado == 'andando':
            if self.direcao == 'dir':
                    player.bx += andarei//2
            if self.direcao == 'esq':
                    player.bx -= andarei//2
            if self.direcao == 'cima':
                    player.by -= andarei//2
            if self.direcao == 'baixo':
                    player.by += andarei//2

            # Andando pela posicao x e y
            for i in range(32):
                if self.direcao == 'dir':
                    player.x += andarei
                    
                if self.direcao == 'esq':
                    player.x -= andarei
                    
                if self.direcao == 'cima':
                    player.y -= andarei
                    
                if self.direcao == 'baixo':
                    
                    player.y += andarei
                self.desenha()
                
            self.estado = 'parado'
            
        

    # # #   Usa magia no proximo bloco  # # #
    def usar(self,magic):

        self.magia = magic
        self.estado = 'usando_magia'
        prox_bloco = ''
        if self.direcao == 'dir':
            prox_bloco = ((11*(2*(player.by))) + (player.bx+1)*2)
        if self.direcao == 'esq':
            prox_bloco = ((11*(2*(player.by))) + (player.bx-1)*2)
        if self.direcao == 'cima':
            prox_bloco = ((11*(2*(player.by-1))) + (player.bx)*2)
        if self.direcao == 'baixo':
            prox_bloco = ((11*(2*(player.by+1))) + (player.bx)*2)
        for i in range(15):
            self.desenha()

        self.estado = 'parado'
        self.desenha()
        att_matriz(magic, prox_bloco)


    # # #   Vira o jogador sempre para a direita    # # #
    def virar(self):
        if self.direcao == 'dir':
            self.direcao = 'baixo'
        elif self.direcao == 'baixo':
            self.direcao = 'esq'
        elif self.direcao == 'esq':
            self.direcao = 'cima'
        elif self.direcao == 'cima':
            self.direcao = 'dir'
        player.desenha()

def atualiza_frente(player):
    auX = player.bx
    auY = player.by
    if player.direcao == 'dir':
        auX +=1
    elif player.direcao == 'baixo':
        auY +=1
    elif player.direcao == 'esq':
        auX -=1 
    elif player.direcao == 'cima':
        auY -=1
    futuro =  ((11*(2*(auY))) + auX*2)
    value = lmatriz[futuro]
    if (value == '0'):
        return 'grama'
    elif (value == '1' or value == '7'):
        return 'pedra'
    elif (value == '2'):
        return 'lava'
    elif (value == '3'):
        return 'chao_pedra'
    elif (value == '4'):
        return 'espinho'
    elif (value == '5'):
        return 'terra'
    elif (value == '6'):
        return 'cabana'
    elif (value == '8'):
        return 'agua'
    elif (value == 'r'):
        return 'arvore'
    elif (value == 'c'):
        return 'caixa'
    elif (value == 'f'):
        return 'fogueira'
    elif (value == 't'):
        return 'tronco'
    elif (value == 'a'):
        return 'fogueira_apagada'
    elif (value == 'v'):
        return 'arvore_queimada'
    elif (value == 'p'):
        return 'portal'

close = False
inimigo = Inimigo(iniX,iniY,ex,fase)
player = Player(inX,inY,inDir,inimigo)
player.desenha()
frente = atualiza_frente(player)
###############codigo jogador#############################
