#include <allegro5/allegro.h>
#include <allegro5/allegro_font.h>
#include <allegro5/allegro_ttf.h>
#include <allegro5/allegro_audio.h>
#include <allegro5/allegro_acodec.h>
#include <allegro5/allegro_image.h>
#include <stdio.h>
#include <stdbool.h>
#include <time.h>

/*Inicialização das variáveis - ALLEGRO5*/
ALLEGRO_DISPLAY *janela = NULL;
ALLEGRO_EVENT_QUEUE *fila_eventos = NULL;
ALLEGRO_BITMAP *Menu[8];  //Imagens do menu
ALLEGRO_BITMAP *imagem[19];  //Imagens dos alimentos
ALLEGRO_FONT *fonte1, *fonte2; //Fonte para os textos
ALLEGRO_AUDIO_STREAM *musicaMenu = NULL;
ALLEGRO_AUDIO_STREAM *musicaJogo = NULL;
ALLEGRO_SAMPLE *sample[3];//efeitos sonoros
FILE *arquivo; /*Arquivo para a maior pontuacao*/

/*Protótipo das funções*/
int rPosicao();
int rImagem();
void escreveArquivo();
int leArquivo();
void fadeout();
void comoJogar();
void loopImagem();
int menu();
int iniciarJogo();
bool inicializar();

/*Random para a posição das imagens na tela*/
int rPosicao()
{
	int k;
	double d;
	d = (double) rand() / ((double) RAND_MAX + 90);
	k = d * 800;
	if(k >= 100 && k <= 700)
	{
    	return k;
	}
	else if(k < 100)
	{
    	return k + 100;
	}
	else if (k > 700)
	{
    	return k - 100;
	}

	return 0;
}

/*Random das imagens dos alimentos*/
int rImagem()
{
	return rand()%10;
}

/*Escreve a pontuação no arquivo dado*/
void escreveArquivo(FILE *file, char *pontos)
{
	file = fopen("pontuacao.txt", "w"); //Abre o arquivo
	fputs(pontos, file); //Escreve no arquivo
	fclose(file); //Fecha o arquivo
}

/*Le a pontuação no arquivo dado*/
int leArquivo(FILE *file)
{
	int pMax;
	char texto[11]; //Texto que vai pegar do arquivo
	file = fopen("pontuacao.txt", "r"); //Abre o arquivo
	fgets(texto, 11, file); //Pega texto do arquivo
	pMax = atoi(texto); //Transforma o texto em inteiro
	fclose(file); //Fecha o arquivo
	return pMax; //Retorna o tanto de pontos

}

void fadeout(int velocidade, ALLEGRO_BITMAP *imagem)
{
	if (velocidade <= 0)
	{
    	velocidade = 1;
	}
	else if (velocidade > 15)
	{
    	velocidade = 15;
	}

	int alfa;
	for (alfa = 0; alfa <= 255; alfa += velocidade)
	{
    	al_clear_to_color(al_map_rgba(0, 0, 0, 0));
    	al_draw_tinted_bitmap(imagem, al_map_rgba(255 - alfa, 255 - alfa, 255 - alfa, alfa), 0, 0, 0);
    	al_flip_display();
    	al_rest(0.005);
	}

	al_destroy_bitmap(imagem);
}

/*Funcao para mostrar a pagina de como jogar*/
void comoJogar(ALLEGRO_BITMAP *img1, ALLEGRO_BITMAP *img2)
{
	ALLEGRO_EVENT evento1;
	while(1)
	{
    	al_draw_bitmap(img1, 0, 0, 0);
    	al_flip_display();
    	al_wait_for_event(fila_eventos, &evento1);
    	if(evento1.type == ALLEGRO_EVENT_KEY_DOWN)
    	{
        	if(evento1.keyboard.keycode == ALLEGRO_KEY_ENTER)
        	{
            	fadeout(9, img1);
            	ALLEGRO_EVENT evento3;
            	while(1)
            	{
                	al_draw_bitmap(img2, 0, 0, 0);
                	al_flip_display();
                	al_wait_for_event(fila_eventos, &evento3);
                	if(evento3.type == ALLEGRO_EVENT_KEY_DOWN)
                	{
                    	if(evento3.keyboard.keycode == ALLEGRO_KEY_ENTER)
                    	{
                        	fadeout(9, img2);
                        	break;
                    	}
                	}
            	}
            	break;
        	}
    	}
	}
}

