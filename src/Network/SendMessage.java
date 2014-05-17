/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Network;

import MessageInterpretations.ReceiveInterpretation;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class SendMessage {
     private PrintWriter writer;
     private Socket clientOutputSocket;
     private String serverip;
     private int clientOutputPort;
     private long time = 1000000000;
     private long currentTime = 0;
     private long startTime = 0;
     
     public SendMessage(String serverip, int clientport){
         this.serverip = serverip;
         this.clientOutputPort = clientport;
     }
     
     public boolean sendMessage(String message){
        try
        {
            clientOutputSocket = new Socket(serverip, clientOutputPort);
            
            writer = new PrintWriter(clientOutputSocket.getOutputStream(), true);
            writer.write(message);
            writer.flush();
            writer.close();
            System.out.println("OK");
            return true;
            } 
        catch (IOException ex) {
            Logger.getLogger(ConnectServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
}
