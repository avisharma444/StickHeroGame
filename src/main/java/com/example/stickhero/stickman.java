package com.example.stickhero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class stickman implements gameObjects, collidable {

    private stick avatarsStick;

    private ImageView smiv;

    public stick getAvatarsStick() {
        return avatarsStick;
    }

    public void setAvatarsStick(stick avatarsStick) {
        this.avatarsStick = avatarsStick;
    }

    public ImageView getSmiv() {
        return smiv;
    }

    public void setSmiv(ImageView smiv) {
        this.smiv = smiv;
    }

    private coordinates position;

    public coordinates getPosition() {
        return position;
    }

    public void setPosition(coordinates position) {
        this.position = position;
    }

    public stickman(ImageView smiv) {
        this.smiv = smiv;
        this.position = new coordinates((int) smiv.getLayoutX(), (int) smiv.getLayoutY());
    }

    public stick extendStick() throws stickOutOfBoundError{
        //extends stick of length equal to the time of hold of master key
//        avatarsStick = new stick(new coordinates(0, 0), 0);
        return avatarsStick;
    }

    public void invert(){
        //inverts to get cherry
        //here the direction of stickman is reversed
    }

    public boolean isStickValid(stick myStick, pillar currPillar, pillar nextPillar) throws stickOutOfBoundError{
        //check weather the extended stick falls on the top of the next pillar
        if(myStick.getLength() == nextPillar.getXstart() - currPillar.getXstart() + currPillar.getWidth()) return true;
        else return false;
    }

    public void collectCherry(){
        //stickman collects cherries
    }

//    public stickman getInstance(){
//        Image stickmanImage = new Image(getClass().getResourceAsStream("0x0ss-85BackgroundRemoved.png"));
////        Ima
//    }
}
