package com.codecool.polishdraughts;

import java.util.ArrayList;
import java.util.Scanner;

public class Board {
    private int n;
    private static Pawn[][] fields;

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

    
    public void setPawn(Pawn pawn) {
        fields[pawn.getCoordinates().getXCoordinate()][pawn.getCoordinates().getXCoordinate()] = pawn;
    }

    public static int[] getStartingMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting position:");
        String position = scanner.nextLine().toUpperCase();

        while (!isValid(position, fields)) {
            System.out.print("Wrong coordinates! Enter correct position: ");
            position = scanner.nextLine().toUpperCase();
        }
        String[] coordinates = position.split("", 2);
        int firstCoordinate = position.charAt(0) - 65;
        System.out.println(firstCoordinate);
        int secondCoordinate = Integer.parseInt(coordinates[1]) - 1;
        System.out.println(secondCoordinate);

        return new int[]{firstCoordinate, secondCoordinate};
    }
    private static boolean isValid(String str, Pawn[][] board) {
        if (str.length() != 2 && str.length() != 3) return false;
        char col = str.charAt(0);
        if (col < 'A' || col >= 'A' + board[0].length) {
            return false;
        }
        try {
            int row = Integer.parseInt(str.substring(1));
            if (row < 1 || row > board.length) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
}