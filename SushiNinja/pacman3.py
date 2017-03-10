# -*- coding: cp1252 -*-
import pygame, sys, random
from pygame.locals import*



class Pacman():
    #Declara atributos da classe
    def __init__ (pac):
        pac.y = 20
        pac.x = 20
        pac.velocidade = 5

    

    #Metodo movimento
    def movimento(pac):
        keys = pygame.key.get_pressed()
        if keys[pygame.K_UP]:
            pac.y -= pac.velocidade
        elif keys[pygame.K_DOWN]:
            pac.y += pac.velocidade
        elif keys[pygame.K_LEFT]:
            pac.x -= pac.velocidade
        elif keys[pygame.K_RIGHT]:
            pac.x += pac.velocidade
            
           
    def desenhar(pac):
        setDisplay.blit(img2, (pac.x,pac.y))


############################################################################
#main
############################################################################

img  =  pygame.image.load ('PacMan.gif')
img2 = pygame.image.load ('pacman.png')


#Criar display      
setDisplay = pygame.display.set_mode((800,600))
pygame.display.set_caption('PACOMP')
pygame.font.init()
black = (0,0,0) #Fundo

#Frames por segundo
clock = pygame.time.Clock()
FPS = 60

#Criar objeto pac da classe Pacman
pac = Pacman()

while True:
    #Evento para fechar o jogo
    for event in pygame.event.get():
        if event.type == QUIT:
            pygame.quit()
            sys.exit()

    ####################TESTE#############################3
###########################################################
    setDisplay.fill(black)
    pac.desenhar()
    pac.movimento()
    pygame.display.flip()
    pygame.display.update()
    clock.tick(FPS)
