/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MessageInterpretations;

import Network.SendMessage;

/**
 *
 * @author DELL
 */
public class SendInterpretation {
    private SendMessage sendMessage;
    
    public SendInterpretation(SendMessage sendMessage){
        this.sendMessage = sendMessage;
    }
    
    public void join(){
        boolean reply = false;
        do{
            reply = sendMessage.sendMessageServer("JOIN#");
        }while(!reply);
        
    }
    
    public void goUp(){
       sendMessage.sendMessageServer("UP#");
    }
    
    public void goDown(){
       sendMessage.sendMessageServer("DOWN#");
    }
    
    public void goLeft(){
       sendMessage.sendMessageServer("LEFT#");
    }
    
    public void goRight(){
       sendMessage.sendMessageServer("RIGHT#");
    }
}
