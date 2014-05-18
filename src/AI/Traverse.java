/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AI;

import MapDetails.Coins;
import MapDetails.Tile;
import MapDetails.Water;
import java.util.List;

/**
 *
 * @author Pranavan
 */
public class Traverse {
    
    private int msize;
    
    public Traverse(int msize){
        this.msize = msize;
    }
    
      public Coins GetBestCoin(Tile[] tiles, Coins[] coins, Tile current, int direction,List<Node> bestP)
        {
            Intelligence ast = new Intelligence(tiles, msize);
            List<Node> bestPath = null;
            Coins target = null;
            int minCost = Integer.MAX_VALUE;

            for(Coins coin : coins)
            {                
                int index = (int)(coin.getX()+(coin.getY()*msize));
                if (tiles[index] instanceof Water)
                {
                    continue;
                }
                List<Node> path = ast.calculatePath(current, tiles[index], direction);
                
                int cost = path.get(path.size() - 1).cost;
                
                // to be modfied
                if ((cost < minCost) && ((cost *1) < coin.getLifeTime()))
                {
                    bestPath = path;
                    minCost = cost;
                    target = coin;
                }
            }

            bestP = bestPath;
            //targetCoin = target;
            
            return target;
            //return this.generateCommandList(bestPath, direction);
        }
    
}
