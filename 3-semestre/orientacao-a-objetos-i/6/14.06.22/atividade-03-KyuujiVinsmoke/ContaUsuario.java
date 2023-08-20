public class ContaUsuario 
{
    private String nome;
    private String cpf;
    private int idade;
    private double salario;

    public ContaUsuario ()
    {

    }
    
    public String getNome (String nome)
    {
        return this.nome;
    }
    
    public void setNome (String nome)
    {
        this.nome = nome;
    }

    public String getCpf (String cpf)
    {
        return this.cpf;
    }

    public void setCpf (String cpf)
    {
        this.cpf = cpf;
    }

    public int getIdade (int idade)
    {
        return this.idade;
    }

    public void setIdade (int idade)
    {
        this.idade = idade;
    }

    public double getSalario (double salario)
    {
        return this.salario;
    }

    public void setSalario (double salario)
    {
        this.salario = salario;
    }
}