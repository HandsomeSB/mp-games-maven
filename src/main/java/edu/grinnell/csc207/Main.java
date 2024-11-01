package edu.grinnell.csc207;
import java.util.Scanner;
import java.io.PrintWriter;

public class Main {
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

                The goal of the game is for you ("O") to eat as much food ("*")
                as you are being chased by the enemy ("X") before getting
                caught.

                Here's how it works: you move one space for each turn using the keys
                above. For every one space you move, the enemy can move two spaces --
                keep in mind the enemy moves EXACTLY two spaces each time. Every time
                you eat the food, your score grows by one and the food moves to a new
                spot on the board.
                """);

        

        //while loop
        //take input
        //call update
        //print board
    } // main(String[])
} // class Main
