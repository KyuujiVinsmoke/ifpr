package ifpr.pgua.eic.chat.servidor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {

    private Vector<BufferedWriter> clientes;
    private int port;
    private ServerSocket server;
    private boolean accepting;

    public ChatServer(int port) throws IOException{
        this.clientes = new Vector<>();
        this.port = port;
        this.server = new ServerSocket(port);
        this.accepting = true;
    }

    public void stop(){
        this.accepting = false;
    }
    
    public void listen() throws IOException {
        
        while(accepting){
            System.out.println("Aguardando conexão...");
            Socket con = server.accept();
            System.out.println(con.getRemoteSocketAddress());
            Thread t = new Thread(new ChatWorker(con,clientes));
            t.start();
        }
                
    }

}
