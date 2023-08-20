#include <stdio.h>
#include <math.h>

int main(){

    char l1, l2;

    printf ("Digite dois caracteres: ");
    scanf ("%c %c", &l1, &l2);

    if (l1 <= l2 && l1 >= 97 && l1 <= 122) { 
        l1 = l1 - 32, l2 = l2 - 32;
        printf ("- %c ", l1);
        l1++, l2++; }

        else { printf ("- %c ", l1);
        l1++, l2++; }
    
    do { 
        if (l1 <= l2 && l1 >= 65 && l1 <= 90) { printf ("%c ", l1), l1++; }

    }  while (l1 != l2);


    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm