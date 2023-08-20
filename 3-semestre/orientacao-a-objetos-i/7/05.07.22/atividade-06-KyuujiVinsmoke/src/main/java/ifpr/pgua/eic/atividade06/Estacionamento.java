package ifpr.pgua.eic.atividade06;

import java.util.ArrayList;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

import java.time.LocalDateTime;

public class Estacionamento 
{
    private String nome;
    private String telefone;
    private ArrayList<Veiculo> veiculos;

    public Estacionamento (String nome, String telefone)
    {
        veiculos = new ArrayList<Veiculo>();
        this.nome = nome;
        this.telefone = telefone;
    }

    public boolean cadastrarVeiculo (String placa, String modelo, String fabricante, int anoFabricacao, String cor)
    {   
        this.veiculos.add (new Veiculo(placa, modelo, fabricante, anoFabricacao, cor));
        return true;
    }

    public ArrayList<Veiculo> listaTodosVeiculos()
    {
        return veiculos;
    }

    public ArrayList<Veiculo> listaVeiculosEstacionados()
    {
        return veiculos;
    }

    
    public Veiculo buscarVeiculo (String placa)
    {   
        Veiculo veiculos = null;
        ArrayList<Veiculo> lista = listaTodosVeiculos();
        for (int i = 0; i < lista.size(); i++)
        {
            if (placa.equals(lista.get(i).getPlaca()))
            {
                veiculos = lista.get(i);
            }
        }

        return veiculos;
    }

    public boolean registrarEntrada (String placa)
    {   
        LocalDateTime horaEntrada = LocalDateTime.now().minusMinutes(0);
        Veiculo veiculos = null;
        ArrayList<Veiculo> lista = listaTodosVeiculos();
        for (int i = 0; i < lista.size(); i++)
        {
            if (placa.equals(lista.get(i).getPlaca()))
            {
                veiculos = lista.get(i);
                if (veiculos.isEstaEstacionado() == false)
                {
                    veiculos.registraEntrada(horaEntrada);
                    return true;
                }
            }
        }

        return false;
    }

    public int registrarSaida (String placa)
    {
        Veiculo veiculos = null;
        ArrayList<Veiculo> lista = listaTodosVeiculos();
        for (int i = 0; i < lista.size(); i++)
        {
            if (placa.equals(lista.get(i).getPlaca()))
            {
                veiculos = lista.get(i);
                if (veiculos.isEstaEstacionado() == true)
                {
                    veiculos.registraSaida();
                    return 1;
                }
            }
        }

        return 0;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone (String telefone)
    {
        this.telefone = telefone;
    }

    public String toString ()
    {
        String str = "";

        str = str + "[Motorista: " +nome;
        str = str + "] [Telefone: " +telefone;
        str = str + "]\n";

        return str;
    }
}