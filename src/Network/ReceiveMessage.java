/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Network;

import MessageInterpretations.ReceiveInterpretation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ReceiveMessage extends Thread {
    private BufferedReader read;
    private InputStreamReader reader;
    private Socket clientInputSocket;
    private int clientInputPort;
    private ReceiveInterpretation receive;
    private ServerSocket serverSocket;

    public ReceiveMessage(int clientPort, ReceiveInterpretation receive) {
        this.clientInputPort = clientPort;
        this.receive = receive;
        try {
            this.serverSocket = new ServerSocket(clientPort);
        } catch (IOException ex) {
            Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String readMessage() {
       if(serverSocket == null)
            try {
                
                serverSocket = new ServerSocket(clientInputPort);
        } catch (IOException ex) {
            Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            String reply = null;
            
            clientInputSocket = serverSocket.accept();
            reader = new InputStreamReader(clientInputSocket.getInputStream());
            read = new BufferedReader(reader);
            
            reply = read.readLine();
            if (reply != null)
                return reply;
        }
           
        catch (IOException ex) {
           
            Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public void run(){
        while(true) {
            String reply = readMessage();
            
            if(reply != null)
                receive.decode(reply);      
        }
    }
}

