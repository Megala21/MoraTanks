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
    private Player player[];
    private LinkedList<Brick> bricks;
    private LinkedList<Water> water;
    private LinkedList<Stone> stone;
    private LinkedList<Bullet> bullet;
    private LinkedList<Coins> coin;
    private LinkedList<LifePack> lifePack;
    private int playerCount;
    
    Map(){
        player = new Player[5];
        player = null;
        bricks = new LinkedList<Brick>();
        water = new LinkedList<Water>();
        stone = new LinkedList<Stone>();
        bullet = new LinkedList<Bullet>();
        coin = new LinkedList<Coins>();
        lifePack = new LinkedList<LifePack>();
        playerCount = 0;
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

    public void updatePlayer(int x, int y, int direction, int shot, int health, int points){
        
    }
    public void addPlayer(Player player) {
        if(playerCount < 5) {
            this.player[player.getIndex()-1] = player;
            playerCount++;
        }
    }

    public void addBricks(Brick bricks) {
        this.bricks.add(bricks);
    }

    public void addWater(Water water) {
        this.water.add(water);
    }

    public void addStone(Stone stone) {
        this.stone.add(stone);
    }

    public void addBullet(Bullet bullet) {
        this.bullet.add(bullet);
    }

    public void addCoin(Coins coin) {
        this.coin.add(coin);
    }

    public void addLifePack(LifePack lifePack) {
        this.lifePack.add(lifePack);
    }
    
    
    
    
}
