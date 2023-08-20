package ifpr.pgua.eic.tads.modelos;

public class ContaSimples extends Conta{

    public ContaSimples(int numeroDaConta, int agencia, String senha, boolean ativa, double saldo, PessoaFisica pessoaFisica) {
        super(numeroDaConta, agencia, senha, ativa, saldo, pessoaFisica);
        
    }

    public ContaSimples(int numeroDaConta, int agencia, String senha, boolean ativa, double saldo, PessoaJuridica pessoaJuridica) {
        super(numeroDaConta, agencia, senha, ativa, saldo, pessoaJuridica);
        
    }
    
}
