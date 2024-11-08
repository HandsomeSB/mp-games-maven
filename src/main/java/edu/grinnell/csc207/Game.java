package edu.grinnell.csc207;

import edu.grinnell.csc207.GameObjects.Enemy;
import edu.grinnell.csc207.GameObjects.GameObject;
import edu.grinnell.csc207.GameObjects.Objective;
import edu.grinnell.csc207.GameObjects.Player;
import edu.grinnell.csc207.util.Matrix;
import edu.grinnell.csc207.util.MatrixV0;
import edu.grinnell.csc207.util.Vector2D;
import java.util.ArrayList;

/**
 * Create the game. Initialize the pieces and turn logic.
 *
 * @author Harrison Zhu
 * @author Mina Bakrac
 */
public class Game {
  /** The board. */
  private Matrix<java.lang.Character> board;

  /** List of game object. */
  private ArrayList<GameObject> gameObjects = GameObject.getGameObjects();

  /** Singleton instance. */
  private static Game instance = new Game();

  /** Objective. */
  private Objective objective;

  /** Player Object. */
  private Player player;

  /** Enemy Object. */
  private Enemy enemy;

  /** Score. */
  private int score = 0;

  /** True game is over. */
  private boolean gameOver = false;

  /**
   * get instance.
   * @return the instance.
   */
  public static Game getInstance() {
    return Game.instance;
  } // getInstance()

  private Game() {
    this.board = new MatrixV0<java.lang.Character>(8, 8, '.');
    init();
  } // Game()

  /** Initialize the board and pieces. */
  private void init() {
    // place character
    this.player = new Player(new Vector2D(0, 0), 'P', this.board.height(), this.board.width());
    this.enemy =
        new Enemy(new Vector2D(7, 0), 'E', this.player, this.board.height(), this.board.width());
    this.objective = new Objective(new Vector2D(2, 2), player, '*');
    // Initial rendering
    renderBoard();
  } // init()

  /** Represent a single turn of the game. */
  public void update() {
    updateGameObjects();
    if (this.player.collidesWith(this.enemy)) {
      this.gameOver = true;
    } // if
    renderBoard();
  } // update()

  /** Updates all the game objects. */
  private void updateGameObjects() {
    for (GameObject go : this.gameObjects) {
      go.update();
    } // for
  } // updateGameObjects()

  /** Make the board. */
  private void renderBoard() {
    this.board.fillRegion(0, 0, this.board.height(), this.board.width(), '.');
    for (GameObject go : this.gameObjects) {
      for (int i = 0; i < go.getSize().getX(); ++i) {
        for (int j = 0; j < go.getSize().getY(); ++j) {
          this.board.set(
              go.getPosition().getY() + i, go.getPosition().getX() + j, go.getCharacter());
        } // for
      } // for
    } // for
  } // renderBoard()

  /**
   * Check if game is over.
   *
   * @return true for a game that is over.
   */
  public boolean getGameOver() {
    return this.gameOver;
  } // getGameOver()

  /**
   * Get the board.
   *
   * @return the board.
   */
  public Matrix<java.lang.Character> getBoard() {
    return this.board;
  } // getBoard()

  /**
   * Get the current score.
   *
   * @return the score.
   */
  public int getScore() {
    return this.score;
  } // getScore()

  /**
   * Set the score.
   *
   * @param val Value to set score to.
   */
  public void setScore(int val) {
    this.score = val;
  } // setScore(int)
} // class Game
