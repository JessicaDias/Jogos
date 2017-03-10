#include <stdio.h>
#include <stdlib.h>
#include <allegro.h>
#include <time.h>
#include <string.h>

/*Prototipo das funções*/
int sorteio();
int comparar ();
int pontuacao ();
int menu ();
void regras();
void iniciarJogo();
int sairJogo ();
int salvarJogo();
int abrirJogo();
char* texto();
char nomeEscrito[20];

int main()
{

    /*Inicialização do Allegro*/
    set_uformat(U_ASCII);
    allegro_init();
    install_keyboard();
    install_timer();
    set_color_depth(32);
    set_gfx_mode(GFX_AUTODETECT_WINDOWED, 860, 640, 0, 0);
    set_window_title("Quem é esse Pokemon?");
    install_sound (DIGI_AUTODETECT, MIDI_AUTODETECT, NULL);
    int exit_program = FALSE;
    BITMAP *buffer = create_bitmap(860,640);
    SAMPLE *som = load_sample("song/Pokemon Theme Song.wav");

    while (!exit_program)
    {
        if (key[KEY_ESC])
        {
            exit_program = TRUE;
        }
        else
        {

            /*Inicio do jogo*/
            play_sample(som,255,127,1000,0);
            BITMAP *imagem = load_bitmap ("images/inicio.bmp", NULL);
            blit(imagem,buffer,0,0,0,0,860,640);
            blit(buffer,screen,0,0,0,0,860,640);
            rest(3000.0);

            menu();
        }
    }
    void destroy_font(ad);
    void destroy_sample(SAMPLE *som);
    void destroy_bitmap(BITMAP *imagem);
    void destroy_bitmap(BITMAP *buffer);
    allegro_exit();
    return 0;
}
END_OF_MAIN();

/*Função para o sorteio do índice que chamará o nome/imagem do Pokemon*/
int sorteio()
{
    int i;

    srand (time(NULL));
    i = rand()%4;
    printf("--- metodo sorteio() : indice sorteado: %d", i);
    return (i);
}

/*A função compara o nome escrito com o nome do Pokemon (pelo índice)*/
int comparar (char *nomeEscrito, int i)
{

    if (i == 0)
    {
        if (!strcmp(nomeEscrito,"PIKACHU"))
        {
            return 0;
        }
        else
        {
            return 2;
        }
    }
    else
    {
        if (i == 1)
        {
            if (!strcmp(nomeEscrito,"CHARIZARD"))
                {
                    return 0;
                }
                else
                {
                    return 2;
                }
        }
        else
        {
            if (i == 2)
            {
                if (!strcmp(nomeEscrito,"TOGEPI"))
                {
                    return 0;
                }
                else
                {
                    return 2;
                }
            }
            else
            {
                if (i == 3)
                {
                    if (!strcmp(nomeEscrito,"BLASTOISE"))
                    {
                        return 0;
                    }
                    else
                    {
                        return 2;
                    }
                }
            }
        }
    }
}


/*A função soma os pontos de acordo com os acertos*/
int pontuacao (int verifica, int *pontos)
{
    if (verifica == 0)
    {
        *pontos = *pontos + 10;
    }
}

/*Função que exibe o menu e chama as outras funções de acordo com a escolha do jogador*/
int menu ()
{
    BITMAP *menu[4];
    BITMAP *buffer = create_bitmap(860,640);
    menu[0] = load_bitmap ("images/menuIniciar.bmp", NULL);
    menu[1] = load_bitmap ("images/menuComo.bmp", NULL);
    menu[2] = load_bitmap ("images/menuCarregar.bmp", NULL);
    menu[3] = load_bitmap ("images/menuSair.bmp", NULL);
    int keyPress_DOWN= 0 , keyPress_UP = 0;
    int i=0;
    int pontos=0;
    int indice=0;

    while(!key[KEY_ESC])
    {
        masked_blit(menu[i],buffer,0,0,0,0,860,640);
        masked_blit(buffer,screen,0,0,0,0,860,640);

        if (key[KEY_DOWN])
        {
            if(!keyPress_DOWN)
            {
                keyPress_DOWN = 1; //i==3?i=0:1++;
                if (i==3)
                {
                    i=0;
                }
                else
                {
                    i++;
                }
            }
        }
        else
        {
            keyPress_DOWN=0;
        }

        if (key[KEY_UP])
        {
            if(!keyPress_UP)
            {
                i-=1;
                keyPress_UP = 1;
            }
        }
        else
        {
            keyPress_UP=1;
        }

        if (key[KEY_ENTER])
        {
            if (i == 0)
            {
                iniciarJogo(&pontos,&indice,1);
            }
            else
            {
                if (i == 1)
                {
                    regras();
                }
                else
                {
                    if (i == 2)
                    {
                        abrirJogo(&indice, &pontos);
                    }
                    else
                    {
                        if(i == 3)
                        {
                            exit (1);
                        }
                    }
                }
            }
        }
    }
}

