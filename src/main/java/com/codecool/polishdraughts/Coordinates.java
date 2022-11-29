package com.codecool.polishdraughts;

public class Coordinates {

    private int x;
    private int y;

    Coordinates(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getXCoordinate(){
        return this.x;
    }

    public int getYCoordinate(){
        return this.y;
    }

    public void setXCoordinate(int x){
        this.x = x;
    }

    public void setYCoordinate(int y){
        this.y = y;
    }
}
