package ifpr.pgua.eic.chat.servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;

public class ChatWorker implements Runnable {

    private Vector<BufferedWriter> clientes;
    private String nome;
    private Socket socket;

    private InputStream in;
    private InputStreamReader inR;
    private BufferedReader bfR;

    private OutputStream ou;
    private OutputStreamWriter ouW;
    private BufferedWriter bfW;


    public ChatWorker(Socket socket, Vector<BufferedWriter> clientes) throws IOException{
        this.clientes = clientes;
        this.socket = socket;
        
        //TODO Criar streams e adicionar cliente
        this.in = socket.getInputStream();
        this.inR = new InputStreamReader(in);
        this.bfR = new BufferedReader(inR);

        this.ou = socket.getOutputStream();
        this.ouW = new OutputStreamWriter(ou);
        this.bfW = new BufferedWriter(ouW);

        clientes.add(bfW);

    }

    @Override
    public void run() {
        
        //TODO Processar as mensagens
        //a primeira mensagem contem o nome
        //após, enquanto a mensagem não for sair
        //enviar ler uma mensagem e enviar para todos
        try{
            String msg = this.bfR.readLine();
            this.nome = msg;

            while(!msg.equalsIgnoreCase("sair")){
                
                msg = this.nome+" enviou: "+msg;
                sendToAll(bfW, msg);
                msg = this.bfR.readLine();
            }
            close();

        }catch(IOException e){
            e.printStackTrace();
        }
                
    }
    
    private void close() throws IOException{
        sendToAll(bfW, "#"+nome+" saiu;"+(clientes.size()-1)+" conectados;");
        clientes.remove(bfW);
        ou.close();
        in.close();
    }

    private void sendToAll(BufferedWriter bw, String msg) throws IOException{

        //TODO Enviar a mensagem para todos os clientes menos para ele mesmo
        for(BufferedWriter out:clientes){
            if(out != bw){
                out.write(msg+"\r\n");
                out.flush();
            }
        }
    }


}