/*Função das ações do jogo em si*/
void iniciarJogo(int *indiceAux, int *pontosAux, int carregar)
{
    int ticks=0;
    while(ticks<10000000)
    {
        ticks++;
    }
    int indice=0;
    int rodada = 0;
    int verifica;
    int pontos=0;
    char* textoDigitado;
    BITMAP *buffer = create_bitmap (860,640);
    FONT *ad = load_font ("font/aventure1.pcx", NULL, NULL);

        while (!key[KEY_ESC])
        {
                while (rodada < 8)

                {
                        if(carregar == 0)
                        {
                            indice = *indiceAux;
                            pontos = *pontosAux;
                        }
                        else {
                        indice = sorteio();
                        }

                        if (indice == 0)
                        {
                            BITMAP *imagem = load_bitmap ("images/pikachu1.bmp", NULL);
                            blit(imagem,buffer,0,0,0,0,860,640);
                            blit(buffer,screen,0,0,0,0,860,640);
                            textoDigitado = texto();
                            verifica = comparar(textoDigitado, indice);
                            pontuacao(verifica, &pontos);

                            if (textoDigitado[0]=='1')
                            {
                                sairJogo(pontos, indice);

                            } else {

                                if (verifica == 0)
                                {
                                    BITMAP *imagem = load_bitmap ("images/pikachu2.bmp", NULL);
                                    blit(imagem,buffer,0,0,0,0,860,640);
                                    blit(buffer,screen,0,0,0,0,860,640);
                                    textprintf_ex(screen, ad, 30,400, makecol(255,255,0), -1, "Voce acertou!");
                                    rest(1000.0);
                                }
                                else
                                {
                                    if (verifica == 2)
                                    {
                                        BITMAP *imagem = load_bitmap ("images/errou.bmp", NULL);
                                        blit(imagem,buffer,0,0,0,0,860,640);
                                        blit(buffer,screen,0,0,0,0,860,640);
                                        rest(1000.0);
                                    }
                                }
                            }
                        }
                        else
                        {
                            if (indice == 1)
                            {
                                BITMAP *imagem = load_bitmap ("images/charizard1.bmp", NULL);
                                blit(imagem,buffer,0,0,0,0,860,640);
                                blit(buffer,screen,0,0,0,0,860,640);
                                textoDigitado = texto();
                                verifica = comparar(textoDigitado, indice);
                                pontuacao(verifica, &pontos);

                                if (textoDigitado[0]=='1')
                                {
                                    sairJogo(pontos, indice);
                                } else {

                                    if (verifica == 0)
                                    {
                                        BITMAP *imagem = load_bitmap ("images/charizard2.bmp", NULL);
                                        blit(imagem,buffer,0,0,0,0,860,640);
                                        blit(buffer,screen,0,0,0,0,860,640);
                                        textprintf_ex(screen, ad, 30,400, makecol(255,255,0), -1, "Voce acertou!");
                                        rest(1000.0);
                                    }
                                    else
                                    {
                                        if (verifica == 2)
                                        {
                                            BITMAP *imagem = load_bitmap ("images/errou.bmp", NULL);
                                            blit(imagem,buffer,0,0,0,0,860,640);
                                            blit(buffer,screen,0,0,0,0,860,640);
                                            rest(1000.0);
                                        }
                                    }
                                }
                            }
                            else
                            {
                                if (indice == 2)
                                {
                                    BITMAP *imagem = load_bitmap ("images/togepi1.bmp", NULL);
                                    blit(imagem,buffer,0,0,0,0,860,640);
                                    blit(buffer,screen,0,0,0,0,860,640);
                                    textoDigitado = texto();
                                    verifica = comparar(textoDigitado, indice);
                                    pontuacao(verifica, &pontos);

                                    if (textoDigitado[0]=='1')
                                    {
                                        sairJogo(pontos, indice);
                                    } else {

                                        if (verifica == 0)
                                        {
                                            BITMAP *imagem = load_bitmap ("images/togepi2.bmp", NULL);
                                            blit(imagem,buffer,0,0,0,0,860,640);
                                            blit(buffer,screen,0,0,0,0,860,640);
                                            textprintf_ex(screen, ad, 30,400, makecol(255,255,0), -1, "Voce acertou!");
                                            rest(1000.0);
                                        }
                                        else
                                        {
                                            if (verifica == 2)
                                            {
                                                BITMAP *imagem = load_bitmap ("images/errou.bmp", NULL);
                                                blit(imagem,buffer,0,0,0,0,860,640);
                                                blit(buffer,screen,0,0,0,0,860,640);
                                                rest(1000.0);
                                            }
                                        }
                                    }
                                }
                                else
                                {
                                    if (indice == 3)
                                    {
                                        BITMAP *imagem = load_bitmap ("images/blastoise1.bmp", NULL);
                                        blit(imagem,buffer,0,0,0,0,860,640);
                                        blit(buffer,screen,0,0,0,0,860,640);
                                        textoDigitado = texto();
                                        verifica = comparar(textoDigitado, indice);
                                        pontuacao(verifica, &pontos);

                                    if (textoDigitado[0]=='1')
                                    {
                                        sairJogo(pontos, indice);
                                    } else {

                                        if (verifica == 0)
                                        {
                                            BITMAP *imagem = load_bitmap ("images/blastoise2.bmp", NULL);
                                            blit(imagem,buffer,0,0,0,0,860,640);
                                            blit(buffer,screen,0,0,0,0,860,640);
                                            textprintf_ex(screen, ad, 30,400, makecol(255,255,0), -1, "Voce acertou!");
                                            rest(1000.0);
                                        }
                                        else
                                        {
                                            if (verifica == 2)
                                            {
                                                BITMAP *imagem = load_bitmap ("images/errou.bmp", NULL);
                                                blit(imagem,buffer,0,0,0,0,860,640);
                                                blit(buffer,screen,0,0,0,0,860,640);
                                                rest(1000.0);
                                            }
                                        }
                                    }
                                }
                            }
                        }
            }//FIM WHILE RODADA
            rodada++;
    }
    sairJogo(pontos,indice);
}
}

