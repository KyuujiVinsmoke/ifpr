package ifpr.pgua.eic.tads.modelos;

public class ContaCorrenteEspecial extends ContaCorrente 
{
    private double limite;

    public ContaCorrenteEspecial(int numeroDaConta, int agencia, Pessoa pessoa, String senha, boolean ativa, double limite) 
    {
        super(numeroDaConta, agencia, pessoa, senha, ativa);
        this.limite = limite;
    }

    public ContaCorrenteEspecial (int numeroDaConta, int agencia, Pessoa pessoa, String senha, boolean ativa, double saldo, double limite) 
    {
        super(numeroDaConta, agencia, pessoa, senha, ativa, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }
}