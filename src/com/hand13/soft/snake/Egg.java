package com.hand13.soft.snake;
import javax.swing.*;
import java.awt.*;

/**
 * Created by hd110 on 2017/10/22.
 * edited by hand13
 */
public class Egg{
    private Node node;

    public Egg(int x,int y) {
        node = new Node();
        node.x = x;
        node.y = y;
    }
    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }
    public void drawEgg(Graphics g, JFrame frame) {
        int width = frame.getWidth()/40;
        int height = frame.getHeight()/40;
        g.setColor(Color.magenta);
        g.fillOval(node.x*width,node.y*height,width,height);
    }
}
