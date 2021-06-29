package src.networking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCP_IP_ServerThread extends Thread {

    private Socket socket;

    public TCP_IP_ServerThread(Socket socket){
        this.socket = socket;
    }
    
    @Override
    public void run(){
        try {
            System.out.println("Client connected"); 
            BufferedReader input =  new BufferedReader( new InputStreamReader(socket.getInputStream()));  
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);  
            
            while(true){
                String echoString = input.readLine();
                if(echoString.equals("exit")){
                    break;
                }
                output.println("Echo from server: " + echoString);
                System.out.println("Client message: " + echoString);
            }
        } catch (Exception e) {
            System.out.println("server exception " + e.getMessage());
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.out.println("server exception: Closing network socket was not succesfull");
                e.printStackTrace();

            }

        }
    }
}


