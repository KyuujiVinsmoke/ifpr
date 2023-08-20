package ifpr.pgua.eic.atividade06;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class Veiculo
{
    private String placa;
    private String modelo;
    private String fabricante;
    private int anoFabricacao;
    private String cor;
    private LocalDateTime horaEntrada = LocalDateTime.now().minusMinutes(0);
    private boolean estaEstacionado;

    public Veiculo (String placa, String modelo, String fabricante, int anoFabricacao, String cor)
    {
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
    }

    public String getPlaca()
    {
        return placa;
    }

    public void setPlaca (String placa)
    {
        this.placa = placa;
    }

    public String getModelo()
    {
        return modelo;
    }

    public void setModelo (String modelo)
    {
        this.modelo = modelo;
    }

    public String getFabricante()
    {
        return fabricante;
    }

    public void setFabricante (String fabricante)
    {
        this.fabricante = fabricante;
    }

    public int getAnoFabricacao()
    {
        return anoFabricacao;
    }

    public void setAnoFabricacao (int anoFabricacao)
    {
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor()
    {
        return cor;
    }

    public void setCor (String cor)
    {
        this.cor = cor;
    }

    public Boolean isEstaEstacionado()
    {
        return estaEstacionado;
    }

    public LocalDateTime getHoraEntrada ()
    {
        return horaEntrada;
    }

    public boolean registraEntrada (LocalDateTime horaEntrada)
    {
        this.estaEstacionado = true;
        this.horaEntrada = horaEntrada;

        return true;
    }

    public boolean registraSaida()
    {
        this.estaEstacionado = false;
        
        return true;
    }
    
    public String toString()
    {
        String str = "";

        str = str + "[Placa: " +placa;
        str = str + "] [Modelo: " +modelo;
        str = str + "] [Fabricante: " +fabricante;
        str = str + "] [Ano de fabricacao: " +anoFabricacao;
        str = str + "] [Cor: " +cor;
        str = str + "]\n";

        return str;
    }
}