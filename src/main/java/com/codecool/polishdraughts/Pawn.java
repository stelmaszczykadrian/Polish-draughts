package com.codecool.polishdraughts;

public class Pawn {
    private boolean color;
    private int x;
    private int y;

    public Pawn(boolean color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color ? "w" : "b";
    }
}

