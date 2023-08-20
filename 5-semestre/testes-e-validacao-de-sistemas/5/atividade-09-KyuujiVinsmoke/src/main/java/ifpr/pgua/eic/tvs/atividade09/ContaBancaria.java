package ifpr.pgua.eic.tvs.atividade09;
//importações

public class ContaBancaria{

    //atributos
    private String agencia;
    private String numero;
    private double saldo=0;
    private Pessoa cliente;

    public ContaBancaria(String agencia, String numero, Pessoa cliente){
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
    }

    public ContaBancaria(String agencia, String numero, Pessoa cliente, double saldo){
        this.agencia = agencia;
        this.numero = numero;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public void setNumero(String numero){
        this.numero = numero;
    }

    public String getNumero(){
        return numero;
    }

    /*public void setAgencia(String valor){
        agencia = valor;
    }*/

    public String getAgencia(){
        return agencia;
    }

    /*public void setNomeCliente(String valor){
        nomeCliente = valor;
    }*/

    public Pessoa getCliente(){
        return cliente;
    }

    public double getSaldo(){
        return saldo;
    }



    //metodos
    String depositar(double valor){

        if(valor < 0){
            return "Valor inválido!";
        }
        saldo = saldo + valor;
        return "ok";
    }

    String sacar(double valor){
        if(valor < 0){
            return "Valor inválido!";
            //return false;
        }
        if(valor > saldo){
            return "Saldo insuficiente!";
            //System.out.println("Impossível sacar!!");
            //return false;
        }

        saldo = saldo - valor;
        return "ok";

    }

    String mostrarSaldo(){
        String texto="";

        texto = "Agência: " + agencia +
                " Número: " + numero +
                " Saldo: " + saldo +
                " Cliente: " + cliente.getNome();

        return texto;
    }

}