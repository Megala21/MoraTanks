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
    private Image[] enemy;
    private Image[] enemy_E;
    private Image[] enemy_S;
    private Image[] enemy_W;
    
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
        enemy = new Image[4];
        enemy_E = new Image[4];
        enemy_S = new Image[4];
        enemy_W = new Image[4];
        
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
        ourPlayer_E = new Image("Images/redTank-E.png");
        ourPlayer_S = new Image("Images/redTank-S.png");
        ourPlayer_W = new Image("Images/redTank-W.png");
        
        enemy[0] = new Image("Images/greenTank.png");
        enemy[1] = new Image("Images/blueTank.png");
        enemy[2] = new Image("Images/yellowTank.png");
        enemy[3] = new Image("Images/vTank.png");
        
        enemy_E[0] = new Image("Images/greenTank-E.png");
        enemy_E[1] = new Image("Images/blueTank-E.png");
        enemy_E[2] = new Image("Images/yellowTank-E.png");
        enemy_E[3] = new Image("Images/vTank-E.png");
        
        enemy_S[0] = new Image("Images/greenTank-S.png");
        enemy_S[1] = new Image("Images/blueTank-S.png");
        enemy_S[2] = new Image("Images/yellowTank-S.png");
        enemy_S[3] = new Image("Images/vTank-S.png");
        
        enemy_W[0] = new Image("Images/greenTank-W.png");
        enemy_W[1] = new Image("Images/blueTank-W.png");
        enemy_W[2] = new Image("Images/yellowTank-W.png");
        enemy_W[3] = new Image("Images/vTank-W.png");
        
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

                switch(direction){
                    case 0 :    ourPlayer.draw(players[index-1].getX()* size, players[index-1].getY()); break;
                    case 1 :    ourPlayer_E.draw(players[index-1].getX()* size, players[index-1].getY()); break;
                    case 2 :    ourPlayer_S.draw(players[index-1].getX()* size, players[index-1].getY()); break;
                    case 3 :    ourPlayer_W.draw(players[index-1].getX()* size, players[index-1].getY()); break;
                }   
            }
            
            for(int i = 0; i < players.length;i++ ){
                if(i != index-1 && players[i] != null){
                    int direction = players[index-1].getDirection();
               /* 0 North
                1 East,
                2 South 
                3 West */
                    switch(direction){
                        case 0 :    enemy[players[i].getIndex()-1].draw(players[index-1].getX()* size, players[index-1].getY()); break;
                        case 1 :    enemy_E[players[i].getIndex()-1].draw(players[index-1].getX()* size, players[index-1].getY()); break;
                        case 2 :    enemy_S[players[i].getIndex()-1].draw(players[index-1].getX()* size, players[index-1].getY()); break;
                        case 3 :    enemy_W[players[i].getIndex()-1].draw(players[index-1].getX()* size, players[index-1].getY()); break;
                    }   
                }
            }
        }   
    }
   
}
