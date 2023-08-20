#include <stdio.h>
#include <stdlib.h>
#include <stdio_ext.h>

#define TAM 30

void desembaralhar (char *p, char *emba);

int main ()
{
    system ("clear");

    char *p = malloc (TAM * sizeof(char));
    char *emba = malloc (TAM * sizeof(char));

    printf ("Digite uma palavra: ");
    __fpurge(stdin);
    gets (p);

    printf ("Difite a mesma palavra embaralhada: ");
    __fpurge(stdin);
    gets (emba);

    desembaralhar (p, emba);

    printf ("\n - Desembaralhada: %s", emba);

    printf ("\n\n");
    return 0;
}

void desembaralhar (char *p, char *emba)
{
    int a, b;
    char resul[TAM];
    
    for (a = 0; p[a] != '\0'; a++)
    {
        for (b = 0; emba[b] != '\0'; b++)
        {
            if (p[a] == emba[b]) { resul[a] = emba[b]; }
        }
    }

    for (a = 0; p[a] != '\0'; a++)
    {
        emba[a] = resul[a];
    }
}