/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package States;

import MapDetails.Brick;
import MapDetails.Coins;
import MapDetails.LifePack;
import MapDetails.Map;
import MapDetails.Player;
import MapDetails.Stone;
import MapDetails.Water;
import java.util.LinkedList;
import java.util.ListIterator;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;
import org.newdawn.slick.Input;
/**
 *
 * @author DELL
 */
public class GamePlaying extends BasicGameState {
    //ID of the state
    private int ID;
    //Image of the Map
    private TiledMap Map;
    private Image score;
    //Image of the brick, stone and water obstacle
    private Image BrickFull;
    private Image BrickQuarter;
    private Image BrickHalf;
    private Image Brick3Quarter;
    private Image Stone;
    private Image Water;
    //Image for the coin and lifepack
    private Image coin;
    private Image lifePack;
    //Image for our Player
    private Image ourPlayer;
    private Image ourPlayer_E;
    private Image ourPlayer_S;
    private Image ourPlayer_W;
    // Images for four enemies
    private Image enemy1;
    private Image enemy1_E;
    private Image enemy1_S;
    private Image enemy1_W;
    private Image enemy1_N;
    private Image enemy2;
    private Image enemy3;
    private Image enemy4;
    // Size of a square in grid
    private int size = 35;
    private Input input;
    private Map map;
    /* GameOpening 0
      GamePlaying 1
      GameOver 2
      ConnectionError 3
    */
    
    /*
    0 (no damage) 
    1 (25% damage)
    2 (50% damage) 
    3 (75% Damage) 
    4 (100% Damage).*/
    
    public GamePlaying(Map map){
        ID = 1;
        this.map = map;
        
    }
    
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        /* Initalizing the maps brick and stones, players, coins and lifepacks*/
        Map = new TiledMap("Images/Map.tmx");
        score = new Image("Images/score1.jpg");
        BrickFull = new Image("Images/Brick.jpg");
        BrickQuarter = new Image("Images/Brickquarter.jpg");
        BrickHalf = new Image("Images/Brickhalf.jpg");
        Brick3Quarter = new Image("Images/Brick3quarter.jpg");
        Stone = new Image("Images/Stone.png");
        Water = new Image("Images/Water.jpg");
        ourPlayer = new Image("Images/redTank.png");
        enemy1 = new Image("Images/greenTank.png");
        enemy2 = new Image("Images/grayTank.png");
        enemy3 = new Image("Images/yellowTank.png");
        enemy4 = new Image("Images/vTank.png");
        coin = new Image("Images/Coins.jpg");
        lifePack = new Image("Images/lifePack.png");   
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        Map.render(0, 0);
        score.draw(700, 0);
        change();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_ENTER))
            sbg.enterState(2);
    }
    
    private void change(){
        LinkedList<Brick> bricks = map.getBricks();
        LinkedList<Water> water = map.getWater();
        LinkedList<Stone> stone = map.getStone();
        LinkedList<Coins> Coin = map.getCoin();
        LinkedList<LifePack> life = map.getLifePack();
        Player[] players = map.getPlayer();
        
        ListIterator iterator = bricks.listIterator();
        
        while(iterator.hasNext()){
            Brick temp = (Brick)iterator.next();
            int damage = temp.getDamage();
            
            switch(damage){
                case 0 : BrickFull.draw(temp.getX()* size, temp.getY()*size); break;
                case 1 : BrickQuarter.draw(temp.getX()* size, temp.getY()*size);break;
                case 2 : BrickHalf.draw(temp.getX()* size, temp.getY()*size);break;
                case 3 : Brick3Quarter.draw(temp.getX()* size, temp.getY()*size);break;
                case 4 : break;
            }
        }    
        
        iterator = water.listIterator();
        
        while(iterator.hasNext()){
            Water temp = (Water)iterator.next();
      
            Water.draw(temp.getX()* size, temp.getY()*size);
        }
        
       iterator = stone.listIterator();
        
        while(iterator.hasNext()){
            Stone temp = (Stone)iterator.next();
      
            Stone.draw(temp.getX()* size, temp.getY()*size);
        }
        
       iterator = Coin.listIterator();
        
        while(iterator.hasNext()){
            Coins temp = (Coins)iterator.next();
      
            if(temp.isAvailable())
                coin.draw(temp.getX()* size, temp.getY()*size);
        }
        
        iterator = life.listIterator();
        
        while(iterator.hasNext()){
            LifePack temp = (LifePack)iterator.next();
      
            if(temp.isAvailable())
                lifePack.draw(temp.getX()* size, temp.getY()*size);
        }
        
        int index = map.getIndex();
        
        if(index != -1){
            if(players[index-1].getHealth() > 0){
                int direction = players[index-1].getDirection();
               /* 0 North
                1 East,
                2 South 
                3 West */

                ourPlayer.draw(players[index-1].getX()* size, players[index-1].getY());
                
            }
        }
        //for(int i = 0; i < players.length && players[i] != null; i++)
            
        
    }
   
}
