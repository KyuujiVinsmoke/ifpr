package ifpr.pgua.eic.escola.models.pessoas;

import java.time.LocalDate;

public class Aluno extends Pessoa
{
    private LocalDate dataMatricula = LocalDate.now();

    public Aluno(String cpf, String nome, String email, String telefone, LocalDate dataMatricula) 
    {
        super(cpf, nome, email, telefone);
        this.dataMatricula = dataMatricula;
    }

    public LocalDate getDataMatricula() 
    {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) 
    {
        this.dataMatricula = dataMatricula;
    }

    public String toString ()
    {
        String str = "\n";
        
        str +="--------------------------------------------------\n";
        str += "CPF: " +getCpf()+ "\n";
        str += "Nome: " +getNome()+ "\n";
        str += "Email: " +getNome()+ "\n";
        str += "Telefone: " +getTelefone()+ "\n";
        str += "Data da Matricula: " +dataMatricula+ "\n";
        str +="--------------------------------------------------\n";

        return str;
    }
}