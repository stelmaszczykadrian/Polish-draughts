package com.codecool.polishdraughts;

public class Board {
    private int n;
    private Pawn[][] fields;

    /* Option 1 */
    public Pawn getField(int x, int y) {
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
                    boardAsString += " " + fields[i][j].getColorLetter()+ " ";
                }
            }
        }
        return boardAsString;
    }


    public void removePawn(int x, int y){
        this.fields[x][y] = null;
    }

    
    public void setPawn(Pawn pawn) {
        fields[pawn.getCoordinates().getXCoordinate()][pawn.getCoordinates().getYCoordinate()] = pawn;
    }


    public Coordinates getValidPosition(String str) {
        if (str.length() != 2 && str.length() != 3) return null;
        char row = str.charAt(0);
        if (row < 'A' || row >= 'A' + n) {
            return null;
        }
        int col;
        try {
            col = Integer.parseInt(str.substring(1));
            if (col < 1 || col > n) {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
        return new Coordinates(row - 'A', col - 1);
    }
}


