#ifndef _PARK_
#define _PARK_

#include <stdio.h>
#include <stdio_ext.h>
#include <stdlib.h>
#include <string.h>

#define TAM 99

void Painel ();
void Entrada ();
int Saida (char *p);
void Visualizar ();

typedef struct
{
    char marca[20];
    char modelo[20];
    char cor[20];
    char placa[10];
}                       Veiculo;

Veiculo *db;
int pos = 0;

void Painel ()
{   
    printf ("---------------------------\n");
    printf ("- 1) Entrada de Veículo   -\n");
    printf ("- 2) Saída de Veículo     -\n");
    printf ("- 3) Visualizar Veículo   -\n");
    printf ("- 0) Sair                 -\n");
    printf ("---------------------------\n");
    printf (">> ");
}

void Entrada ()
{
    printf ("\n[ENTRADA DE VEICULOS]\n");

    if (pos < 0) { pos = 0; }
    pos = pos + 1;
    db = realloc (db, pos * sizeof (Veiculo));
}

int Saida (char *p)
{
    int a, b, x, cont = 0;

    for(a = 1, b = 2, x = 0; a <= pos; a++, b++)
    {
        x = strcmp (db[a].placa, p);

        if (x == 0 && a < pos) { db[a] = db[b], cont = cont + 1; }
        else if (cont > 0 && a < pos) { db[a] = db[b]; }
        else if (x == 0 && a == pos) { cont = cont + 1; }
    }

    if (cont > 0 ) { pos = pos - 1; }

    if (cont > 0) { return 1;}
    else { return -1; }
}

void Visualizar ()
{ 
    int cont;
    printf ("\n[VISUALIZAÇAO DE VEICULOS]\n");

    for (cont = 1; cont <= pos; cont++)
    {
        printf ("%i | %s / %s / %s / %s\n", cont, db[cont].marca, db[cont].modelo, db[cont].cor, db[cont].placa);
    }

    printf ("\n");
}

#endif