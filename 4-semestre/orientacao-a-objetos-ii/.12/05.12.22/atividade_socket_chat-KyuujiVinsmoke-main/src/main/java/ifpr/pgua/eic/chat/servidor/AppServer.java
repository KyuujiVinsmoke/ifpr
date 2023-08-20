package ifpr.pgua.eic.chat.servidor;

import java.io.BufferedWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

public class AppServer {
    public static void main(String[] args) throws Exception{
        
        ChatServer server = new ChatServer(12345);

        server.listen();
        
    }
}
