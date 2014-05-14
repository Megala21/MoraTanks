/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package States;

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
    private Image Brick;
    private Image Stone;
    private Image Water;
    //Image for the coin and lifepack
    private Image coin;
    private Image lifePack;
    //Image for our Player
    private Image ourPlayer;
    // Images for four enemies
    private Image enemy1;
    private Image enemy2;
    private Image enemy3;
    private Image enemy4;
    // Size of a square in grid
    private int size = 35;
    private Input input;
    
    /* GameOpening 0
      GamePlaying 1
      GameOver 2
      ConnectionError 3
    */
    
    public GamePlaying(){
        ID = 1;
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
        Brick = new Image("Images/Brick.jpg");
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
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        input = gc.getInput();
        if(input.isKeyPressed(Input.KEY_ENTER))
            sbg.enterState(2);
    }
    
}
