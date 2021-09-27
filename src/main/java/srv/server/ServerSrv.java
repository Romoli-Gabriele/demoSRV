package srv.server;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSrv{

    ServerSocket server = null;
    Socket client = null;
    String StringRV = null;
    String StringMD = null;
    BufferedReader inDalClient;
    DataOutputStream outVersoClient;
    public ServerSrv(){
        
    }
    public Socket attendi(){
        try {
            System.out.println("Server partito in esecuzione...");
            server = new ServerSocket(6789);
            client = server.accept();
            server.close();
            inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
            outVersoClient = new DataOutputStream( client.getOutputStream());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
        return client;
    }
    public void comunica() {
        try{
        System.out.println("3 Benvenuto client, scrivi la frase da trasformare in maiuscolo. Attendo...");
        StringRV = inDalClient.readLine();
        System.out.println("6 ricevuta la stringa dal CLI:"+StringRV);
        StringMD = StringRV.toUpperCase();
        System.out.println("7 Invio stringa modificata al CLI...");
        outVersoClient.writeBytes(StringMD+'\n');
        System.out.println("9 Server: elaborazione terminata ...");
        client.close();
        }catch(Exception e){

        }
    }
}
