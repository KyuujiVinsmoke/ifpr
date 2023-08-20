package ifpr.pgua.eic.tads.modelos;

public class ContaEspecial extends Conta {
    
    private double limite;

    public ContaEspecial(int numeroDaConta, int agencia, 
                      String senha, boolean ativa, double saldo, 
                       PessoaFisica pessoa,double limite) {
        super(numeroDaConta, agencia, senha, ativa, saldo, pessoa);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    @Override
    public boolean sacar(double valor){

        if(valor > 0 && valor <= (getSaldo()+limite)){
            saldo = saldo - valor;
            return true;
        }

        return false;
    }

    



}
