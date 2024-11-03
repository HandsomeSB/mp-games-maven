package edu.grinnell.csc207.util;

public class Vector2D {
    private int x;
    private int y;

    public Vector2D(int x, int y) { 
        this.x = x; 
        this.y = y;
    }

    public int getX() { 
        return x;
    }

    public int getY() { 
        return y;
    }

    public void setX(int val) { 
        this.x = val;
    }

    public void setY(int val) { 
        this.y = val;
    }

    public void incrementX(int val) { 
        this.x += val;
    }

    public void incrementY(int val) { 
        this.y += val;
    }

    public int manhattanDist(Vector2D other) { 
        return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
    }
}
