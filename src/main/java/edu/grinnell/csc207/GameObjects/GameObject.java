package edu.grinnell.csc207.GameObjects;
import java.util.ArrayList;

import edu.grinnell.csc207.util.Vector2D;

/**
 * The board pieces of our game.
 * 
 * @author Harrison Zhu
 * @author Mina Bakrac
 */
public class GameObject {
    private static ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    public Vector2D position;
    public Vector2D size;
    public Character character;
    public int boardHeight;
    public int boardWidth;

    /**
     * Create a new games object.
     * 
     * @param pos
     *      The position.
     * @param size
     *      The size.
     * @param chara
     *      The character.
     * @param boardHeight
     *      The height of the board.
     * @param boardWidth
     *      The width of the board.
     */
    public GameObject(Vector2D pos, Vector2D size, Character chara, int boardHeight, int boardWidth) { 
        this.position = pos;
        this.size = size;
        this.character = chara;
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        GameObject.gameObjects.add(this);
    } // GameObject(Vector2D, Vector2D, Character, int, int)

    /**
     * 
     *
     * @param pos
     *      The position.
     * @param chara
     *      The character.
     * @param boardHeight
     *      The height of the board.
     * @param boardWidth
     *      The width of the board.
     */
    public GameObject(Vector2D pos, Character chara, int boardHeight, int boardWidth) { 
        this(pos, new Vector2D(1, 1), chara, boardHeight, boardWidth);
    } // GameObject(Vector2D, Character, int, int)

    /**
     * 
     *
     * @param chara
     *      The character.
     * @param boardHeight
     *      The height of the board.
     * @param boardWidth
     *      The width of the board.
     */
    public GameObject(Character chara, int boardHeight, int boardWidth) { 
        this(new Vector2D(0, 0), new Vector2D(1, 1), chara, boardHeight, boardWidth);
    } // GameObject(Character, int, int)

    /**
     * Checks for collision between two game objects.
     * 
     * @param other
     *      Object for which we are checking for collision.
     * @return true if the two overlap.
     */
    public boolean collidesWith(GameObject other) { 
        // Check for no overlap horizontally
        if (this.position.getX() + this.size.getX() <= other.position.getX() || other.position.getX() + other.size.getX() <= this.position.getX()) {
            return false;
        } // if
        // Check for no overlap vertically
        if (this.position.getY() + this.size.getY() <= other.position.getY() || other.position.getY() + other.size.getY() <= this.position.getY()) {
            return false;
        } // if
        // If neither of the above, rectangles are colliding
        return true;
    } // collidesWith(GameObject)

    /**
     * The standard update method for all game objects.
     */
    public void update() { 
    } // update()

    /**
     * Our game objects.
     * @return array list of type gameobject.
     */
    public static ArrayList<GameObject> getGameObjects() { 
        return GameObject.gameObjects;
    } // getGameObjects()
} // class GameObject
