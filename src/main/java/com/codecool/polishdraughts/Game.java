package com.codecool.polishdraughts;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

    public static void playRound(Board board, char currentPlayer){
        displayTurn(currentPlayer);
        Board.getStartingMove();
//        Board.getEndingMove();
//        metoda tryToMakeMove
//        metoda movePawn
        System.out.println(board);
    }

    private static void displayTurn(char currentPlayer) {
        if (currentPlayer == 'w'){
            System.out.println("White turn!");
        }
        else {
            System.out.println("Black turn!");
        }
    }

    public static void start() {
        Display display = new Display();
        Scanner scan = new Scanner(System.in);
        Board board = new Board(10);
        display.printMessage("Welcome in Polish Draughts Game! White starts!");
        boolean wrongUserInput = true;
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

        char currentPlayer = 'w';

//        wersja dla testu
        while (true) {
            playRound(board, currentPlayer);
            currentPlayer = currentPlayer == 'w' ? 'b' : 'w';
        }

//        wersja końcowa, jak będziemy mieli metodę checkForWinner()
//        while (checkForWinner() == false) {
//            playRound(board, currentPlayer);
//            currentPlayer = currentPlayer == 'w' ? 'b' : 'w';
//        }
    }
}