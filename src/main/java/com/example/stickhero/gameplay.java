package com.example.stickhero;

import java.util.ArrayList;

public class gameplay{
    private stickman playingStickman;
    public ArrayList<pillar> pillars = new ArrayList<pillar>();
    //player iterates over all the pillars


    public stickman getPlayingStickman() throws stickmanNotFoundError{
        return playingStickman;
    }

    public int getCherryCounter() {
        return cherryCounter;
    }

    public void holdToExtendStick(){

    }

    public void tapToInvertStickman(){

    }

    public void reveiveStickman(){

    }

    public int cherryCounter;


}
