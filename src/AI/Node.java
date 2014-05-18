/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AI;

import MapDetails.Tile;

/**
 *
 * @author Pranavan
 */
public class Node {
    public Tile tile;
    public Node parent;
    public int cost;
    public int direction;

    public Node(Tile tile, Node parent, int cost, int direction) {
        this.tile = tile;
        this.parent = parent;
        this.cost = cost;
        this.direction = direction;
    }  
}
