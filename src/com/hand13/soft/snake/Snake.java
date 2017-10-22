package com.hand13.soft.snake;
import sun.dc.pr.PRError;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by hd110 on 2017/10/22.
 * edited by hand13
 */
public class Snake {
    private Node head;

    private Node tail;
    private Color color = Color.red;
    private int length;

    private JFrame frame;

    private Direction direction;

    public Snake(Frame frame) {
        this.frame = frame;
        length = 1;
        direction = Direction.RIGHT;
        head = new Node();
        head.x =20;
        head.y = 20;
        tail = head;
        head.next = tail;
        tail.prev = head;
    }
    public void addHead() {
        Node node = new Node();
        node.x = head.x;
        node.y = head.y;
        switch (direction) {
            case UP:
                node.y--;
                break;
            case DOWN:
                node.y++;
                break;
            case LEFT:
                node.x--;
                break;
            case RIGHT:
                node.x++;
                break;
        }
        if(node.x ==40)
            node.x = 0;
        if(node.x == -1)
            node.x = 39;
        if(node.y == 40)
            node.y =0;
        if(node.y == -1)
            node.y = 40;
        node.next = head;
        head.prev = node;
        head = node;
        length++;
    }

    public void deleteTail() {
        tail = tail.prev;
        tail.next = null;
        length--;
    }

    public void drawSnake(Graphics g) {
        int wf = frame.getWidth()/40;
        int hf = frame.getHeight()/40;
        Node n = head;
        g.setColor(Color.cyan);
        g.fillOval(n.x*wf,n.y*hf,wf,hf);
        n = n.next;
        while (n != null) {
            if(n == head)
                break;
            g.setColor(color);
            g.fillOval(n.x*wf,n.y*hf,wf,hf);
            if(n == n.next)
                break;
            n = n.next;
            color = color.darker();
        }
    }
    public void keyPressed(int code){
        switch (code){
            case KeyEvent.VK_W:
                direction = Direction.UP;
                break;
            case KeyEvent.VK_S:
                direction = Direction.DOWN;
                break;
            case KeyEvent.VK_A:
                direction =Direction.LEFT;
                break;
            case KeyEvent.VK_D:
                direction = Direction.RIGHT;
                break;
        }
    }

    public Node getHead() {
        return head;
    }
}

class Node{
    int x;
    int y;
    Node prev;
    Node next;
}
