package edu.grinnell.csc207.UI;

import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Processes user input in the console.
 *
 * @author Harrison Zhu
 * @author Mina Bakrac
 */
public class KeyboardInput {
    private static KeyboardInput instance = new KeyboardInput();

    /**
     * Get instance of keyboard input.
     *
     * @return instance.
     */
    public static KeyboardInput getInstance() {
        return instance;
    } // getInstance()

    private String lastRecordedInput;
    private PrintWriter pen = new PrintWriter(System.out, true);
    private Scanner scan = new Scanner(System.in);


    private KeyboardInput() { 
        lastRecordedInput = "";
    } // KeyboardInput()

    /**
     * Prompt and record the input.
     */
    public void promptAndRecordInput() { 
        pen.print(":");
        pen.flush();
        lastRecordedInput = scan.nextLine();
    } // promptAndRecordInput()

    public Character getInput() {
        if (! this.lastRecordedInput.isEmpty())
            return this.lastRecordedInput.charAt(0);
            return Character.valueOf(' ');
    } // getInput()

    /**
     * Returns full last recorded input.
     *
     * @return last recorded input.
     */
    public String getFullInput() { 
        return this.lastRecordedInput;
    }
}
