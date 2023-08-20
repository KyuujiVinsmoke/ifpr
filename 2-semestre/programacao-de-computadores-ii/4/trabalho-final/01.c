#include "BIBLIOTECA.h"

int main() 
{	
	// VARIAVEIS DO JOGO
	int mapa[ALT][LAR];
	int lin, col, final, px, py;
	char jogada;

	// CONTADOR LINK E EPONA
	int contepona = 0, contlink = 0;

	// VARIAVEIS DE TESTE
	int linha, l, coluna, c;
	double cont1, cont2;
	
	// VARIAVEL TXT E BIN
	FILE *fp;
	char nome[TAM];

	srand(time(NULL));

	// EXIBIR HISTORIA
	system ("clear");
	branco;
	printf ("\t Crie Um Mapa Usando Link Como Inicio,\n");
	printf ("\t     Onde Ele Percorrera o Caminho    \n");
	printf ("\t         Para Salvar Epona.           \n");
	azulescuro;
	printf ("\t                  ♦️");
	__fpurge(stdin);
	scanf("%c", &nome[TAM]);

	// INICIAR O MAPA COM PAREDES
	for (lin = 0; lin  <ALT; lin++) 
	{
		for (col = 0; col < LAR; col++) 
		{
			mapa[lin][col] = PAREDE;
		}
	}

	// EDITOR DE MAPAS
	for (final = 0, px = py = 1; final == 0; contepona = 0, contlink = 0) 
	{
		system("clear");
		verde;
		printf("\t\t  EDITOR DE MAPAS - JODO DE RESGATE\n");
		for (lin = 0; lin < ALT; lin++) 
		{
			// printf("");
			for (col = 0; col < LAR; col++) 
			{

				if (lin == px && col == py) 
				{
					azulescuro;				
					printf("_");

					if (mapa[lin][col] == INICIO)
					{
						contlink = 9;
						linha = lin;
						coluna = col;
					}

					if (mapa[lin][col] == ANIMAL) 
					{
						contepona = 9;
					}
				}
				
				else if (mapa[lin][col] == CAMINHO) 
				{
					branco;
					printf(" ");
				}
				
				else if (mapa[lin][col] == PAREDE) 
				{
					branco;
					printf("#");
				}
				
				else if (mapa[lin][col] == INICIO) 
				{
					azulescuro;
					printf("☻");
					contlink = 1;
					linha = lin;
					coluna = col;
				}
				
				else if (mapa[lin][col] == ANIMAL) 
				{
					verde;
					printf("♞");
					contepona = 1;
				}
			}
			printf ("\n");
		}

		// CONTROLES DE EDIÇÃO
		verde;
		printf ("(C: Caminho)(P: Parede)(L: Link)(E: Epona)(S: Salvar)(0: Sair)");

		// INICIO JÁ EXISTENTE
		if (jogada == 'L' && contlink == 1 || jogada == 'l' && contlink == 1)
		{
			vermelho;
			printf ("\n[ERROR] Link Já Existente");
		}

		// ANIMAL JÁ EXISTENTE
		else if (jogada == 'E' && contepona == 1 || jogada == 'e' && contepona == 1)
		{
			vermelho;
			printf ("\n[ERROR] Epona Já Existente");
		}

		// INICIO INEXISTENTE
		else if (jogada == 'S' && contlink == 0 || jogada == 's' && contlink == 0)
		{
			vermelho;
			printf ("\n\t[ERROR] Link Inexistente");
		}

		// ANIMAL INEXISTENTE
		else if (jogada == 'S' && contepona == 0 || jogada == 's' && contepona == 0)
		{
			vermelho;
			printf ("\n[ERROR] Epona Inexistente");
		}

		// TESTAR CAMINHO
		else if (jogada == 'S' && contlink >= 1 && contepona >= 1|| jogada == 's' && contlink >= 1 && contepona >= 1)
		{
			for (l = linha, c = coluna, cont1 = 0; cont1 < 10000000; cont1++)
			{
				for (cont2 = 0; cont2 == 0;)
				{	
					px = (l - 1) + rand() % 3;

					if (px == l - 1)
					{
						py = c;
					}

					else if (px == l)
					{
						py = (c - 1) + rand() % 3;
					}
					
					else if (px == l + 1)
					{
						py = c;
					}

					if (mapa[px][py] == ANIMAL && px >= 0 && py >= 0 && px < ALT && py < LAR)
					{	
						cont1 = 10000009;
						cont2 = 1;
						final = 1;
					}

					else if (mapa[px][py] == CAMINHO && px >= 0 && py >= 0 && px < ALT && py < LAR)
					{
						cont2 = 1;
						l = px;
						c = py;
					}

					else if (mapa[px][py] == INICIO && px >= 0 && py >= 0 && px < ALT && py < LAR)
					{
						cont2 = 1;
						l = px;
						c = py;
					}
				}
			}

			px = linha;
			py = coluna;

			if (cont1 == 10000000)
			{
				vermelho;
				printf ("\n[ERROR] Caminho Não Encontrado");
			}
		}
		
		if (final == 0)
		{
			// CAPTURA TECLA
			jogada = getch();

			// TECLA ESPECIAL
			if (jogada == 27) 
			{
				jogada = getch(); 

				if (jogada == 91) 
				{      
					jogada = getch();
				
					// CIMA
					if (jogada == 65) 
					{
						if (px > 0) 
						{
							px--;
						}
					}

	  				// BAIXO
					else if (jogada == 66) 
					{
		    			if (px < ALT - 1) 
						{
							px++;
						}
					}

					// DIREITA
					else if (jogada == 67) 
					{
						if (py < LAR - 1) 
						{
							py++;
						}
			    	}

					// ESQUERDA
					else if (jogada == 68) 
					{
						if (py > 0) 
						{
							py--;
						}
					}
				}	
			}

			// PAREDE
			else if (jogada == 'P' || jogada == 'p') 
			{		
				mapa[px][py] = PAREDE;
			}

			// CAMINHO
			else if (jogada == 'C' || jogada == 'c') 
			{		
				mapa[px][py] = CAMINHO;
			}

			// INICIO
			else if (jogada == 'L' && contlink == 0 || jogada == 'l' && contlink == 0) 
			{
				mapa[px][py] = INICIO;
			}

			// EPONA
			else if (jogada == 'E' && contepona == 0 || jogada == 'e' && contepona == 0) 
			{		
				mapa[px][py] = ANIMAL;
			}

			// SAIR
			if (jogada == '0') 
			{ 
				printf ("\n\n");
				return 0; 
			}
		}
	}

	// SALVAR O NOME DO MAPA EM .txt
	fp = fopen ("MAPSNAME.txt", "a+");
    printf ("\n- Escolha O Nome Do Mapa: ");
    __fpurge(stdin);
	branco;
    gets(nome);
    fputs (nome, fp);
    fputc ('\n', fp);
    fclose(fp);
	verde;
	printf ("\n[Mapa Salvo]");
	
	// SALVAR O MAPA EM .bin
	fp = fopen ("MAPS.bin", "a+");
    if (fp != NULL)
    {
        fwrite (mapa, sizeof (Saves), 1, fp);
    }
	fclose(fp);
	
	printf ("\n\n");
	return 0;
}