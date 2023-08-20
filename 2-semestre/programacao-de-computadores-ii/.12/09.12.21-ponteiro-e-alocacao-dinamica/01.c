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

int main(){
    system ("clear");
    srand(time(NULL));

    int n, *pont_n;
    char l, *pont_l;

    printf ("Digite um número inteiro e um caracter: ");
    scanf ("%i %c", &n, &l);

    pont_n = n;
    pont_l = l;
        
    printf (" - [Inteiro]: endereço = %p / conteúdo = %i", &pont_n, pont_n);
    printf ("\n - [Caractere]: endereço = %p / conteúdo = %c", &pont_l, pont_l);
        
    
    printf ("\n\n");
    return 0;            
} 