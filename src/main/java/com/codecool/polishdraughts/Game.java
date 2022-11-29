package com.codecool.polishdraughts;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;

public class Game {

//    public static void main(String[] args) {
//        Board board = new Board(11);
//        board.setPawn(new Pawn(false, 2,2));
//        System.out.println(board);
//        board.getForbiddenPlaces();
//        System.out.println(board.getField(1,1).validateMove(board, 3,3));
//        }


    public static void Start() {
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
                Board board = new Board(intUserInput);
                System.out.println(board);
            } else {
                display.printMessage("Only numbers from 10 to 20 are available.Try again.");
            }
        }
    }
}