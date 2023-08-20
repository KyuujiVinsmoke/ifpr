package ifpr.pgua.eic.escola.models.pessoas;

public class Professor extends Pessoa
{
    private double salario;

    public Professor(String cpf, String nome, String email, String telefone, double salario) 
    {
        super(cpf, nome, email, telefone);
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
        String str = "\n";
        
        str +="--------------------------------------------------\n";
        str += "CPF: " +getCpf()+ "\n";
        str += "Nome: " +getNome()+ "\n";
        str += "Email: " +getNome()+ "\n";
        str += "Telefone: " +getTelefone()+ "\n";
        str += "Salario: " +salario+ "\n";
        str +="--------------------------------------------------\n";

        return str;
    }
}