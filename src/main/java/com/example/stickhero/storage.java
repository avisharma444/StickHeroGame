package com.example.stickhero;

import java.util.ArrayList;
import java.util.HashMap;

public class storage {
    ArrayList<pillar> gamePillars = new ArrayList<>();

    ArrayList<cherry> gameCherries = new ArrayList<>();

    public ArrayList<pillar> getGamePillars() {
        return gamePillars;
    }

    public void setGamePillars(ArrayList<pillar> gamePillars) {
        this.gamePillars = gamePillars;
    }

    ArrayList<player>  players = new ArrayList<player>();
    public ArrayList<player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<player> players) {
        this.players = players;
    }

    public storage(ArrayList<pillar> pils) {
        this.gamePillars = pils;
    }
}
