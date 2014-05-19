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
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class ReceiveMessage extends Observable implements Runnable {

    private BufferedReader read;
    private InputStreamReader reader;
    private Socket clientInputSocket;
    private int clientInputPort;
    private ReceiveInterpretation receive;
    private ServerSocket serverSocket;
    private String reply;

    public ReceiveMessage(int clientPort, ReceiveInterpretation receive) {
        this.clientInputPort = clientPort;
        this.receive = receive;
        this.addObserver(receive);
        try {
            this.serverSocket = new ServerSocket(clientPort);
        } catch (IOException ex) {
            Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void run() {
          try {
                //    this.serverSocket = new ServerSocket(clientInputPort);
                clientInputSocket = serverSocket.accept();
                reader = new InputStreamReader(clientInputSocket.getInputStream());
                read = new BufferedReader(reader);

                if ((reply = read.readLine()) != null) {
                    System.out.println(reply);
                    /*receive.decode(reply);*/
                    setChanged();
                    notifyObservers(reply);
                    

                }

            } catch (Exception ex) {
                System.out.println("hjdjhbdjs");
            }
        while (true) {
            try {
                //    this.serverSocket = new ServerSocket(clientInputPort);
                    clientInputSocket = serverSocket.accept();
                    
                reader = new InputStreamReader(clientInputSocket.getInputStream());
                read = new BufferedReader(reader);
                    
                long current = System.currentTimeMillis();
                
            //Read The Message
            StringBuffer buffer = new StringBuffer();
            if ((reply = read.readLine()) != null || current + 1000 < System.currentTimeMillis() ) {
                    System.out.println(reply);
                    receive.decode(reply);
                   /* setChanged();
                    notifyObservers(reply);*/
                    
                 
                }
          
            

            } catch (Exception ex) {
                System.out.println("hjdjhbdjs");
                try {

                    this.serverSocket = new ServerSocket(clientInputPort);
                } catch (IOException ex1) {

                    Logger.getLogger(ReceiveMessage.class.getName()).log(Level.SEVERE, null, ex1);
                }

                continue;
            }
            

        }
    }
}
