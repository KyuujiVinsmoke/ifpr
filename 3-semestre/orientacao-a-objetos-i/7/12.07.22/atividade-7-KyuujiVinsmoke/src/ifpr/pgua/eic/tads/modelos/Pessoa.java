package ifpr.pgua.eic.tads.modelos;

public class Pessoa {

    private String nome;
    private int idade;
    private double salario;
    private ContaCorrente contaCorrente;

    public Pessoa (String nome, int idade, double salario) {
        this.nome = nome;
        this.idade = idade;
        this.salario = salario;
    }

    public String getCpf() {
        return getCpf();
    }

    public String getCnpj() {
        return getCnpj();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }


    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public ContaCorrente getContaCorrente() {
        return contaCorrente;
    }

    public void setContaCorrente(ContaCorrente contaCorrente) {
        this.contaCorrente = contaCorrente;
    }


    public String toString(){
        String str="";

        str = "Pessoa[nome:"+nome+", idade:"+idade+", salario:"+salario+"]";
        
        return str;
    }
}