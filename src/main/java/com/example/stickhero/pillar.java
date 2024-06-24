package com.example.stickhero;

import javafx.scene.shape.Rectangle;

public class pillar implements gameObjects, collidable{
    private coordinates position;

    private Rectangle pillarRct;

    public coordinates getPosition() {
        return position;
    }

    public void setPosition(coordinates pillarPosition) {
        this.position = pillarPosition;
    }

    public pillar(Rectangle pillarRct) {
        this.pillarRct = pillarRct;
        this.position = new coordinates((int) pillarRct.getLayoutX(), (int) pillarRct.getLayoutY());
        this.height = (int) pillarRct.getHeight();
        this.width = (int) pillarRct.getWidth();
        this.xstart = (int) pillarRct.getLayoutX();
    }

    @Override
    public String toString() {
        return "pillar{" +
                "pillarPosition=" + position +
                ", height=" + height +
                ", width=" + width +
                ", xstart=" + xstart +
                '}';
    }

    private int height;
    private int width;
    private int xstart;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getXstart() {
        return xstart;
    }

    public void setXstart(int xstart) {
        this.xstart = xstart;
    }

    public pillar(int height, int width, int xstart) {
        this.height = height;
        this.width = width;
        this.xstart = xstart;
    }
}
