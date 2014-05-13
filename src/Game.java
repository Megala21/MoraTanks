
import States.ConnectionError;
import States.GameOpening;
import States.GameOver;
import States.GamePlaying;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
//import 
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DELL
 */
public class Game extends StateBasedGame{
    public static void main(String[] args) {
        //Initalizing window size and putting the icon 
        try{
            AppGameContainer agc = new AppGameContainer(new Game());
            agc.setDisplayMode(1300, 700, false);
            agc.setIcon("Images/tankIcon.png");
            agc.setShowFPS(false);
            agc.setSoundOn(true);
            
            agc.start();
        }
        catch(SlickException e){
            e.printStackTrace();
        }
    }

    public Game() {
        super("Mora Tanks");
    }

    @Override
    public void initStatesList(GameContainer gc) {
        try{
            
            addState(new GameOpening());
            addState(new GamePlaying());
            addState(new GameOver());
            addState(new ConnectionError());
           
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
