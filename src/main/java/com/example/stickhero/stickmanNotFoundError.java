package com.example.stickhero;

public class stickmanNotFoundError extends Exception{
    stickmanNotFoundError(String msg){
        super(msg);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
