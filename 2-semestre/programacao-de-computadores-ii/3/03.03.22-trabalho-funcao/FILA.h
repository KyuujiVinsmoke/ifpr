#ifndef _FILA_
#define _FILA_

int *fila, f;

int InicioFila ();
int Enqueue (int *f);
int Dequeue (int *f);
int Fifo (int *f);

int InicioFila ()
{
    fila = malloc (TAM * sizeof (int));
    f = 0;

    return 0;
}

int Enqueue (int *f)
{
    int x = *f;

    printf ("[INSERIR - FILA]\n");
    printf ("Valor: ");
    __fpurge(stdin);
    scanf ("%i", &fila[x]);
    
    x++;
    *f = x;

    return 0;
}

int Dequeue (int *f)
{
    int x1 = 0, x2;

    printf ("[REMOVER - FILA]\n");
    printf ("Dado (%i) Removido\n", fila[x1]);
    
    for (x2 = 1; x2 < *f; x1++, x2++)
    {
        fila[x1] = fila[x2];
    }
   
    *f = x1;

    return 0;
}

int Fifo (int *f)
{
    int x;

    printf ("[VISUALIZAR - FILA]\n");
    printf ("FILA:\n");

    for (x = 0; x < *f; x++)
    {
        printf ("%i ", fila[x]);
    }

    printf ("\n");

    return 0;
}

#endif