/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Network;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;

/**
 *
 * @author DELL
 */
public class ConnectServer {
   
    private Socket clientOutputSocket, clientInputSocket;
    private ServerSocket serverSocket;
    private ReceiveMessage receive;
    
    public ConnectServer() throws IOException    {
        connect();
    }
    
    public void connect()  {
        try{
            clientOutputSocket = new Socket("127.0.0.1", 6000);
       
          
       
            serverSocket = new ServerSocket(7000);
            clientInputSocket = serverSocket.accept();
            receive = new ReceiveMessage(clientInputSocket);
           
            
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

 
    
}

