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
  /** Singleton instance of KeyboardInput. */
  private static KeyboardInput instance = new KeyboardInput();

  /**
   * Get instance of keyboard input.
   *
   * @return instance.
   */
  public static KeyboardInput getInstance() {
    return instance;
  } // getInstance()

  /** Last Recorded Input. */
  private String lastRecordedInput;

  /** PrintWriter. */
  private PrintWriter pen = new PrintWriter(System.out, true);

  /** Scanner. */
  private Scanner scan = new Scanner(System.in);

  private KeyboardInput() {
    lastRecordedInput = "";
  } // KeyboardInput()

  /** Prompt and record the input. */
  public void promptAndRecordInput() {
    pen.print(":");
    pen.flush();
    lastRecordedInput = scan.nextLine();
  } // promptAndRecordInput()

  /**
   * Returns the first letter of the input.
   *
   * @return first letter of the last recorded input
   */
  public Character getInput() {
    if (!this.lastRecordedInput.isEmpty()) {
      return this.lastRecordedInput.charAt(0);
    } // if
    return Character.valueOf(' ');
  } // getInput()

  /**
   * Returns full last recorded input.
   *
   * @return last recorded input.
   */
  public String getFullInput() {
    return this.lastRecordedInput;
  } // getFullInput()
} // KeyboardInput
