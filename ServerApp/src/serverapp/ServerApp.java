package serverapp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    static final int port = 1200;

    public static void main(String[] args) throws Exception {

        // Listen to a specific port

        ServerSocket s = new ServerSocket(port);
        System.out.println("Waiting for connection");
        Socket socClient = s.accept(); // Accept a client socket
        System.out.println("Connection established");

        // Initialize in / out

        BufferedReader inServer = new BufferedReader(new InputStreamReader(socClient.getInputStream()));
        PrintWriter outServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socClient.getOutputStream())), true);

        // Read message sent by the client
        String str = inServer.readLine();
        int n =Integer.parseInt(str);
        for(int i=1;i<=n;i++){
            int nb=0;
            for(int k=2;k<i;k++){
                if(i%k==0){
                    nb++;
                }
            }
            if(nb ==0){
                System.out.println(i+" est un nombre premier");
            }
        }

        // Close in / out
        inServer.close();
        outServer.close();

        // Close client socket
        socClient.close();
    }
}