void regras()
{
    while (!key[KEY_1])
    {
        BITMAP *imagem = load_bitmap ("images/regras.bmp", NULL);
        BITMAP *buffer = create_bitmap (860,640);
        blit(imagem,buffer,0,0,0,0,860,640);
        blit(buffer,screen,0,0,0,0,860,640);

    }
        menu();
}


int sairJogo (int pontos, int indice)
{
    BITMAP *imgmenu[2];
    BITMAP *buffer = create_bitmap(860,640);
    imgmenu[0] = load_bitmap ("images/salvaarsim.bmp", NULL);
    imgmenu[1] = load_bitmap ("images/salvaar.bmp", NULL);
    int keyPress_DOWN= 0 , keyPress_UP = 0;
    int i=0;

    while((!key[KEY_ESC]) && (!key[KEY_ENTER]))
    {
        FONT *ad = load_font ("font/aventure1.pcx", NULL, NULL);
        masked_blit(imgmenu[i],buffer,0,0,0,0,860,640);
        masked_blit(buffer,screen,0,0,0,0,860,640);
        textprintf_ex(screen, ad, 700,165, makecol(243,245,43), -1, "%d", pontos);

        if (key[KEY_DOWN])
        {
            if(!keyPress_DOWN)
            {
                keyPress_DOWN = 1;
                if (i==1)
                {
                    i=0;
                }
                else
                {
                    i++;
                }

            }
        }
        else
        {
            keyPress_DOWN=0;
        }

        if (key[KEY_UP])
        {
            if(!keyPress_UP)
            {
                i-=1;
                keyPress_UP = 1;
            }
        }
        else
        {
            keyPress_UP=1;
        }
    }

    if ( i == 0)
    {
        salvarJogo(pontos, indice);
    }
    else
    {
        menu();
    }
}


int salvarJogo(int pontos, int indice)
{
    FILE *arquivoJogo;

    /*Abre o arquivo habilitado*/
    arquivoJogo = fopen("bd/jogopokemon.txt", "wt");

    /*Teste*/
    if(arquivoJogo == NULL)
    {
        exit(1);
    }

    fprintf(arquivoJogo, "%d\n%d", indice, pontos);
    BITMAP *buffer = create_bitmap(860,640);
    BITMAP *imagem = load_bitmap ("images/sair.bmp", NULL);
    blit(imagem,buffer,0,0,0,0,860,640);
    blit(buffer,screen,0,0,0,0,860,640);
    rest(1000.0);

    fclose(arquivoJogo);
    exit (1);
}


