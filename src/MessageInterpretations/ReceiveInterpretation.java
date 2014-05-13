/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MessageInterpretations;

import org.newdawn.slick.Game;

/**
 *
 * @author DELL
 */
public class ReceiveInterpretation {
    
    private String players_full = "PLAYERS_FULL#";
    private String already_added = "ALREADY_ADDED#";
    private String game_already_started = "GAME_ALREADY_STARTED#";
    private Game game;
    
    public ReceiveInterpretation(Game game){
       this.game = game;
    }
    public void decode(String message){
        String reply= message;
   
        if(reply.equalsIgnoreCase(players_full)){
            indiatePleyarsFull();
        }
        else if(reply.equalsIgnoreCase(already_added)){
            System.out.println("Player already added");

        }
    }
    
    public void indiatePleyarsFull(){
        
    }
}
