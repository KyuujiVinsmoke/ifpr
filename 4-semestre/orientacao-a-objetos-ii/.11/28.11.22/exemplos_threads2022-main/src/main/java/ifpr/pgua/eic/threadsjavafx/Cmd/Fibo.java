package ifpr.pgua.eic.threadsjavafx.Cmd;

public class Fibo implements Runnable {
    
    private long posicao;
    private boolean terminou;

    public Fibo(long posicao){
        this.posicao = posicao;
        this.terminou = false;
    }

    public boolean isTerminou(){
        return terminou;
    }

    private long f(long n){
        if( n < 2){
            return 1;
        }else{
            return f(n-1)+f(n-2);
        }
    }

    public void run(){
        System.out.println("Fibonnaci de "+posicao+"="+f(posicao));
        this.terminou = true;
    }
}


