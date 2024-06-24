package com.example.stickhero;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class stickHero {

    private Image img = new Image(getClass().getResourceAsStream("0x0ss-85BackgroundRemoved.png"));

    private static stickHero sh = null;

    private ImageView imv = new ImageView(img);

    public Image getImg() {
        return img;
    }

    private stickHero() {
    }

    public static stickHero getInstance(){
        if(sh == null){
            sh = new stickHero();
        }
        return sh;
    }

    public boolean equals(Object o){
        if(o!=null && getClass() == o.getClass()){
            stickHero s = (stickHero) o;
            return (this.imv == s.imv);
        }
        return false;
    }

    public ImageView getImv() {
        return imv;
    }
}

