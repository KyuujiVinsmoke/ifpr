package ifpr.pgua.eic.threadsjavafx.Cmd;

public class Printer implements Runnable{

    private int id;
    private int numImpressoes;
    private int tempoSono;
    private String mensagem;

    public Printer(int id, int numImpressoes, int tempoSono, String mensagem){
        this.id = id;
        this.numImpressoes = numImpressoes;
        this.tempoSono = tempoSono;
        this.mensagem = mensagem;
    }

    public void run(){

        int cont=0;

        while(cont < numImpressoes){
            System.out.println(mensagem);
            try{
                System.out.println("Printer "+id+" dormindo por "+tempoSono);
                Thread.sleep(tempoSono);
            }catch(InterruptedException e){
                System.out.println("Interrompida!!");
            }
            cont+=1;
        }
    
    }


    
}
