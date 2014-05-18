/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MessageInterpretations;

import MapDetails.Brick;
import MapDetails.Coins;
import MapDetails.LifePack;
import MapDetails.Map;
import MapDetails.Player;
import MapDetails.Stone;
import MapDetails.Water;
import States.GameOpening;
import java.awt.Font;
import java.util.Observable;
import java.util.Observer;
import org.newdawn.slick.Game;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author DELL
 */
public class ReceiveInterpretation implements Observer {

    private final String players_full = "PLAYERS_FULL#";
    private final String already_added = "ALREADY_ADDED#";
    private final String game_already_started = "GAME_ALREADY_STARTED#";
    private final String game_finished = "GAME_FINISHED#";
    private StateBasedGame game;
    private Map map;
    private GameOpening gameOpening;

    public ReceiveInterpretation(StateBasedGame game, Map map) {
        this.game = game;
        this.map = map;

        gameOpening = (GameOpening) game.getState(0);
    }

    public void decode(String message) {
        String reply = message;

        System.out.println(message);
        if (reply.equalsIgnoreCase(players_full)) {
            game.enterState(3);
        } else if (reply.equalsIgnoreCase(already_added)) {
            gameOpening.indicateSituation("Player already added");
        } else if (reply.equalsIgnoreCase(game_already_started)) {
            game.enterState(0);
            gameOpening.indicateSituation("Player Full, try again later");
        } else if (reply.equalsIgnoreCase(game_finished)) {
            game.enterState(2);
        } else if (reply.startsWith("S")) {
            createPlayer(reply);
        } else if (reply.startsWith("I")) {
            createMap(reply);
        } else if (reply.startsWith("G:")) {
            updateMap(reply);
        } else if (reply.startsWith("C")) {
            updateCoin(reply);
        } else if (reply.startsWith("L")) {
            updateLife(reply);
        }
    }

    public void createMap(String details) {
        String temp[] = details.split("[:\\#]");

        System.out.println(details);

        

            String brick[] = temp[2].split("[,\\;]");
            for (int i = 0; i < brick.length; i++) {
                System.out.println("brick " + brick[i]);
            }
            String stone[] = temp[3].split("[;\\,]");
            String water[] = temp[4].split("[;\\,]");

            for (int i = 0; i < brick.length; i = i + 2) {
                map.addBricks(new Brick(Integer.parseInt(brick[i]), Integer.parseInt(brick[i + 1])));
            }
            for (int i = 0; i < stone.length; i = i + 2) {
                map.addStone(new Stone(Integer.parseInt(stone[i]), Integer.parseInt(stone[i + 1])));
            }
            for (int i = 0; i < water.length; i = i + 2) {
                map.addWater(new Water(Integer.parseInt(water[i]), Integer.parseInt(water[i + 1])));
            }
        

        if (game.getCurrentState().getID() != 1) {
            game.enterState(1);
        }
    }

    private void createPlayer(String reply) {

        /*S:P0;0,0;0:P1;0,9;0:P2;9,0;0#*/
        String temp[] = reply.split("[:\\#]");
        int ind = 0;

        for (int i = 1; i < temp.length; i++) {
            String[] tmp = temp[i].split("[,\\;]");
            int x = Integer.parseInt(tmp[1]);
            System.out.println(x);
            int y = Integer.parseInt(tmp[2]);
            int direction = Integer.parseInt(tmp[3]);
            int index = Integer.parseInt(tmp[0].substring(1));

            map.addPlayer(new Player(x, y, direction, index));
            ind = index;
        }

        map.setIndex(ind);
        game.enterState(1);

    }

    private void updateMap(String reply) {
        /*G:P0;0,0;0;0;100;0;0:P1;4,9;1;0;100;0;0:P2;5,0;3;0;100;0;0:2,1,0;3,6,0;0,8,0;8,4,0;4,7,0;6,3,0;1,8,0;7,2,0;6,8,0;2,3,0#*/
        String temp[] = reply.split("[:\\#]");

        for (int i = 1; i < temp.length - 1; i++) {
            String[] t = temp[i].split("[;\\,]");
            int x = Integer.parseInt(t[1]);
            int y = Integer.parseInt(t[2]);
            int direction = Integer.parseInt(t[3]);
            int shot = Integer.parseInt(t[4]);
            int health = Integer.parseInt(t[5]);
            int coins = Integer.parseInt(t[6]);
            int points = Integer.parseInt(t[7]);
            int index = Integer.parseInt(t[0].substring(1));
            map.updatePlayer(x, y, direction, shot, health, coins, points, index);
        }
        String brick[] = temp[temp.length - 1].split("[;\\,]");

        for (int i = 0; i < brick.length - 2; i = i + 3) {
            map.updateBrick(i, i + 1, i + 2);

        }
    }

    private void updateCoin(String reply) {
        String[] coin = reply.split("[:\\,\\#]");
        int x = Integer.parseInt(coin[1]);
        int y = Integer.parseInt(coin[2]);
        long lifeTime = Long.parseLong(coin[3]);
        int val = Integer.parseInt(coin[4]);
        System.out.println("Life " + lifeTime);
        map.addCoin(new Coins(x, y, lifeTime, val));
    }

    private void updateLife(String reply) {
        String[] life = reply.split("[:\\,\\#]");
        int x = Integer.parseInt(life[1]);
        int y = Integer.parseInt(life[2]);
        long lifeTime = Long.parseLong(life[3]);

        map.addLifePack(new LifePack(x, y, lifeTime));
    }

    @Override
    public void update(Observable o, Object o1) {
        decode(String.valueOf(o1));
    }

}
