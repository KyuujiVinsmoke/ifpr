public class Pessoa
{
    String nome;
    int dia;
    int mes;
    int ano;
    int quantidadePessoas;
    Endereco endereco;

    public Pessoa (String nome, int dia, int mes, int ano, Endereco endereco) 
    {
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.endereco = endereco;
    }

    public Pessoa (String nome, int dia, int mes, int ano) 
    {
        this.nome = nome;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public int getQuantidadePessoas() 
    {
        return quantidadePessoas;
    }

    public void setQuantidadePessoas (int quantidadePessoas) 
    {
        this.quantidadePessoas = quantidadePessoas;
    }

    public String toString ()
    {
        String str = "";
        
        str += "Nome: " +nome+ "\n";
        str += "Data de Nascimento: " +dia+ "/" +mes+ "/" +ano+ "\n";

        return str;
    }
}