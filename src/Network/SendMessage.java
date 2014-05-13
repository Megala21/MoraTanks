/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Network;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class SendMessage {
     private BufferedWriter write;
     private Socket clientOutputSocket;
     
     public SendMessage(Socket clientOutputSocket){
         this.clientOutputSocket = clientOutputSocket;
         try {
             write = new BufferedWriter(new OutputStreamWriter(clientOutputSocket.getOutputStream()));
         } catch (IOException ex) {
             Logger.getLogger(SendMessage.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
}
