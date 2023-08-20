#include <stdio.h>
#include <stdio_ext.h>
#include <stdlib.h>
#include <time.h>
#include <unistd.h>

#define TAM 30

int main() {

	int a, op;
	int fim, erros, dicas, flag;
	char palavra[TAM], espelho[TAM], resposta[TAM], dica1[TAM], dica2[TAM], letra;

	// Configuração Inicial
	system("clear");
	printf("Palavra: ");
	__fpurge(stdin);
	gets(palavra);
	printf("1ª Dica: ");
	__fpurge(stdin);
	gets(dica1);
	printf("2ª Dica: ");
	__fpurge(stdin);
	gets(dica2);

	for(a=0; a<TAM; a++) { espelho[a] = '_'; }
	espelho[a] = '\0';
	
	// Inicia o jogo
	fim = 0;
	erros = 0;
	dicas = 0;
	do {
		system("clear");
		printf("-------------------------------------------------------------");
		printf("\n--------------------------- FORCA ---------------------------");
		printf("\n-------------------------------------------------------------");
		printf("\n--------- Total de Erros: %i | Dicas Disponíveis: %i ----------", erros, (2-dicas));
		printf("\n-------------------------------------------------------------");
		if(dicas > 0) { printf("\n--------- 1ª Dica: [%s]", dica1); }
		if(dicas > 1) { printf("\n--------- 2ª Dica: [%s]", dica2); }
		printf("\n--------- Palavra: ");
		for(a=0; palavra[a] != '\0'; a++) {
			if(fim == 0) {
				printf("%c ", espelho[a]);
			}
			else {
				printf("%c ", palavra[a]);
			}
		}
		printf("\n-------------------------------------------------------------");

		if(fim == 0) {
			printf("\n------- 1) Efetuar jogada -----------------------------------");
			printf("\n------- 2) Solicitar dica -----------------------------------");
			printf("\n------- 3) Advinhar palavra ---------------------------------");
			printf("\n------- 4) Visualizar forca ---------------------------------");
			printf("\n-------------------------------------------------------------\n> ");
			__fpurge(stdin);
			scanf("%i", &op);
			
			switch(op) {

				// Efetuar Jogada
				case 1:
					printf("> Digite uma letra (a-z): ");
					__fpurge(stdin);
					scanf("%c", &letra);
					// Converte para minúsculo
					if(letra <= 90) { letra = letra - 32; }
					// Compara as strings
					flag = 0;
					for(a=0; palavra[a] != '\0'; a++) {
						if(palavra[a] == letra) {
							espelho[a] = palavra[a];
							flag = 1;
						}
					}
					if(flag == 0) {
						erros++;
						if(erros == 4) {
							fim = 1; // perdeu
						}
					}
					break;

				// Solicitar Dica
				case 2:
						if(dicas < 2) { dicas++; }
						break;

				// Advinhar palavra
				case 3:
						printf("> Digite a palavra: ");
						__fpurge(stdin);
						gets(resposta);
						// Compara a resposta
						flag = 1;					
						for(a=0; palavra[a] != '\0'; a++) {
							if(palavra[a] != resposta[a]) {
								flag = 0;
							}
						}
						if(flag == 1) { fim = -2; }	
						else { fim = -1; }
						break;

				// Visualizar forca
				case 4:
						if(erros > 0) {
							printf("\t\t\t ___");
 							printf("\n\t\t\t  O "); 
						}
						if(erros == 2) { 
							printf("\n\t\t\t  | "); 
							printf("\n\t\t\t  | "); 
						}
						else if(erros == 3) {
							printf("\n\t\t\t /|%c ", 92);
							printf("\n\t\t\t  | ");
						}
						else if(erros > 4) {
							printf("\n\t\t\t / %c ", 92);
						}
						__fpurge(stdin);
						getchar();
						break;
			}
		}
		else {
			fim = -1 * fim; 
		}

	}while(fim <= 0);	
	
	if(fim == 2) {
		printf("\n------------------------ Você Venceu ------------------------");
	}
	else {
		printf("\n------------------------ Você Perdeu ------------------------");
	}
	printf("\n-------------------------------------------------------------");

	printf("\n\n");
	return 0;
}
