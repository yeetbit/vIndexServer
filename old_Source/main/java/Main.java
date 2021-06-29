package main.java;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.List;
import java.util.ArrayList;
import database.DataSourceThread;
import networking.TCP_IP_ServerThread;

public class Main {

    public static void main(String[] args) {

        DataSourceThread dST = new DataSourceThread();

        // by instantiating the Model classes, we are able to use the object's methods.  


        dST.close();

        try (ServerSocket serversocket = new ServerSocket(50000)) {
            while(true){
                new TCP_IP_ServerThread(serversocket.accept()).start(); // infinite loop for connecting
            }
            
            
        } catch (IOException e) {
            System.out.println("server exception: ");
            e.printStackTrace();
        }
    }
}
