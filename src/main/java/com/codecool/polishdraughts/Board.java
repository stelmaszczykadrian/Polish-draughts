package com.codecool.polishdraughts;

import java.util.Arrays;

public class Board {
    private int n;
    private Pawn[][] fields;


    public Board(int n) {
        this.n = n;
        fields = new Pawn[n][n];

        for (int i = 0; i < n; i++) {
            fields[0][i] = (i % 2 == 0 ? new Pawn(true, 0, i) : null);
            fields[1][i] = (i % 2 != 0 ? new Pawn(true, 1, i) : null);
            if (n % 2 == 0) {
                fields[n - 2][i] = (i % 2 == 0 ? new Pawn(false, n - 2, i) : null);
                fields[n - 1][i] = (i % 2 != 0 ? new Pawn(false, n - 1, i) : null);
            } else {
                fields[n - 2][i] = (i % 2 != 0 ? new Pawn(false, n - 2, i) : null);
                fields[n - 1][i] = (i % 2 == 0 ? new Pawn(false, n - 1, i) : null);
            }
        }
        System.out.println(Arrays.deepToString(fields));
    }


    @Override
    public String toString() {
        String boardAsString = "";
        for (int i = 0; i < n; i++) {
            boardAsString += String.format("%" + 3 + "d", i + 1);
        }
        for (int i = 0; i < n; i++) {
            boardAsString += "\n";
            boardAsString += (((char) (i + 65)));
            for (int j = 0; j < n; j++) {
                if (fields[i][j] == null) {
                    boardAsString += " . ";
                } else {
                    boardAsString += " " + fields[i][j].getColor()+ " ";
                }
            }
        }
        return boardAsString;
    }
}