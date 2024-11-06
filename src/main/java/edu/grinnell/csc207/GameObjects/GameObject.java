package edu.grinnell.csc207.GameObjects;
import edu.grinnell.csc207.util.Vector2D;

public class GameObject {
    public Vector2D position;
    public Vector2D size;
    public Character character;
    public int boardHeight;
    public int boardWidth;

    public GameObject(Vector2D pos, Vector2D size, Character chara, int boardHeight, int boardWidth) { 
        this.position = pos;
        this.size = size;
        this.character = chara;
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
    }

    public GameObject(Vector2D pos, Character chara, int boardHeight, int boardWidth) { 
        this(pos, new Vector2D(1, 1), chara, boardHeight, boardWidth);
    }

    public GameObject(Character chara, int boardHeight, int boardWidth) { 
        this(new Vector2D(0, 0), new Vector2D(1, 1), chara, boardHeight, boardWidth);
    }

    public boolean collidesWith(GameObject other) { 
        // Check for no overlap horizontally
        if (this.position.getX() + this.size.getX() <= other.position.getX() || other.position.getX() + other.size.getX() <= this.position.getX()) {
            return false;
        }

        // Check for no overlap vertically
        if (this.position.getY() + this.size.getY() <= other.position.getY() || other.position.getY() + other.size.getY() <= this.position.getY()) {
            return false;
        }

        // If neither of the above, rectangles are colliding
        return true;
    }

    public void update() { 

    }
}
