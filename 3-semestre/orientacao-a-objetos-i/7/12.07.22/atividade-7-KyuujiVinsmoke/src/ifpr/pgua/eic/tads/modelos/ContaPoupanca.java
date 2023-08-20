package ifpr.pgua.eic.tads.modelos;

public class ContaPoupanca extends ContaCorrente 
{
    private double taxaRendimento;

    public ContaPoupanca (int numeroDaConta, int agencia, Pessoa pessoa, String senha, boolean ativa, double taxaRendimento) 
    {
        super(numeroDaConta, agencia, pessoa, senha, ativa);
        this.taxaRendimento = taxaRendimento;
    }

    public ContaPoupanca (int numeroDaConta, int agencia, Pessoa pessoa, String senha, boolean ativa, double saldo, double taxaRendimento) 
    {
        super(numeroDaConta, agencia, pessoa, senha, ativa, saldo);
        this.taxaRendimento = taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
}
