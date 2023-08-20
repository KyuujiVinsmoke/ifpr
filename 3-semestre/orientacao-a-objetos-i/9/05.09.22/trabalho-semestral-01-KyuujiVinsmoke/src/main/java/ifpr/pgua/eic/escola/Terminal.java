// package ifpr.pgua.eic.escola;

// import java.time.LocalDate;
// import java.util.ArrayList;
// import java.util.Scanner;

// import ifpr.pgua.eic.escola.models.Curso;
// import ifpr.pgua.eic.escola.models.Escola;
// import ifpr.pgua.eic.escola.models.pessoas.Aluno;
// import ifpr.pgua.eic.escola.models.pessoas.Professor;

// public class Terminal 
// {
//     private static Escola escola = new Escola("nome", "telefone");
//     private static Scanner scan = new Scanner(System.in);
    
//     public static String menuGeral()
//     {
//         String str = "";

//         str += "\n1) Opcoes de Cadastros\n";
//         str += "2) Opcoes de Listas\n";
//         str += "3) Opçoes de Matriculas\n";
//         str += "0) Sair\n> ";
        
//         return str;
//     }

//     public static String menuCadastros()
//     {   
//         String str = "";

//         str += "\n1) Cadastrar Aluno\n";
//         str += "2) Cadastrar Professor\n";
//         str += "3) Cadastrar Curso\n";
//         str += "0) Sair\n> ";

//         return str;
//     }

//     public static String menuListas()
//     {
//         String str = "";

//         str += "\n1) Listar Alunos Cadastrados\n";
//         str += "2) Listar Professores Cadastrados\n";
//         str += "3) Listar Cursos Cadastrados\n";
//         str += "4) Listar Alunos Matriculados\n";
//         str += "0) Sair\n> ";

//         return str;
//     }

//     public static String menuMatriculas()
//     {
//         String str = "";

//         str += "\n1) Matricular Aluno\n";
//         str += "2) Desmatricular Aluno\n";
//         str += "0) Voltar\n> ";

//         return str;
//     }

//     public static String menuMatricularAluno() 
//     {
//         String str = "";

//         return str;
//     }

//     public static String menuDesmatricularAluno() 
//     {
//         String str = "";

//         return str;
//     }

//     public static void main(String[] args) 
//     {   
//         String cpf;
//         String nome;
//         String email;
//         String telefone;
//         LocalDate dataMatricula;
//         double salario;
//         int codigo;
//         String descricao;
//         int cargaHoraria;

//         for (int op = 9; op != 0;)
//         {
//             System.out.print(menuGeral());
//             op = scan.nextInt();

//             if (op == 1)
//             {
//                 System.out.print(menuCadastros());
//                 op = scan.nextInt();
                
//                 if (op == 1)
//                 {
//                     System.out.print("\nCPF:\n> ");
//                     cpf = scan.nextLine();
//                     scan.nextLine();

//                     System.out.print("\nNome:\n> ");
//                     nome = scan.nextLine();

//                     System.out.print("\nEmail:\n> ");
//                     email = scan.nextLine();

//                     System.out.print("\nTelefone:\n> ");
//                     telefone = scan.nextLine();

//                     dataMatricula = LocalDate.now();

//                     escola.cadastrarAluno(cpf, nome, email, telefone, dataMatricula);
//                 }

//                 else if (op == 2)
//                 {
//                     System.out.print("\nCPF:\n> ");
//                     cpf = scan.nextLine();
//                     scan.nextLine();

//                     System.out.print("\nNome:\n> ");
//                     nome = scan.nextLine();

//                     System.out.print("\nEmail:\n> ");
//                     email = scan.nextLine();

//                     System.out.print("\nTelefone:\n> ");
//                     telefone = scan.nextLine();

//                     System.out.print("\nSalario:\n> ");
//                     salario = scan.nextDouble();

//                     escola.cadastrarProfessor(cpf, nome, email, telefone, salario);
//                 }

//                 else if (op == 3)
//                 {
//                     System.out.print("\nCodigo:\n> ");
//                     codigo = scan.nextInt();
//                     scan.nextLine();

//                     System.out.print("\nNome:\n> ");
//                     nome = scan.nextLine();

//                     System.out.print("\nDescricao:\n> ");
//                     descricao = scan.nextLine();

//                     System.out.print("\nCarga Horaria:\n> ");
//                     cargaHoraria = scan.nextInt();

//                     //System.out.print("\nProfessor:\n> ");
//                 }
//             }

//             else if (op == 2)
//             {
//                 System.out.print(menuListas());
//                 op = scan.nextInt();

//                 if (op == 1)
//                 {
//                     ArrayList<Aluno> lista = escola.listarAlunos();
//                     for (int i = 0; i < lista.size(); i++)
//                     {
//                         System.out.print(lista.get(i));
//                     }
//                 }

//                 else if (op == 2)
//                 {
//                     escola.listarProfessores();
//                 }

//                 else if (op == 3)
//                 {
//                     escola.listarCursos();
//                 }

//                 else if (op == 4)
//                 {
//                     //escola.listarAlunosMatriculados(curso);
//                 }
//             }

//             else if (op == 3)
//             {
//                 System.out.print(menuMatriculas());
//                 op = scan.nextInt();

//                 if (op == 1)
//                 {
                    
//                 }

//                 else if (op == 2)
//                 {

//                 }
//             }
//         }
//     }
// }