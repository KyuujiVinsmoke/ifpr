package ifpr.pgua.eic.tads.modelos;

public class Conta {
    
    private int numeroDaConta;
    private int agencia;
    private String senha;
    private boolean ativa;
    protected double saldo;
    private PessoaFisica pessoaFisica;
    private PessoaJuridica pessoaJuridica;

    public Conta(int numeroDaConta, int agencia, String senha, boolean ativa, double saldo, PessoaFisica pessoaFisica) {
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.senha = senha;
        this.ativa = ativa;
        this.saldo = saldo;
        this.pessoaFisica = pessoaFisica;
    }

    public Conta(int numeroDaConta, int agencia, String senha, boolean ativa, double saldo, PessoaJuridica pessoaJuridica) {
        this.numeroDaConta = numeroDaConta;
        this.agencia = agencia;
        this.senha = senha;
        this.ativa = ativa;
        this.saldo = saldo;
        this.pessoaJuridica = pessoaJuridica;
    }

    public Conta(int numeroDaConta, int agencia, String senha, boolean ativa, PessoaFisica pessoaFisica){
        this(numeroDaConta, agencia, senha, ativa, 0.0, pessoaFisica);
    }

    public int getNumeroDaConta() {
        return numeroDaConta;
    }

    public void setNumeroDaConta(int numeroDaConta) {
        this.numeroDaConta = numeroDaConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public boolean isAtiva() {
        return ativa;
    }
    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }
    public double getSaldo() {
        return saldo;
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public PessoaJuridica getPessoaJuridica() {
        return pessoaJuridica;
    }

    public void setPessoaJuridica(PessoaJuridica pessoaJuridica) {
        this.pessoaJuridica = pessoaJuridica;
    }


    public boolean depositar(double valor){
        if(valor > 0){
            saldo = saldo + valor;
            return true;
        }else{
            return false;
        }
        
    }

    public boolean sacar(double valor){
        if(valor > 0 && valor <= saldo){
            saldo = saldo - valor;
            return true;
        }else{
            return false;
        }
        
    }

    @Override
    public String toString(){
        String str = "";

        str = "ContaCorrente[";
        str = str + "Numero da Conta:"+numeroDaConta;
        str = str + ",Agencia: "+agencia;
        str = str + ",Ativa: "+ativa;
        str = str + ",Saldo: "+saldo;
        str = str + "]";

        return str;

    }
    

}
