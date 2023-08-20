public class Endereco
{
    String pais;
    String estado;
    String cidade;
    String bairro;
    String rua;
    int numero;
    String complemento;

    public Endereco (String pais, String estado, String cidade, String bairro, String rua, int numero, String complemento) 
    {
        this.pais = pais;
        this.estado = estado;
        this.cidade = cidade;
        this.bairro = bairro;
        this.rua = rua;
        this.numero = numero;
        this.complemento = complemento;
    }

    public String toString ()
    {
        String str = "";
        
        str += "\nPais: " +pais+ "\n";
        str += "Estado: " +estado+ "\n";
        str += "Cidade: " +cidade+ "\n";
        str += "Bairro: " +bairro+ "\n";
        str += "Rua: " +rua+ "\n";
        str += "Numero: " +numero+ "\n";
        str += "Complemento: " +complemento;

        return str;
    }
}