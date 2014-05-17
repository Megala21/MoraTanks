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
public class LifePack extends Tile{
    private final long lifeTime;
    private final long currentTime;
    private boolean available;
    
    public LifePack(int x, int y, long lifeTime){
        super(x,y);
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
    
    public long getLifeTime() {
        return lifeTime;
    }
    
   
}

