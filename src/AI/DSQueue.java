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
public class DSQueue {
       private LinkedList<Node>  list = new LinkedList<Node>();

    public void enqueue(Node e) {
        list.addLast(e);
    }

    public Node dequeue() {
        return list.pollFirst();
    }

    public int size() {
        return list.size();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void removeAll() {
        list.clear();
    }
}