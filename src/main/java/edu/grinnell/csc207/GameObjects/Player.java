package edu.grinnell.csc207.GameObjects;

import edu.grinnell.csc207.Game;
import edu.grinnell.csc207.UI.KeyboardInput;
import edu.grinnell.csc207.util.Vector2D;

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
    switch (move) {
      case 'w':
        if (this.getPosition().getY() - 1 < 0) {
          System.out.println("Invalid movement");
          return;
        } // if
        this.getPosition().incrementY(-1);
        break;
      case 'a':
        if (this.getPosition().getX() - 1 < 0) {
          System.out.println("Invalid movement");
          return;
        } // if
        this.getPosition().incrementX(-1);
        break;
      case 's':
        if (this.getPosition().getY() + 1 >= Game.getInstance().getBoard().height()) {
          System.out.println("Invalid movement");
          return;
        } // if
        this.getPosition().incrementY(1);
        break;
      case 'd':
        if (this.getPosition().getX() + 1 >= Game.getInstance().getBoard().width()) {
          System.out.println("Invalid movement");
          return;
        } // if
        this.getPosition().incrementX(1);
        break;
      default:
        break;
    } // switch
  } // update()
} // class Player
