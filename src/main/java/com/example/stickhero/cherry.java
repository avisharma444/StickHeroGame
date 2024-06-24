package com.example.stickhero;

import javafx.scene.image.ImageView;

public class cherry implements gameObjects, collidable {
    private coordinates position;

    private ImageView cherryIv;

    public ImageView getCherryIv() {
        return cherryIv;
    }

    public void setCherryIv(ImageView cherryIv) {
        this.cherryIv = cherryIv;
    }

    public coordinates getPosition() {
        return position;
    }

    public void setPosition(coordinates cherryPosition) {
        this.position = cherryPosition;
    }


    public cherry(ImageView cherryIv) {
        this.cherryIv = cherryIv;
        this.position = new coordinates((int) cherryIv.getLayoutX(), (int) cherryIv.getLayoutY());
    }

}
