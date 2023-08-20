#include <stdio.h>
#include <math.h>

int main(){

    int n, saq, dep, tra, ext, sair;
    
    saq = 1;
    dep = 2;
    tra = 3;
    ext = 4;
    sair = 5;

    do {
    printf ("\n1 - Saque");
    printf ("\n2 - Depósito");
    printf ("\n3 - Transferência");
    printf ("\n4 - Extrato");
    printf ("\n5 - Sair");
    printf ("\n> ");
    scanf ("%i", &n);

    if (n == 1) { printf ("[SAQUE]\n"); }

    else if (n == 2) { printf ("[DEPÓSITO]\n"); }

    else if (n == 3) { printf ("[TRANSFERÊNCIA]\n"); }

    else if (n == 4) { printf ("[EXTRATO]\n"); }

    else if (n == 5) { printf ("[SAIR]\n"); }

    else { printf("Tente Novamente\n"); }

    } while (n != 5);
        
    
    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm