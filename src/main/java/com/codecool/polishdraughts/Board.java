package com.codecool.polishdraughts;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    private int n;
    private Pawn[][] fields;

    /* Option 1 */
    public Pawn getField(int x, int y) {
        System.out.println(fields[x][y]);
        return fields[x][y];
    }


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
//        System.out.println(Arrays.deepToString(fields));
    }

    /* may not be used, depends on further logic of the game */
    public ArrayList<int[]> getForbiddenPlaces() {
        ArrayList<int[]> forbiddenPlaces = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i % 2 == 0 && j % 2 != 0) || (i % 2 != 0 && j % 2 == 0)) {
                    forbiddenPlaces.add(new int[]{i, j});
                }
            }
        }
        for (int[] place: forbiddenPlaces) {
            System.out.print("(" + place[0] + ", ");
            System.out.print(place[1] + "), ");
        }
        System.out.println();
        return forbiddenPlaces;
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

    public void removePawn(int x, int y){
        this.fields[x][y] = null;
    }

    /* for test only */
    public void setPawn(Pawn pawn) {
        fields[pawn.getCoordinates().getXCoordinate()][pawn.getCoordinates().getXCoordinate()] = pawn;
    }
}