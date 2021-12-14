package srv.server;
import java.io.*;
import java.net.InetAddress;
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
    public Socket attendi(){//NON SI TOCCA
        try {
            String ind = InetAddress.getLocalHost().getHostAddress();
            System.out.println("Server partito in esecuzione..."+ind);
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
        StringRV = inDalClient.readLine();//--Leggi linea inviata dal client 
        System.out.println("6 ricevuta la stringa dal CLI:"+StringRV);

        //Fare modifiche richieste dal server ///////////..........
        System.out.println("7 Invio stringa modificata al CLI...");
        outVersoClient.writeBytes(StringMD+'\n');//rispondi al client
        System.out.println("9 Server: elaborazione terminata ...");
        client.close();//chiudi trasmissione
        }catch(Exception e){
            
        }
    }
}
