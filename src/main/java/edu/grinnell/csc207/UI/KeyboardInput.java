package edu.grinnell.csc207.UI;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Processes user input in the console
 */
public class KeyboardInput {
    private static KeyboardInput instance = new KeyboardInput();
    public static KeyboardInput getInstance() {
        return instance;
    }

    private String lastRecordedInput;
    private PrintWriter pen = new PrintWriter(System.out, true);
    private Scanner scan = new Scanner(System.in);

    private KeyboardInput() { 
        lastRecordedInput = "";
    }

    public void promptAndRecordInput() { 
        pen.print(":");
        pen.flush();
        lastRecordedInput = scan.nextLine();
    }

    public Character getInput() { 
        return this.lastRecordedInput.charAt(0);
    }

    public String getFullInput() { 
        return this.lastRecordedInput;
    }

}
