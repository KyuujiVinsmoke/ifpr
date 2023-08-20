package ifpr.pgua.eic.escola.models.pessoas;

public class Professor extends Pessoa
{
    private double salario;

    public Professor(String nome, String cpf, String email, String telefone, double salario) 
    {
        super(nome, cpf, email, telefone);
        this.salario = salario;
    }

    public double getSalario() 
    {
        return salario;
    }

    public void setSalario(double salario) 
    {
        this.salario = salario;
    }

    public String toString ()
    {
        String str = "";
        
        str += "Nome: " +getNome(); 
        str += "\nCPF: " +getCpf();

        return str;
    }
}