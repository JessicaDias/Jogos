# -*- coding: cp1252 -*-

import pygame, sys, random,glob
from pygame.locals import *
############################Player#######################################
class Player():
    #Declara atributos da classe
    def __init__ (pac):
        pac.y = 0
        pac.x = 0
        pac.velocidade = 0
        pac.img = pygame.image.load ('thiago1.png')
        pac.img2 = pygame.image.load ('thiago2.png')
        pac.area = pygame.Rect(pac.x,pac.y,60,60)
        pac.anima = 0
        pac.direcao = 0
        pac.ponto = 0
        pac.pontoFont = pygame.font.Font("arial.ttf", 64)
        pac.vida = 0
	
    #desenhar jogador
    def desenhar(pac):
        pac.anima +=1
        if pac.anima > 10:
            pac.anima=0
        if pac.anima > 5:
            setDisplay.blit(pac.img, (pac.x,pac.y))
        elif pac.anima <=5:
            setDisplay.blit(pac.img2, (pac.x,pac.y))
#####################################Movimento SETAS###########################
def movimento(pac):
             #comidas
        for food in foods[:]:
            if pac.area.colliderect(food):
                foods.remove(food)
                pac.ponto +=1
                sushiSound.play()
             #shuriken
        if pac.area.colliderect(prof.area):
            pac.vida +=1
            pac.y = 100
            pac.x = 700
            prof.x=400
            prof.y=350
        #bordas
        if pac.y <= 0:
            pac.y += 25
        if pac.y >= 680:
            pac.y -= 25
        if pac.x <= 0:
            pac.x +=25
        if pac.x >= 780:
            pac.x -=25
            
        for p in paredes[:]:
            if pac.area.colliderect(p):
                 if pac.direcao == 1:
                    pac.y += 5
                 if pac.direcao == 2:
                    pac.y -= 5
                 if pac.direcao == 3:
                    pac.x -= 5
                 if pac.direcao == 4:
                    pac.x += 5 
            elif ~pac.area.colliderect(p):           
                keys = pygame.key.get_pressed()
                if keys[pygame.K_UP]:
                    pac.direcao = 1
                    pac.y -= pac.velocidade
                elif keys[pygame.K_DOWN]:
                    pac.direcao = 2
                    pac.y += pac.velocidade
                elif keys[pygame.K_LEFT]:
                    pac.direcao = 4
                    pac.x -= pac.velocidade
                elif keys[pygame.K_RIGHT]:
                    pac.direcao = 3
                    pac.x += pac.velocidade

        #PvP
        if pac.area.colliderect(p2.area):
                if pac.direcao == 1:
                    p2.y -= 15
                    pac.y += 15
                if pac.direcao == 2:
                    p2.y += 15
                    pac.y -= 15
                if pac.direcao == 3:
                    p2.x += 15
                    pac.x -= 15
                if pac.direcao == 4:
                    p2.x -= 15
                    pac.x += 15
def pontos(self):
            scoreBlit = self.pontoFont.render(str(self.ponto), 1, (0, 0, 0))
            setDisplay.blit(scoreBlit, (700, 16))
###################################Movimento WASD##########################
def movimento2(p2):
             #comidas
        for food in foods[:]:
            if p2.area.colliderect(food):
                foods.remove(food)
                p2.ponto +=1
                sushiSound.play()
                #Shuriken
        if p2.area.colliderect(prof.area):
            p2.vida += 1
            p2.x =100
            p2.y = 100
            prof.x=400
            prof.y=350
            
        if p2.y <= 0:
            p2.y += 25
        if p2.y >= 680:
            p2.y -= 25
        if p2.x <= 0:
            p2.x +=25
        if p2.x >= 780:
            p2.x -=25
           
        for p in paredes[:]:
            if p2.area.colliderect(p):
                 if p2.direcao == 1:
                    p2.y += 5
                 if p2.direcao == 2:
                    p2.y -= 5
                 if p2.direcao == 3:
                    p2.x -= 5
                 if p2.direcao == 4:
                    p2.x += 5 
            elif ~p2.area.colliderect(p):           
                keys = pygame.key.get_pressed()
                if keys[pygame.K_w]:
                    p2.direcao = 1
                    p2.y -= p2.velocidade
                elif keys[pygame.K_s]:
                    p2.direcao = 2
                    p2.y += p2.velocidade
                elif keys[pygame.K_a]:
                    p2.direcao = 4
                    p2.x -= p2.velocidade
                elif keys[pygame.K_d]:
                    p2.direcao = 3
                    p2.x += p2.velocidade

          #PvP
        if p2.area.colliderect(p1.area):
                if p2.direcao == 1:
                    p1.y -= 15
                    p2.y += 15
                if p2.direcao == 2:
                    p1.y += 15
                    p2.y -= 15
                if p2.direcao == 3:
                    p1.x += 15
                    p2.x -= 15
                if p2.direcao == 4:
                    p1.x -= 15
                    p2.x += 15
def pontos2(self):
            scoreBlit = self.pontoFont.render(str(self.ponto), 1, (0, 0, 0))
            setDisplay.blit(scoreBlit, (32, 16))
