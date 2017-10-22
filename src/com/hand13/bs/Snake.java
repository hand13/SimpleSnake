package com.hand13.bs;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by hd110 on 2017/10/22.
 * edited by hand13
 */
public class Snake implements Points {
    private List<Point> points;
    public Snake() {
        points = new ArrayList<>();
        points.add(new Point(20,20,Statue.HEAD));
    }

    @Override
    public List<Point> getPoints() {
        return points;
    }
}
class Point {
    private int x;
    private int y;
    private Statue statue;
    public Point(int x,int y,Statue statue) {
        this.x = x;
        this.y = y;
        this.statue = statue;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Statue getStatue() {
        return statue;
    }

    public void setStatue(Statue statue) {
        this.statue = statue;
    }
}
