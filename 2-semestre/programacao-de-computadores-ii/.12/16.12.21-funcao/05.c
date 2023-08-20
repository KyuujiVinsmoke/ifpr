#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define preto		"\33[30m"
#define vermelho    "\33[31m"
#define verde		"\33[32m"
#define amarelo	   	"\33[33m"
#define azulescuro	"\33[34m"
#define roxo		"\33[35m"
#define azulclaro	"\33[36m"
#define branco      "\33[37m"

#define TAM 5

agregar();

int main(){
    system ("clear");
    srand(time(NULL));

    agregar();
    
    printf ("\n\n");
    return 0;            
}  
    

int agregar(int a, int aresul1, int aresul2, int aresul3, int ares1, int b, int bresul1, int bresul2, int bresul3, int bres1, int resul1, int resul2, int resul3){

    printf ("Digite dois números com 3 dígitos: ");
    scanf ("%i %i", &a, &b);

    aresul1 = a / 100;
	ares1 = a % 100;
	aresul2 = ares1 / 10;
	aresul3 = ares1 % 10;

    bresul1 = b / 100;
	bres1 = b % 100;
	bresul2 = bres1 / 10;
	bresul3 = bres1 % 10;

    resul1 = aresul1 + bresul1;
    resul2 = aresul2 + bresul2;
    resul3 = aresul3 + bresul3;

    if (resul1 > 9) { resul1 = 0; }
    if (resul2 > 9) { resul2 = 0; }
    if (resul3 > 9) { resul3 = 0; }

    printf ("%i%i%i", resul1, resul2, resul3);

    return 0;            
}  