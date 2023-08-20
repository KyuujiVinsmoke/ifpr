package ifpr.pgua.eic.chat.cliente;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ChatClient {

    private String nome;
    private String ipServidor;
    private int portaServidor;
    private boolean conectado;

    private Socket socket;

    private InputStream in;
    private InputStreamReader inR;
    private BufferedReader bfR;

    private OutputStream ou;
    private OutputStreamWriter ouW;
    private BufferedWriter bfW;

    public ChatClient(String nome, String ipServidor, int portaServidor) throws IOException {

        this.nome = nome;
        this.ipServidor = ipServidor;
        this.portaServidor = portaServidor;
        this.conectado = false;
    }

    public void conectar() throws IOException{
        //TODO Criar socket e streams
        //enviar mensagem com o nome

        this.socket = new Socket(ipServidor, portaServidor);

        this.in = socket.getInputStream();
        this.inR = new InputStreamReader(in);
        this.bfR = new BufferedReader(inR);

        this.ou = socket.getOutputStream();
        this.ouW = new OutputStreamWriter(ou);
        this.bfW = new BufferedWriter(ouW);

        conectado = true;

        enviaMensagem(nome);

       
        
    }

    public String recebeMensagem() throws IOException {
    
        //TODO Ler uma mensagem
        if(!conectado){
            throw new IOException("Não conectado!");
        }
        String msg = this.bfR.readLine();
        return msg;
    }

    public void enviaMensagem(String msg) throws IOException {
        //TODO Enviar uma mensagem
        if(!conectado){
            throw new IOException("Não conectado!");
        }
        this.bfW.write(this.nome+"\r\n");
        this.bfW.flush();
    }

    public boolean isConectado(){
        return conectado;
    }

    public void sair() throws IOException {
        
        //TODO fechar tudo    
        this.bfW.close();
        this.ouW.close();
        this.ou.close();

        this.bfR.close();
        this.inR.close();
        this.in.close();

        this.conectado = false;
    
    }

}
