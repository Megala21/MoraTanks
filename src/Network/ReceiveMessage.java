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
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ReceiveMessage extends Thread {
    private BufferedReader read;
    private Socket clientInputSocket;
    private ReceiveInterpretation receive;

    public ReceiveMessage(Socket clientInputSocket, ReceiveInterpretation receive) {
        try {
            this.clientInputSocket = clientInputSocket;
            this.receive = receive;
            read = new BufferedReader(new InputStreamReader(this.clientInputSocket.getInputStream()));
        } catch (IOException ex) {
            Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String readMessage(){
        try {
            return read.readLine();
        } catch (IOException ex) {
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

