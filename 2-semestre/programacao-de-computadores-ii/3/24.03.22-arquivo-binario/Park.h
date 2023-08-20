#ifndef _Park_
#define _Park_

#include <stdio.h>
#include <stdio_ext.h>
#include <stdlib.h>
#include <string.h>

#define TAM 99

typedef struct
{
    char marca[20];
    char modelo[20];
    char cor[20];
    char placa[20];
}                       Veiculo;

void Painel ();
void Entrada (Veiculo *db);
int Saida (char *p);
void Visualizar ();

FILE *fp, *back;

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

void Entrada (Veiculo *db)
{
    fp = fopen ("PARK.bin", "a+");

    if (fp != NULL)
    {
        fwrite (db, sizeof (Veiculo), 1, fp);
    }

    fclose(fp);
    printf ("\n[OK]\n\n");
}

int Saida (char *p)
{
    int teste, ret, cont;
    Veiculo db;

    fp = fopen ("PARK.bin", "a+");
    back = fopen ("BACKUP.bin", "a+");
            
    for (teste = 0, ret = 1, cont = 0; ret == 1;)
    {
        ret = fread (&db, sizeof (Veiculo), 1, fp);

        teste = strcmp (db.placa, p);

        if (teste != 0 && ret == 1) 
        {
            fwrite (&db, sizeof (Veiculo), 1, back);
        }
        else if (teste == 0 && ret == 1) 
        { 
            cont = cont + 1; 
        }
    }

    remove ("PARK.bin");
    fclose(fp);
    rename ("BACKUP.bin", "PARK.bin");
    fclose(back);  

    if (cont > 0) { return 1; }
    else if (cont == 0) { return -1; }
}

void Visualizar ()
{ 
    int cont, ret;
    Veiculo db;

    printf ("\n[VISUALIZAÇAO DE VEICULOS]\n");

    fp = fopen ("PARK.bin", "a+");

    for (cont = 1, ret = 1; ret == 1; cont++)
    {
        ret = fread (&db, sizeof (Veiculo), 1, fp);

        if (ret == 1)
        {
            printf ("%i | %s / %s / %s / %s\n", cont, db.marca, db.modelo, db.cor, db.placa);
        }
    }
    fclose(fp);
    printf ("\n");
}

#endif