/*Funcao para o loop de uma imagem ate apertar enter*/
void loopImagem(ALLEGRO_BITMAP *img)
{
	ALLEGRO_EVENT evento2;
	while(1)
	{
    	al_draw_bitmap(img, 0, 0, 0);
    	al_flip_display();
    	al_wait_for_event(fila_eventos, &evento2);
    	if(evento2.type == ALLEGRO_EVENT_KEY_DOWN)
    	{
        	if(evento2.keyboard.keycode == ALLEGRO_KEY_ENTER)
        	{
            	break;
        	}
    	}
	}
}

int menu()
{
	/*Load das imagens do menu*/
	Menu[0] = al_load_bitmap("menuIniciar.jpg");
	Menu[1] = al_load_bitmap("menuRegras.jpg");
	Menu[2] = al_load_bitmap("menuCuriosidades.jpg");
	Menu[3] = al_load_bitmap("menuCreditos.jpg");
	Menu[4] = al_load_bitmap("comoJogar.jpg");
	Menu[5] = al_load_bitmap("pontuacao.jpg");
	Menu[6] = al_load_bitmap("curiosidades.jpg");
	Menu[7] = al_load_bitmap("creditos.jpg");

	/*Variáveis locais*/
	int i = 0;
	int alfa;

	/*Exibe a primeira opção do menu com fade in*/
	for (alfa = 0; alfa <= 255; alfa += 9)
	{
    	al_clear_to_color(al_map_rgb(0, 0, 0));
    	al_draw_tinted_bitmap(Menu[0], al_map_rgba(alfa, alfa, alfa, alfa), 0, 0, 0);
    	al_flip_display();
    	al_rest(0.005);
	}

	/*Música do menu*/
	al_attach_audio_stream_to_mixer(musicaMenu, al_get_default_mixer());
	al_set_audio_stream_playing(musicaMenu, true);
	al_set_audio_stream_playing(musicaJogo, false);

	/*Loop do jogo*/
	while (1)
	{
    	/*Desenha no loop a imagem do menu necessária*/
    	al_draw_bitmap(Menu[i], 0, 0, 0);
    	al_flip_display();
    	/*Evento para fechar o jogo quando clicar no botão "fechar" da janela*/
    	if (!al_is_event_queue_empty(fila_eventos))
    	{
        	ALLEGRO_EVENT evento;
        	al_wait_for_event(fila_eventos, &evento);
        	if (evento.type == ALLEGRO_EVENT_DISPLAY_CLOSE)
        	{
            	return 1; /*Se fechar, retorna verdadeiro*/
            	break;
        	}
        	else if(evento.type == ALLEGRO_EVENT_KEY_DOWN)
        	{
            	switch (evento.keyboard.keycode)
            	{
            	case ALLEGRO_KEY_DOWN:
                	/*Condição para atribuir valor a 'x' e relacioná-la com a opção escolhida*/
                	i == 3? i = 0 : i++;
                	break;
            	case ALLEGRO_KEY_UP:
                	/*Voltar uma opção no menu*/
                	i == 0? i = 3 : i--;
                	break;
            	case ALLEGRO_KEY_ENTER: /*Selecionar opção*/
                	al_play_sample(sample[1], 0.7, 1.0, 1.0, ALLEGRO_PLAYMODE_ONCE, NULL);//som do enter
                	switch (i)
                	{
                	case 0:
                    	fadeout(9, Menu[0]);
                    	iniciarJogo();
                        return 0;
                	case 1:
                    	fadeout(9, Menu[1]);
                    	comoJogar(Menu[4], Menu[5]);
                    	return 0; //Depois que mostrar o comoJogar, sai da função e retorna falso
                	case 2:
                    	fadeout(9, Menu[0]);
                    	loopImagem(Menu[6]);
                    	return 0;
                	case 3:
                    	fadeout(9, Menu[0]);
                    	loopImagem(Menu[7]);
                    	return 0;
                    	break;
                	}
                	break;
            	}
        	}
    	}
	}
	al_destroy_display(janela);
}

