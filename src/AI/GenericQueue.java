/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AI;

import java.util.LinkedList;

/**
 *
 * @author Pranavan
 */
public class GenericQueue {
       private LinkedList<Node>  nodeList = new LinkedList<Node>();

    public void enqueue(Node e) {
        nodeList.addLast(e);
    }

    public Node dequeue() {
        return nodeList.pollFirst();
    }

    public int size() {
        return nodeList.size();
    }

    public boolean isEmpty() {
        return nodeList.isEmpty();
    }

    public void removeAll() {
        nodeList.clear();
    }
}