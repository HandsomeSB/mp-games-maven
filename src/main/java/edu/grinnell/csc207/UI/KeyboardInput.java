package edu.grinnell.csc207.UI;

/**
 * Processes user input in the console
 */
public class KeyboardInput {
    private static KeyboardInput instance = new KeyboardInput();
    public static KeyboardInput getInstance() {
        return instance;
    }

    private Character lastRecordedInput;

    private KeyboardInput() { 

    }

    public void promptAndRecordInput() { 

    }

    public Character getInput() { 
        return this.lastRecordedInput;
    }

}
