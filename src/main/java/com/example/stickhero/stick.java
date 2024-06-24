package com.example.stickhero;

import javafx.scene.shape.Rectangle;

public class stick implements gameObjects, collidable{
    private coordinates position;

    private Rectangle RectnagleofStick;

    public Rectangle getRectnagleofStick() {
        return RectnagleofStick;
    }

    public void setRectnagleofStick(Rectangle rectnagleofStick) {
        RectnagleofStick = rectnagleofStick;
    }

    public coordinates getPosition() {
        return position;
    }

    public void setPosition(coordinates position) {
        this.position = position;
    }

    public stick(Rectangle rectnagleofStick) {
        this.RectnagleofStick = rectnagleofStick;
        this.position = new coordinates((int) rectnagleofStick.getLayoutX(), (int) rectnagleofStick.getLayoutY());
    }

    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
