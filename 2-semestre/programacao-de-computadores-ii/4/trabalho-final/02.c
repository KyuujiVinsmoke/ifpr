#include "BIBLIOTECA.h"

int main() 
{	
	// VARIAVEIS DO JOGO
	int mapa[ALT][LAR];
	int lin, col, final, px, py;
	char jogada;
	
	// VARIAVEL COM NOME DOS MAPAS
    char linha[TAM];

    int op, cont, n, contparede = 0;
	char nada;

	// VARIAVEL AUTOMATICO
	int l, c;
	int cont1, cont2;

	// TIMER
	int comeco, fim;
	int segundos, minutos, horas;

	// VARIAVEL TXT E BIN
    FILE *fp;

	srand(time(NULL));

	// EXIBIR MAPAS PARA JOGAR
    for (op = 9999; op >= cont;)
	{
		system ("clear");

		verde;
		printf ("Escolha Um Mapa:\n");
    	fp = fopen ("MAPSNAME.txt", "a+");
    	for (cont = 1; fgets (linha, TAM, fp) != NULL; cont++)
    	{	
        	printf ("(%i) ", cont);
        	printf ("%s", linha);
    	}

		printf ("(0) Sair\n");
    	fclose(fp);
    	printf ("\n> ");
		branco;
    	scanf ("%i", &op);
		
		if (op <= 0)
		{
			printf ("\n\n");
			return 0;
		}
	}

	// ESCOLHER MAPA
    fp = fopen ("MAPS.bin", "a+");
	for (cont = 0; cont < op; cont++)
    {	
        fread (mapa, sizeof (Saves), 1, fp);
    }
    fclose(fp);

	// MODO DE JOGO
	for (op = 3; op > 2;)
	{
		system ("clear");
		verde;
		printf ("Escolha o Modo De Jogo");
		printf ("\n(1) Manual");
		printf ("\n(2) Automático");
		printf ("\n(0) Sair\n");
		printf ("\n> ");
		
		branco;
		scanf ("%i", &op);
		
		if (op <= 0)
		{
			printf ("\n\n");
			return 0;
		}
	}

	// EXIBIR HISTORIA
	system ("clear");
	branco;
	printf ("\t Link Perdeu Sua Égua Epona,\n");
	printf ("\t   Ajude-o a Encontrá-la.   \n");
	azulescuro;
	printf ("\t              ♦️");
	__fpurge(stdin);
	scanf("%c", &nada);

	// JOGO DE RESGATE
    for (final = 0, cont = 0, n = 2; final < 13;) 
	{	
		system ("clear");
		
		// EXIBIR NOME DO JOGO
		if (final == 0)
		{
			verde;
			printf ("Lost Woods");
		}

		// EXIBIR FIM DO JOGO
		else if (final != 0)
		{
			verde;
			printf ("Parabénsa a Epona Foi Encontrada");
		}

		// CONTAGEM DO TIMER
		for (segundos = fim - comeco, minutos = 0, horas = 0; segundos >= 60; segundos = segundos - 60)
    	{
        	minutos++;
	
        	if (minutos >= 60) 
        	{
            	horas++;
            	minutos = minutos - 60;
        	}
    	}

		// EXIBIR TIMER
		vermelho;
		__fpurge(stdin);
		if (final == 0) { printf ("\t\t\t\t     Timer: "); }
		else { printf ("\t     Timer: "); }

   		if (horas < 10) { printf ("[0%i:", horas); }
    	else { printf ("[%i:", horas); }

    	if (minutos < 10) { printf ("0%i:", minutos); }
    	else { printf ("%i:", minutos); }

    	if (segundos < 10) { printf ("0%i]\n", segundos); }
    	else { printf ("%i]\n", segundos); }

		for (lin=0; lin<ALT; lin++) 
		{
			// INICIA VITORIA
			if (final == 1)
			{
				system ("clear");
				lin = 0;
				col = 0;
				cont = 1;
				final++;
				verde;
				printf ("Parabénsa a Epona Foi Encontrada");

				// EXIBIR TIMER
				vermelho;
				__fpurge(stdin);
				if (final == 0) { printf ("\t\t\t\t     Timer: "); }
				else { printf ("\t     Timer: "); }

   				if (horas < 10) { printf ("[0%i:", horas); }
    			else { printf ("[%i:", horas); }

    			if (minutos < 10) { printf ("0%i:", minutos); }
    			else { printf ("%i:", minutos); }

    			if (segundos < 10) { printf ("0%i]\n", segundos); }
    			else { printf ("%i]\n", segundos); }
			}

			// printf("");
			for (col=0; col<LAR; col++) 
			{	
				// IDENTIFICA FINAL
				if (mapa[lin][col] == ANIMAL && px == lin && py == col && final == 0)
				{	
					final = 1;
				}

				// IDENTIFICA INICIO
				if (mapa[lin][col] == INICIO && n == 2) 
				{
					mapa[lin][col] = CAMINHO;
					px = lin;
					py = col;
					n = 1;
				}

				// EXIBE MAPA
				if (final == 11)
				{
					verde;				
					printf("♦️");
				}
				
				else if (lin == px && col == py && n <= 1) 
				{
					if (final == 0 || 0 == (final % 2) && final > 0) 
					{ 
						azulescuro;				
						printf("☻");
						l = px;
						c = py;
					}

					else if (1 == (final % 2) && final > 0)
					{
						verde;
						printf ("♞");
					}
				}
				
				else if (mapa[lin][col] == CAMINHO) 
				{	
					branco;
					printf (" ");
				}
				
				else if (mapa[lin][col] == PAREDE) 
				{
					if (final == 0 || 0 == (final % 2) && final > 0)
					{
						branco;
						printf ("#");
					}
					
					else if (1 == (final % 2) && final > 0)
					{
						preto;
						printf ("#");
					}
				}
				
				else if (mapa[lin][col] == ANIMAL) 
				{	
					if (final == 0)
					{
						verde;
						printf ("♞");
					}
				}
			}
			printf ("\n");
		}

		// EXIBIR FINAL
		if (final > 1)
		{
			sleep(1);
			final++;
			if (final == 12)
			{
				printf ("\n\n");
				return 0;
			}
		}

		// MODO MANUAL
		if (op == 1 && final == 0)
		{
			// PAINEL DE JOGO
			if (final == 0)
			{
				verde;
				printf ("   (^: Cima)(v: Baixo)(<: Esquerda)(>: Direita)(0: Sair)");
			}
		
			// CONTROLES DE EDIÇÃO
			if (cont == 0)
			{	
				// ERROR DE PAREDE
				if (contparede > 0)
				{
					vermelho;
					printf ("\n   [ERROR] Parede");
				}
		
				contparede = 0;

				// CAPTURA TECLA
				jogada = getch();

				// TECLA ESPECIAL
				if (jogada == 27) 
				{
					jogada = getch(); 

					if (jogada == 91) 
					{      
						jogada = getch();
				
						// CIMA COM PAREDES
						if (jogada == 65)
						{
							if (px > 0) 
							{
								px--;
								if (mapa[px][py] == PAREDE) { px++, contparede++; }
						
							}
						}		

	  					// BAIXO COM PAREDES
						else if (jogada == 66) 
						{
		    				if (px < ALT-1) 
							{
								px++;
								if (mapa[px][py] == PAREDE) { px--, contparede++; }
							}
						}

						// DIREITA COM PAREDES
						else if (jogada == 67) 
						{
							if (py < LAR-1) 
							{
								py++;
								if (mapa[px][py] == PAREDE) { py--, contparede++; }
							}
			    		}

						// ESQUERDA COM PAREDES
						else if (jogada == 68) 
						{
							if (py > 0) 
							{
								py--;
								if (mapa[px][py] == PAREDE) { py++, contparede++; }
							}
						}
					}
				}
			}
		}

		// MODO AUTOMATICO
		else if (op == 2 && final == 0)
		{
			sleep(1);
			for (cont1 = 0; cont1 == 0;)
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
						mapa[l][c] = CAMINHO;
						cont1 = 1;
						cont2 = 1;
						final = 1;
					}

					else if (mapa[px][py] == CAMINHO && px >= 0 && py >= 0 && px < ALT && py < LAR)
					{
						mapa[l][c] = CAMINHO;
						mapa[px][py] = INICIO;
						cont1 = 1;
						cont2 = 1;
					}
				}
			}
		}

		// FINAL DO TIMER
		if (n == 0 && final == 0)
		{
			fim = time(NULL);
		}

		// INICIO DO TIMER
		if (n == 1)
		{
			comeco = time(NULL);
			fim = time(NULL);
			n = 0;
		}
			
		// SAIR
		if (jogada == '0') 
		{ 
			printf ("\n\n");
			return 0; 
		}
    }

    printf("\n\n");
    return 0;
}