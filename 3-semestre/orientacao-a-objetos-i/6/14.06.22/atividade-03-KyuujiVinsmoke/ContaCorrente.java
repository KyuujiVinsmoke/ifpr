import java.util.Random;

public class ContaCorrente
{
    private int numeroDaConta;
    private int agencia;
    private String documento;
    private String senha;
    private boolean ativa;
    public double saldo;

    Random numeros = new Random();

    public ContaCorrente ()
    {
        this.numeroDaConta = numeros.nextInt (9999999) +1000000;
        this.agencia = numeros.nextInt (9) +1;
        this.ativa = true;
    }

    public int getNumeroDaConta (int numeroDaConta)
    {
        return this.numeroDaConta;
    }

    public void setNumeroDaConta (int numeroDaConta)
    {
        this.numeroDaConta = numeroDaConta;
    }

    public int getAgencia (int agencia)
    {
        return this.agencia;
    }

    public void setAgencia (int agencia)
    {
        this.agencia = agencia;
    }

    public String getDocumento (String documento)
    {
        return this.documento;
    }
    
    public void setDocumento (String documento)
    {
        this.documento = documento;
    }

    public String getSenha (String senha)
    {
        return this.senha;
    }
    
    public void setSenha (String senha )
    {
        this.senha = senha;
    }

    public boolean getAtiva (boolean ativa)
    {
        return this.ativa;
    }

    public void setAtiva (boolean ativa)
    {
        this.ativa = ativa;
    }

    public String toString ()
    {
        return "\nEste E O Seu Numero De Conta: " + numeroDaConta + "\nEsta E A Sua Agencia: " + agencia +
        "\nEste E O Seu Documento: " + documento + "\nEste E O Seu Saldo: R$" + saldo;
    }
    
    void Sacar (double valor)
    {   
        saldo = saldo - valor;
    }

    void Depositar (double valor)
    {   
        saldo = saldo + valor;
    }
}