####################################shuriken##################################3
class Iminigo():
    def __init__(self):
        self.x = 200
        self.y = 400
        self.speed_x = random.choice([-8,-9,-10,-11])
        self.speed_y = random.choice([5,6,7,8])
        self.img = pygame.image.load ('shu1.png')
        self.img2 = pygame.image.load ('shu2.png')
        self.anima = 0
        self.area = pygame.Rect(self.x,self.y,170,170)
        
    def mover(self):
        self.x += self.speed_x
        self.y += self.speed_y
        if self.y <= 0:
            self.speed_y *= -1
        if self.y >= 550:
            self.speed_y *= -1
        if self.x <= 0:
           self.speed_x *=-1
        if self.x >= 650:
           self.speed_x *=-1
                
            
                    
    	    
    def desenhar(self):
            self.anima+=1
            if self.anima == 10:
                self.anima =0
            if self.anima < 5:
                setDisplay.blit(self.img, (self.x,self.y))
            elif self.anima >=5:
                setDisplay.blit(self.img2, (self.x,self.y))
        

            
##################################vencedor###############################
def vencedor(p1,p2):
    if(p1.vida == 10):
        print "p2"
        p1.vida=0
        pygame.time.wait(1000)
    if(p2.vida == 10):
        print "p1"
        p2.vida=0
        pygame.time.wait(1000)
####################################eventos#################################

#######################################main##############################3    	
# pygame
pygame.init()
pygame.font.init()
mainClock = pygame.time.Clock()

 # Criando janela do jogo
WINDOWWIDTH = 800
WINDOWHEIGHT = 700
windowSurface = pygame.display.set_mode((WINDOWWIDTH, WINDOWHEIGHT), 0, 32)
setDisplay = pygame.display.set_mode((800,700))
pygame.display.set_caption('NINJA')
pygame.font.init()
BLACK = (0,0,0)
 # COMIDA
foodCounter = 0
NEWFOOD = 40
FOODSIZE = 25

img = pygame.image.load ('sushi.png')
foods = []
for i in range(20):
    foods.append(pygame.Rect(random.randint(0, WINDOWWIDTH - FOODSIZE),
        random.randint(0, WINDOWHEIGHT - FOODSIZE), FOODSIZE, FOODSIZE))


#Dados dos jogadores
    #p1
p1 = Player()
p1.y = 100
p1.x = 700
p1.velocidade = 3
p1.img = pygame.image.load ('thiago1.png')
p1.img2 = pygame.image.load ('thiago2.png')
p1.area = pygame.Rect(p1.x,p1.y,60,60)
p1.anima = 0
p1.direcao = 0
p1.ponto = 0
p1.pontoFont = pygame.font.Font("arial.ttf", 64)
p1.vida =0
    #p2
p2= Player()
p2.y = 100
p2.x = 100
p2.velocidade = 3
p2.img = pygame.image.load ('player2.png')
p2.img2 = pygame.image.load ('player2.png')
p2.area = pygame.Rect(p2.x,p2.y,60,60)
p2.anima = 0
p2.direcao = 0
p2.ponto = 0
p2.pontoFont = pygame.font.Font("arial.ttf", 64)
p2.vida=0

#suriken
prof = Iminigo()
#paredes
paredes = []
paredes.append(pygame.Rect(0,0,800,10))
paredes.append(pygame.Rect(0,0,10,800))
paredes.append(pygame.Rect(0,690,800,10))
paredes.append(pygame.Rect(790,0,10,800))
#musica
sushiSound = pygame.mixer.Sound('sushi.wav')
pygame.mixer.music.load('Mbackground.wav')
pygame.mixer.music.play(-1,0.0)
musicPlaying = True

#eventos
cont=0
rand = random.randint(100, 500)
#background
background = pygame.image.load ('background.jpg')
background2 = pygame.image.load ('background2.jpg')
# loop do jogo
while True:

    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            sys.exit()
    
    vencedor(p1,p2)    
    foodCounter += 1
    if foodCounter >= NEWFOOD:
        # coloca + sushi
        foodCounter = 0
        foods.append(pygame.Rect(random.randint(0, WINDOWWIDTH - FOODSIZE),
            random.randint(0, WINDOWHEIGHT - FOODSIZE), FOODSIZE, FOODSIZE))
    # Atualiza o fundo
    setDisplay.blit(background,(1,1))
    #funçoes dos jogadores
    p1.desenhar()
    p2.desenhar()
    movimento2(p2)
    movimento(p1)
    pontos2(p2)
    pontos(p1)
     # desenha as comidas
    for i in range(len(foods)):
        #pygame.draw.rect(windowSurface, GREEN, foods[i])
        setDisplay.blit(img, foods[i])
    #da shuriken
    prof.mover()
    prof.desenhar()
    #Calculo da colisao quadrada
    p1.area = pygame.Rect(p1.x,p1.y,60,60)
    p2.area = pygame.Rect(p2.x,p2.y,60,60)
    prof.area = pygame.Rect(prof.x,prof.y,170,170)
    #pygame.draw.rect(windowSurface, WHITE, pac.area)
    #pygame.draw.rect(windowSurface, BLACK, prof.area)
   
    #PAREDE
    pygame.draw.rect(windowSurface, BLACK, paredes[0])
    pygame.draw.rect(windowSurface, BLACK, paredes[1])
    pygame.draw.rect(windowSurface, BLACK, paredes[2])
    pygame.draw.rect(windowSurface, BLACK, paredes[3])
    cont +=1
    #if cont == 100;
    # atualiza a tela
    pygame.display.update()
    mainClock.tick(40)

