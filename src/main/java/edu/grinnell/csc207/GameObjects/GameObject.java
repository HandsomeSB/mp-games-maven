package edu.grinnell.csc207.GameObjects;

import edu.grinnell.csc207.util.Vector2D;
import java.util.ArrayList;

/**
 * The board pieces of our game.
 *
 * @author Harrison Zhu
 * @author Mina Bakrac
 */
public class GameObject {
  /** ArrayList of all game objects. */
  private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
  /** Position of game object. */
  private Vector2D position;
  /** Size of game object. */
  private Vector2D size;
  /** The character to represent the game object. */
  private Character character;
  /** Height of the board. */
  private int boardHeight;
  /** Width of the board. */
  private int boardWidth;

  /**
   * Create a new games object.
   *
   * @param pos The position.
   * @param initSize The size.
   * @param chara The character.
   * @param bHeight The height of the board.
   * @param bWidth The width of the board.
   */
  public GameObject(Vector2D pos, Vector2D initSize, Character chara, int bHeight, int bWidth) {
    this.position = pos;
    this.size = initSize;
    this.character = chara;
    this.boardHeight = bHeight;
    this.boardWidth = bWidth;
    GameObject.gameObjects.add(this);
  } // GameObject(Vector2D, Vector2D, Character, int, int)

  /**
   * @param pos The position.
   * @param chara The character.
   * @param bHeight The height of the board.
   * @param bWidth The width of the board.
   */
  public GameObject(Vector2D pos, Character chara, int bHeight, int bWidth) {
    this(pos, new Vector2D(1, 1), chara, bHeight, bWidth);
  } // GameObject(Vector2D, Character, int, int)

  /**
   * @param chara The character.
   * @param bHeight The height of the board.
   * @param bWidth The width of the board.
   */
  public GameObject(Character chara, int bHeight, int bWidth) {
    this(new Vector2D(0, 0), new Vector2D(1, 1), chara, bHeight, bWidth);
  } // GameObject(Character, int, int)

  /**
   * Checks for collision between two game objects.
   *
   * @param other Object for which we are checking for collision.
   * @return true if the two overlap.
   */
  public boolean collidesWith(GameObject other) {
    // Check for no overlap horizontally
    if (this.position.getX() + this.size.getX() <= other.position.getX()
        || other.position.getX() + other.size.getX() <= this.position.getX()) {
      return false;
    } // if
    // Check for no overlap vertically
    if (this.position.getY() + this.size.getY() <= other.position.getY()
        || other.position.getY() + other.size.getY() <= this.position.getY()) {
      return false;
    } // if
    // If neither of the above, rectangles are colliding
    return true;
  } // collidesWith(GameObject)

  /** The standard update method for all game objects. */
  public void update() {} // update()

  /**
   * Get position.
   * @return position of game object.
   */
  public Vector2D getPosition() { 
    return this.position;
  }

  /**
   * Set position.
   * @param val new value. 
   */
  public void setPosition(Vector2D val) {
    this.position = val;
  }

  /**
   * Get size.
   * @return size of game object.
   */
  public Vector2D getSize() { 
    return this.size;
  }

  /**
   * Get character. 
   * @return character of game object. 
   */
  public Character getCharacter() { 
    return this.character;
  }

  /**
   * Our game objects.
   *
   * @return array list of type gameobject.
   */
  public static ArrayList<GameObject> getGameObjects() {
    return GameObject.gameObjects;
  } // getGameObjects()
} // class GameObject
