package com.codecool.polishdraughts;

public class Pawn {
    private boolean color;
    Coordinates position;

    public Pawn(boolean color, int x, int y) {
        this.color = color;
        position = new Coordinates(x, y);
    }

    public String getColor() {
        return color ? "w" : "b";
    }

    public Coordinates getCoordinates(){
        return this.position;
    }
}
