package com.example.stickhero;

import java.util.ArrayList;

public class player {
    private int cherries;

    private ArrayList<cherry> listOfCherries = new ArrayList<cherry>();

    private stickman myAvatar;

    public stickman getMyAvatar() throws stickmanNotFoundError {
        return myAvatar;
    }


    public void setMyAvatar(stickman myAvatar) {
        this.myAvatar = myAvatar;
    }

    @Override
    public String toString() {
        return "player{" +
                ", cherries=" + cherries +
                '}';
    }



    public int getCherries() {
        return cherries;
    }

    public void setCherries(int cherries) {
        this.cherries = cherries;
    }

    public player( int cherries) {
        this.cherries = cherries;
    }

    public void revive(){
        //code for reviving the player
    }
}