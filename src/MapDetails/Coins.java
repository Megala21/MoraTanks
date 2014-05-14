/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MapDetails;

/**
 *
 * @author DELL
 */
public class Coins {
    
    private final int x;
    private final int y;
    private final long lifeTime;
    private final int amount;
    private final long currentTime;
    private boolean available;
    
    public Coins(int x, int y, long lifeTime, int amount){
        this.x = x;
        this.y = y;
        this.amount = amount;
        this.lifeTime = lifeTime;
        this.currentTime = System.currentTimeMillis();
        available = true;
    }
    
    public boolean take(){
        if(currentTime+lifeTime > System.currentTimeMillis() && available){
            available = false;
            return true;
        }
        return false;
    }
    
    public boolean isAvailable(){
        if(currentTime+lifeTime > System.currentTimeMillis() && available)
            return true;
        else
            return false;
    }
    
    public int getAmount(){
        return amount;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public long getLifeTime() {
        return lifeTime;
    }
    
   
}

