package edu.grinnell.csc207.GameObjects;

import edu.grinnell.csc207.Game;
import edu.grinnell.csc207.UI.KeyboardInput;
import edu.grinnell.csc207.util.Vector2D;
import java.io.PrintWriter;

/**
 * The player game piece.
 *
 * @author Harrison Zhu
 * @author Mina Bakrac
 */
public class Player extends GameObject {

  /**
   * Create a new player.
   *
   * @param pos The position.
   * @param chara The character.
   * @param boardHeight The height of the board.
   * @param boardWidth The width of the board.
   */
  public Player(Vector2D pos, Character chara, int boardHeight, int boardWidth) {
    super(pos, chara, boardHeight, boardWidth);
  } // Player(Vector2D, Character, int, int)

  /**
   * Create a new player.
   *
   * @param pos The position.
   * @param size The size.
   * @param chara The character.
   * @param boardHeight The height of the board.
   * @param boardWidth The width of the board.
   */
  public Player(Vector2D pos, Vector2D size, Character chara, int boardHeight, int boardWidth) {
    super(pos, size, chara, boardHeight, boardWidth);
  } // Player(Vector2D, Vector2D, Character, int, int)

  /** The update method for the player piece. */
  @Override
  public void update() {
    char move = KeyboardInput.getInstance().getInput();
    Vector2D nextPos = new Vector2D(this.getPosition().getX(), this.getPosition().getY());
    switch (move) {
      case 'w':
        nextPos.incrementY(-1);
        break;
      case 'a':
        nextPos.incrementX(-1);
        break;
      case 's':
        nextPos.incrementY(1);
        break;
      case 'd':
        nextPos.incrementX(1);
        break;
      default:
        break;
    } // switch

    if (GameObject.isOutOfBound(nextPos, Game.getInstance())) {
      PrintWriter pen = new PrintWriter(System.out, true);
      pen.println("Invalid Input");
      pen.flush();
    } else { // if
      this.setPosition(nextPos);
    } // else
  } // update()
} // class Player
