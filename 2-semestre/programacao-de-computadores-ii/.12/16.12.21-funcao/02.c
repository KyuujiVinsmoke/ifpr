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

int fatorial();

int main(){
    system ("clear");
    srand(time(NULL));

    fatorial();

    printf ("\n\n");
    return 0;
}


int fatorial(double n, double cont, double resul){
    resul = 0;

    printf ("\nDigite um valor: ");
    scanf ("%lf", &n);

    for (cont = n; cont > 2;) {

        cont--;
        resul = n * cont;
        n = resul;

    }
    
    printf (" - Fatorial: %.0lf", n);

    return 0;            
} 
