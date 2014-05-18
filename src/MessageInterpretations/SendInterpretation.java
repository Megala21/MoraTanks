/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MessageInterpretations;

import Network.ConnectServer;
import Network.SendMessage;
import States.GameOpening;
import org.newdawn.slick.Game;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author DELL
 */
public class SendInterpretation {
    private ConnectServer cs;
    private StateBasedGame game;
    
    public SendInterpretation(ConnectServer cs, Game game){
        this.cs = cs;
        this.game = (StateBasedGame) game;
    }
    
    public void join(){
        boolean reply = false;
        
        GameOpening go = (GameOpening) game.getState(0);
        go.indicateSituation("Connecting......");
    
            reply = cs.sendMessage("JOIN#");
        
        
        if(!reply)
            go.indicateSituation("Unable to connect...try again later");
        else {
            go.indicateSituation("Successfully Connected....");
           
        }
        
    }
    
    public void goUp(){
       cs.sendMessage("UP#");
    }
    
    public void goDown(){
       cs.sendMessage("DOWN#");
    }
    
    public void goLeft(){
       cs.sendMessage("LEFT#");
    }
    
    public void goRight(){
       cs.sendMessage("RIGHT#");
    }
}
