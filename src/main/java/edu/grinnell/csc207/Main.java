package edu.grinnell.csc207;
import java.util.Scanner;

import edu.grinnell.csc207.GameObjects.GameObject;
import edu.grinnell.csc207.UI.KeyboardInput;
import edu.grinnell.csc207.util.Matrix;

import java.io.PrintWriter;

/**
 * Main class of our Matrix game.
 *
 * @author Harrison Zhu
 * @author Mina Bakrac
 */
public class Main {
    /**
     * Display board and pieces.
     *
     * @param pen
     *      Pen for output.
     */
    public static void display(PrintWriter pen) { 
        Matrix<Character> board = Game.getInstance().getBoard();
        pen.println("Score: " + Game.getInstance().getScore());
        for(int i = 0; i < board.height(); ++i) { 
            for(int j = 0; j < board.width(); ++j) { 
                pen.print(board.get(i, j));
                pen.print(" ");
            } // for
            pen.println();
        } // for
    } // display(PrintWriter)

    /**
     * Main method of our game.
     *
     * @param args
     *      Command line arguments.
     */
    public static void main(String[] args) {
        PrintWriter pen = new PrintWriter(System.out, true);
        Scanner scan = new Scanner(System.in);
        //print instruction
        pen.println("""
                Welcome to our awesome game!

                Command-line arguments:

                * -w key - move up on the board
                * -a key - move left on the board
                * -s key - move down on the board
                * -d key - move right on the board

                The goal of the game is for you ("P") to eat as much food ("*")
                as you are being chased by the enemy ("E") before getting
                caught.

                Here's how it works: you move one space for each turn using the keys
                above. For every one space you move, the enemy can move two spaces --
                keep in mind the enemy moves EXACTLY two spaces each time. Every time
                you eat the food, your score grows by one and the food moves to a new
                spot on the board.
                """);
        Game game = Game.getInstance();
        display(pen);
        while (!KeyboardInput.getInstance().getFullInput().equals("quit") && !game.getGameOver()){//while
            KeyboardInput.getInstance().promptAndRecordInput();
            game.update();
            display(pen);
        } // while
        pen.println("GAME OVER!");
    } // main(String[])
} // class Main