package ifpr.pgua.eic.tads.modelos;

public class PessoaJuridica extends Pessoa
{
    private String cnpj;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public PessoaJuridica (String nome, int idade, double salario, String cnpj)
    {
        super (nome, idade, salario);
        this.cnpj = cnpj;
    }
}