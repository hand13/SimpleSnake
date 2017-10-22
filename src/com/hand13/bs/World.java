package com.hand13.bs;

/**
 * Created by hd110 on 2017/10/22.
 * edited by hand13
 */
public class World {
    private int size;
    private Statue[][] points;

    public World(int size) {
        this.size = size;
        points = new Statue[size][size];
        reflash();
    }
    private void reflash() {
        for(int i =0;i < size;i++) {
            for(int j = 0;j<size;j++){
                points[i][j] = Statue.SPACE;
            }
        }
    }
    public void addPoints(Points p) {
        reflash();
        for(Point point :p.getPoints()){
            points[point.getX()][point.getY()] = point.getStatue();
        }
    }
}
