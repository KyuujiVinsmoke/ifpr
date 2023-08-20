package ifpr.pgua.eic.atividade06;

import ifpr.pgua.eic.atividade06.Estacionamento;
import ifpr.pgua.eic.atividade06.Veiculo;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class App 
{
    private static Scanner scan = new Scanner(System.in);
    private static Estacionamento estacionamento = new Estacionamento (null, null);

    private static String menu() 
    {
        String str = "";

        str += "\n[Escolha uma opcao]";
        str += "\n(1) Cadastrar veiculo:";
        str += "\n(2) Buscar veiculo por placa:";
        str += "\n(3) Registrar entrada de veículo:";
        str += "\n(4) Registrar saída de veículo:";
        str += "\n(5) Listar todos os veículos:";
        str += "\n(6) Listar veiculos estacionados:";
        str += "\n(7) Gerar veiculos";
        str += "\n(0) Sair:";
        str += "\n> ";

        return str;
    }

    private static void cadastrarVeiculo()
    {
    
    }

    private static void listaTodosVeiculos()
    {
        
    }

    private static void listaVeiculosEstacionados()
    {
        
    }

    private static void buscarVeiculo()
    {
      
    }

    private static void registrarEntrada()
    {
        
    }

    private static void gerarVeiculos()
    {

    }

    public static void main( String[] args )
    {
        Veiculo veiculos = null;
        
        String placa;
        String modelo;
        String fabricante;
        int anoFabricacao;
        String cor;
        LocalDateTime horaEntrada;
        boolean estaEstacionado;
        LocalDateTime totalMinutos;

        String nome;
        String telefone;
        
        for (int op = 1; op > 0 && op < 8;)
        {
            System.out.print (menu());
            op = scan.nextInt();
            scan.nextLine();
            
            if (op == 1)
            {
                System.out.print ("\nInforme a placa do veiculo:");
                System.out.print ("\n> ");
                placa = scan.nextLine();

                veiculos = estacionamento.buscarVeiculo(placa);
                    
                if (veiculos != null)
                {
                    System.out.print ("[Placa ja cadastrada]\n");
                }
                
                else
                {   
                    System.out.print ("[Placa ainda nao cadastrada, informe os detalhes do veiculo]\n");
                    System.out.print ("\nInforme o modelo do veiculo:");
                    System.out.print ("\n> ");
                    modelo = scan.nextLine();

                    System.out.print ("\nInforme o fabricante do veiculo:");
                    System.out.print ("\n> ");
                    fabricante = scan.nextLine();

                    System.out.print ("\nInforme o ano do veiculo:");
                    System.out.print ("\n> ");
                    anoFabricacao = scan.nextInt();
                    scan.nextLine();

                    System.out.print ("\nInforme a cor do veiculo:");
                    System.out.print ("\n> ");
                    cor = scan.nextLine();

                    veiculos = new Veiculo (placa, modelo, fabricante, anoFabricacao, cor);
                    estacionamento.cadastrarVeiculo(placa, modelo, fabricante, anoFabricacao, cor);
                }
            }

            else if (op == 2)
            {   
                if (veiculos != null)
                {
                    System.out.print ("\nInforme a placa que deseja buscar:");
                    System.out.print ("\n> ");
                    placa = scan.nextLine();
                    
                    veiculos = estacionamento.buscarVeiculo(placa);
                    
                    if (veiculos != null)
                    {
                        System.out.print (veiculos);
                    }
                    
                    else { System.out.print ("[Placa nao encontrada]\n");}
                }

                else 
                {
                    System.out.print ("[Nenhum veiculo cadastrado]\n");
                }
            }

            else if (op == 3)
            {
                System.out.print ("\nInforme a placa do veiculo:");
                System.out.print ("\n> ");
                placa = scan.nextLine();

                veiculos = estacionamento.buscarVeiculo(placa);
                    
                if (veiculos != null)
                {
                    if (estacionamento.registrarEntrada(placa) == true)
                    {   
                        System.out.print ("Informe o nome do motorista:");
                        System.out.print ("\n> ");
                        nome = scan.nextLine();

                        System.out.print ("Informe o telefone do motorista:");
                        System.out.print ("\n> ");
                        telefone = scan.nextLine();

                        System.out.print ("[Entrada do veiculo registrada]\n");
                    }

                    else 
                    {
                        System.out.print ("[Veiculo ja estacionado]\n");
                    }
                }

                else 
                {
                    System.out.print ("[Placa nao cadastrada]\n");
                }
            }

            else if (op == 4)
            {
                System.out.print ("\nInforme a placa do veiculo:");
                System.out.print ("\n> ");
                placa = scan.nextLine();

                veiculos = estacionamento.buscarVeiculo(placa);
                    
                if (veiculos != null)
                {
                    if (estacionamento.registrarSaida(placa) == 1)
                    {
                        System.out.print ("[Saida do veiculo registrada]\n");
                    }

                    else 
                    {
                        System.out.print ("[Veiculo nao estacionado]\n");
                    }
                }

                else 
                {
                    System.out.print ("[Placa nao cadastrada]\n");
                }
            }

            else if (op == 5)
            {   
                if (veiculos != null)
                {
                    ArrayList<Veiculo> lista = estacionamento.listaTodosVeiculos();
                    for (int i = 0; i < lista.size(); i++)
                    {
                        System.out.print (lista.get(i));
                    }
                }

                else 
                {
                    System.out.print ("[Nenhum veiculo cadastrado]\n");
                }
            }

            else if (op == 6)
            {
                if (veiculos != null)
                {
                    ArrayList<Veiculo> lista = estacionamento.listaVeiculosEstacionados();
                    for (int i = 0; i < lista.size(); i++)
                    {
                        if (lista.get(i).isEstaEstacionado() == true)
                        {
                            veiculos = lista.get(i);
                            System.out.print (lista.get(i));
                        }
                    }

                    if (veiculos == null)
                    {
                        System.out.print ("[nenhum veiculo estacionado]\n");
                    }
                }

                else 
                {
                    System.out.print ("[Nenhum veiculo cadastrado]\n");
                }
            }

            else if (op == 7)
            {
                for (int i = 0; i < 5; i++)
                {
                    placa = "" +i;
                    veiculos = estacionamento.buscarVeiculo(placa);
                    
                    if (veiculos == null)
                    {
                        veiculos = new Veiculo (""+i,"" +i, ""+i , i, "" +i);
                        estacionamento.cadastrarVeiculo(""+i,"" +i, ""+i , i, "" +i);
                    }
                }

                System.out.print ("[Veiculos gerados]\n");
            }

            else if (op == 0) { return; }
        }
    }
}