int iniciarJogo()
{
	/*Declaração de variáveis locais*/
	bool sair = false;
	int x[7], i;  /*x[] Posição em que os alimentos são criados no topo*/
	x[6]=500;  /*Posição em que o avatar é criado no jogo*/
	int a, b, c, d, e, f; /*Índice para imagens*/
	int velocidadeBoneco = 0; /*"Velocidade" que o avatar recebe por comer um alimento saudável/não-saudável*/
	int imagemBoneco; /*Índice para a imagem da barriga*/
	int tamBarriga = 10; /*Contador para a mudança da imagem da barriga (2 em 2 alimentos saudáveis/não-saudáveis)*/
	float y[6]; /*Velocidade da queda dos alimentos*/
	int erro = 0, pontos = 0, pontuacaoMax; /*Contagem dos pontos*/
	pontuacaoMax = leArquivo(arquivo); //Coloca os pontos do arquivo na variavel local
	bool pausar = false;
	int alfa; //Para o fade in
	char textoPontos[10], maxPonto[10],erros[20]; //Cria uma string pros pontos
	srand((unsigned int)time(NULL));

	/*Música*/
	al_attach_audio_stream_to_mixer(musicaJogo, al_get_default_mixer());
	al_set_audio_stream_playing(musicaJogo, true);
	al_set_audio_stream_playing(musicaMenu, false);

	/*Inicialização das imagens*/
	imagem[0] = al_load_bitmap("bacon.png");
	imagem[1] = al_load_bitmap("maca.png");
	imagem[2] = al_load_bitmap("cq.png");
	imagem[3] = al_load_bitmap("alface.png");
	imagem[4] = al_load_bitmap("sorvete.png");
	imagem[5] = al_load_bitmap("agua.png");
	imagem[6] = al_load_bitmap("pizza.png");
	imagem[7] = al_load_bitmap("peixe.png");
	imagem[8] = al_load_bitmap("refri.png");
	imagem[9] = al_load_bitmap("torrada.png");
	imagem[10] = al_load_bitmap("fundo.jpg");
	imagem[11] = al_load_bitmap("boneco1.png");
	imagem[12] = al_load_bitmap("boneco2.png");
	imagem[13] = al_load_bitmap("boneco3.png");
	imagem[14] = al_load_bitmap("boneco4.png");
	imagem[15] = al_load_bitmap("boneco5.png");
	imagem[16] = al_load_bitmap("final1.jpg");
	imagem[17] = al_load_bitmap("final2.jpg");

	/*Inicialização do vetor y com 600 para não aparecer na tela quando iniciar*/
	for(i = 0; i <= 6; i++)
	{
    	y[i] = 610;
	}

	/*Random para as imagens iniciais*/
	a = rImagem();
	b = rImagem();
	c = rImagem();
	d = rImagem();
	e = rImagem();
	f = rImagem();

	/*Fade in*/
	for (alfa = 0; alfa <= 255; alfa += 9)
	{
    	al_clear_to_color(al_map_rgb(0, 0, 0));
    	al_draw_tinted_bitmap(imagem[10], al_map_rgba(alfa, alfa, alfa, alfa), 0, 0, 0);
    	al_draw_tinted_bitmap(imagem[11], al_map_rgba(alfa, alfa, alfa, alfa), x[6], 512, 0);
    	al_flip_display();
    	al_rest(0.005);
	}

	/*Loop que executa o jogo até o jogador pressionar a tecla 's' (será direcionado para o menu)*/
	while (!sair)
	{
    	if (!al_is_event_queue_empty(fila_eventos))
    	{
        	ALLEGRO_EVENT evento;
        	al_wait_for_event(fila_eventos, &evento);
        	if (evento.type == ALLEGRO_EVENT_KEY_DOWN)
        	{
            	switch (evento.keyboard.keycode)
            	{
            	case ALLEGRO_KEY_S:
                	fadeout(9, imagem[10]);
                	al_play_sample(sample[2], 1.0, 0.0, 1.0, ALLEGRO_PLAYMODE_ONCE, NULL);//som para sair
                	al_set_audio_stream_playing(musicaJogo, false);//parar som jogo
                	al_draw_bitmap(imagem[16],0,0,0);
                	al_draw_text(fonte2, al_map_rgb(255,255,255), 460, 210,ALLEGRO_ALIGN_CENTRE, textoPontos); //Desenha a contagem dos pontos
                	al_draw_text(fonte2, al_map_rgb(255, 255, 255), 520, 300, ALLEGRO_ALIGN_CENTRE, maxPonto); //Desenha a maior pontuacao
                	al_flip_display();
                	al_rest(2.0);
                	return 0;
            	case ALLEGRO_KEY_RIGHT:
                	/*Movimento do avatar para a direita*/

                	if(x[6]<735) /*735 é o limite em que o avatar pode se mover na coordenada x*/
                	{
                    	x[6] += 50 - velocidadeBoneco;
                	}
                	else
                	{
                    	x[6] = 0;
                	}
                	break;
            	case ALLEGRO_KEY_LEFT:
                	if(x[6]>0)
                	{
                    	x[6] -= 50 - velocidadeBoneco;
                	}
                	else
                	{
                    	x[6] = 735;
                	}
                	break;
            	case ALLEGRO_KEY_P:
                	pausar--;
                	break;
            	}
        	}
    	}

    	while(pausar)
    	{
        	al_draw_text(fonte2, al_map_rgb(255, 255, 255), 400, 200, ALLEGRO_ALIGN_CENTRE, "Pressione P para voltar o jogo.");
        	al_flip_display();
        	if (!al_is_event_queue_empty(fila_eventos))
        	{
            	ALLEGRO_EVENT evento;
            	al_wait_for_event(fila_eventos, &evento);
            	if (evento.type == ALLEGRO_EVENT_KEY_DOWN)
            	{
                	switch(evento.keyboard.keycode)
                	{
                	case ALLEGRO_KEY_P:

                    	pausar--;
                    	break;
                	case ALLEGRO_KEY_S:
                    	fadeout(9, imagem[10]);
                    	al_play_sample(sample[2], 1.0, 0.0, 1.0, ALLEGRO_PLAYMODE_ONCE, NULL);//som do alimento
                    	al_set_audio_stream_playing(musicaJogo, false);//parar som jogo
                    	al_draw_bitmap(imagem[16],0,0,0);
                    	al_draw_text(fonte2, al_map_rgb(255,255,255), 460, 210,ALLEGRO_ALIGN_CENTRE, textoPontos); //Desenha a contagem dos pontos
                    	al_draw_text(fonte2, al_map_rgb(255, 255, 255), 520, 300, ALLEGRO_ALIGN_CENTRE, maxPonto); //Desenha a maior pontuacao
                    	al_flip_display();
                    	al_rest(2.0);
                    	return 0;
                	}
            	}
        	}
    	}

    	/*Início da animação*/
    	al_draw_bitmap(imagem[10],0,0,0);
    	/*Velocidade da queda dos alimentos base + velocidade randômica*/
    	y[0]+=1.5;
    	y[1]+=1.9;
    	y[2]+=2.4;
    	y[3]+=1.7;
    	y[4]+=2.0;
    	y[5]+=1.5;
    	/*Condição para identificar colisões*/
    	if((y[0]>510 && y[0]<550) && (x[0]<=x[6]+44 && x[0]>=x[6]-35))
    	{
        	/*510 e 550: colisão apenas com a cabeça do boneco (altura)
        	+44 e -35: colisão apenas com a cabeça do boneco (largura)*/
        	al_play_sample(sample[0], 1.0, 0.0, 1.0, ALLEGRO_PLAYMODE_ONCE, NULL);//som do alimento
        	x[0] = 900; /*Alimento é direcionado para fora da janela de visualização*/
        	if(a%2==0) /*Índices pares são de alimentos não saudáveis*/
        	{
            	if(50 - velocidadeBoneco > 4) /*Evitar velocidade negativa e se movimentar para o lado oposto*/
            	{
                	velocidadeBoneco += 5; /*Diminui 5 na velocidade do avatar*/
            	}
            	tamBarriga += 5; /*Quando tamBarriga é igual a 10, modifica a imagem (mais gordo)*/
            	pontos += 2;
        	}
        	else
        	{
            	if(50 - velocidadeBoneco < 50) /*Evitar velocidade maior que 50 e se movimentar x rápido que a vel. inicial*/
            	{
                	velocidadeBoneco--; /*Aumenta 1 na velocidade do avatar*/
            	}
            	tamBarriga -= 1; /*De 5 para 0, diminui de 1 em 1 e modifica imagem (mais magro)
            	Para 1 alimento não saudável, comer 5 saudáveis*/

            	pontos += 5;
        	}
        	a = rImagem(); /*Random para a imagem de outro alimento*/
    	}
    	if((y[1]>510 && y[1]<550) && (x[1]<=x[6]+44 && x[1]>=x[6]-35))
    	{
        	al_play_sample(sample[0], 1.0, 0.0, 1.0, ALLEGRO_PLAYMODE_ONCE, NULL);//som do alimento
        	x[1] = 900;
        	if(b%2==0)
        	{
            	if(50 - velocidadeBoneco > 4)
            	{
                	velocidadeBoneco += 5;
            	}
            	tamBarriga += 5;
            	pontos += 2;
        	}
        	else
        	{
            	if(50 - velocidadeBoneco < 50)
            	{
                	velocidadeBoneco -= 1;
            	}
            	tamBarriga -= 1;
            	pontos += 5;

        	}
        	b = rImagem();
    	}
    	if((y[2]>510 && y[2]<550) && (x[2]<=x[6]+44 && x[2]>=x[6]-35))
    	{
        	al_play_sample(sample[0], 1.0, 0.0, 1.0, ALLEGRO_PLAYMODE_ONCE, NULL);//som do alimento
        	x[2] = 900;
        	if(c%2==0)
        	{
            	if(50 - velocidadeBoneco > 4)
            	{
                	velocidadeBoneco += 5;
            	}
            	tamBarriga += 5;
            	pontos += 2;
        	}
        	else
        	{
            	if(50 - velocidadeBoneco < 50)
            	{
                	velocidadeBoneco -= 1;
            	}
            	tamBarriga -= 1;
            	pontos += 5;

        	}
        	c = rImagem();
    	}
    	if((y[3]>510 && y[3]<550) && (x[3]<=x[6]+44 && x[3]>=x[6]-35))
    	{
        	al_play_sample(sample[0], 1.0, 0.0, 1.0, ALLEGRO_PLAYMODE_ONCE, NULL);//som do alimento
        	x[3] = 900;
        	if(d%2==0)
        	{
            	if(50 - velocidadeBoneco > 4)
            	{
                	velocidadeBoneco += 5;
            	}
            	tamBarriga += 5;
            	pontos += 2;
        	}
        	else
        	{
            	if(50 - velocidadeBoneco < 50)
            	{
                	velocidadeBoneco -= 1;
            	}
            	tamBarriga -= 1;
            	pontos += 5;

        	}
        	d = rImagem();
    	}
    	if((y[4]>510 && y[4]<550) && (x[4]<=x[6]+44 && x[4]>=x[6]-35))
    	{
        	al_play_sample(sample[0], 1.0, 0.0, 1.0, ALLEGRO_PLAYMODE_ONCE, NULL);//som do alimento
        	x[4] = 900;
        	if(e%2==0)
        	{
            	if(50 - velocidadeBoneco > 4)
            	{
                	velocidadeBoneco += 5;
            	}
            	tamBarriga += 5;
            	pontos += 2;
        	}
        	else
        	{
            	if(50 - velocidadeBoneco < 50)
            	{
                	velocidadeBoneco -= 1;
            	}
            	tamBarriga -= 1;
            	pontos += 5;

        	}
        	e = rImagem();
    	}
    	if((y[5]>510 && y[5]<550) && (x[5]<=x[6]+44 && x[5]>=x[6]-35))
    	{
        	al_play_sample(sample[0], 1.0, 0.0, 1.0, ALLEGRO_PLAYMODE_ONCE, NULL);//som do alimento
        	x[5] = 900;
        	if(f%2==0)
        	{
            	if(50 - velocidadeBoneco > 4)
            	{
                	velocidadeBoneco += 5;
            	}
            	tamBarriga += 5;
            	pontos += 2;
        	}
        	else
        	{
            	if(50 - velocidadeBoneco < 50)
            	{
                	velocidadeBoneco -= 1;
            	}
            	tamBarriga -= 1;
            	pontos += 5;

        	}
        	f = rImagem();
    	}
    	/*Quando o alimento não colide com o avatar, ele chega até o limite da tela e é recriado*/
    	if(y[0]>675)
    	{
        	y[0] = 0; /*Alimento é recriado nessa posição*/
        	x[0] = rPosicao();
        	a = rImagem();

    	}
    	if(y[1]>1475)
    	{
        	y[1] = 0;
        	x[1] = rPosicao();
        	b = rImagem();

    	}
    	if(y[2]>1975)
    	{
        	y[2] = 0;
        	x[2] = rPosicao();
        	c = rImagem();

    	}
    	if(y[3]>2375)
    	{
        	y[3] = 0;
        	x[3] = rPosicao();
        	d = rImagem();

    	}
    	if(y[4]>2075)
    	{
        	y[4] = 0;
        	x[4] = rPosicao();
        	e = rImagem();

    	}
    	if(y[5]>1675)
    	{
        	y[5] = 0;
        	x[5] = rPosicao();
        	f = rImagem();

    	}
    	/*Verifica os alimentos saudáveis (ímpares) que caíram no chão*/
    	if((y[0]==600 && x[0]<900) && a%2!=0)erro++;
    	if((y[1]==600 && x[1]<900) && b%2!=0)erro++;
    	if((y[2]==600 && x[2]<900) && c%2!=0)erro++;
    	if((y[3]==600 && x[3]<900) && d%2!=0)erro++;
    	if((y[4]==600 && x[4]<900) && e%2!=0)erro++;
    	if((y[5]==600 && x[5]<900) && f%2!=0)erro++;
    	if(erro >= 10)
    	{
        	fadeout(9, imagem[10]);
        	al_play_sample(sample[2], 1.0, 0.0, 1.0, ALLEGRO_PLAYMODE_ONCE, NULL);//som do alimento
        	al_set_audio_stream_playing(musicaJogo, false);//parar som jogo
        	al_draw_bitmap(imagem[17],0,0,0);
        	al_draw_text(fonte2, al_map_rgb(255,255,255), 460, 260,ALLEGRO_ALIGN_CENTRE, textoPontos); //Desenha a contagem dos pontos
        	al_draw_text(fonte2, al_map_rgb(255, 255, 255), 510, 350, ALLEGRO_ALIGN_CENTRE, maxPonto); //Desenha a maior pontuacao
        	al_flip_display();
        	al_rest(2.0);
        	return 0;
    	}

    	al_rest(0.011); /*Pausa de 0.011*/

    	/*Exibe a imagem dos alimentos*/
    	al_draw_bitmap(imagem[a], x[0], y[0],0);
    	al_draw_bitmap(imagem[b], x[1], y[1],0);
    	al_draw_bitmap(imagem[c], x[2], y[2],0);
    	al_draw_bitmap(imagem[d], x[3], y[3],0);
    	al_draw_bitmap(imagem[e], x[4], y[4],0);
    	al_draw_bitmap(imagem[f], x[5], y[5],0);
    	/*Verifica qual imagem do boneco deve ser exibida (magro/gordo)*/
    	if(tamBarriga >= 50) /*de 8 até 10 alimentos não saudáveis*/
    	{
        	imagemBoneco = 15;

    	}
    	else
    	{
        	if(tamBarriga >= 40) /*de 7 até 8 alimentos não saudáveis*/
        	{
            	imagemBoneco = 14;

        	}
        	else
        	{
            	if(tamBarriga >= 30) /*de 5 até 7 alimentos não saudáveis*/
            	{
                	imagemBoneco = 13;

            	}
            	else
            	{
                	if(tamBarriga >= 20) /*de 2 até 5 alimentos não saudáveis*/
                	{
                    	imagemBoneco = 12;

                	}
                	else
                	{
                    	if(tamBarriga < 19) /*até 1 alimento não saudável*/
                    	{
                        	imagemBoneco = 11;

                    	}
                	}
            	}
        	}
    	}

    	/*Exibe o avatar com o tamanho da barriga referente à ingestão dos alimentos*/
    	al_draw_bitmap(imagem[imagemBoneco],x[6],512,0);

    	itoa(pontos, textoPontos, 10);

    	if(pontos > pontuacaoMax) //Se a pontuação for maior que a do recorde
    	{
        	pontuacaoMax = pontos; //Atualiza a variavel local pra mostrar na tela
        	escreveArquivo(arquivo, textoPontos); //Sobrescreve no arquivo tambem
    	}
    	itoa(pontuacaoMax, maxPonto, 10);
    	itoa(erro, erros, 10);
    	al_draw_text(fonte1, al_map_rgb(255,255,255), 120, 8,ALLEGRO_ALIGN_CENTRE, textoPontos); //Desenha a contagem dos pontos
    	al_draw_text(fonte1, al_map_rgb(255,255,255), 100, 50,ALLEGRO_ALIGN_CENTRE, erros);
    	al_draw_text(fonte1, al_map_rgb(255,255,255), 135, 50,ALLEGRO_ALIGN_CENTRE, "/10");

    	al_flip_display();
	}
	return 0;
}

