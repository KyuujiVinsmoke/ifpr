#include <stdio.h>
#include <math.h>

int main(){

    int n, cont, resto, resul;
    cont = 1;
    resul = 1;

    printf ("\nNúmero inteiro: ");
    scanf ("%i", &n);
    
    printf ("- Divisivel por: 1");

    do {
        cont++;
        resto = n % cont;
    
        if (resto == 0 && cont < n) { printf (" + %i", cont); }

        if (resto == 0 && cont < n) { resul = resul + cont; }

    } while (cont < n);

        if (resul == n) { printf (" = %i", resul); }

        else {printf (" = %i", resul); }
       
        if (resul == n) { printf (" [PERFEITO]"); }

        else { printf (" [IMPERFEITO]"); }


    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm