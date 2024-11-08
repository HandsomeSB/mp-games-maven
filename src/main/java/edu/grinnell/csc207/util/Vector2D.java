package edu.grinnell.csc207.util;

/**
 * Creates a vector system for locations and movement of game pieces.
 * 
 * @author Harrison Zhu
 * @author Mina Bakrac
 */
public class Vector2D {
    private int x;
    private int y;

    /**
     * Create a new 2D vector.
     *
     * @param x
     *      The x-coordinate.
     * @param y
     *      The y-coordinate.
     */
    public Vector2D(int x, int y) { 
        this.x = x; 
        this.y = y;
    }

    /**
     * Get the X coordinate.
     *
     * @return the x coordinate.
     */
    public int getX() { 
        return x;
    } // getX()

    /**
     * Get the Y coordinate.
     *
     * @return the y coordinate.
     */
    public int getY() { 
        return y;
    } // getY()

    /**
     * Set the X coordinate.
     *
     * @param val 
     *      What to set x to.
     */
    public void setX(int val) { 
        this.x = val;
    } // setX(int)

    /**
     * Set the Y coordinate.
     * 
     * @param val 
     *      What to set y to.
     */
    public void setY(int val) { 
        this.y = val;
    } // setY(int)

    /**
     * Increment the X coordinate.
     *
     * @param val
     *      How much to increment by.
     */
    public void incrementX(int val) { 
        this.x += val;
    } // incrementX(int)

    /**
     * Increment the Y coordinate.
     *
     * @param val
     *      How much to increment by.
     */
    public void incrementY(int val) { 
        this.y += val;
    } // incrementY(int)

    /**
     * Determines distance between two points on board.
     *
     * @param other
     *      The other point.
     * @return the distance.
     */
    public int manhattanDist(Vector2D other) { 
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    } // manhattanDist(Vector2D)
} // class Vector2D
