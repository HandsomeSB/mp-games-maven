package edu.grinnell.csc207.GameObjects;

import edu.grinnell.csc207.util.Vector2D;

public class GameObject {
    public Vector2D position;
    public Character character;

    public GameObject(Vector2D pos, Character chara) { 
        this.position = pos;
        this.character = chara;
    }

    public GameObject(Character chara) { 
        this.character = chara;
        this.position = new Vector2D(0, 0);
    }

    public void update() { 
        
    }
}
