/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapDetails;

import java.util.LinkedList;

/**
 *
 * @author DELL
 */
public class Map {
    private Player[] player;
    private LinkedList<Brick> bricks;
    private LinkedList<Water> water;
    private LinkedList<Stone> stone;
    private LinkedList<Bullet> bullet;
    private LinkedList<Coins> coin;
    private LinkedList<LifePack> lifePack;
    
    Map(){
        player = new Player[5];
        bricks = new LinkedList<Brick>();
        water = new LinkedList<Water>();
        stone = new LinkedList<Stone>();
        bullet = new LinkedList<Bullet>();
        coin = new LinkedList<Coins>();
        lifePack = new LinkedList<LifePack>();
    }

    public Player[] getPlayer() {
        return player;
    }

    public LinkedList<Brick> getBricks() {
        return bricks;
    }

    public LinkedList<Water> getWater() {
        return water;
    }

    public LinkedList<Stone> getStone() {
        return stone;
    }

    public LinkedList<Bullet> getBullet() {
        return bullet;
    }

    public LinkedList<Coins> getCoin() {
        return coin;
    }

    public LinkedList<LifePack> getLifePack() {
        return lifePack;
    }

    public void setPlayer(Player[] player) {
        this.player = player;
    }

    public void setBricks(LinkedList<Brick> bricks) {
        this.bricks = bricks;
    }

    public void setWater(LinkedList<Water> water) {
        this.water = water;
    }

    public void setStone(LinkedList<Stone> stone) {
        this.stone = stone;
    }

    public void setBullet(LinkedList<Bullet> bullet) {
        this.bullet = bullet;
    }

    public void setCoin(LinkedList<Coins> coin) {
        this.coin = coin;
    }

    public void setLifePack(LinkedList<LifePack> lifePack) {
        this.lifePack = lifePack;
    }
    
    
    
    
}
