#include <stdio.h>
#include <math.h>
#include <time.h>
#include <stdlib.h>
#define TAM 5

int main () {
	
	int lin, col, cont, pontospl, pontosmaq, jogadaspl, jogadasmaq;
	char bat[TAM][TAM];
	int esp[TAM][TAM];
	int jogador = 1, jogadas;
	
	srand(time(NULL));
	
	 for(lin=0; lin<5; lin++) {
		for(col=0; col<5; col++) {
			bat[lin][col] = 35;
		}
	}
	
	printf("\n---------------------------------------------");
	printf("\n-------------Batalha Naval-------------------");
	printf("\n---------------------------------------------");
     	printf("\n\t| 0 | 1 | 2 | 3 | 4 |  ");
		printf(" %c ", bat[lin][col]);
	printf("\n\t| 0 |"); 
	printf("\n\t| 1 |");
	printf("\n\t| 2 |");			
	printf("\n\t| 3 |");
	printf("\n\t| 4 |");
	printf("\n---------------------------------------------");
	printf("\n----- Player: 0 | Computador: 0-------");
	printf("\n------------Jogadas: 5 -------------");
	printf("\n---------------------------------------------");
	
		for ( lin = 0; lin<TAM; lin++) {
			for (col = 0; col<TAM; col++) { 
            
            bat[lin][col] = 35;
            esp[lin][col] = 35;
            

           	 }       
       }

	//numero 1
	for(cont=0; cont<7; cont++) {
		lin = rand()%5;
		col = rand()%5;
			if(esp[lin][col] == 35) {
				esp[lin][col] = 49;
			}
				else {	
				  cont--;
			}
	}
	
	// numero 3
		for(cont=0; cont<5; cont++) {
			lin = rand()%5;
			col = rand()%5;
			   if(esp[lin][col] == 35) {
				 esp[lin][col] = 51;
			}
			    else {	
				 cont--;
			}
	}
	
	 // numero 5
	for(cont=0; cont<2; cont++) {
		lin = rand()%5;
		col = rand()%5;
			if(esp[lin][col] == 35) {
			esp[lin][col] = 53;
		}
				else {	
				cont--;
			}
	}
	
    
	do{
		
		if(jogador == 1) {
			printf("Player: ");
			scanf("%i %i", &lin, &col);
		
			esp[lin][col] = 1;
		
			jogador = 2;
		
			
		}
		
		else{
			
			esp[lin][col] = 2;
			printf("Computador: ");
			printf("%i %i", lin, col);
			sleep(1);
			
			jogador = 1;
		}
		
		
	printf("\n---------------------------------------------");
	printf("\n-------------Batalha Naval-------------------");
	printf("\n---------------------------------------------");
     	printf("\n\t| 0 | 1 | 2 | 3 | 4 |  ");
	printf("\n\t| 0 |"); printf("|%c |", bat[lin][col]);
	printf("\n\t| 1 |");
	printf("\n\t| 2 |");			
	printf("\n\t| 3 |");
	printf("\n\t| 4 |");
	printf("\n---------------------------------------------");
	printf("\n----- Jogador:%i | Computador:%i-------", pontospl, pontosmaq);
	printf("\n------Jogadas Jogador: %i -------------", jogadaspl);
	printf("\n------Jogadas Computador: %i -------------", jogadasmaq);
	printf("\n---------------------------------------------");
	pontospl++;
	pontosmaq++;
	jogadaspl--;
 	jogadasmaq--;
 		
 		
 			//jogadasiguais
 		if( jogadaspl == jogadasmaq ) {
 			
 			printf("Jogada invalida!!");
 			sleep(1);
 			jogadaspl--;
 			jogadasmaq--;
		 }
		 //pontos iguais
		 	if(pontospl == pontosmaq) {
		 		printf("\n---------------------------------------------");
				printf("\n-------------Batalha Naval-------------------");
				printf("\n---------------------------------------------");
     				printf("\n\t| 0 | 1 | 2 | 3 | 4 |  ");
				printf("\n\t| 0 |"); printf("|%c |", bat[lin][col]);
				printf("\n\t| 1 |");
				printf("\n\t| 2 |");			
				printf("\n\t| 3 |");
				printf("\n\t| 4 |");
				printf("\n---------------------------------------------");
				printf("\n----- Jogador:%i | Computador:%i-------", pontospl, pontosmaq);
				printf("\n------------Jogadas Jogador: %i -------------", jogadaspl);
				printf("\n------------Jogadas Maquina: %i -------------", jogadasmaq);
				printf("\n---------------------------------------------");
				printf("\n-------------Empate----------------");
				break;
		 		
			 }
 				if( pontospl > pontosmaq) {
 				
 				printf("\n---------------------------------------------");
				printf("\n-------------Batalha Naval-------------------");
				printf("\n---------------------------------------------");
     				printf("\n\t| 0 | 1 | 2 | 3 | 4 |  ");
				printf("\n\t| 0 |"); printf("|%c |", bat[lin][col]);
				printf("\n\t| 1 |");
				printf("\n\t| 2 |");			
				printf("\n\t| 3 |");
				printf("\n\t| 4 |");
				printf("\n---------------------------------------------");
				printf("\n----- Jogador:%i | Computador:%i-------", pontospl, pontosmaq);
				printf("\n------------Jogadas Jogador: %i -------------", jogadaspl);
				printf("\n------------Jogadas Maquina: %i -------------", jogadasmaq);
				printf("\n---------------------------------------------");
				printf("\n-------------Jogador venceu!!!----------------");
 		 		pontospl++;
				pontosmaq++;
			 	jogadaspl--;
 			    jogadasmaq--;
 		
		 	break;
			 }
			 
			 else{
 				
 				printf("\n---------------------------------------------");
	 			printf("\n-------------Batalha Naval-------------------");
				printf("\n---------------------------------------------");
     					printf("\n\t| 0 | 1 | 2 | 3 | 4 |  ");
				printf("\n\t| 0 |"); printf("|%2c |", bat[lin][col]);
				printf("\n\t| 1 |");
				printf("\n\t| 2 |");			
				printf("\n\t| 3 |");
				printf("\n\t| 4 |");
				printf("\n---------------------------------------------");
				printf("\n------- Jogador:%i | Computador:%i ---------", pontospl, pontosmaq);
				printf("\n------------Jogadas Jogador: %i -------------", jogadaspl);
				printf("\n------------Jogadas Computador: %i ----------", jogadasmaq);
				printf("\n---------------------------------------------");
				printf("\n-------------Computador venceu!!-------------");
 
 			break;
			 }
			 
			 
			 
	}while(jogadaspl < 5 && jogadasmaq < 5);
	
	
			if(jogadaspl > 4 || jogadasmaq > 4 ) {
				
				printf("Jogada inválida");
				sleep(1);
			}
		
		
	
	
	
	
	return 0;
}