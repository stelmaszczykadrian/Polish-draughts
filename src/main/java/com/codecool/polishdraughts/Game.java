package com.codecool.polishdraughts;
import java.util.Scanner;

public class Game {

    Board board;

    boolean currentPlayer = true;

    public void start() {
        Display display = new Display();
        Scanner scan = new Scanner(System.in);
        boolean wrongUserInput = true;
        display.printMessage("Welcome in Polish Draughts Game!");
        while (wrongUserInput) {
            display.printSameLineMsg("Put the size of the board. It need to be from 10 to 20: ");
            String userInput = scan.nextLine();
            display.printMessage("Your choice is: " + userInput);
            int intUserInput = Integer.parseInt(userInput);
            if (intUserInput >= 10 && intUserInput <= 20) {
                wrongUserInput = false;
                board = new Board(intUserInput);
                System.out.println(board);
            } else {
                display.printMessage("Only numbers from 10 to 20 are available.Try again.");
            }
        }
    }

    // zmienić nazwę na getStartingPosition
    public Coordinates getStartingMove() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the starting position:");
        String position = scanner.nextLine().toUpperCase();

        Coordinates coordinates;
        while ((coordinates = board.getValidPosition(position)) == null
                || !validateStartingPosition(coordinates)) {
            System.out.print("Wrong coordinates! Enter correct position: ");
            position = scanner.nextLine().toUpperCase();
        }

        return coordinates;
    }

    public Coordinates getEndingPosition() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the ending position:");
        String position = scanner.nextLine().toUpperCase();
        Coordinates coordinates;
        while ((coordinates = board.getValidPosition(position)) == null) {
            System.out.print("Wrong coordinates! Enter correct position: ");
            position = scanner.nextLine().toUpperCase();
        }
        return coordinates;
    }

    public boolean validateStartingPosition(Coordinates coordinates) {
        Pawn pawn = board.getField(coordinates.getXCoordinate(), coordinates.getYCoordinate());
        if (pawn != null && pawn.getColor() == currentPlayer) {
            return true;
        }
        return false;
    }

    public void tryToMakeMove(){
        Coordinates coordinatesStart = getStartingMove();
        Coordinates coordinatesEnd = getEndingPosition();
        Pawn pawn = board.getField(coordinatesStart.getXCoordinate(), coordinatesStart.getYCoordinate());
        while (!pawn.validateMove(board, coordinatesEnd.getXCoordinate(), coordinatesEnd.getYCoordinate())) {
            coordinatesEnd = getEndingPosition();
        }
        board.removePawn(coordinatesStart.getXCoordinate(), coordinatesStart.getYCoordinate());
        pawn.setCoordinates(coordinatesEnd);
        board.setPawn(pawn);
        System.out.println(board);
        }


    public boolean checkForWinner() {
        return false;
    }


}