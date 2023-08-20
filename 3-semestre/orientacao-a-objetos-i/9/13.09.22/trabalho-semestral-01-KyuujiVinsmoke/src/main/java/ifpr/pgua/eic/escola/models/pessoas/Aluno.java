package ifpr.pgua.eic.escola.models.pessoas;

import java.time.LocalDate;

public class Aluno extends Pessoa
{
    private LocalDate dataMatricula = LocalDate.now();

    public Aluno(String nome, String cpf, String email, String telefone, LocalDate dataMatricula) 
    {
        super(nome, cpf, email, telefone);
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
        String str = "";
        
        str += "Nome: " +getNome(); 
        str += "\nCPF: " +getCpf();

        return str;
    }
}