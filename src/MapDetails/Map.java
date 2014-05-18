/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapDetails;

import java.util.LinkedList;
import java.util.ListIterator;

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
    private int index ;
    
    public Map(){
        player = new Player[5];
        //player = null;
        bricks = new LinkedList<Brick>();
        water = new LinkedList<Water>();
        stone = new LinkedList<Stone>();
        bullet = new LinkedList<Bullet>();
        coin = new LinkedList<Coins>();
        lifePack = new LinkedList<LifePack>();
        playerCount = 0;
        index = -1;
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
    
    public int getIndex(){
        return index;
    }
    public void updatePlayer(int x, int y, int direction, int shot, int health, int coins, int points, int index){
        if(player[index] == null)
            addPlayer(new Player(x, y, direction, index));
        player[index].setX(x);
        player[index].setY(y);
        player[index].setIsShot(shot);
        player[index].setHealth(health);
        player[index].setCoins(coins);
        player[index].setPoints(points);
        player[index].setIndex(index);
    }
    
    public void addPlayer(Player player) {
        if(playerCount < 5) {
            this.player[player.getIndex()] = player;
            playerCount++;
        }
    }

    public void setIndex(int index){
        this.index = index;
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
   
    public void updateBrick(int x, int y, int damageLevel){
        ListIterator iterator = bricks.listIterator();
        Brick temp;
        if(iterator.hasNext()){
             temp = (Brick)iterator.next();
        int counts = 0;
        while(temp != null){
            if(temp.getX() == x && temp.getY() == y) {
                temp.setDamage(damageLevel);
                counts = 1;
                break;
            }
            if(iterator.hasNext())
                temp = (Brick)iterator.next();
            else
                temp = null;
            }
        if(counts == 0){
            Brick n = new Brick(x, y);
            n.setDamage(damageLevel);
            bricks.add(n);
         }    
        }
   }
}
    