int abrirJogo(int *indice, int *pontos)
{
    FILE *arquivoJogo;

    /*Abre o arquivo habilitado para a leitura*/
    arquivoJogo = fopen("bd/jogopokemon.txt", "rt");

    if(arquivoJogo == NULL) //teste
    {
        exit(1);
    }

    /*Faz a leitura apenas da variável do tipo inteiro*/
    fscanf(arquivoJogo, "%d\n%d", &*indice, &*pontos);
    printf("---------indice: %d\n---------pontos: %d\n", *indice, *pontos);
    iniciarJogo(&*indice, &*pontos, 0);
    fclose(arquivoJogo);
}

char* texto(int i)
{
    BITMAP *imagem = NULL;
    char nomeEscrito[15];
    char letra[0];
    int j;
    for(j=0; j<15; j++)nomeEscrito[j] = 0;
    letra[0]=0;
    int img_pos_x = 20;
    int keyPress_A=0, keyPress_B=0, keyPress_C=0, keyPress_D=0, keyPress_E=0, keyPress_F=0, keyPress_G=0, keyPress_H=0;
    int keyPress_I=0, keyPress_J=0, keyPress_K=0, keyPress_L=0, keyPress_M=0, keyPress_N=0, keyPress_O=0, keyPress_P=0;
    int keyPress_Q=0, keyPress_R=0, keyPress_S=0, keyPress_T=0, keyPress_U=0, keyPress_V=0, keyPress_W=0, keyPress_X=0;
    int keyPress_Y=0, keyPress_Z=0, keyPress_1=0;

    while ((!key[KEY_ENTER] && (!key[KEY_1])))
    {
        if (key[KEY_A])
        {
            if(!keyPress_A)
            {
                keyPress_A = 1;
                imagem = load_bitmap ("images/A.bmp", NULL);
                draw_sprite(screen, imagem, img_pos_x,400);
                img_pos_x += 30;
                strncat(nomeEscrito,"A",1);

            }
        }
        else
        {
            keyPress_A=0;
        }

        if (key[KEY_B])
        {
                    if(!keyPress_B)
                    {
                        keyPress_B = 1;
                        imagem = load_bitmap ("images/B.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"B",1);
                    }
                }
                else
                {
                    keyPress_B=0;
                }

                if (key[KEY_C])
                {
                    if(!keyPress_C)
                    {
                        keyPress_C = 1;
                        imagem = load_bitmap ("images/C.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"C",1);
                    }
                }
                else
                {
                    keyPress_C=0;

                }

                if (key[KEY_D])
                {
                    if(!keyPress_D)
                    {
                        keyPress_D = 1;
                        imagem = load_bitmap ("images/D.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"D",1);
                    }
                }
                else
                {
                    keyPress_D=0;
                }

                if (key[KEY_E])
                {
                    if(!keyPress_E)
                    {
                        keyPress_E = 1;
                        imagem = load_bitmap ("images/E.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"E",1);
                    }
                }
                else
                {
                    keyPress_E=0;
                }

                if (key[KEY_F])
                {
                    if(!keyPress_F)
                    {
                        keyPress_F = 1;
                        imagem = load_bitmap ("images/F.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"F",1);
                    }
                }
                else
                {
                    keyPress_F=0;

                }

                if (key[KEY_G])
                {
                    if(!keyPress_G)
                    {
                        keyPress_G = 1;
                        imagem = load_bitmap ("images/G.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"G",1);
                    }
                }
                else
                {
                    keyPress_G=0;
                }

                if (key[KEY_H])
                {
                    if(!keyPress_H)
                    {
                        keyPress_H = 1;
                        imagem = load_bitmap ("images/H.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"H",1);
                    }
                }
                else
                {
                    keyPress_H=0;
                }

                if (key[KEY_I])
                {
                    if(!keyPress_I)
                    {
                        keyPress_I = 1;
                        imagem = load_bitmap ("images/I.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"I",1);
                    }
                }
                else
                {
                    keyPress_I=0;

                }
                if (key[KEY_J])
                {
                    if(!keyPress_J)
                    {
                        keyPress_J = 1;
                        imagem = load_bitmap ("images/J.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"J",1);
                    }
                }
                else
                {
                    keyPress_J=0;

                }

                if (key[KEY_K])
                {
                    if(!keyPress_K)
                    {
                        keyPress_K = 1;
                        imagem = load_bitmap ("images/K.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"K",1);
                    }
                }
                else
                {
                    keyPress_K=0;
                }

                if (key[KEY_L])
                {
                    if(!keyPress_L)
                    {
                        keyPress_L = 1;
                        imagem = load_bitmap ("images/L.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"L",1);
                    }
                }
                else
                {
                    keyPress_L=0;
                }

                if (key[KEY_M])
                {
                    if(!keyPress_M)
                    {
                        keyPress_M = 1;
                        imagem = load_bitmap ("images/M.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"M",1);
                    }
                }
                else
                {
                    keyPress_M=0;
                }

                if (key[KEY_N])
                {
                    if(!keyPress_N)
                    {
                        keyPress_N = 1;
                        imagem = load_bitmap ("images/N.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"N",1);
                    }
                }
                else
                {
                    keyPress_N=0;
                }

                if (key[KEY_O])
                {
                    if(!keyPress_O)
                    {
                        keyPress_O = 1;
                        imagem = load_bitmap ("images/O.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"O",1);
                    }
                }
                else
                {
                    keyPress_O=0;
                }

                if (key[KEY_P])
                {
                    if(!keyPress_P)
                    {
                        keyPress_P = 1;
                        imagem = load_bitmap ("images/P.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"P",1);
                    }
                }
                else
                {
                    keyPress_P=0;

                }

                if (key[KEY_Q])
                {
                    if(!keyPress_Q)
                    {
                        keyPress_Q = 1;
                        imagem = load_bitmap ("images/Q.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"Q",1);
                    }
                }
                else
                {
                    keyPress_Q=0;

                }

                if (key[KEY_R])
                {
                    if(!keyPress_R)
                    {
                        keyPress_R = 1;
                        imagem = load_bitmap ("images/R.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"R",1);
                    }
                }
                else
                {
                    keyPress_R=0;

                }

                if (key[KEY_S])
                {
                    if(!keyPress_S)
                    {
                        keyPress_S = 1;
                        imagem = load_bitmap ("images/S.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"S",1);
                    }
                }
                else
                {
                    keyPress_S=0;

                }

                if (key[KEY_T])
                {
                    if(!keyPress_T)
                    {
                        keyPress_T = 1;
                        imagem = load_bitmap ("images/T.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"T",1);
                    }
                }
                else
                {
                    keyPress_T=0;

                }

                if (key[KEY_U])
                {
                    if(!keyPress_U)
                    {
                        keyPress_U = 1;
                        imagem = load_bitmap ("images/U.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"U",1);
                    }
                }
                else
                {
                    keyPress_U=0;

                }

                if (key[KEY_V])
                {
                    if(!keyPress_V)
                    {
                        keyPress_V = 1;
                        imagem = load_bitmap ("images/V.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"V",1);
                    }
                }
                else
                {
                    keyPress_V=0;

                }

                if (key[KEY_W])
                {
                    if(!keyPress_W)
                    {
                        keyPress_W = 1;
                        imagem = load_bitmap ("images/W.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"W",1);
                    }
                }
                else
                {
                    keyPress_W=0;

                }

                if (key[KEY_Y])
                {
                    if(!keyPress_Y)
                    {
                        keyPress_Y = 1;
                        imagem = load_bitmap ("images/Y.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"Y",1);
                    }
                }
                else
                {
                    keyPress_Y=0;

                }

                if (key[KEY_X])
                {
                    if(!keyPress_X)
                    {
                        keyPress_X = 1;
                        imagem = load_bitmap ("images/X.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"X",1);
                    }
                }
                else
                {
                    keyPress_X=0;

                }

                if (key[KEY_Z])
                {
                    if(!keyPress_Z)
                    {
                        keyPress_Z = 1;
                        imagem = load_bitmap ("images/Z.bmp", NULL);
                        draw_sprite(screen, imagem, img_pos_x,400);
                        img_pos_x += 30;
                        strncat(nomeEscrito,"Z",1);
                    }
                }
                else
                {
                    keyPress_Z=0;

                }

                if (key[KEY_1])
                {
                    if(!keyPress_1)
                    {
                        keyPress_1 = 1;
                        strncat(nomeEscrito,"1",1);
                    }
                }
                else
                {
                    keyPress_1=0;

                }

    }
        printf("\nnomeEscrito : %s\n",nomeEscrito);
        return (nomeEscrito);
}
