#include <stdio.h>
#include <math.h>

int main(){

    double n, nmenor, nmaior;
    nmenor = -1;
    nmaior = -1;

    do {
    printf ("Número: ");
    scanf ("%lf", &n);

        if (n > nmaior) (nmaior = n);

        if (n < nmenor && n > -1) (nmenor = n);

        else if (nmenor == -1) (nmenor = nmaior);

    } while (n > -1);
    
    if (nmenor == -1 & nmaior == -1) { printf ("\nTente Novamente"); }

    else { printf ("\n- Menor: %.0lf\n- Maior: %.0lf", nmenor, nmaior); }
        
    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm