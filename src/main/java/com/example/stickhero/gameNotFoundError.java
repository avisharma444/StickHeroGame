package com.example.stickhero;

public class gameNotFoundError extends Exception {
    gameNotFoundError(String msg){
        super(msg);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
