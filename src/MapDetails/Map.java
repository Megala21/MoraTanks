/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapDetails;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author DELL
 */
public class Map implements Observer{
    private Player player[];
    private LinkedList<Brick> bricks;
    private LinkedList<Water> water;
    private LinkedList<Stone> stone;
    private LinkedList<Bullet> bullet;
    private LinkedList<Coins> coin;
    private LinkedList<LifePack> lifePack;
    private int playerCount;
    private int index ;
    private Tile gridTile[][];
    
    public Map(){
        player = new Player[5];
        gridTile = new Tile[20][20];
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
    public void updatePlayer(int x, int y, int direction, int shot, int health, int coins, int points, int index1){
        if(player[index1] == null)
            addPlayer(x, y, direction, index1);
        player[index1].setX(x);
        player[index1].setY(y);
        player[index1].setIsShot(shot);
        player[index1].setHealth(health);
        player[index1].setCoins(coins);
        player[index1].setPoints(points);
        player[index1].setIndex(index1);
    }
    
    public void addPlayer(int x, int y, int direction, int index1) {
        this.player[index1] = new Player(x,y, direction, index1);
            playerCount++;
        
    }

    public void setIndex(int index){
        this.index = index;
    }
    public void addBricks(Brick bricks) {
        this.bricks.add(bricks);
        gridTile[bricks.getX()][bricks.getY()] = bricks;
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
        
        int counts = 0;/*
        while(iterator.hasNext() ){
            temp = (Brick) iterator.next();
            if(temp.getX() == x && temp.getY() == y) {
                temp.setDamage(damageLevel);
                counts = 1;
     
            }
     
        }
        if(counts == 0){
            Brick n = new Brick(x, y);
            n.setDamage(damageLevel);
            bricks.add(n);
         }    */
        
        Brick b = (Brick)gridTile[x][y];
        b.setDamage(damageLevel);
        
    }
   

    @Override
    public void update(Observable o, Object o1) {
        
    }
}
    

