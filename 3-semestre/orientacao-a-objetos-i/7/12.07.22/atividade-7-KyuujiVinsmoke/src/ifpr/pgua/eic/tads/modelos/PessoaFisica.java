package ifpr.pgua.eic.tads.modelos;

public class PessoaFisica extends Pessoa 
{
    private String cpf;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public PessoaFisica (String nome, int idade, double salario, String cpf)
    {
        super (nome, idade, salario);
        this.cpf = cpf;
    }
}