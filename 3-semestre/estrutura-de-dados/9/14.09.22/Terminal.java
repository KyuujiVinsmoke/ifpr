import java.util.Scanner;

public class Terminal 
{
    public static void main(String[] args) 
    {
        Scanner scan = new Scanner(System.in);
        ArvoreBinaria arvore = new ArvoreBinaria();
        
        for (int op = 9; op != 0;)
        {
            System.out.print("\n1) Inserir");
            System.out.print("\n2) Remover");
            System.out.print("\n3) Buscar");
            System.out.print("\n4) Exibir");
            System.out.print("\n0) Sair\n> ");

            op = scan.nextInt();
            scan.nextLine();

            if (op == 1)
            {
                System.out.print("\nMatricula:\n> ");
                String matricula = scan.nextLine();

                System.out.print("\nNome:\n> ");
                String nome = scan.nextLine();

                System.out.print("\nDia:\n> ");
                int dia = scan.nextInt();

                System.out.print("\nMes:\n> ");
                int mes = scan.nextInt();
                
                System.out.print("\nAno:\n> ");
                int ano = scan.nextInt();

                DataNascimento dataNascimento = new DataNascimento(dia, mes, ano);
                arvore.inserir(new Aluno(matricula, nome, dataNascimento));

                System.out.print ("\n[Aluno Inserido]\n");
            }

            if (op == 2)
            {
                System.out.print("\nMatricula:\n> ");
                arvore.excluir(scan.nextLine());

                System.out.print("\n[Aluno Removido]\n");
            }

            if (op == 3)
            {
                System.out.print("\nMatricula:\n> ");
                String busca = scan.nextLine();

                if(arvore.buscar(busca) == null) 
                {
                    System.out.print("\n[Aluno Não Encontrado]\n");
                } 

                else 
                {
                    System.out.print(arvore.buscar(busca));
                }
            }

            if (op == 4)
            {
                arvore.listar();
            }
        }

        scan.close();
    }
}