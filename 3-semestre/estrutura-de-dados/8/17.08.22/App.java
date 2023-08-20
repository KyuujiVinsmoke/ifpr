import java.util.Scanner;

public class App 
{
    public static void main(String[] args) 
    {
        for (int i = 0; i < 10; i++)
        {
            System.out.println ("\n\n\n");
        }

        Scanner scan = new Scanner(System.in);
        Lista lista = new Lista();

        String nome;
        int dia;
        int mes;
        int ano;

        String pais;
        String estado;
        String cidade;
        String bairro;
        String rua;
        int numero;
        String complemento;

        for (int op = 9; op != 0;)
        {
            System.out.println ("\n\t\t[Lista]\n");
            System.out.println ("1) Criar lista automatica");
            System.out.println ("2) Adicionar pessoa");
            System.out.println ("3) Editar pessoa");
            System.out.println ("4) Apagar pessoa");
            System.out.println ("5) Apagar lista completa");
            System.out.println ("6) Exibir lista");
            System.out.println ("0) Sair");
            System.out.print ("> ");
            op = scan.nextInt();

            if (op == 1)
            {
                Endereco endereco1 = new Endereco("Brasil", "Parana", "Paranagua", "Parque Agari", "Delhi", 16, "B");
                Pessoa pessoa1 = new Pessoa("Andre", 18, 6, 1999, endereco1);
                lista.inserirPessoa(pessoa1);

                Endereco endereco2 = new Endereco("Brasil", "Parana", "Paranagua", "São Vicente", "Sei lá", 12, "Nada a informar");
                Pessoa pessoa2 = new Pessoa("Gustavo", 12, 9, 2001, endereco2);
                lista.inserirPessoa(pessoa2);

                Endereco endereco3 = new Endereco("Brasil", "Parana", "Paranagua", "Divineia", "Sei lá", 22, "Nada a informar");
                Pessoa pessoa3 = new Pessoa("Leonardo", 22, 2, 2003, endereco3);
                lista.inserirPessoa(pessoa3);

                Endereco endereco4 = new Endereco("Brasil", "Parana", "Paranagua", "Divineia", "Sei lá", 26, "Nada a informar");
                Pessoa pessoa4 = new Pessoa("Pedro", 26, 12, 2003, endereco3);
                lista.inserirPessoa(pessoa4);

                System.out.print("\n--------------------------------------------------\n");
                System.out.print ("\n\t\tLista Criada\n\n");
            }

            else if (op == 2)
            {
                System.out.print ("\nNome da pessoa: \n> ");
                nome = scan.next();

                System.out.print ("\nDia de nascimento: \n> ");
                dia = scan.nextInt();
                scan.nextLine();

                System.out.print ("\nMes de nascimento: \n> ");
                mes = scan.nextInt();

                System.out.print ("\nAno de nascimento: \n> ");
                ano = scan.nextInt();

                System.out.print ("\nPais: \n> ");
                pais = scan.next();

                System.out.print ("\nEstado: \n> ");
                estado = scan.next();
                scan.nextLine();

                System.out.print ("\nCidade: \n> ");
                cidade = scan.next();

                System.out.print ("\nBairro: \n> ");
                bairro = scan.next();

                System.out.print ("\nRua: \n> ");
                rua = scan.next();

                System.out.print ("\nNumero: \n> ");
                numero = scan.nextInt();
                scan.nextLine();

                System.out.print ("\nComplemento: \n> ");
                complemento = scan.next();

                Endereco endereco = new Endereco(pais, estado, cidade, bairro, rua, numero, complemento);
                Pessoa pessoa = new Pessoa(nome, dia, mes, ano, endereco);
                lista.inserirPessoa(pessoa);

                System.out.print("\n--------------------------------------------------\n");
                System.out.print ("\n\tPessoa adicionada a lista\n\n");
            }

            else if  (op == 3)
            {
                System.out.print ("\nEscolha a pessoa que deseja editar: \n> ");
                nome = scan.next();

                No posicao = lista.pessoaCadastrada(nome);

                if (posicao != null)
                {
                    System.out.print("\n--------------------------------------------------\n");
                    System.out.print ("\n\t\tPessoa encontrada\n");
                    System.out.print("\n--------------------------------------------------\n");
                    
                    System.out.print ("\nNome da pessoa: \n> ");
                    nome = scan.next();
    
                    System.out.print ("\nDia de nascimento: \n> ");
                    dia = scan.nextInt();
                    scan.nextLine();
    
                    System.out.print ("\nMes de nascimento: \n> ");
                    mes = scan.nextInt();
    
                    System.out.print ("\nAno de nascimento: \n> ");
                    ano = scan.nextInt();
    
                    System.out.print ("\nPais: \n> ");
                    pais = scan.next();
    
                    System.out.print ("\nEstado: \n> ");
                    estado = scan.next();
                    scan.nextLine();
    
                    System.out.print ("\nCidade: \n> ");
                    cidade = scan.next();
    
                    System.out.print ("\nBairro: \n> ");
                    bairro = scan.next();
    
                    System.out.print ("\nRua: \n> ");
                    rua = scan.next();
    
                    System.out.print ("\nNumero: \n> ");
                    numero = scan.nextInt();
                    scan.nextLine();
    
                    System.out.print ("\nComplemento: \n> ");
                    complemento = scan.next();

                    Endereco endereco = new Endereco(pais, estado, cidade, bairro, rua, numero, complemento);
                    Pessoa pessoa = new Pessoa(nome, dia, mes, ano, endereco);
                    lista.editarPessoa(pessoa, posicao);

                    System.out.print("\n--------------------------------------------------\n");
                    System.out.print ("\n\t\tPessoa editada\n\n");
                }

                else
                {
                    System.out.print("\n--------------------------------------------------\n");
                    System.out.print ("\n\t\tPessoa nao encontrada\n\n");
                }
            }

            else if (op == 4)
            {
                System.out.print ("\nEscolha a pessoa que deseja apagar: \n> ");
                nome = scan.next();

                No posicao = lista.pessoaCadastrada(nome);

                if (posicao != null)
                {
                    lista.apagarPessoa(nome, posicao);
                    System.out.print("\n--------------------------------------------------\n");
                    System.out.print ("\n\tPessoa apagada da lista\n\n");
                }

                else
                {
                    System.out.print("\n--------------------------------------------------\n");
                    System.out.print ("\n\t\tPessoa nao encontrada\n\n");
                }
            }
            
            else if (op == 5)
            {
                lista.apagarTodasPessoas();
                System.out.print("\n--------------------------------------------------\n");
                System.out.print ("\n\t\tLista apagada\n\n");
            }

            else if (op == 6)
            {
                System.out.println (lista.toString());
            }

            System.out.print ("--------------------------------------------------\n");
            scan.nextLine();
        }

        System.out.println ("\n\tIsso é tudo, pe-pe-pessoal\n");
    }
}