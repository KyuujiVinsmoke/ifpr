#include <stdio.h>

int main(){

char l1, l2, l3;

printf ("\nDigite três letras: ");
scanf ("%c %c %c", &l1, &l2, &l3);


    printf ("\n Combinação 1 = %c %c %c", l1, l2, l3);
    printf ("\n Combinação 2 = %c %c %c", l1, l3, l2);
    printf ("\n Combinação 3 = %c %c %c", l2, l1, l3);
    printf ("\n Combinação 4 = %c %c %c", l2, l3, l1);
    printf ("\n Combinação 5 = %c %c %c", l3, l1, l2);
    printf ("\n Combinação 6 = %c %c %c", l3, l2, l1);

    
    printf ("\n\n");
    return 0;

}