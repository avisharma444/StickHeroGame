package com.example.stickhero;

public class stickOutOfBoundError extends Exception{
    stickOutOfBoundError(String msg){
        super(msg);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
