package com.hand13.soft.snake;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/**
 * Created by hd110 on 2017/10/22.
 * edited by hand13
 */
public class Frame extends JFrame {
    private int size;
    private Snake snake;
    private Egg egg;
    private Thread thread;
    public void init() {
        size = 40;
        snake = new Snake(this);
        setEgg();
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snakeAction(e.getKeyCode());
                repaint();
                thread.interrupt();
            }
        });
        thread = new Thread(new Display());
    }
    public Thread getThread(){
        return thread;
    }
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        int wf = this.getWidth()/40;
        int hf = this.getHeight()/40;
        for(int i = 1; i <=size;i++) {
            g.drawLine(i*wf,0,i*wf,getHeight());
            g.drawLine(0,i*hf,getWidth(),i*hf);
        }
        snake.drawSnake(g);
        egg.drawEgg(g,this);
    }
    private void setEgg() {
        boolean ko = true;
        int x=0;
        int y=0;
        while(ko) {
            x = (int)(Math.random()*38)+1;
            y = (int)(Math.random()*38)+1;
            ko = isSnake(x,y);
        }
        egg = new Egg(x,y);
    }

    public static  void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(1000,1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("hand13");
        frame.init();
        frame.setVisible(true);
        frame.thread.start();
    }

    public void snakeAction(int code) {
        Node head = snake.getHead();
        Node vNext = new Node();
        switch (code) {
            case KeyEvent.VK_W:{
                vNext.x = head.x;
                vNext.y = head.y -1;
                if(pz(vNext))
                    return;
                break;
            }
            case KeyEvent.VK_S:{
                vNext.x = head.x;
                vNext.y = head.y+1;
                if(pz(vNext))
                    return;
                break;
            }
            case KeyEvent.VK_A:{
                vNext.x = head.x - 1;
                vNext.y = head.y;
                if(pz(vNext))
                    return;
                break;
            }
            case KeyEvent.VK_D:{
                vNext.x = head.x +1;
                vNext.y = head.y;
                if(pz(vNext))
                    return;
                break;
            }
        }
        snake.keyPressed(code);
        snake.addHead();
        if(!(vNext.x == egg.getNode().x && vNext.y == egg.getNode().y)){
            snake.deleteTail();
            return;
        }
        setEgg();
    }
    public boolean isSnake(int x,int y) {
        Node node = snake.getHead();
        while(node != null) {
            if((node.x == x && node.y == y)){
                return true;
            }
            if(node.next == node)
                break;
            node = node.next;
        }
        return false;
    }
    public boolean pz(Node node) {
        return (isSnake(node.x,node.y) || node.x == 40 || node.y == 40);
    }
    class Display implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000);
                    snakeAction(KeyEvent.VK_SPACE);
                    repaint();
                } catch (InterruptedException ie) {
                }
            }
        }
    }
}
