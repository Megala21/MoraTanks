/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MessageInterpretations;

import MapDetails.Brick;
import MapDetails.Map;
import MapDetails.Player;
import MapDetails.Stone;
import MapDetails.Water;
import org.newdawn.slick.Game;

/**
 *
 * @author DELL
 */
public class ReceiveInterpretation {
    
    private final String players_full = "PLAYERS_FULL#";
    private final String already_added = "ALREADY_ADDED#";
    private final String game_already_started = "GAME_ALREADY_STARTED#";
    private Game game;
    private Map map;
    
    public ReceiveInterpretation(Game game, Map map){
       this.game = game;
       this.map = map;
    }
    
    public void decode(String message){
        String reply= message;
   
        if(reply.equalsIgnoreCase(players_full)){
            indiatePleyarsFull();
        }
        else if(reply.equalsIgnoreCase(already_added)){
            System.out.println("Player already added");
        }
        else if(reply.equalsIgnoreCase(game_already_started)){
            
        }
        else if(reply.startsWith("S"))
            createPlayer(reply);
        else if(reply.startsWith("I"))
            createMap(reply);
        else if(reply.startsWith("G:"))
            updateMap(reply);
    }
    
    public void indiatePleyarsFull(){
        
    }
    
    public void createMap(String details){
       String temp[] = details.split(":");
       String brick[] = temp[2].split("[;,]");
       String stone[] = temp[3].split("[;,]");
       String water[] = temp[4].split("[;,#]");
       
       for(int i = 0; i < brick.length; i = i+2){
           map.addBricks(new Brick(Integer.parseInt(brick[i]),Integer.parseInt(brick[i+1])));
       }
       for(int i = 0; i < stone.length; i = i+2){
           map.addStone(new Stone(Integer.parseInt(stone[i]),Integer.parseInt(stone[i+1])));
       }
       for(int i = 0; i < water.length; i = i+2){
           map.addWater(new Water(Integer.parseInt(water[i]),Integer.parseInt(water[i+1])));
       }
        
    }

    private void createPlayer(String reply) {
        String temp[] = reply.split("[:,#]");
        int x = Integer.parseInt(temp[2]);
        int y = Integer.parseInt(temp[3]);
        int direction = Integer.parseInt(temp[4]);
        int index = Integer.parseInt(temp[1].substring(1));
        
        map.addPlayer(new Player(x, y, direction, index));
    }

    private void updateMap(String reply) {
    
    }
}
