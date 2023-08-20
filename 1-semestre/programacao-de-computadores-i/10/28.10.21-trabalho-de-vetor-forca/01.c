#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <stdio_ext.h>

#define TAM 30

int main(){
    system ("clear");

    int erros = 0, v = 0, dicas = 2, n, p, l = 0, contn, contletra;
    char barra = 95, dica1[TAM], dica2[TAM], palavra[TAM], pala[TAM], letra[TAM];

    printf ("Palavra: ");
    __fpurge(stdin);
    gets (palavra);

    printf ("1ª Dica: ");
    __fpurge(stdin);
    gets (dica1);

    printf ("2ª Dica: ");
    __fpurge(stdin);
    gets (dica2);

    system ("clear");

    for (contn = 0, p = 0; palavra[p] != '\0'; p++)
    {
      contn++;
    }
    
    for (; erros < 5;) {

        printf ("\n-------------------------------------------------------------");
        printf ("\n------------------------- FORCA -----------------------------");
        printf ("\n-------------------------------------------------------------");
        printf ("\n--------- Total de Erros: %i | Dicas Disponíveis: %i ----------", erros, dicas);
        printf ("\n-------------------------------------------------------------");

        if (dicas < 2 || erros >= 4 || v >= contn) {
        printf ("\n-------- 1ª Dica: [%s]", dica1); }
        if (dicas < 1 || erros >= 4 || v >= contn) {
        printf ("\n-------- 2ª Dica: [%s]", dica2); }
        printf ("\n-------- Palavra:");

        if (v == contn || erros == 4 || v >= 999) 
        { 
            for (p = 0; palavra[p] != '\0'; p++)
            {
                printf (" %c", palavra[p]); 
            }
        }

        else 
        {
            for (p = 0; palavra[p] != '\0'; p++) {
   
                for (l = 0, contletra = 0; letra[l] != '\0'; l++)
                {
                    if (letra[l] == palavra[p]) { printf (" %c", letra[l]), contletra++; }
                }
                if (contletra == 0) { printf (" %c", barra); }
            }
        }
    
        printf ("\n-------------------------------------------------------------");

        if (v == contn) {
        printf ("\n---------------------- Você Venceu --------------------------");
        printf ("\n-------------------------------------------------------------");
        break; }
    
        if (erros == 4 || v >= 999) {
        printf ("\n---------------------- Você Perdeu --------------------------");
        printf ("\n-------------------------------------------------------------");
        erros++; 
        break; }

        printf ("\n-------- 1) Efetuar jogada ----------------------------------");
        printf ("\n-------- 2) Solicitar dica ----------------------------------");
        printf ("\n-------- 3) Advinhar palavra --------------------------------");
        printf ("\n-------- 4) Visualizar Forca --------------------------------");
        printf ("\n-------------------------------------------------------------");
        printf ("\n> ");
        __fpurge(stdin);
        scanf ("%i", &n);

        if (n == 1) { 
            
            printf ("> Digite uma letra (a-z): ");
            __fpurge(stdin);
            scanf ("%c", &letra[l]);

            for (contletra = 0, p = 0; palavra[p] != '\0'; p++)
            {
                if (letra[l] != palavra[p]) { contletra++; }
                else if (letra[l] == palavra[p]) { v++; }
            }
            if (contletra == contn) { erros++; }
            l++;
        }

        else if (n == 2) { dicas--; }

        else if (n == 3) {
            printf ("> Digite a palavra: ");
            __fpurge(stdin);
            gets(letra);
            v = 0;

            for (p = 0, l = 0; letra[l] != '\0'; p++, l++)
            {
                if (palavra[p] == letra[l]) { v++; }
                else { v = 999; }
            }
        }
        
        else if (n == 4) { 
        
            if (erros > 0) {
            printf ("\n                           ___\n                            O"); }

            if (erros == 2) {
            printf ("\n                            | \n                            |"); }

            if (erros > 2) {
            printf ("\n                           <|>\n                            |"); }
        } 
    }       

    printf ("\n\n");
    return 0;            

}   //gcc 01.c -o 01 -lm