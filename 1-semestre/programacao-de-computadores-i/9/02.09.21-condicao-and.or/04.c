#include <stdio.h>
#include <math.h>

int main(){

    int dia1, dia2;

    printf ("\nDigite os dois dias: ");
    scanf ("%i %i", &dia1, &dia2);

    if (dia1 == 1) { printf ("\n[Domingo, "); }

    else if (dia1 == 2) { printf ("\n[Segunda, "); }

    else if (dia1 == 3) { printf ("\n[Terça, "); }

    else if (dia1 == 4) { printf ("\n[Quarta, "); }

    else if (dia1 == 5) { printf ("\n[Quinta, "); }

    else if (dia1 == 6) { printf ("\n[Sexta, "); }

    else if (dia1 == 7) { printf ("\n[Sábado, "); }

    else { printf ("\n[Inválido, "); }

        if (dia2 == 1) { printf ("Domingo]"); }
     
        else if (dia2 == 2) { printf ("Segunda]"); }
     
        else if (dia2 == 3) { printf ("Terça]"); }

        else if (dia2 == 4) { printf ("Quarta]"); }

        else if (dia2 == 5) { printf ("Quinta]"); }

        else if (dia2 == 6) { printf ("Sexta]"); }

        else if (dia2 == 7) { printf ("Sábado]"); }

        else { printf ("Inválido]"); }


    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm