#include <stdio.h>
#include <math.h>

int main(){

    int base, topo, esp, ast, cont;

    printf ("\nLargura e Altura: ");
    scanf ("%i %i", &base, &topo);

    cont = topo;

        do {
        
         esp = base - topo;
         ast = cont;
 
            do { if (esp > 0) { printf (" "); }
                esp--;
       
            } while (esp > 0);

            
            do { if (ast > 0) { printf ("* "); }
                ast--;
            
            } while (ast > 0);

         printf ("\n");

         base--;
         cont++;
        
        } while (base >= topo);
        

    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm