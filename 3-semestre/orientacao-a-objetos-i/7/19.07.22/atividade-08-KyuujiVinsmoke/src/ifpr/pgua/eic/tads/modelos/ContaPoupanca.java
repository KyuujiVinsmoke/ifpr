package ifpr.pgua.eic.tads.modelos;

public class ContaPoupanca extends Conta {
    
    private double txRendimento;

    public ContaPoupanca(int numeroDaConta, int agencia, 
                         String senha, boolean ativa, 
                        double saldo, PessoaFisica pessoa,
                        double txRendimento) {
        super(numeroDaConta, agencia, senha, ativa, saldo, pessoa);
        this.txRendimento = txRendimento;
    }
    
    public void render(){
        double rendimento = saldo*txRendimento;
        saldo += rendimento;
    }

}
