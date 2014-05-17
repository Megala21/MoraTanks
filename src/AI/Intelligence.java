/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AI;

import MapDetails.Stone;
import MapDetails.Tile;
import MapDetails.Water;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Pranavan
 */
public class Intelligence {

    Node current = new Node(null, null, 0, 0);
    int mapSize;
    Tile[] squares;

    public Intelligence (Tile[] sqrs, int mapSize) {
        this.squares = sqrs;
        this.mapSize = mapSize;
    }

    //calculate the least cost path between two given squares
    public List<Node> calculatePath(Tile source, Tile destination, int direction) {

        List<Node> openList = new ArrayList<Node>();
        List<Node> closedList = new ArrayList<Node>();
        List<Tile> closedSqrs = new ArrayList<Tile>();

        openList.add(new Node(source, null, 0, direction));

       boolean finished = false;
        int k = 0;

        while (!finished) {
            k++;
            int fullCost = Integer.MAX_VALUE;

            //get the node with the least cost
            for(Node node : openList){
                    if (current.tile == null) {
                    current = node;
                    fullCost = current.cost + getHeuristic(current.tile, destination);
                } else if ((getHeuristic(node.tile, destination) + node.cost) < fullCost) {
                    current = node;
                    fullCost = current.cost + getHeuristic(current.tile, destination);
                }
            }

            int currentDirection = current.direction;

            int xCord = (int) current.tile.getX();
            int yCord = (int) current.tile.getY();

            int cost = 0;

            int iMin = (xCord > 0) ? -1 : 0;
            int iMax = (xCord < (mapSize - 1)) ? 1 : 0;
            int jMin = (yCord > 0) ? -1 : 0;
            int jMax = (yCord < (mapSize - 1)) ? 1 : 0;

            for (int i = iMin; i <= iMax; i++) {
                for (int j = jMin; j <= jMax; j++) {
                    if ((i != 0) && (j != 0)) //if a diagonal square
                    {
                        continue;
                    }
                    if ((i == 0) && (j == 0)) //if the center square
                    {
                        continue;
                    }

                   boolean isDir = false;

                    if ((j == -1) && (currentDirection == 0)) {
                        isDir = true;
                    } else if ((j == 1) && (currentDirection == 2)) {
                        isDir = true;
                    } else if ((i == -1) && (currentDirection == 3)) {
                        isDir = true;
                    } else if ((i == 1) && (currentDirection == 1)) {
                        isDir = true;
                    }

                    int index = (xCord + i) + ((yCord + j) * mapSize);
                    Tile currentSqr = squares[index];

                    cost = this.getCost(xCord + i, yCord + j, isDir);

                    int tempDirection = currentDirection;
                    if (j == -1) {
                        tempDirection = 0;
                    } else if (j == 1) {
                        tempDirection = 2;
                    } else if (i == -1) {
                        tempDirection = 4;
                    } else if (i == 1) {
                        tempDirection = 1;
                    }

                    if ((cost >= 0) && (!closedSqrs.contains(currentSqr))) {
                        openList.add(new Node(currentSqr, current, (cost + current.cost), tempDirection));
                    }
                }
            }

            openList.remove(current);
            closedList.add(current);
            closedSqrs.add(current.tile);

            if ((current.tile == destination) || (openList.size() == 0)) {
                finished = true;
            }

            current = new Node(null, null, 0, 0);

        }

        return this.filterClosedL(closedList);
        //return closedList;
    }

    //calculate cost to move to a given square
    public int getCost(int i, int j, boolean inDirection) {
        int index = i + (j * mapSize);
        Tile currentSqr = squares[index];

        int cost = 0;

       // Have to modify
        /*if ((currentSqr instanceof Stone) || (currentSqr instanceof Water)) {
        cost = -5;
        } else if (currentSqr.getSType() == 0) {
        cost = 1;
        } else if (currentSqr.getSType() == 1) {
        Brick currentBrick = (Brick) currentSqr;
        cost = currentBrick.getStrength() + 1;
        }*/

        if (!inDirection) {
            cost = cost + 1;
        }

        return cost;
    }

    //calculate a heuristic value for a given source and destination
    public int getHeuristic(Tile source, Tile target) {
        int hDistance = Math.abs((int) source.getX() - (int) target.getX());
        int vDistance = Math.abs((int) source.getY() - (int) target.getY());

        int heurCost = hDistance + vDistance;

        return heurCost;
    }

    public List<Node> filterClosedL(List<Node> close) {
        List<Node> result = new ArrayList<Node>();
        /*Node current = close[close.getSize() - 1];
        close*/

        while (current.parent != null) {
            result.add(current);
            current = current.parent;
        }

        result.add(current);

        Collections.reverse(result);
        return result;
    }
}
