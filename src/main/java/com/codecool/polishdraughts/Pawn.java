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

    public Coordinates getCoordinates() {
        return this.position;
    }

    public boolean validateMove(Board board, int endPosX, int endPosY) {
        int direction = color ? 1 : -1;
        int left = -1;
        int right = 1;
        if (position.getXCoordinate() + direction == endPosX &&
                (position.getYCoordinate() + left == endPosY ||
                position.getYCoordinate() + right == endPosY) &&
                board.getField(endPosX, endPosY) == null) {
            return true;
        } else if (Math.abs(position.getXCoordinate() - endPosX) == 2 &&
                Math.abs(position.getYCoordinate() - endPosY) == 2 &&
                board.getField((position.getXCoordinate() + endPosX) / 2,
                        (position.getYCoordinate() + endPosY) / 2) != null &&
                board.getField((position.getXCoordinate() + endPosX) / 2,
                        (position.getYCoordinate() + endPosY) / 2).color != color) {
            return true;
        }
        return false;
    }
}


