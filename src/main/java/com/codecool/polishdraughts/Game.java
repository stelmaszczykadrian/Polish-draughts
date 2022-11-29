package com.codecool.polishdraughts;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {
    public static void main(String[] args) {
        Board board = new Board(11);
        System.out.println(board);

    }

    public boolean validateStartingPos(int[][] board, int x, int y) {
        return true;
    }

    public boolean validateEndingPos(int[][] board, int x, int y) {
        return true;
    }
}
