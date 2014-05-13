/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package States;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author DELL
 */
public class GameOpening extends BasicGameState
{   
    private int ID;
    private Image background;
    private Music backgroundMusic;
    private Input input;
   /* GameOpening 0
      GamePlaying 1
      GameOver 2
      ConnectionError 3
    */
    public GameOpening() {
        ID = 0;
    }
    
    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg){
        try{
           background = new Image("Images/Tanks.jpg");
           backgroundMusic = new Music("Sound/music.wav");
        }
        catch(SlickException e){
            e.printStackTrace();
        }
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) {
        try{
            background.draw();
            backgroundMusic.play();
            backgroundMusic.loop();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    //@SuppressWarnings("empty-statement")
    public void update(GameContainer gc, StateBasedGame sbg, int i){
        try{
        input = gc.getInput();
        
            if(input.isKeyDown(Input.KEY_ENTER)) 
                System.out.println();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
    

