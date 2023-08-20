#include <stdio.h>
#include <stdio_ext.h>
#include <stdlib.h>

#define TAM 50

int opcoes (int *op);
void CadastrarAluno();
void CadastrarDisciplina();
void VisualizarAmbos();
void MatricularAluno();
void VisualizarMatriculas();

int main ()
{
    system ("clear");

    int op;

    for (op = 9; op > 0;)
    {
        opcoes(&op);

        if (op == 1) { CadastrarAluno(); }
        else if (op == 2) { CadastrarDisciplina(); }
        else if (op == 3) { VisualizarAmbos(); }
        else if (op == 4) { MatricularAluno(); }
        else if (op == 5) { VisualizarMatriculas(); }
        else if (op == 0) { break; }
    }

    printf ("\n[TCHAU XD]");

    printf ("\n\n");
    return 0;
}

int opcoes (int *op)
{
    printf ("----------------------------------------------\n");
    printf ("(1) - Cadastrar Aluno\n");
    printf ("(2) - Cadastrar Disciplina\n");
    printf ("(3) - Visualizar Alunos e Disciplinas\n");
    printf ("(4) - Matrícular Aluno\n");
    printf ("(5) - Visualizar Matrículas\n");
    printf ("(0) - Sair\n");
    printf ("----------------------------------------------\n");
    printf ("Opção: ");
    scanf ("%i", op);
    printf ("----------------------------------------------\n");

    return 0;
}

void CadastrarAluno()
{
    char aluno[TAM];
    FILE *fp;

    fp = fopen ("alunos.txt", "a+");

    printf ("\n- Aluno: ");
    __fpurge(stdin);
    gets(aluno);
    printf ("\n");

    fputs (aluno, fp);
    fputc ('\n', fp);

    fclose(fp);
}

void CadastrarDisciplina()
{
    char diciplina[TAM];
    FILE *fp;

    fp = fopen ("disciplinas.txt", "a+");

    printf ("\n- Diciplina: ");
    __fpurge(stdin);
    gets(diciplina);
    printf ("\n");

    fputs (diciplina, fp);
    fputc ('\n', fp);

    fclose(fp);
}

void VisualizarAmbos()
{
    int cont;
    char linha[TAM];
    FILE *fp;

    fp = fopen ("alunos.txt", "a+");

    printf ("\nALUNOS CADASTRADOS\n");
    printf ("----------------------------------------------\n");

    for (cont = 1; fgets (linha, TAM, fp) != NULL; cont++)
    {
        printf ("%i | ", cont);
        printf ("%s", linha);
    }
    fclose(fp);


    printf ("----------------------------------------------\n");


    fp = fopen ("disciplinas.txt", "a+");

    printf ("DICIPLINAS CADASTRADAS\n");
    printf ("----------------------------------------------\n");

    for (cont = 1; fgets (linha, TAM, fp) != NULL; cont++)
    {
        printf ("%i | ", cont);
        printf ("%s", linha);
    }
    fclose(fp);


    printf ("\n");
}

void MatricularAluno()
{
    int alu, disci, cont;
    char aluno[TAM], disciplina[TAM];
    FILE *fp;

    printf ("- linha Aluno: ");
    scanf ("%i", &alu);
    printf ("- Linha Disciplina: ");
    scanf ("%i", &disci);

    fp = fopen ("alunos.txt", "a+");

    for (cont = 0; cont < alu; cont++)
    {
        if (cont <= alu) { fgets (aluno, TAM, fp); }
    }


    fp = fopen ("matriculas.txt", "a+");
    
    for (cont = 0; aluno[cont] != '\n'; cont++)
    {
        fputc (aluno[cont], fp);
    }
    fputs ("<=>", fp);
    fclose(fp);


    fp = fopen ("disciplinas.txt", "a+");

    for (cont = 0; cont < disci; cont++)
    {
       if (cont <= disci) { fgets (disciplina, TAM, fp); }
    }
    fclose(fp);


    fp = fopen ("matriculas.txt", "a+");
    fputs (disciplina, fp);
    fclose(fp);
}

void VisualizarMatriculas()
{
    int cont;
    char linha[TAM];
    FILE *fp;

    fp = fopen ("matriculas.txt", "a+");

    printf ("\nMATRÍCULAS EFETUADAS\n");
    printf ("----------------------------------------------\n");

    for (cont = 1; fgets (linha, TAM, fp) != NULL; cont++)
    {
        printf ("%i | ", cont);
        printf ("%s", linha);
    }

    fclose(fp);
}