int main(void)
{
	bool sair = false;

	if (!inicializar())
	{
    	return -1;
	}
	al_attach_audio_stream_to_mixer(musicaMenu, al_get_default_mixer());
	al_set_audio_stream_playing(musicaMenu, true);
    imagem[18] = al_load_bitmap("imageminicial.jpg");
	al_draw_bitmap(imagem[18],0,0,0);
    al_flip_display();
    al_rest(3.0);
	while(!sair) //Enquanto nao sair
	{
    	if(menu()) //Se a funcao do menu retornar verdadeiro
    	{
        	sair = true; //Sair vira verdadeiro e sai do jogo
    	}
	}

	al_destroy_event_queue(fila_eventos);
	al_destroy_display(janela);
	return 0;
}

/*Inicializa o Allegro5*/
bool inicializar()
{
	if (!al_init())
	{
    	fprintf(stderr, "Falha ao inicializar Allegro.\n");
    	return false;
	}
	janela = al_create_display(800, 600);
	if (!janela)
	{
    	fprintf(stderr, "Falha ao criar janela.\n");
    	return false;
	}
	al_set_window_title(janela, "Raining Food");

	al_init_image_addon();

	if (!al_install_keyboard())
	{
    	fprintf(stderr, "Falha ao inicializar o teclado.\n");
    	return false;
	}
	fila_eventos = al_create_event_queue();
	if (!fila_eventos)
	{
    	fprintf(stderr, "Falha ao criar fila de eventos.\n");
    	al_destroy_display(janela);
    	return false;
	}

	al_init_font_addon(); //Instala fonte
	al_init_ttf_addon(); //Instala fonte

	fonte1 = al_load_ttf_font("cac_champagne.ttf", 35, 0); //Coloca a fonte
	fonte2 = al_load_ttf_font("cac_champagne.ttf", 60, 0);


	if(!fonte1 || !fonte2) //Testa pra ver se funciona
	{
    	fprintf(stderr, "Falha ao criar a fonte.\n");
    	al_destroy_display(janela);
    	return false;
	}

	//teste de audio
	if (!al_install_audio())
	{
    	fprintf(stderr, "Falha ao inicializar áudio.\n");
    	return false;
	}

	if (!al_init_acodec_addon())
	{
    	fprintf(stderr, "Falha ao inicializar codecs de áudio.\n");
    	return false;
	}

	if (!al_reserve_samples(1))
	{
    	fprintf(stderr, "Falha ao alocar canais de áudio.\n");
    	return false;
	}
	//audios
	musicaMenu = al_load_audio_stream("musicaMenu.ogg", 4, 1024);//som do menu
	musicaJogo = al_load_audio_stream("musicaJogo.ogg", 4, 1024);//som do jogo
	if (!musicaMenu)
	{
    	fprintf(stderr, "Falha ao carregar audio.\n");
    	al_destroy_event_queue(fila_eventos);
    	al_destroy_display(janela);
    	al_destroy_sample(sample[0]);
    	return false;
	}
	sample[0] = al_load_sample("up.wav");
	sample[1] = al_load_sample("enter.wav");
	sample[2] = al_load_sample("sair.wav");

	al_register_event_source(fila_eventos, al_get_keyboard_event_source());
	al_register_event_source(fila_eventos, al_get_display_event_source(janela));
	return true;
}
